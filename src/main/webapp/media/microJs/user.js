/**
 *  user js文件
 */

function ajaxLogin(username, password) {

	$.ajax({

	     type : 'post',

	     url : "ajaxLogin.do",

		 dataType : 'JSON',
		 
		 data : {
			 username : username,
			 password : password
		 },

	     success : function(data) {
	    	if(data.isSuccess) {
	    		alert('登陆成功');
	    		
	    		window.location.href="login.do?" + "username=" + username + "&password=" + password;
	    	} else {
	    		alert(data.errorMsg)
	    	}
	    } ,
	     error : function() {  
	    	 alert("返回数据异常");
	        } 

	});
}