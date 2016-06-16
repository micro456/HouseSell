<div class="page-container row-fluid">

		<!-- BEGIN SIDEBAR -->

		<div class="page-sidebar nav-collapse collapse">

			<!-- BEGIN SIDEBAR MENU -->        

			<ul class="page-sidebar-menu">

				<li>

					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

					<div class="sidebar-toggler hidden-phone"></div>

					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

				</li>

				<li>

					<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->

					<form class="sidebar-search">

						<div class="input-box">

							<a href="javascript:;" class="remove"></a>

							<input type="text" placeholder="Search..." />

							<input type="button" class="submit" value=" " />

						</div>

					</form>

					<!-- END RESPONSIVE QUICK SEARCH FORM -->

				</li>


				<li class="active ">

					<a href="javascript:;">

					<i class="icon-th"></i> 

					<span class="title">房屋销售信息</span>

					<span class="selected"></span>

					<span class="arrow open"></span>

					</a>

					<ul class="sub-menu">


						<li >

							<a href="onSell.do">

							在销售房产</a>

						</li>


						<li >

							<a href="sold.do">

							已销售房产</a>

						</li>
						
						
						
							<li >
	
								<a href="seller.do">
	
								卖家</a>
	
							</li>
						
						
					
							<li >
	
								<a href="buyer.do">
	
								买家</a>
	
							</li>

					</ul>

				</li>


				<li class="">

					<a href="javascript:;">

					<i class="icon-th"></i> 

					<span class="title">购买与出售</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">
						<#if currentUser ?? && (currentUser.type == 1 || currentUser.type == 2)>

							<li >
	
								<a href="buy.do">
	
								购买房产</a>
	
							</li>
						</#if>
						<#if currentUser ?? && (currentUser.type == 0 || currentUser.type == 2)>
							<li >
	
								<a href="sell.do">
	
								出售房产</a>
	
							</li>
						</#if>

					</ul>

				</li>

				<li class="last ">

					<a href="tradeInfo.do">

					<i class="icon-bar-chart"></i> 

					<span class="title">交易信息</span>

					</a>

				</li>

			</ul>

			<!-- END SIDEBAR MENU -->

		</div>

		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->

		<!-- END PAGE -->

	</div>