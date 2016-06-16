

function deleteHouse(houseId) {
	
	$.ajax({

	     type : 'post',

	     url : "deleteHouse.do",

		 dataType : 'JSON',
		 
		 data : {
			 houseId : houseId
		 },

	     success : function(data) {
	    	if(data.isSuccess) {
	    		alert('删除成功');
	    		window.location.reload();
	    	} else {
	    		alert(data.errorMsg)
	    	}
	    } ,
	     error : function() {  
	    	 var rt = window.confirm("异常,刷新当前页面？");
	    		if(rt) {
		    		window.location.reload();
	    		} 
	        } 

	});
}

// 出售房产
function sellHouse(houseName, houseAddress, houseArea, housePrice, houseType, houseRegion) {
	$.ajax({

	     type : 'post',

	     url : "sellHouseValidate.do",

		 dataType : 'JSON',
		 
		 data : {
			 houseName : houseName,
			 houseAddress : houseAddress,
			 houseArea : houseArea,
			 housePrice : housePrice,
			 houseType : houseType,
			 houseRegion : houseRegion
		 },

	     success : function(data) {
	    	if(data.isSuccess) {
	    		var isSell = confirm("请确认数据，即将出售");
	    		if(isSell) {
//	    			var sellHouse = function() {
	    				// 内嵌ajax
	    	    		$.ajax({

	    	    		     type : 'post',

	    	    		     url : "sellHouse.do",

	    	    			 dataType : 'JSON',
	    	    			 
	    	    			 data : {
	    	    				 houseName : houseName,
	    	    				 houseAddress : houseAddress,
	    	    				 houseArea : houseArea,
	    	    				 housePrice : housePrice,
	    	    				 houseType : houseType,
	    	    				 houseRegion : houseRegion
	    	    			 },

	    	    		     success : function(data) {
	    	    		    	if(data.isSuccess) {
	    	    		    		alert('已成功出售');
	    	    		    		window.location.reload();
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
//		    		}
	    		} else {
	    			alert("你取消了出售");
	    		}
	    		
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
	 
}

	/*$('#sellHouseForm').validate({
		 errorElement: 'label', //default input error message container
	    errorClass: 'help-inline', // default input error message class
	    focusInvalid: false, // do not focus the last invalid input
	    ignore: "",
	    rules: {
	        houseName: {
	            required: true
	        },
	        houseArea: {
	            required: true,
	            number : true
	        },
	        housePrice: {
		       	 required: true,
		       	 number : true
	        },
	        houseAddress: {
	            required: true,
	        }
	    },

	    messages: { // custom messages for radio buttons and checkboxes
	    	houseName: {
	            required: "请输入房屋名字"
	        },
	        houseArea: {
	            required: "请输入面积",
	            number : "请输入数字"
	        },
	        housePrice: {
	            required: "请输入价格",
	            number : "请输入数字"
	        },
	        houseAddress: {
	            required: "请输入地址"
	        }
	    },

	});*/

// 购买房产
function buyHouse(houseId) {
	houseId = houseId.attr("value");
	$.ajax({

	     type : 'post',

	     url : "buyHouse.do",

		 dataType : 'JSON',
		 
		 data : {
			 houseId : houseId
		 },

	     success : function(data) {
	    	if(data.isSuccess) {
	    		alert('购买成功');
	    		window.location.reload();
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
}

// test sell
/*var Sell = function () {
    
    return {
        //main function to initiate the module
        init: function () {
        	
           $('#sellHouseForm').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            rules: {
	    	        houseName: {
	    	            required: true
	    	        },
	    	        houseArea: {
	    	            required: true,
	    	            number : true
	    	        },
	    	        housePrice: {
	    		       	 required: true,
	    		       	 number : true
	    	        },
	    	        houseAddress: {
	    	            required: true,
	    	        }
	    	    },

	    	    messages: { // custom messages for radio buttons and checkboxes
	    	    	houseName: {
	    	            required: "请输入房屋名字"
	    	        },
	    	        houseArea: {
	    	            required: "请输入面积",
	    	            number : "请输入数字"
	    	        },
	    	        housePrice: {
	    	            required: "请输入价格",
	    	            number : "请输入数字"
	    	        },
	    	        houseAddress: {
	    	            required: "请输入地址"
	    	        }
	    	    },

	            invalidHandler: function (event, validator) { //display error alert on form submit   
	                $('.alert-error', $('#sellHouseForm')).show();
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
	            	window.location.href = "sellHouse.do?" + "houseName=" + $('#houseName').val() + "&houseArea=" + $('#houseArea').val() + "&housePrice=" + $('#housePrice').val()+ "&houseAddress=" + $('#houseAddress').val();
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
	            }
	        });

        }

    };

}();*/

// 查找房产类型
function searchType() {
	var typeId = $("#houseType").val();
	$.ajax({

	     type : 'post',

	     url : "onSell.do",

		 dataType : 'JSON',
		 
		 data : {
			 typeId : typeId
		 },

	     success : function(data) {
	    	if(data.isSuccess) {
	    		window.location.reload();
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
}


var FormValidation = function () {


    return {
        //main function to initiate the module
        init: function () {

            // for more info visit the official plugin documentation: 
            // http://docs.jquery.com/Plugins/Validation

            var form1 = $('#searchForm');
            var error1 = $('.alert-error', form1);
            var success1 = $('.alert-success', form1);

            form1.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-inline', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",
                rules: {
                    lowPrice: {
                        number : true
                    },
                    highPrice: {
                        number: true
                    }
                },
                
                messages: { // custom messages for radio buttons and checkboxes
                	lowPrice: {
                        number: "请输入数字"
                    },
                    highPrice: {
                        number: "请输入数字"
                    }
                },


                invalidHandler: function (event, validator) { //display error alert on form submit              
                    success1.hide();
                    error1.show();
                    App.scrollTo(error1, -200);
                },

                highlight: function (element) { // hightlight error inputs
                    $(element)
                        .closest('.help-inline').removeClass('ok'); // display OK icon
                    $(element)
                        .closest('.control-group').removeClass('success').addClass('error'); // set error class to the control group
                },

                unhighlight: function (element) { // revert the change dony by hightlight
                    $(element)
                        .closest('.control-group').removeClass('error'); // set error class to the control group
                },

                success: function (label) {
                    label
                        .addClass('valid').addClass('help-inline ok') // mark the current input as valid and display OK icon
                    .closest('.control-group').removeClass('error').addClass('success'); // set success class to the control group
                },

                submitHandler: function (form) {
                    success1.show();
                    form.submit();
                    error1.hide();
                }
            });


            //apply validation on chosen dropdown value change, this only needed for chosen dropdown integration.


        }

    };

}();