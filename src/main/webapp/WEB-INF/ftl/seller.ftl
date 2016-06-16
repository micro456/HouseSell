
	<!-- BEGIN HEADER -->
	<#include "header.ftl" />
	
	<!-- END HEADER -->

	<!-- BEGIN CONTAINER -->
<div class="page-container row-fluid">

		<!-- BEGIN PAGE -->

		<div class="page-content">


			<!-- BEGIN PAGE CONTAINER-->

			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">

					<div class="span6">

						<!-- BEGIN SAMPLE TABLE PORTLET-->

						<div class="portlet box purple">

							<div class="portlet-title">

								<div class="caption"><i class="icon-comments"></i>卖家列表</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body">

								<table class="table table-striped table-hover">

									<thead>

										<tr>

											<th>卖家ID</th>

											<th>卖家账号名</th>

											<th>联系电话</th>

											<th class="hidden-480">电子邮件</th>

										</tr>

									</thead>

									<tbody>
									<#if sellerList ??>
										
										<#list sellerList as seller>
											<tr>
	
												<td>${seller.userId}</td>
	
												<td>${seller.name}</td>
	
												<td><#if seller.telephone ??>${seller.telephone}</#if></td>
	
												<td class="hidden-480"><#if seller.email ??>${seller.email}</#if></td>
	
											</tr>
										</#list>
									</#if>

									</tbody>

								</table>

							</div>

						</div>

						<!-- END SAMPLE TABLE PORTLET-->

					</div> 

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->


				<!-- END PAGE CONTENT-->

			</div>

			<!-- END PAGE CONTAINER-->

		</div>

		<!-- END PAGE --> 


	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->
	<#include "footer.ftl" />
	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script src="media/js/dropzone.js"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="media/js/app.js"></script>

	<script>

		jQuery(document).ready(function() {

		// initiate layout and plugins

		App.init();

		});

	</script>

	<!-- END PAGE LEVEL SCRIPTS -->

<script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();</script></body>

<!-- END BODY -->

</html>