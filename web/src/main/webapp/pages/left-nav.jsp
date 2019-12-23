<%--
  Created by IntelliJ IDEA.
  User: wtyoha
  Date: 2019/11/13
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    <%--    异步请求用于获取主页面内容区域的信息--%>

    function getContent(url, info, successMsg) {
        $.get(url, info, function (data) {
            var t = typeof data;
            if (t === 'string') {
                // 返回结果不是 json 时加载到页面中
                $("#mainContennt").html(data);
                if (successMsg != null && successMsg !== '') {
                    alert(successMsg);
                }
            } else {
                //    返回结果是 json 时， 做解析，报告错误
                if (data.error === true) {
                    alert(data.errorMsg);
                }
            }
        })
    }
</script>
<!-- 导航侧栏 -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>张猿猿</p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>
        <!-- search form -->
        <!--<form action="#" method="get" class="sidebar-form">
    <div class="input-group">
        <input type="text" name="q" class="form-control" placeholder="搜索...">
        <span class="input-group-btn">
        <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
        </button>
      </span>
    </div>
</form>-->
        <!-- /.search form -->


        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header"><span style="color: white"><b>菜单</b></span></li>

            <li id="admin-index"><a href="all-admin-index.jsp"><i class="fa fa-dashboard"></i> <span>首页</span></a>
            </li>

            <!-- 菜单 -->


            <li class="treeview">
                <a href="#">
                    <i class="fa fa-folder"></i> <span>系统管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <li id="user-manage">
                        <a href="${pageContext.request.contextPath}/user/userList">
                            <i class="fa fa-circle-o"></i> 用户管理
                        </a>
                    </li>

                    <li id="role-manage">
                        <a href="${pageContext.request.contextPath}/role/roleList">
                            <i class="fa fa-circle-o"></i> 角色管理
                        </a>
                    </li>

                    <li id="resource-authority">
                        <a href="${pageContext.request.contextPath}/permission/permissionList">
                            <i class="fa fa-circle-o"></i> 资源权限管理
                        </a>
                    </li>

                    <li id="view-log">
                        <a href="${pageContext.request.contextPath}/sysLog/sysLogList">
                            <i class="fa fa-circle-o"></i> 访问日志
                        </a>
                    </li>

                </ul>
            </li>


            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i> <span>基础数据</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <li id="product-manage">
                        <a href="${pageContext.request.contextPath}/product/productList">
                            <i class="fa fa-circle-o"></i> 产品管理
                        </a>
                    </li>

                    <li id="order-manage">
                        <a href="${pageContext.request.contextPath}/order/orderList">
                            <i class="fa fa-circle-o"></i> 订单管理
                        </a>
                    </li>

                </ul>
            </li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
<!-- 导航侧栏 /-->
