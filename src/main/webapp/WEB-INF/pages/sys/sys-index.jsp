<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>后台管理</title>
<meta name="description" content="后台管理系统">
<meta name="keywords" content="index">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="apple-mobile-web-app-title" content="后台管理" />
<%@ include file="/include/common-include.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/amazeui.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/admin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/app.css" />
</head>
<body>
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

	<header class="am-topbar admin-header">
		<div class="am-topbar-brand">
			<strong>微信公众号管理平台</strong>
		</div>

		<button
			class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
			data-am-collapse="{target: '#topbar-collapse'}">
			<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
		</button>

		<div class="am-collapse am-topbar-collapse" id="topbar-collapse">

			<ul
				class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
				<li><a href="javascript:;"><span class="am-icon-envelope-o"></span>
						消息 <span class="am-badge am-badge-warning">5</span></a></li>
				<li class="am-dropdown" data-am-dropdown><a
					class="am-dropdown-toggle" data-am-dropdown-toggle
					href="javascript:;"> <span class="am-icon-users"></span> 管理员 <span
						class="am-icon-caret-down"></span>
				</a>
					<ul class="am-dropdown-content">
						<!--  <li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
          <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li> -->
						<li><a href="#"><span class="am-icon-power-off"></span>注销</a></li>
					</ul></li>
				<li class="am-hide-sm-only"><a href="javascript:;"
					id="admin-fullscreen"><span class="am-icon-arrows-alt"></span>
						<span class="admin-fullText">全屏显示</span></a></li>
			</ul>
		</div>
	</header>

	<div class="am-cf admin-main">
		<!-- sidebar start -->
		<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
			<div class="am-offcanvas-bar admin-offcanvas-bar">
				<ul class="am-list admin-sidebar-list">
					<li><a href="${pageContext.request.contextPath}/sys/index"><span
							class="am-icon-home"></span> 首页</a></li>
					<li class="admin-parent"><a class="am-cf"
						data-am-collapse="{target: '#collapse-nav'}"><span
							class="am-icon-wechat am-icon-sm"></span>&nbsp; 微信管理 <span
							class="am-icon-angle-right am-fr am-margin-right"></span></a>
						<ul class="am-list am-collapse admin-sidebar-sub am-in"
							id="collapse-nav">
							<li><a
								href="${pageContext.request.contextPath}/sys/user/registered"
								class="am-cf"> <span class="am-icon-users"></span> 注册用户 <span
									class="am-badge am-badge-secondary am-margin-right am-fr">+6</span>
									</span></a></li>
							<li><a
								href="${pageContext.request.contextPath}/sys/user/unregistered"><span
									class="am-icon-user-plus"></span> 关注(Only) <span
									class="am-badge am-badge-secondary am-margin-right am-fr">+22</span></a></li>
							<li><a href="admin-gallery.html"><span
									class="am-icon-envelope-o"></span> 用户消息<span
									class="am-badge am-badge-secondary am-margin-right am-fr">+12</span></a></li>
						</ul></li>
				</ul>

				<div class="am-panel am-panel-default admin-sidebar-panel">
					<div class="am-panel-bd">
						<p>
							<span class="am-icon-bookmark"></span> 公告
						</p>
						<p>时光静好，与君语；细水流年，与君同。—— Amaze UI</p>
					</div>
				</div>

				<div class="am-panel am-panel-default admin-sidebar-panel">
					<div class="am-panel-bd">
						<p>
							<span class="am-icon-tag"></span> wiki
						</p>
						<p>Welcome to the Amaze UI wiki!</p>
					</div>
				</div>
			</div>
		</div>
		<!-- sidebar end -->

		<!-- content start -->
		<div class="admin-content">

			<div class="am-cf am-padding">
				<div class="am-cf text-center">
					<strong>数据统计(fake)</strong>
				</div>
			</div>

			<ul
				class="am-avg-sm-1 am-avg-md-2 am-margin am-padding am-text-center admin-content-list ">
				<li><a href="#" class="am-text-secondary"><span
						class="am-icon-btn am-icon-recycle"></span><br />昨日访问<br />80082</a></li>
				<li><a href="#" class="am-text-secondary"><span
						class="am-icon-btn am-icon-user-md"></span><br />在线用户<br />3000</a></li>
			</ul>
			<div class="am-cf am-padding ">
				<div class="am-cf text-center">
					<strong>访问日志(fake)</strong>
				</div>
			</div>
			<hr>
			<div class="am-g">
				<div class="am-u-sm-12">
					<table
						class="am-table am-table-bd am-table-striped admin-content-table">
						<thead>
							<tr>
								<th>序号</th>
								<th>用户名</th>
								<th>最近访问地址</th>
								<th>最近访问时间</th>
								<th>管理</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>John Clark</td>
								<td><a href="#">http://www.baidu.com</a></td>
								<td>2015-10-23 23:12:23</td>
								<td>
									<div class="am-dropdown" data-am-dropdown>
										<a href="#">删除</a>
										</li>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- content end -->

	</div>

	<a href="#" class="am-show-sm-only admin-menu"
		data-am-offcanvas="{target: '#admin-offcanvas'}"> <span
		class="am-icon-btn am-icon-th-list"></span>
	</a>

	<footer>
		<hr>
		<p class="am-padding-left am-footer">
			<small>Powered by AmazeUI <br> © 2015 Dbyz.
			</small>
		</p>
	</footer>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/common/jquery/jquery-2.1.4.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/common/amaze/amazeui.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/sys/app.js"></script>
</body>
</html>