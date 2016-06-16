
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

					<div class="span12">

						<!-- BEGIN STYLE CUSTOMIZER -->

						<div class="portlet box red">

							<div class="portlet-title">

								<div class="caption"><i class="icon-cogs"></i>交易列表</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body">

								<table class="table table-hover">

									<thead>

										<tr>

											<th>房产编号</th>

											<th>房产名称</th>

											<th>卖家</th>

											<th>买家</th>

											<th>价格</th>

										</tr>

									</thead>

									<tbody>
									<#if houseList ??>
										<#list houseList as house>
										<tr>
											
											<td>${house.houseId}</td>

											<td>${house.houseName}</td>
											
											<#if sellerList??>
												<#list sellerList as seller>
													<#if seller_index == house_index>
														<td>${seller.name}</td>
													</#if>
												</#list>
											</#if>
											
											<#if buyerList??>
												<#list buyerList as buyer>
													<#if buyer_index == house_index>
														<td>${buyer.name}</td>
													</#if>
												</#list>
											</#if>

											<td>${house.housePrice}</span></td>

										</tr>
 										</#list>
									</#if>
									</tbody>

								</table>

							</div>

						</div>

						<!-- END SAMPLE TABLE PORTLET-->


						<!-- END BEGIN STYLE CUSTOMIZER --> 


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