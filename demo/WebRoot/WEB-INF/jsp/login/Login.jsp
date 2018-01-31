<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	    String path = request.getContextPath();
	    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
    %>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登陆</title>
</head>
 <link rel="stylesheet" href="css/login.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js" ></script>
<script type="text/javascript" src="js/Vidage.min.js" ></script>
<script type="text/javascript" src="js/login.js" ></script>
<body>

<div class="Vidage">
		<div class="Vidage__image"></div>
		<video id="VidageVideo" class="Vidage__video" preload="metadata" poster="image/video_cover.jpeg" loop autoplay muted>
			<source src="image/night.mp4" type="video/mp4">
		</video>
	</div>
	<div class ="login" id = "login">
		<form id="userForm" action="login.do" method="post">
           
            <div class="form-group">
                <input id="username" name="uname" type="text" class="form-control" placeholder="用户名" required="required"  autocomplete="off" >
            </div>
            <div class="key">
                <input id="password" name="pwd" type="password" class="form-control" placeholder="密码" required="required">
            </div>
            <input id="button_submit" type="submit" value="登录" >
		</form>
	 </div>
	  <script>
	    $(document).ready(function(){  
	    	$("#button_submit").click(function(){
	  		  $.ajax({
	  			  url:"<%=basePath%>login_Name.do",
	  			  type:"POST",
  				  async :"false",
	  			  data:{"name": $("#username").val(),"pwd":$("#password").val()},
	  			  dataType:"json",
	  			  success:function(data){
	  				  if(data == false){
	  					  alert("用户不存在,或密码不正确,请重新输入!");
 					  	}
  				  }
	  		  });
	  		});
	    });  
    </script>
</body>
</html> 