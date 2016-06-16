
	<!-- BEGIN HEADER -->
	<#include "header.ftl" />
	
	<!-- END HEADER -->

	<!-- BEGIN CONTAINER -->

<div class="page-container row-fluid">
		<!-- BEGIN PAGE -->

		<div class="page-content">
			<div class="row-fluid">

					<div class="span12">

						<div class="tabbable tabbable-custom boxless">

							<ul class="nav nav-tabs">

								<li class="active"><a href="#tab_1" data-toggle="tab">房产填写</a></li>

							</ul>
							<div class="alert alert-error hide">

								<button class="close" data-dismiss="alert"></button>
				
								<span>Enter any username and password.</span>
				
							</div>

							<div class="tab-content">

								<div class="tab-pane active" id="tab_1">

									<div class="portlet box blue">

										<div class="portlet-title">

											<div class="caption"><i class="icon-reorder"></i>房产信息</div>

											<div class="tools">

												<a href="javascript:;" class="collapse"></a>

												<a href="#portlet-config" data-toggle="modal" class="config"></a>

												<a href="javascript:;" class="reload"></a>

												<a href="javascript:;" class="remove"></a>

											</div>

										</div>

										<div class="portlet-body form">

											<!-- BEGIN FORM-->

											<form action="" class="horizontal-form" id="sellHouseForm">


												<div class="row-fluid">

													<div class="span6 ">

														<div class="control-group">

															<label class="control-label" for="firstName">房产名字</label>

															<div class="controls">

																<input type="text" name="houseName" class="m-wrap span12" placeholder="房屋名字" id="houseName" />

															</div>

														</div>

													</div>

													<!--/span-->

													<div class="span6 ">

														<div class="control-group">

															<label class="control-label" for="lastName">房产地址</label>

															<div class="controls">

																<input type="text" name="houseAddress" class="m-wrap span12" placeholder="地址" id="houseAddress" />

															</div>

														</div>

													</div>

													<!--/span-->

												</div>

												<!--/row-->

												<div class="row-fluid">

													<div class="span6 ">

														<div class="control-group">

															<label class="control-label" for="firstName">房产价格</label>

															<div class="controls">

																<input type="text" name="housePrice" class="m-wrap span12" placeholder="价格" id="housePrice" />

															</div>

														</div>

													</div>

													<!--/span-->

													<div class="span6 ">

														<div class="control-group">

															<label class="control-label" for="lastName">房产面积</label>

															<div class="controls">

																<input type="text" id="houseArea" name="houseArea" class="m-wrap span12" placeholder="面积">

															</div>

														</div>

													</div>

													<!--/span-->
													<div class="controls">
													
													<label class="control-label" for="lastName">房产类型</label>

														<select class="small m-wrap" tabindex="1" id="houseType" name="houseType">
														
														<#if allHouseTypeList ??>
															<#list allHouseTypeList as houseType>

															<option value="${houseType.id}">${houseType.typeName}</option>

															</#list>
														</#if>

														</select>

													</div>
													
													<div class="controls">
													
													<label class="control-label" for="lastName">房产所在地区</label>

														<select class="small m-wrap" tabindex="1" id="houseRegion" name="houseRegion>
														
														<#if allRegionList ??>
															<#list allRegionList as region>

															<option value="${region.id}">${region.regionName}</option>

															</#list>
														</#if>

														</select>

													</div>

												</div>

												<!--/row-->        


												<div  class="form-actions">

													<a href="javascript:sellHouse($('#houseName').val(),$('#houseAddress').val(),$('#houseArea').val(),$('#housePrice').val(),$('#houseType').val(),$('#houseRegion').val());" class="btn blue"><i class="icon-ok"></i>出售</a>

												</div>

											</form>

											<!-- END FORM--> 

										</div>

									</div>

								</div>



							</div>

						</div>

					</div>

				</div>

		</div>

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
		 Sell.init();

		});

	</script>

	<!-- END PAGE LEVEL SCRIPTS -->

<script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();</script></body>

<!-- END BODY -->

</html>