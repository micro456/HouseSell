

	<!-- BEGIN HEADER -->
	<#include "header.ftl" />
	
	<!-- END HEADER -->

	<!-- BEGIN CONTAINER -->
<div class="page-container row-fluid">

		<!-- BEGIN PAGE -->

		<div class="page-content no-min-height">


			<!-- BEGIN PAGE CONTAINER-->

			<div class="container-fluid promo-page">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN STYLE CUSTOMIZER -->


						<!-- END BEGIN STYLE CUSTOMIZER -->  

						<h3 class="page-title">

							 <small>按户型查询</small>

						</h3>
						
						<div class="controls">
													
							<form  action="onSell.do" method="post" id="searchForm">
							
							
									<div class="alert alert-error hide">

										<button class="close" data-dismiss="alert"></button>

										查询条件错误

									</div>

									<div class="alert alert-success hide">

										<button class="close" data-dismiss="alert"></button>

										查询结果已返回

									</div>
							
								<div class="control-group">
								<select class="small m-wrap" tabindex="1" name="typeId">
								
									<#if allHouseTypeList ??>
									<option value="" selected="selected">请选择户型</option>
										<#list allHouseTypeList as houseType>
	
										<option value="${houseType.id}">${houseType.typeName}</option>
	
										</#list>
									</#if>

								</select>
								
								</div>
								
								<div class="control-group">
								<select class="small m-wrap" tabindex="1" name="regionId">
								
									<#if allHouseTypeList ??>
									<option value="" selected="selected">请选择地区</option>
										<#list allRegionList as region>
	
										<option value="${region.id}">${region.regionName}</option>
	
										</#list>
									</#if>

								</select>
								
								</div>
								
								<div class="control-group error">

										<label class="control-label">最低价格<span class="required">*</span></label>

										<div class="controls">

											<input id="lowPrice" name="lowPrice" class="span6 m-wrap" type="text"><span class="help-inline" for="number">请输入数字.</span>

										</div>

								</div>
								
								<div class="control-group error">

										<label class="control-label">最高价格<span class="required">*</span></label>

										<div class="controls">

											<input id="highPrice" name="highPrice" class="span6 m-wrap" type="text"><span class="help-inline" for="number">请输入数字.</span>

										</div>

								</div> 
								<input type="submit" class="btn"  value="查询"></input>
								
							</form>
						</div>
						

					</div>
					
						<!-- BEGIN CONDENSED TABLE PORTLET-->

						<div class="portlet box red">

							<div class="portlet-title">

								<div class="caption"><i class="icon-picture"></i>待售房产信息详情</div>

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
											
											<th>房屋所在地区</th>
											
											<th>房屋价格</th>

											<th class="hidden-480">所有人</th>
											
											<th>类型</th>

											<th>发布时间</th>
											
											<#if currentUser ?? && currentUser.type == 2>
											
											<th>删除</th>
											
											</#if>

										</tr>

									</thead>

									<tbody>
									<#if onSellHouseList ??>
									
										<#list onSellHouseList as house>
											<#assign index = house_index />
											<tr>
	
												<td>${house.houseId}</td>
	
												<td>${house.houseName}</td>
	
												<td>${house.houseAddress}</td>
	
												<td>${house.houseArea}</td>
												
												<td>${house.region}</td>
	
												<td>${house.housePrice}</td>
												
												<td>${house.userName}</td>
												
												<td>${house.type}</td>
												
												
												<td>${house.createTime?string('yyyy-MM-dd')}</td>
												
												<#if currentUser ?? && currentUser.type == 2> <#-- 当管理员权限才能删除 -->
											
												<td><a class="btn red icn-only" href="javascript:deleteHouse('${house.houseId}');"><i class="icon-remove icon-white"></i></td>
														
												</#if>
											
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

		</div>

		<!-- END PAGE --> 

	</div>
	<!-- END CONTAINER -->

	

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<#include "footer.ftl" />

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script src="media/js/dropzone.js"></script>
	
	<script type="text/javascript" src="media/js/jquery.validate.min.js"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="media/js/app.js"></script>

	<script>

		jQuery(document).ready(function() {

		// initiate layout and plugins

		App.init();
		
	    FormValidation.init();

		});

	</script>

	<!-- END PAGE LEVEL SCRIPTS -->

<script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();</script></body>

<!-- END BODY -->

</html>