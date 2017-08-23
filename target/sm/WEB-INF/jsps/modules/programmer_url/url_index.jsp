<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/jsps/base/taglib.jsp"%>
<%@ include file="/WEB-INF/jsps/base/backToLogin.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>小说</title>
<link href="${smStatic}/css/modules/novel/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${smStatic}/js/lib/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${smStatic}/js/modules/novel/jquery.movebg.js"></script>
<script src="https://hm.baidu.com/hm.js?b2e5ac9401b5820ffa4e9fa608593a5b"></script>
<script type="text/javascript" async="" charset="utf-8" src="http://c.cnzz.com/core.php?web_id=30085487&t=q"></script>
<script  src="http://img4.km.com/bookimg/public/javascripts/ga.js"></script>
<script src="https://img1.km.com/bookimg/public/javascripts/ua_1228.js"></script>
<link href="${smStatic}/css/modules/novel/style.css" rel="stylesheet" type="text/css"></link>


<link href="https://img2.km.com/bookimg/public/styles/book/global_v2.css?20170106" rel="stylesheet" />
<link href="https://img3.km.com/bookimg/public/styles/book/book_index_v2.css?0122" rel="stylesheet"></link>
<script type="text/javascript" src="http://union2.50bang.org/web/ajax59?uId2=SPTNPQRLSX&uId=71595148731109603521246&r=http%3A%2F%2Fbook.km.com%2F&lO=http%3A%2F%2Fbook.km.com%2Fboy.html?nytjsplit=http%3A%2F%2Fbook.km.com%2F"></script>
<link rel="stylesheet" type="text/css" href="http://s1.hao123img.com/resource/fe/pkg/aio-eef856ab5.231bb088c.css"></link>
<link rel="stylesheet" type="text/css" href="http://s1.hao123img.com/resource/fe/widget/ui/header/common/v2/header.ff567bfe4.css"></link>
<link rel="stylesheet" type="text/css" href="http://s0.hao123img.com/resource/fe/widget/ui/header/common/v2/logo/logo.f97ff30ee.css"></link>
<link rel="stylesheet" type="text/css" href="http://s1.hao123img.com/resource/fe/widget/ui/header/common/v2/sitemap/sitemap.1943d4d0a.css"></link>
<link rel="stylesheet" type="text/css" href="http://s2.hao123img.com/resource/fe/widget/ui/header/common/v2/adv/adv.25330c25d.css"></link>
<link rel="stylesheet" type="text/css" href="http://s0.hao123img.com/resource/fe/widget/ui/header/common/v2/form/form.e1a566aa2.css"></link>
<link rel="stylesheet" type="text/css" href="http://s0.hao123img.com/resource/fe/widget/ui/header/common/v2/tools/tools.a417dd454.css"></link>
<link rel="stylesheet" type="text/css" href="http://s2.hao123img.com/resource/fe/pkg/aio-aa68408dd.dfc181073.css"></link>
<link rel="stylesheet" type="text/css" href="http://s2.hao123img.com/resource/fe/pkg/aio-8155b5719.3dd99d32e.css"></link>
<link rel="stylesheet" type="text/css" href="http://s0.hao123img.com/resource/fe/pkg/aio-1c2d6f9f2.2b182a527.css"></link>
<script src="http://s0.hao123img.com/res/js/track.js?-413145" data-log-config="pageId:hao123-erji-book;page:hao123-erji-book;level:2;vp:hao123-erji-book"></script>
</head>

<body id="xtopjsinfo">
<div class="top_bar">
<div class="wrap_in">
<p class="main_menu">
<a href="javascript:addFav();">欢迎你${user.username}</a>
</p>
<p class="user_info">
<c:if test="${user==null }">
<span class="unlogin">
<i>|</i>
<a id="top-bar-login" class="login" href="javascript:void(0);">登录</a>
<i>|</i>
<a id="top-bar-register" class="register" href="javascript:void(0);">注册</a>
</span>
</c:if>
<c:if test="${user!=null }">
<span class="unlogin">
<i>|</i>
<a id="top-bar-login" class="login" href="javascript:void(0);">个人中心</a>
</span>
</c:if>

</p>
</div>
</div>

<div class="header">
<div class="wrap_in">
<div class="logo">
<a href="#">
<embed wmode="transparent" src="http://chabudai.sakura.ne.jp/blogparts/honehoneclock/honehone_clock_wh.swf" quality="high" bgcolor="#ffffff" width="160" height="70" name="honehoneclock" align="middle" allowscriptaccess="always" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer">
</a>
</div>
<div class="search_meta">
<div class="search_box">
<form id="search_from_top" action="/search.html" method="get" accept-charset="gb2312" onsubmit="return search.check_searchform()">
<input id="search_type" name="search_type" value="" type="hidden">
<input id="keyword" class="search_focus" name="keyword" placeholder="请输入书名/作者/标签" maxlength="20" autocomplete="off" type="text">
<button class="btn_search" type="submit">好书~搜~</button>
</form>
</div>

<div id="search_result" class="suggest_wrap" style="display: none">
<div class="suggest_box">
<ul id="search_result_list">
</ul>
</div>
</div>

</div>
<div class="aside clearfix">

<object type="application/x-shockwave-flash" style="outline:none;" data="http://cdn.abowman.com/widgets/hamster/hamster.swf?" width="130" height="80" id="__wow_video_player__463292481" title="Adobe Flash Player"><param name="movie" value="http://cdn.abowman.com/widgets/hamster/hamster.swf?"><param name="AllowScriptAccess" value="always"><param name="wmode" value="opaque"></object>
</div>
</div>

<!-- 代码 开始 -->
<div class="wraper" id="summerizeId">
    <div class="nav">
        <ul>
            <li class="nav-item"><a href="#" target="_blank">首页</a></li>
        <c:forEach items="${list }" var="summerize">
       	 <input type="text" value="${summerize.summarizeId }" hidden="hidden" />
          <li class="nav-item"><a href="#" target="_blank">${summerize.summarizeName}</a></li>
           </c:forEach>
        </ul>
        <!--移动的滑动-->
        <div class="move-bg">
		
		
		</div>
        <!--移动的滑动 end-->
    </div>
</div>




<div id="bd" class="content-wrapper">


<div class="mod-content clearfix">
<div class="content-con content-con-first">
<h2 class="content-title">
<span class="content-title-des">空空如也</span>
</h2>
<ul class="content-link">
<li>
<h3>
<div>
<a class="text-con" href="" title="" target="_blank">这里什么也没有</a>
</div>
</h3>
</li>
<li>
</ul>
</div>
<!-- 第一個小說 -->
</div>
</div>
</body>
<script type="text/javascript">

$(function(){
	$(".nav").movebg({width:120/*滑块的大小*/,extra:40/*额外反弹的距离*/,speed:300/*滑块移动的速度*/,rebound_speed:400/*滑块反弹的速度*/});
$("#summerizeId ul li").each(function(){
	
	$(this).mouseover(function(){
		
		var summarizeId = $(this).prev().val();
		if(""==summarizeId ||undefined ==summarizeId||$(("#"+summarizeId +" ul")).length>0){
			
			return ;
		}
		
		$.ajax({
			url :"${sm}/programmer/findCategoryBySummrizeId.php?summerizeId="+summarizeId,
					type: "get",
					success:function(data){
						var html ='<div class="mod-content clearfix" id="'+summarizeId+'">';
						
							
					var leng = 0;			
						for(var v=0;v<data.length;v++){
						html+='<div class="content-con content-con-first"><h2 class="content-title"><span class="content-title-des"> '+data[v].categoryName+'</span></h2><ul class="content-link">'
							leng = data[v].includeUrl;	
						
						for(var p = 0; p<leng.length;p++){
								
								html+='<li><h3><div><a class="text-con" href="'+leng[p].urlHref+'" title="" target="_blank">'+leng[p].urlName+'</a></div></h3></li><li>';
								
							} 
						
							


                        }
                        html+='</ul></div>';
                        $(".mod-content clearfix").hide();
                        $("#bd").append(html);



                    }
			
			
			
			
		})
		
		
		
		
	})
	
	
})



})
 swal({
	title: "疑问?", 
	text: "我得先问一句:你是程序猿吗?", 
	type: "warning",
	showCancelButton: true,
	closeOnConfirm: false,
	confirmButtonText: "是俺,没错",
	confirmButtonColor: "#ec6c62"
	}, function() {
		$.ajax({
			url: "do.php",
			type: "DELETE"
		}).done(function(data) {
			swal({   
				title: "Good!",   
				text: '好的,正在前往程序员之家 <br/>请稍等...',   
				imageUrl: "images/thumbs-up.jpg",
				html: true,
				timer: 5000,   
				showConfirmButton: false
			});
			
			
			
			
		
		}).error(function(data) {
			swal("OMG", "删除操作失败了!", "error");
		});
	});

 
</script>
</html>
