<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/jsps/base/taglib.jsp" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>欢迎来到SweetyFamily</title>
    <link rel="stylesheet" href="${smStatic}/css/sysindex/styles.css"/>
    <link rel="stylesheet" href="${smStatic}/css/utils/sweetAlert/sweetalert.css" />
    <script type="text/javascript" src="${smStatic}/js/lib/sweetAlert/sweetalert-dev.js"> </script>
    <script type="text/javascript" src="${smStatic}/js/lib/sweetAlert/sweetalert.min.js"> </script>

</head>
<body>
<div id="formContainer">
    <form id="login" method="post" action="${sm}/sys/user">
        <a href="#" id="flipToRecover" class="flipLink">Forgot?</a> <input
            type="text" name="username" id="loginEmail" placeholder="手机/邮箱/账号"/>
        <input type="password" name="password" id="loginPass"
               placeholder="密码"/> <input type='button' value="Login"
                                         id="login" onclick="sb('Login')"/> <input type='button' id="register"
                                                                                   value="register"
                                                                                   onclick="sb('register')"/>
    </form>
    <form id="recover" method="post">
        <a href="#" id="flipToLogin" class="flipLink">Forgot?</a> <input
            type="text" name="recoverEmail" id="recoverEmail"
            placeholder="请输入您绑定的邮箱"/> <input type="button"
                                             value="Recover" onclick="sb()"/>
    </form>
</div>

<!-- JavaScript includes -->


<script type="text/javascript" src="${smStatic}/js/lib/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${smStatic}/js/modules/login/script.js"></script>
<script type="text/javascript" src="${smStatic}/js/lib/jquery.form.js"></script>

</body>
<script type="text/javascript">
    var timestamp = new Date().getTime();
    $(function () {
        document.onkeydown = function (e) {
            var ev = document.all ? window.event : e;
            if (ev.keyCode == 13) {

                sb("Login");

            }
        }
    });
    function sb(obj) {
        var username = $("#loginEmail").val();
        var password = $("#loginPass").val();
        if ("" == username) {
            swal("用户名不符合格式");
            return;
        }

        if (username.length > 12) {
            swal("用户名最多可以12位");
            return;

        }
        if ("" == password) {
            swal("密码不符合格式");
            return;
        }
        if (password.length > 15) {
            swal("密码最多15位");
            return;
        }


        if ("Login" == obj) {
            $.ajax({
                url: "${sm}/sys/user.php",
                type: "post",
                data: {"username": username, "password": password, "message": obj},
                success: function (data) {
                    if (data == "1") {
                        //登陆成功
                        swal("你好${user.username}!", "欢迎来到sm", "success");

                        setTimeout(function () {

                            window.location.href = "${sm}/sys/index.php";

                        }, "500");
                    } else if (data == "3") {
                        swal("牛逼!", "不要胡乱篡改数据", "error");

                    } else if (data == "5") {
                        swal("非常抱歉!", "用户名密码错误", "error");

                    } else if (data == "2") {
                        //注册成功
                        swal("你好${user.username}!", "注册成功", "success");

                        setTimeout(function () {

                            window.location.href = "${sm}/sys/index.php";
                        }, "500");

                    } else {
                        swal("失败了~~");

                    }

                }
            })

        } else {

            if ("register" == obj) {




                swal({
                        title: "注册暂未发放",
                        text: "现在不允许注册, 你不要想搞个大新闻",
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "偷偷注册",
                        cancelButtonText: "算了还是撤吧",
                        closeOnConfirm: false,
                        closeOnCancel: false
                    },
                    function (isConfirm) {
                        if (isConfirm) {


                            swal({
                                    title: "留下邮箱",
                                    text: "别被别人看到你的邮箱,偷偷留下来",
                                    type: "input",
                                    showCancelButton: true,
                                    closeOnConfirm: false,
                                    animation: "slide-from-left",
                                    inputPlaceholder: "啦啦啦啦啦~~"
                                },
                                function (inputValue) {
                                    if (inputValue === false) return false;

                                    if (inputValue === "") {
                                        swal.showInputError("你都不写邮箱, 怎么注册啊~");
                                        return false
                                    }

                                    var re = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;

                                    if (re.test(inputValue)) {
                                        swal("Nice!", "客管您的邮箱是 :" + inputValue+ " 快去邮箱确认注册吧");

                                        $.ajax({
                                            url:"/api/mailSend.php/"+inputValue,
                                            type: "post",
                                            data: {user_email:inputValue,username:username,password:password,timestamp:timestamp},
                                            beforeSend:function () {

                                            },
                                            success:function (data) {

                                                if(data==0){

                                                   setTimeout('window.location.href="https://www.baidu.com"',2000) ;
                                                }

                                            }




                                        })



                                    } else {
                                        swal.showInputError("你确定你写对了吗?");
                                    }


                                });



                        } else {
                            swal("Cancelled", "滚吧", "error");
                        }
                    });


            }

        }
    }

</script>
</html>

