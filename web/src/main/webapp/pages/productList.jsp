<%--
  Created by IntelliJ IDEA.
  User: wtyoha
  Date: 2019/11/14
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="content-wrapper">

    <!-- 内容头部 -->
    <section class="content-header">
        <h1>
            产品管理
            <small>全部产品</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/index.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="javascript:void(0)" onclick="getContent('${pageContext.request.contextPath}/product/productList')">产品管理</a></li>
            <li class="active">全部产品</li>
        </ol>
    </section>
    <!-- 内容头部 /-->

    <!-- 正文区域 -->
    <section class="content">

        <!-- .box-body -->
        <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">列表</h3>
            </div>

            <div class="box-body">

                <!-- 数据表格 -->
                <div class="table-box">

                    <!--工具栏-->
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default" title="新建"
                                        onclick='getContent("${pageContext.request.contextPath}/product/edit")'><i
                                        class="fa fa-file-o"></i> 新建
                                </button>
                                <button type="button" class="btn btn-default" title="删除"
                                        onclick='confirm("你确认要删除吗？")'><i class="fa fa-trash-o"></i> 删除
                                </button>
                                <button type="button" class="btn btn-default" title="开启"
                                        onclick='confirm("你确认要开启吗？")'><i class="fa fa-check"></i> 开启
                                </button>
                                <button type="button" class="btn btn-default" title="屏蔽"
                                        onclick='confirm("你确认要屏蔽吗？")'><i class="fa fa-ban"></i> 屏蔽
                                </button>
                                <button type="button" class="btn btn-default" title="刷新"
                                        onclick="getContent('${pageContext.request.contextPath}/product/productList');"><i class="fa fa-refresh"></i> 刷新
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="box-tools pull-right">
                        <div class="has-feedback">
                            <input type="text" class="form-control input-sm" placeholder="搜索">
                            <span class="glyphicon glyphicon-search form-control-feedback"></span>
                        </div>
                    </div>
                    <!--工具栏/-->

                    <!--数据列表-->
                    <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                        <thead>
                        <tr style="font-size: 12px">
                            <th class="" style="padding-right:0px;">
                                <input id="selall" type="checkbox" class="icheckbox_square-blue">
                            </th>
                            <th class="sorting_asc">ID</th>
                            <th class="sorting">产品编号</th>
                            <th class="sorting">产品名称</th>
                            <th class="sorting">金额</th>
                            <th class="sorting">出发城市</th>
                            <th class="sorting">出发时间</th>
                            <th class="sorting">产品描述</th>
                            <th class="sorting">订单状态</th>

                            <th class="text-center">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${requestScope.productList}" var="product" varStatus="i">
                            <tr style="font-size: 12px">
                                <td><input name="ids" type="checkbox"></td>
                                <td>
                                        ${i.count}
                                </td>
                                <td>${product.productNum}</td>
                                <td>${product.productName}</td>
                                <td>￥${product.productPrice}</td>
                                <td>${product.cityName}</td>
                                <td>${product.departureTimeStr}</td>
                                <td>${product.productDesc}</td>
                                <td>${product.productStatusStr}</td>

                                <td class="text-center">
                                    <button type="button" class="btn bg-olive btn-xs"
                                            onclick='location.href="productEdit.jsp"'>订单
                                    </button>
                                    <button type="button" class="btn bg-olive btn-xs"
                                            onclick='location.href="productEdit.jsp"'>详情
                                    </button>
                                    <button type="button" class="btn bg-olive btn-xs"
                                            onclick='location.href="productEdit.jsp"'>编辑
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>



                        </tbody>
                        <!--
                    <tfoot>
                    <tr>
                    <th>Rendering engine</th>
                    <th>Browser</th>
                    <th>Platform(s)</th>
                    <th>Engine version</th>
                    <th>CSS grade</th>
                    </tr>
                    </tfoot>-->
                    </table>
                    <!--数据列表/-->


                </div>
                <!-- 数据表格 /-->


            </div>
            <!-- /.box-body -->

            <!-- .box-footer-->
            <div class="box-footer">
                <div class="pull-left">
                    <div class="form-group form-inline">
                        总共2 页，共14 条数据。 每页
                        <select class="form-control">
                            <option>10</option>
                            <option>15</option>
                            <option>20</option>
                            <option>50</option>
                            <option>80</option>
                        </select> 条
                    </div>
                </div>

                <div class="box-tools pull-right">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">首页</a>
                        </li>
                        <li><a href="#">上一页</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">下一页</a></li>
                        <li>
                            <a href="#" aria-label="Next">尾页</a>
                        </li>
                    </ul>
                </div>

            </div>
            <!-- /.box-footer-->


        </div>

    </section>
    <!-- 正文区域 /-->
</div>
