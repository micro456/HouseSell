/*function ajaxLogin() {
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
  	    		// 登陆成功
  	    		window.location.href = "login.do?" + "username=" + "$('#username').attr('value')" + "?password=" + "$('#password').attr('value')";
  	    	} else {
  	    		alert(data.errorMsg);
  	    	}
  	    } ,
  	     error : function() {  
  	    	 var rt = window.confirm("返回数据异常");
  	    		if(rt) {
  		    		window.location.reload();
  	    		} 
  	        } 

  	});
}*/

var Login = function () {
    
    return {
        //main function to initiate the module
        init: function () {
        	
           $('.login-form').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            rules: {
	                username: {
	                    required: true
	                },
	                password: {
	                    required: true
	                },
	                remember: {
	                    required: false
	                }
	            },

	            messages: {
	                username: {
	                    required: "请填写用户名."
	                },
	                password: {
	                    required: "请填写密码."
	                }
	            },

	            invalidHandler: function (event, validator) { //display error alert on form submit   
	                $('.alert-error', $('.login-form')).show();
	            },

	            highlight: function (element) { // hightlight error inputs
	                $(element)
	                    .closest('.control-group').addClass('error'); // set error class to the control group
	            },

	            success: function (label) {
	                label.closest('.control-group').removeClass('error');
	                label.remove();
	            },

	            errorPlacement: function (error, element) {
	                error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	            },

	            submitHandler: function (form) {
	            	window.location.href = "login.do?" + "username=" + $('#username').val() + "&password=" + $('#password').val();
	            	/*$.ajax({

	           	     type : 'post',

	           	     url : "ajaxLogin.do",

	           		 dataType : 'JSON',
	           		 
	           		 data : {
	           			 username : username,
	           			 password : password
	           		 },

	           	     success : function(data) {
	           	    	if(data.isSuccess) {
	           	    		// 登陆成功
	           	    		window.location.href = "login.do?" + "username=" + "$('#username').attr('value')" + "?password=" + "$('#password').attr('value')";
	           	    	} else {
	           	    		alert(data.errorMsg);
	           	    	}
	           	    } ,
	           	     error : function() {  
	           	    	 var rt = window.confirm("返回数据异常");
	           	    		if(rt) {
	           		    		window.location.reload();
	           	    		} 
	           	        } 

	           	});*/
	            }
	        });

	        $('.login-form input').keypress(function (e) {
	            if (e.which == 13) {
	                if ($('.login-form').validate().form()) {
	                    window.location.href = "login.do";
	                }
	                return false;
	            }
	        });

	        $('.forget-form').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            ignore: "",
	            rules: {
	                email: {
	                    required: true,
	                    email: true
	                }
	            },

	            messages: {
	                email: {
	                    required: "Email is required."
	                }
	            },

	            invalidHandler: function (event, validator) { //display error alert on form submit   

	            },

	            highlight: function (element) { // hightlight error inputs
	                $(element)
	                    .closest('.control-group').addClass('error'); // set error class to the control group
	            },

	            success: function (label) {
	                label.closest('.control-group').removeClass('error');
	                label.remove();
	            },

	            errorPlacement: function (error, element) {
	                error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	            },

	            submitHandler: function (form) {
	                window.location.href = "login.do";
	            }
	        });

	        $('.forget-form input').keypress(function (e) {
	            if (e.which == 13) {
	                if ($('.forget-form').validate().form()) {
	                    window.location.href = "login.do";
	                }
	                return false;
	            }
	        });

	        jQuery('#forget-password').click(function () {
	            jQuery('.login-form').hide();
	            jQuery('.forget-form').show();
	        });

	        jQuery('#back-btn').click(function () {
	            jQuery('.login-form').show();
	            jQuery('.forget-form').hide();
	        });

	        $('.register-form').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            ignore: "",
	            rules: {
	                register_username: {
	                    required: true
	                },
	                register_password: {
	                    required: true,
	                    
	                    minlength: 6
	                },
	                rpassword: {
	                    equalTo: "#register_password"
	                },
	                email: {
	                    required: true,
	                    email: true
	                },
	                type : {
	                	required : true,
	                },
	                tnc: {
	                    required: true
	                }
	            },

	            messages: { // custom messages for radio buttons and checkboxes
	            	register_username: {
	                    required: "请填写用户名"
	                },
	                register_password: {
	                    required: "请输入密码",
	                    
	                    minlength: "密码请输入不小于6位数的"
	                },
	                rpassword: {
	                    equalTo: "两次密码不等"
	                },
	                email: {
	                    required: "请输入邮箱",
	                    email: "请输入正确的邮箱"
	                },
	            	type : {
	            		required : "请选择一个角色"
	            	},
		            tnc: {
	                    required: "请同意协议"
	                }
	            },

	            invalidHandler: function (event, validator) { //display error alert on form submit   

	            },

	            highlight: function (element) { // hightlight error inputs
	                $(element)
	                    .closest('.control-group').addClass('error'); // set error class to the control group
	            },

	            success: function (label) {
	                label.closest('.control-group').removeClass('error');
	                label.remove();
	            },

	            errorPlacement: function (error, element) {
	                if (element.attr("name") == "tnc") { // insert checkbox errors after the container                  
	                    error.addClass('help-small no-left-padding').insertAfter($('#register_tnc_error'));
	                } else {
	                    error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	                }
	            },

	            submitHandler: function (form) {
	                window.location.href = "register.do?" + "register_username=" + $('#register_username').val() + "&register_password=" + $('#register_password').val() + "&register_email=" + $("#register_email").val() + "&register_telephone=" + $("#register_telephone").val() + "&type=" + $("#type").val();
	            }
	        });

	        jQuery('#register-btn').click(function () {
	            jQuery('.login-form').hide();
	            jQuery('.register-form').show();
	        });

	        jQuery('#register-back-btn').click(function () {
	            jQuery('.login-form').show();
	            jQuery('.register-form').hide();
	        });
        }

    };

}();