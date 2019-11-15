<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 内容区域 -->
<div class="content-wrapper">

    <!-- 内容头部 -->
    <section class="content-header">
        <h1>
            订单管理
            <small>订单表单</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/index.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="javascript:void(0)" onclick='getContent("${pageContext.request.contextPath}/product/productList")'>产品列表</a></li>
            <li class="active">产品表单</li>
        </ol>
    </section>
    <!-- 内容头部 /-->

    <!-- 正文区域 -->
    <section class="content">

        <form id="productInfo">
            <!--订单信息-->
            <div class="panel panel-default">
                <div class="panel-heading">产品信息</div>
                <div class="row data-type">

                    <div class="col-md-2 title">产品编号</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="产品编号" value="" name="productNum">
                    </div>

                    <div class="col-md-2 title">出发时间</div>
                    <div class="col-md-4 data">
                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <input type="text" class="form-control pull-right" id="datepicker-a3"
                                   name="departureTimeStr">
                        </div>
                    </div>
                    <div class="col-md-2 title">产品名称</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="产品名称" name="productName">
                    </div>

                    <div class="col-md-2 title">出发城市</div>
                    <div class="col-md-4 data">
                        <input type="text" name="cityName"/>
                    </div>

                    <div class="col-md-2 title">产品价格</div>
                    <div class="col-md-4 data">
                        <input type="text" name="productPrice"/>
                    </div>

                    <div class="col-md-2 title">产品状态</div>
                    <div class="col-md-4 data">
                        <select class="form-control select2" name="productStatusStr" style="width: 100%;">
                            <option value="" selected="selected">关闭</option>
                            <option value="">开启</option>
                        </select>
                    </div>

                    <div class="col-md-2 title rowHeight2x">其他信息</div>
                    <div class="col-md-10 data rowHeight2x">
                        <textarea class="form-control" rows="3" placeholder="其他信息" name="productDesc"></textarea>
                    </div>

                </div>
            </div>
            <!--订单信息/-->

            <!--工具栏-->
            <div class="box-tools text-center">
                <button type="button" class="btn bg-maroon"
                        onclick="getContent('${pageContext.request.contextPath}/product/editSubmit', $('#productInfo').serialize())">保存
                </button>
                <button type="button" class="btn bg-default" onclick="getContent('${pageContext.request.contextPath}/product/productList');">返回</button>
            </div>
            <!--工具栏/-->
        </form>

    </section>
    <!-- 正文区域 /-->

</div>
<!-- 内容区域 /-->

