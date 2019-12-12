<%@ page import="cn.wtyoha.company_background_system.domain.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <!-- Font Awesome -->
    <!-- Ionicons -->
    <!-- iCheck -->
    <!-- Morris chart -->
    <!-- jvectormap -->
    <!-- Date Picker -->
    <!-- Daterange picker -->
    <!-- Bootstrap time Picker -->
    <!--<link rel="stylesheet" href="../../../plugins/timepicker/bootstrap-timepicker.min.css">-->
    <!-- bootstrap wysihtml5 - text editor -->
    <!--数据表格-->
    <!-- 表格树 -->
    <!-- select2 -->
    <!-- Bootstrap Color Picker -->
    <!-- bootstrap wysihtml5 - text editor -->
    <!--bootstrap-markdown-->
    <!-- Theme style -->
    <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
    <!-- Ion Slider -->
    <!-- ion slider Nice -->
    <!-- bootstrap slider -->
    <!-- bootstrap-datetimepicker -->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


    <!-- jQuery 2.2.3 -->
    <!-- jQuery UI 1.11.4 -->
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <!-- Bootstrap 3.3.6 -->
    <!-- Morris.js charts -->
    <!-- Sparkline -->
    <!-- jvectormap -->
    <!-- jQuery Knob Chart -->
    <!-- daterangepicker -->
    <!-- datepicker -->
    <!-- Bootstrap WYSIHTML5 -->
    <!-- Slimscroll -->
    <!-- FastClick -->
    <!-- iCheck -->
    <!-- AdminLTE App -->
    <!-- 表格树 -->
    <!-- select2 -->
    <!-- bootstrap color picker -->
    <!-- bootstrap time picker -->
    <!--<script src="../../../plugins/timepicker/bootstrap-timepicker.min.js"></script>-->
    <!-- Bootstrap WYSIHTML5 -->
    <!--bootstrap-markdown-->
    <!-- CK Editor -->
    <!-- InputMask -->
    <!-- DataTables -->
    <!-- ChartJS 1.0.1 -->
    <!-- FLOT CHARTS -->
    <!-- FLOT RESIZE PLUGIN - allows the chart to redraw when the window is resized -->
    <!-- FLOT PIE PLUGIN - also used to draw donut charts -->
    <!-- FLOT CATEGORIES PLUGIN - Used to draw bar charts -->
    <!-- jQuery Knob -->
    <!-- Sparkline -->
    <!-- Morris.js charts -->
    <!-- Ion Slider -->
    <!-- Bootstrap slider -->
    <!-- bootstrap-datetimepicker -->
    <!-- 页面meta /-->

    <link rel="stylesheet" href="../plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="../plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="../plugins/morris/morris.css">
    <link rel="stylesheet" href="../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="../plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="../plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="../plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="../plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="../plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="../plugins/select2/select2.css">
    <link rel="stylesheet" href="../plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="../plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="../plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="../plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="../plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="../plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
    <script type="text/javascript" src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script>
        function refreshPage() {
            $("#orderForm").submit();
        }
        function submitNewOrder() {
            if ($("#orderNum").val() == "") {
                alert("订单编号为空!");
                return;
            }else if ($("#bindProductId").val() == "") {
                alert("未选择产品!");
                return;
            } else if ($("#memberNickName").val() == "") {
                alert("会员昵称为空!");
                return;
            }else if ($("#memberName").val() == "") {
                alert("联系人姓名为空!");
                return;
            } else {
                $("#orderForm").prop("action", "${pageContext.request.contextPath}/order/newOrderSubmit");
                $("#orderForm").submit();
            }
        }
    </script>
</head>

<body class="hold-transition skin-yellow sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="head.jsp"/>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <jsp:include page="left-nav.jsp"/>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                订单管理
                <small>订单表单</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="all-order-manage-list.html">订单管理</a></li>
                <li class="active">订单表单</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!--订单信息-->
            <form id="orderForm" action="${pageContext.request.contextPath}/order/orderNew" method="post">
                <div class="panel panel-default">
                    <div class="panel-heading">订单-产品信息</div>
                    <div class="row data-type">
                        <div class="col-md-2 title">订单编号</div>
                        <div class="col-md-4 data">
                            <input type="text" id="orderNum" name="orderNum" class="form-control" placeholder="订单编号"
                                   value="${order.orderNum}">
                        </div>

                        <div class="col-md-2 title">下单时间</div>
                        <div class="col-md-4 data">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input type="text" class="form-control pull-right" id="datepicker-a3"
                                       value="${order.orderTimeStr}" name="orderTimeStr">
                            </div>
                        </div>
                        <div class="col-md-2 title">路线名称</div>
                        <div class="col-md-4 data">
                            <select class="form-control select2" id="bindProductId" name="product.id" onchange="refreshPage()">
                                <c:choose>
                                    <c:when test="${order.product != null}">
                                        <option class="selected" value="${order.product.id}">${order.product.productNum}&nbsp;|&nbsp;${order.product.productName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option></option>
                                    </c:otherwise>
                                </c:choose>
                                <c:forEach items="${productList}" var="product">
                                    <option value="${product.id}">${product.productNum}&nbsp;|&nbsp;${product.productName}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="col-md-2 title">出发城市</div>
                        <div class="col-md-4 data">
                            <input class="form-control" type="text" name="cityName" disabled="disabled"
                                   value="${order.product.cityName}">
                        </div>

                        <div class="col-md-2 title">出发时间</div>
                        <div class="col-md-4 data">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input type="text" class="form-control pull-right" id="datepicker-a6"
                                       disabled="disabled"
                                       value="${order.product.departureTimeStr}">
                            </div>
                        </div>
                        <div class="col-md-2 title">出游人数</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" placeholder="出游人数" disabled="disabled"
                                   value="${order.peopleCount}">
                        </div>

                        <div class="col-md-2 title rowHeight2x">其他信息</div>
                        <div class="col-md-10 data rowHeight2x">
                            <textarea class="form-control" rows="3" name="orderDesc"
                                      placeholder="其他信息">${order.orderDesc}</textarea>
                        </div>

                    </div>
                </div>
                <!--产品信息/-->

                <!--联系人信息-->
                <div class="panel panel-default">
                    <div class="panel-heading">联系人信息
                        <div style="float: right;">
                            选择已有会员
                            <select class="" id="bindMember" name="member.id" onchange="refreshPage()">
                                <c:if test="${order.member == null}">
                                    <option value=""></option>
                                </c:if>
                                <c:forEach items="${members}" var="member">
                                    <c:if test="${order.member !=null && order.member.id == member.id}">
                                        <option value="${member.id}">${member.name}&nbsp;|&nbsp;${member.phoneNum}</option>
                                    </c:if>
                                </c:forEach>
                                <c:forEach items="${members}" var="member">
                                    <c:if test="${order.member==null || !(order.member.id == member.id)}">
                                        <option value="${member.id}">${member.name}&nbsp;|&nbsp;${member.phoneNum}</option>
                                    </c:if>
                                </c:forEach>
                                <c:if test="${order.member != null}">
                                    <option value=""></option>
                                </c:if>
                            </select>
                        </div>
                    </div>
                    <div class="row data-type">
                        <div class="col-md-2 title">会员</div>
                        <div class="col-md-4 data text">
                            <input type="text" class="form-control" value="${order.member.nickName}" id="memberNickName" name="member.nickName">

                        </div>

                        <div class="col-md-2 title">联系人</div>
                        <div class="col-md-4 data text">
                            <input type="text" class="form-control" value="${order.member.name}" id="memberName" name="member.name">
                        </div>

                        <div class="col-md-2 title">手机号</div>
                        <div class="col-md-4 data text">
                            <input type="text" class="form-control" value="${order.member.phoneNum}" name="member.phoneNum">
                        </div>

                        <div class="col-md-2 title">邮箱</div>
                        <div class="col-md-4 data text">
                            <input type="text" class="form-control" value="${order.member.email}" name="member.email">
                        </div>
                    </div>
                </div>
                <!--联系人信息/-->
            </form>
            <!--工具栏-->
            <div class="box-tools text-center">
                <button type="button" class="btn bg-green"
                        onclick="submitNewOrder()">
                    提交
                </button>
                <button type="button" class="btn bg-default"
                        onclick="location.href='${pageContext.request.contextPath}/order/orderList'">返回
                </button>
            </div>
            <%--            <div class="box-tools text-center">--%>
            <%--                <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>--%>
            <%--            </div>--%>
            <!--工具栏/-->

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <jsp:include page="foot.jsp"/>
    <!-- 底部导航 /-->

</div>


<script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="../plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="../plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="../plugins/raphael/raphael-min.js"></script>
<script src="../plugins/morris/morris.min.js"></script>
<script src="../plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="../plugins/knob/jquery.knob.js"></script>
<script src="../plugins/daterangepicker/moment.min.js"></script>
<script src="../plugins/daterangepicker/daterangepicker.js"></script>
<script src="../plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="../plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="../plugins/fastclick/fastclick.js"></script>
<script src="../plugins/iCheck/icheck.min.js"></script>
<script src="../plugins/adminLTE/js/app.min.js"></script>
<script src="../plugins/treeTable/jquery.treetable.js"></script>
<script src="../plugins/select2/select2.full.min.js"></script>
<script src="../plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="../plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="../plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="../plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="../plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="../plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="../plugins/ckeditor/ckeditor.js"></script>
<script src="../plugins/input-mask/jquery.inputmask.js"></script>
<script src="../plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="../plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="../plugins/chartjs/Chart.min.js"></script>
<script src="../plugins/flot/jquery.flot.min.js"></script>
<script src="../plugins/flot/jquery.flot.resize.min.js"></script>
<script src="../plugins/flot/jquery.flot.pie.min.js"></script>
<script src="../plugins/flot/jquery.flot.categories.min.js"></script>
<script src="../plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="../plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="../plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
    $(document).ready(function () {
        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });


    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }


    $(document).ready(function () {
        $('#datepicker-a3').datepicker({
            autoclose: true,
            language: 'zh-CN'
        });
    });


    $(document).ready(function () {
        $('#datepicker-a6').datepicker({
            autoclose: true,
            language: 'zh-CN'
        });
    });


    $(document).ready(function () {
        // 激活导航位置
        setSidebarActive("order-manage");
    });
</script>
</body>

</html>