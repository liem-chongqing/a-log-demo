<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>邮箱发送验证码</title>
	</head>
	<body>
	
		<a href="javascript:;" onclick="demoAjax()">发送验证码</a>
		<script type="text/javascript">
			var xhr;
		  	function createXMLHttpRequest(){
		    	if(window.XMLHttpRequest){
		    		xhr = new XMLHttpRequest; 
		    	}else{
		    	    xhr=new ActiveXObject("Microsoft.XMLHTTP");
		    	}
		  	}
		  	
		  	function demoAjax(){
		  		createXMLHttpRequest(); 
		  		xhr.open("get", "<%=request.getContextPath() %>/sendmail", true);
		  		xhr.onreadystatechange=success;
		  		xhr.send();
		  	}
		  	
		  	function success(){
		  		if(xhr.readyState==4){
			  		if(xhr.status==200){ 
			  			var text = xhr.responseText;
			  			alert(text);
			  		}
		  		}
		  	}
	    </script>
	</body>
</html>	