<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/jsps/base/taglib.jsp"%>
<%@ include file="/WEB-INF/jsps/base/backToLogin.jsp"%>
<html>
<head>
<title>请欣赏~~</title>
<%--<script src="${smStatic }/js/sysindex/flash.js"></script>--%>
    <script src="${smStatic}/js/lib/jquery-2.1.1.min.js"></script>

    <script type="text/javascript" src="${smStatic}/css/assets/three.min.js"></script>
    <script type="text/javascript" src="${smStatic}/css/assets/Detector.js"></script>
    <%--<link rel="stylesheet" href="http://dreamsky.github.io/main/blog/common/init.css">--%>
<style type="text/css">
*{ margin:0px; }
</style>
    <style type="text/css">
        body {
            background-color: #326696;
            margin: 0px;
            overflow: hidden;
            font-family:Monospace;
            font-size:13px;
            text-align:center;
            font-weight: bold;
            text-align:center;

        }
        a {
            color:#0078ff;
        }
    </style>

</head>
<body>
<%--<object id="swfInf" type="application/x-shockwave-flash" data="http://www.pedrolamin.com.br/2008/index.swf" width="100%" height="100%" >--%>

<%--</object>--%>
<script id="vs" type="x-shader/x-vertex">

			varying vec2 vUv;

			void main() {

				vUv = uv;
				gl_Position = projectionMatrix * modelViewMatrix * vec4( position, 1.0 );

			}

		</script>

<script id="fs" type="x-shader/x-fragment">

			uniform sampler2D map;

			uniform vec3 fogColor;
			uniform float fogNear;
			uniform float fogFar;

			varying vec2 vUv;

			void main() {

				float depth = gl_FragCoord.z / gl_FragCoord.w;
				float fogFactor = smoothstep( fogNear, fogFar, depth );

				gl_FragColor = texture2D( map, vUv );
				gl_FragColor.w *= pow( gl_FragCoord.z, 20.0 );
				gl_FragColor = mix( gl_FragColor, vec4( fogColor, gl_FragColor.w ), fogFactor );

			}

		</script>

<script type="text/javascript">


        $(".top-banner").remove();



    if ( ! Detector.webgl ) Detector.addGetWebGLMessage();

    var container;
    var camera, scene, renderer;
    var mesh, geometry, material;

    var mouseX = 0, mouseY = 0;
    var start_time = Date.now();

    var windowHalfX = window.innerWidth / 2;
    var windowHalfY = window.innerHeight / 2;

    init();

    function init() {

        container = document.createElement( 'div' );
        document.body.appendChild( container );

        // Bg gradient

        var canvas = document.createElement( 'canvas' );
        canvas.width = 32;
        canvas.height = window.innerHeight;

        var context = canvas.getContext( '2d' );

        var gradient = context.createLinearGradient( 0, 0, 0, canvas.height );
        gradient.addColorStop(0, "#1e4877");
        gradient.addColorStop(0.5, "#4584b4");

        context.fillStyle = gradient;
        context.fillRect(0, 0, canvas.width, canvas.height);

        container.style.background = 'url(' + canvas.toDataURL('image/png') + ')';
        container.style.backgroundSize = '32px 100%';

        //

        camera = new THREE.PerspectiveCamera( 30, window.innerWidth / window.innerHeight, 1, 3000 );
        camera.position.z = 6000;

        scene = new THREE.Scene();

        geometry = new THREE.Geometry();

        var texture = THREE.ImageUtils.loadTexture( '${smStatic}/img/cloud/cloud10.png', null, animate );
        texture.magFilter = THREE.LinearMipMapLinearFilter;
        texture.minFilter = THREE.LinearMipMapLinearFilter;

        var fog = new THREE.Fog( 0x4584b4, - 100, 3000 );

        material = new THREE.ShaderMaterial( {

            uniforms: {

                "map": { type: "t", value: texture },
                "fogColor" : { type: "c", value: fog.color },
                "fogNear" : { type: "f", value: fog.near },
                "fogFar" : { type: "f", value: fog.far },

            },
            vertexShader: document.getElementById( 'vs' ).textContent,
            fragmentShader: document.getElementById( 'fs' ).textContent,
            depthWrite: false,
            depthTest: false,
            transparent: true

        } );

        var plane = new THREE.Mesh( new THREE.PlaneGeometry( 64, 64 ) );

        for ( var i = 0; i < 8000; i++ ) {

            plane.position.x = Math.random() * 1000 - 500;
            plane.position.y = - Math.random() * Math.random() * 200 - 15;
            plane.position.z = i;
            plane.rotation.z = Math.random() * Math.PI;
            plane.scale.x = plane.scale.y = Math.random() * Math.random() * 1.5 + 0.5;

            THREE.GeometryUtils.merge( geometry, plane );

        }

        mesh = new THREE.Mesh( geometry, material );
        scene.add( mesh );

        mesh = new THREE.Mesh( geometry, material );
        mesh.position.z = - 8000;
        scene.add( mesh );

        renderer = new THREE.WebGLRenderer( { antialias: false } );
        renderer.setSize( window.innerWidth, window.innerHeight );
        container.appendChild( renderer.domElement );

        document.addEventListener( 'mousemove', onDocumentMouseMove, false );
        window.addEventListener( 'resize', onWindowResize, false );

    }

    function onDocumentMouseMove( event ) {

        mouseX = ( event.clientX - windowHalfX ) * 0.25;
        mouseY = ( event.clientY - windowHalfY ) * 0.15;

    }

    function onWindowResize( event ) {

        camera.aspect = window.innerWidth / window.innerHeight;
        camera.updateProjectionMatrix();

        renderer.setSize( window.innerWidth, window.innerHeight );

    }

    function animate() {

        requestAnimationFrame( animate );

        position = ( ( Date.now() - start_time ) * 0.03 ) % 8000;

        camera.position.x += ( mouseX - camera.position.x ) * 0.01;
        camera.position.y += ( - mouseY - camera.position.y ) * 0.01;
        camera.position.z = - position + 8000;

        renderer.render( scene, camera );

    }




</script>


<%--<script src="http://www.google-analytics.com/urchin.js" type="text/javascript"></script>--%>
<%--<script type="text/javascript">--%>
<%--_uacct = "UA-1155128-1"; urchinTracker(); --%>
<%--</script>--%>
</body>
<script type="text/javascript">
    var stop =setInterval("myInterval()",5000);//1000为1秒钟
setInterval("close()",15000);//1000为1秒钟


   function myInterval()
    {
    	swal({
    		title: "Good!",
    		text: '您好 ${user.username}<br/>功能待开发中~~ 先欣赏着~~',
    		imageUrl: "${smStatic}/img/sysindex/small/thumbs-up.jpg",
    		html: true,
    		timer: 3000,
    		showConfirmButton: false
    	});

	     }
function novel(){
	window.location.href="${sm}/programmer/good_url.php";
}

function movie(){
	window.location.href="${sm}/sys/movie/index.php";
	
	
	
}
function animation(){
	window.location.href="${sm}/sys/animation/index.php";
	
	
	
}

function close() {

    clearInterval(stop);

}
</script></html>
