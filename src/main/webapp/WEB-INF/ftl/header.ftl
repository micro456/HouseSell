	
	<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>房屋销售系统</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	<!-- BEGIN GLOBAL MANDATORY STYLES -->

	<link href="media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/style-metro.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/style.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/style-responsive.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

	<link href="media/css/uniform.default.css" rel="stylesheet" type="text/css"/>

	<!-- END GLOBAL MANDATORY STYLES -->

	<!-- BEGIN PAGE LEVEL STYLES -->

	<link href="media/css/dropzone.css" rel="stylesheet"/>

	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="media/image/favicon.ico" />
	

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed page-full-width">
	<input type="hidden" id="contextPath" value="${micro.contextPath}" />
	<div class="header navbar navbar-inverse navbar-fixed-top">

		<!-- BEGIN TOP NAVIGATION BAR -->

		<div class="navbar-inner">

			<div class="container">

				<!-- BEGIN LOGO -->

				<a class="brand" href="home.do">

				<img src="media/image/logo.png" alt="logo">

				</a>

				<!-- END LOGO -->

				<!-- BEGIN HORIZANTAL MENU -->

				<div class="navbar hor-menu hidden-phone hidden-tablet">

					<div class="navbar-inner">

						<ul class="nav">

							<li class="visible-phone visible-tablet">

								<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->

								<form class="sidebar-search">

									<div class="input-box">

										<a href="javascript:;" class="remove"></a>

										<input type="text" placeholder="Search...">            

										<input type="button" class="submit" value=" ">

									</div>

								</form>

								<!-- END RESPONSIVE QUICK SEARCH FORM -->

							</li>

							

							<li>

								<a data-toggle="dropdown" class="dropdown-toggle" href="javascript:;">

								<span class="selected"></span>

								房产销售信息

								<span class="arrow"></span>     

								</a>

								<ul class="dropdown-menu">

									<li>

										<a href="onSell.do">

										在销售房产</a>

									</li>

									<li>

										<a href="sold.do">

										已销售房产 </a>

									</li>



								</ul>

								<b class="caret-out"></b>                        

							</li>
							<li>

								<a data-toggle="dropdown" class="dropdown-toggle" href="javascript:;">

								<span class="selected"></span>

								用户信息

								<span class="arrow"></span>     

								</a>

								<ul class="dropdown-menu">

									<li>

										<a href="buyer.do">

										买家</a>

									</li>

									<li>

										<a href="seller.do">

										卖家 </a>

									</li>



								</ul>

								<b class="caret-out"></b>                        

							</li>

							<li>

								<a href="buy.do">购买</a>

							</li>

							<li>

								<a href="sell.do">出售</a>

							</li>
							
							<li>

								<a href="tradeInfo.do">

								交易信息 

								</a>

							</li>

						</ul>

					</div>

				</div>

				<!-- END HORIZANTAL MENU -->

				<!-- BEGIN RESPONSIVE MENU TOGGLER -->

				<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">

				<img src="media/image/menu-toggler.png" alt="">

				</a>          

				<!-- END RESPONSIVE MENU TOGGLER -->            

				<!-- BEGIN TOP NAVIGATION MENU -->              

				<ul class="nav pull-right">

					<!-- BEGIN NOTIFICATION DROPDOWN -->   


					<!-- END NOTIFICATION DROPDOWN -->

					<!-- BEGIN INBOX DROPDOWN -->


					<!-- END INBOX DROPDOWN -->

					<!-- BEGIN TODO DROPDOWN -->


					<!-- END TODO DROPDOWN -->

					<!-- BEGIN USER LOGIN DROPDOWN -->

					<li class="dropdown user">

						<a href="#" class="dropdown-toggle" data-toggle="dropdown">

						<img alt="" src="media/image/house/kumamon-logo.jpg">

						<span class="username"><#if username ??>${username}<#else>illagelUser</#if></span>

						<i class="icon-angle-down"></i>

						</a>

						<ul class="dropdown-menu">


							<li><a href="welcome.do"><i class="icon-key"></i>退出</a></li>

						</ul>

					</li>

					<!-- END USER LOGIN DROPDOWN -->

				</ul>

				<!-- END TOP NAVIGATION MENU --> 

			</div>

		</div>
		
		

		<!-- END TOP NAVIGATION BAR -->

	</div>