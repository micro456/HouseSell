<div class="page-container row-fluid">

	<!-- BEGIN HEADER -->
	<#include "header.ftl" />
	
	<!-- END HEADER -->

	<!-- BEGIN CONTAINER -->

		<!-- BEGIN PAGE -->

		<div class="page-content">


			<!-- BEGIN PAGE CONTAINER-->

			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN CONDENSED TABLE PORTLET-->

						<div class="portlet box red">

							<div class="portlet-title">

								<div class="caption"><i class="icon-picture"></i>已销售房产信息详情</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body">

								<table class="table table-condensed table-hover">

									<thead>

										<tr>

											<th>房产ID</th>

											<th>房屋名称</th>

											<th>房屋地址</th>
											
											<th>房屋面积</th>
											
											<th>房屋价格</th>

											<th class="hidden-480">购买人</th>

											<th>发布时间</th>
											
											<#if currentUser.type == 2><th>删除</th></#if>

										</tr>

									</thead>

									<tbody>
									<#if soldHouseList ?? && buyerList ??>
									
										<#list soldHouseList as house>
											<#assign index = house_index />
											<tr>
	
												<td>${house.houseId}</td>
	
												<td>${house.houseName}</td>
	
												<td>${house.houseAddress}</td>
	
												<td>${house.houseArea}</td>
	
												<td>${house.housePrice}</td>
												
												<#list buyerList as buyer>
													<#if buyer_index == index>
														<td>${buyer.name}</td>
													</#if>
												</#list>
												
												
												<td>${house.createTime?string('yyyy-MM-dd')}</td>
											
												<#if currentUser.type == 2><td><a class="btn red icn-only" href="javascript:deleteHouse('${house.houseId}');"><i class="icon-remove icon-white"></i></td></#if>
	
											</tr>
											
										</#list>
										
									</#if>

									</tbody>

								</table>

							</div>

						</div>

						<!-- END CONDENSED TABLE PORTLET-->

					</div>

						<!-- END SAMPLE TABLE PORTLET-->


						<!-- END BEGIN STYLE CUSTOMIZER --> 

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->


				<!-- END PAGE CONTENT-->

			</div>

			<!-- END PAGE CONTAINER-->


		<!-- END PAGE --> 

	</div>
	<!-- END CONTAINER -->

	

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<#include "footer.ftl" />

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