<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>tx 音乐是生活的调味剂</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- Bootstrap -->
    <link href="../../css/bootstrap.css" rel="stylesheet" media="screen" />
    <link href="../../css/thin-admin.css" rel="stylesheet" media="screen" />
    <link href="../../css/font-awesome.css" rel="stylesheet" media="screen" />
    <link href="../../style/style.css" rel="stylesheet" />
    <link href="../../style/dashboard.css" rel="stylesheet" />
    <style>
        #fanye .disabled{
            pointer-events:none;
        }
    </style>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
          <!--<script src="../../assets/js/html5shiv.js"></script>
          <script src="../../assets/js/respond.min.js"></script>-->
    <![endif]-->
    <script src="../../js/jquery.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script src="/js/layui/layui.all.js" charset="utf-8"></script>
    <!--<script type="text/javascript" src="js/smooth-sliding-menu.js"></script>-->
    <script>


        $(function () {
            $("#toggleSearch").click(function () {
                var flag =  $(this).attr("flag");
                if(flag == 1){
                    $("#find").show(500);
                    $(this).attr("flag",2);
                    $(this).html("收缩↑");
                }else{
                    $("#find").hide(500)
                    $(this).attr("flag",1);


                    $(this).html("展开↓");
                }
            });
            /*$("#addSong").click(function () {
                window.location.href = "addSong.html";
            });*/

            var pageNo = parseInt($("#pageNo").val());
            var totalPage = parseInt($("#totalPage").val());

            if (pageNo == 1 && pageNo == totalPage) {
                $("#pre").addClass("disabled")
                $("#next").addClass("disabled")
            }

            if (pageNo == 1 && pageNo < totalPage) {
                $("#pre").addClass("disabled")
                $("#next").removeClass("disabled")
            }
            if (pageNo > 1 && pageNo < totalPage) {
                $("#pre").removeClass("disabled")
                $("#next").removeClass("disabled")
            }
            if (pageNo > 1 && pageNo == totalPage) {
                $("#pre").removeClass("disabled")
                $("#next").addClass("disabled")
            }

            $("#pre a").click(function () {
                pageNo = pageNo - 1;
                $("#pageNo").val(pageNo)
                $("#mtFrom").submit();
            })

            $("#next a").click(function () {
                pageNo = pageNo + 1;
                $("#pageNo").val(pageNo)
                $("#mtFrom").submit();
            })

            $("#toNum a").click(function () {
                var val = $(this).text();
                $("#pageNo").val(val)
                $("#mtFrom").submit();
            })


            var pop;
            $("#addSong").click(function () {
                pop = layer.open({
                    type: 1,
                    content: $('#mtypePop'),
                    cancel: function(index, layero){
                        $('#mtypePop').css("display", "none")
                    }
                });
            })

            layui.use('form', function () {
                var form = layui.form;
                form.on('submit(demo1)', function(data){
                    $.ajax({
                        url: "/mtype/addMtype",
                        data: data.field,
                        dataType: "text",
                        type: "POST",
                        success: function (d) {
                            if (d == "success") {
                                layer.msg("添加成功")
                                layer.close(pop)
                                $('#mtypePop').css("display", "none")
                            }
                        }
                    })
                    return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
                });
            })

            var pop1;
            $("[modify]").click(function () {
                var tid = parseInt($(this).attr("tid"));

                $.ajax({
                    url: "/mtype/toUpdate",
                    data: {tid: tid},
                    dataType: "json",
                    type: "POST",
                    success: function (jsonObject) {
                        $("#tid").val(jsonObject.tid)
                        $("#ptname").val(jsonObject.tname)
                        $("#ptdesc").val(jsonObject.tdesc)
                    }
                })

                pop1 = layer.open({
                    type: 1,
                    content: $('#mtypePop1'),
                    cancel: function(index, layero){
                        $('#mtypePop1').css("display", "none")
                    }
                });
            })

            layui.use('form', function () {
                var form = layui.form;
                form.on('submit(demo2)', function(data){
                    $.ajax({
                        url: "/mtype/updateMtype",
                        data: data.field,
                        dataType: "text",
                        type: "POST",
                        success: function (d) {
                            if (d == "success") {
                                layer.msg("修改成功")
                                layer.close(pop1)
                                $("#mtFrom").submit();
                                $('#mtypePop1').css("display", "none")
                            }
                        }
                    })
                    return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
                });
            })


            $(".btn-warning").click(function () {
                var tid = parseInt($(this).attr("tid"));

                layer.confirm('是否确定删除?', {icon: 3, title:'提示'}, function(index){
                    $.ajax({
                        url: "/mtype/deleteMtype",
                        data: {tid: tid},
                        type: "POST",
                        dataType: "text",
                        success: function (obj) {
                            if (obj == "success") {
                                layer.msg("删除成功")
                                $("#mtFrom").submit();
                                layer.close(index);
                            }
                        }
                    })

                });

            })

            $("#search").click(function () {
                $("#pageNo").val(1)
                $("#mtFrom").submit();
            });



        })


    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>
<div class="container">
    <div class="top-navbar header b-b"> <a data-original-title="Toggle navigation" class="toggle-side-nav pull-left" href="#"><i class="icon-reorder"></i> </a>
        <div class="brand pull-left"> <a href="index.html"><img src="../../images/logo.png" width="147" height="33" /></a></div>
        <ul class="nav navbar-nav navbar-right  hidden-xs">
            <li class="dropdown"> <a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i class="icon-warning-sign"></i> <span class="badge">5</span> </a>
                <ul class="dropdown-menu extended notification">
                    <li class="title">
                        <p>You have 5 new notifications</p>
                    </li>
                    <li> <a href="#"> <span class="label label-success"><i class="icon-plus"></i></span> <span class="message">New user registration.</span> <span class="time">1 mins</span> </a> </li>
                    <li> <a href="#"> <span class="label label-danger"><i class="icon-warning-sign"></i></span> <span class="message">High CPU load on cluster #2.</span> <span class="time">5 mins</span> </a> </li>
                    <li> <a href="#"> <span class="label label-success"><i class="icon-plus"></i></span> <span class="message">New user registration.</span> <span class="time">10 mins</span> </a> </li>
                    <li> <a href="#"> <span class="label label-info"><i class="icon-bullhorn"></i></span> <span class="message">New items are in queue.</span> <span class="time">25 mins</span> </a> </li>
                    <li> <a href="#"> <span class="label label-warning"><i class="icon-bolt"></i></span> <span class="message">Disk space to 85% full.</span> <span class="time">35 mins</span> </a> </li>
                    <li class="footer"> <a href="#">View all notifications</a> </li>
                </ul>
            </li>
            <li class="dropdown"> <a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i class="icon-tasks"></i> <span class="badge">7</span> </a>
                <ul class="dropdown-menu extended notification">
                    <li class="title">
                        <p>You have 7 pending tasks</p>
                    </li>
                    <li> <a href="#"> <span class="task"> <span class="desc">Preparing new release</span> <span class="percent">30%</span> </span>
                        <div class="progress progress-small">
                            <div class="progress-bar progress-bar-info" style="width: 30%;"></div>
                        </div>
                    </a> </li>
                    <li> <a href="#"> <span class="task"> <span class="desc">Change management</span> <span class="percent">80%</span> </span>
                        <div class="progress progress-small progress-striped active">
                            <div class="progress-bar progress-bar-danger" style="width: 80%;"></div>
                        </div>
                    </a> </li>
                    <li> <a href="#"> <span class="task"> <span class="desc">Mobile development</span> <span class="percent">60%</span> </span>
                        <div class="progress progress-small">
                            <div class="progress-bar progress-bar-success" style="width: 60%;"></div>
                        </div>
                    </a> </li>
                    <li> <a href="#"> <span class="task"> <span class="desc">Database migration</span> <span class="percent">20%</span> </span>
                        <div class="progress progress-small">
                            <div class="progress-bar progress-bar-warning" style="width: 20%;"></div>
                        </div>
                    </a> </li>
                    <li class="footer"> <a href="#">View all tasks</a> </li>
                </ul>
            </li>
            <li class="dropdown"> <a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i class="icon-envelope"></i> <span class="badge">1</span> </a>
                <ul class="dropdown-menu extended notification">
                    <li class="title">
                        <p>You have 3 new messages</p>
                    </li>
                    <li> <a href="#"> <span class="photo"> <img src="../../images/profile.png" width="34" height="34" /></span> <span class="subject"> <span class="from">John Doe</span> <span class="time">Just Now</span> </span> <span class="text"> Consetetur sadipscing elitr... </span> </a> </li>
                    <li> <a href="#"> <span class="photo"><img src="../../images/profile.png" width="34" height="34" /></span> <span class="subject"> <span class="from">John Doe</span> <span class="time">35 mins</span> </span> <span class="text"> Sed diam nonumy... </span> </a> </li>
                    <li> <a href="#"> <span class="photo"><img src="../../images/profile.png" width="34" height="34" /></span> <span class="subject"> <span class="from">John Doe</span> <span class="time">5 hours</span> </span> <span class="text"> No sea takimata sanctus... </span> </a> </li>
                    <li class="footer"> <a href="#">View all messages</a> </li>
                </ul>
            </li>
            <li class="dropdown user  hidden-xs"> <a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i class="icon-male"></i> <span class="username">John Doe</span> <i class="icon-caret-down small"></i> </a>
                <ul class="dropdown-menu">
                    <li><a href="#"><i class="icon-user"></i> My Profile</a></li>
                    <li><a href="#"><i class="icon-calendar"></i> My Calendar</a></li>
                    <li><a href="#"><i class="icon-tasks"></i> My Tasks</a></li>
                    <li class="divider"></li>
                    <li><a href="#"><i class="icon-key"></i> Log Out</a></li>
                </ul>
            </li>
        </ul>
        <form role="search" class="navbar-form pull-right" id="search-form" />
        <input type="search" placeholder="Search..." class="search-query" id="search-input" />
        </form>
    </div>
</div>
<div class="wrapper">

    <jsp:include page="menu.jsp"></jsp:include>
    <div class="page-content">
        <div class="content container">
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-title">流派列表 <small>favor song</small></h2>
                </div>
            </div>


            <form id="mtFrom" action="/mtype/list" method="post" class="form-horizontal" >
            <div class="row">
                <div class="col-lg-12">
                    <div class="widget">
                        <div class="widget-header"> <i class="icon-list-ol"></i>
                            <h3>搜索条件</h3>
                        </div>
                        <div class="widget-content">

                            <fieldset id="find">
                                <div class="control-group">
                                    <label for="tname" class="control-label">流派</label>
                                    <div class="controls form-group">
                                        <div class="input-group"> <span class="input-group-addon"><i class="icon-music"></i></span>
                                            <input type="text" value="${tname}" placeholder="如：摇滚" name="tname" id="tname" class="form-control" />

                                        </div>
                                    </div>
                                </div>
                            </fieldset>
                            <div class="form-actions text-right">
                                <div>
                                    <button class="btn btn-primary" id="search">搜索</button>
                                    <button id="addSong" class="btn btn-primary" data-target="#myModal2"  type="button" >添加流派</button>
                                    <button id="toggleSearch" flag = "2" class="btn btn-default" type="button">收缩↑</button>
                                </div>
                            </div>


                        </div>
                        <div class="widget-content">
                            <div class="body">
                                <table class="table table-striped table-images" style="color: white;font-size: 14px">
                                    <thead>
                                    <tr>
                                        <th class="hidden-xs-portrait">序号</th>

                                        <th class="hidden-xs">流派</th>
                                        <th class="hidden-xs">描述</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="mtype" items="${page.list}" varStatus="status">
                                        <tr>
                                            <td class="hidden-xs-portrait">${status.count}</td>
                                            <td class="hidden-xs-portrait">${mtype.tname}</td>
                                            <td class="hidden-xs"> ${mtype.tdesc} </td>
                                            <td><button type="button" modify class="btn btn-sm btn-primary" tid="${mtype.tid}"> 修改 </button>
                                                <button data-toggle="button" tid="${mtype.tid}" class="btn btn-sm btn-warning"> 删除 </button></td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                                <jsp:include page="pagination.jsp"></jsp:include>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            </form>
        </div>
    </div>
</div>

<div class="bottom-nav footer"> 拓薪教育出品 </div>
<script>$("#songtype").addClass("current");</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

</body>




</html>

<div id="mtypePop" style="margin-right: 50px;margin-top: 50px; display: none">
    <form id="addMtypeForm" class="layui-form" method="post" action="/mtype/addMtype" lay-filter="example">
        <div class="layui-form-item" >
            <label class="layui-form-label">输入框</label>
            <div class="layui-input-block">
                <input  type="text" name="tname" style="color: black;"  lay-verify="title" autocomplete="off" placeholder="请输入流派名" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">文本域</label>
            <div class="layui-input-block">
                <textarea  style="color: black;" placeholder="请输入流派描述" class="layui-textarea" name="tdesc"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-normal layui-btn-radius" lay-submit="" lay-filter="demo1">添加流派</button>
            </div>
        </div>
    </form>
</div>

<div id="mtypePop1" style="margin-right: 50px;margin-top: 50px; display: none">
    <form id="updateMtypeForm" class="layui-form" method="post" action="/type/updateMtype" lay-filter="example">
        <input type="hidden" name="tid" id="tid">
        <div class="layui-form-item" >
            <label class="layui-form-label">输入框</label>
            <div class="layui-input-block">
                <input id="ptname" type="text" name="tname" style="color: black;"  lay-verify="title" autocomplete="off" placeholder="请输入流派名" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">文本域</label>
            <div class="layui-input-block">
                <textarea id="ptdesc" style="color: black;" placeholder="请输入流派描述" class="layui-textarea" name="tdesc"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-normal layui-btn-radius" lay-submit="" lay-filter="demo2">修改流派</button>
            </div>
        </div>
    </form>
</div>



