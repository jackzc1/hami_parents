<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>tx 音乐是生活的调味剂</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <style>
        #fanye .disabled{
            pointer-events:none;
        }
    </style>
    <script src="/js/layui/layui.all.js" charset="utf-8"></script>
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
            $("#addSong").click(function () {
                window.location.href = "/song/toAdd";
            });

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

            $("#search").click(function () {
                $("#pageNo").val(1)
                $("#mtFrom").submit();
            });

            //删除
            $(".btn-warning").click(function () {
                var sid = parseInt($(this).attr("sid"));
                layer.confirm('是否确定删除?', {icon: 3, title:'提示'}, function(index){
                    $.ajax({
                        url: "/song/deleteSong",
                        data: {sid: sid},
                        type: "POST",
                        dataType: "text",
                        success: function (obj) {
                            if (obj == "success") {
                                layer.msg("删除成功")
                                $("#pageNo").val(1)
                                $("#mtFrom").submit();
                                layer.close(index);
                            }
                        }
                    })

                });

            })
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
                    <h2 class="page-title">歌曲列表 <small>favor song</small></h2>
                </div>
            </div>
            <form id="mtFrom" action="/song/list" method="post" class="form-horizontal" />
                <div class="row">
                <div class="col-lg-12">
                    <div class="widget">
                        <div class="widget-header"> <i class="icon-list-ol"></i>
                            <h3>搜索条件</h3>
                        </div>
                        <div class="widget-content">

                            <fieldset id="find">
                                <!--<legend class="section">Horizontal form</legend>-->
                                <div class="control-group">
                                    <label for="sname" class="control-label">歌名</label>
                                    <div class="controls form-group">
                                        <div class="input-group"> <span class="input-group-addon"><i class="icon-music"></i></span>
                                            <input type="text" value="${sq.sname}" placeholder="如：想你的365天" name="sname" id="sname" class="form-control" />
                                        </div>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label for="srname" class="control-label">歌手</label>
                                    <div class="controls form-group">
                                        <div class="input-group"> <span class="input-group-addon"><i class="icon-user"></i></span>
                                            <input type="text" value="${sq.srname}" placeholder="如：李玟" name="srname" id="srname" class="form-control" />
                                        </div>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label for="aname" class="control-label">专辑</label>
                                    <div class="controls form-group">
                                        <div class="input-group"> <span class="input-group-addon"><i class="icon-reorder"></i></span>
                                            <input type="text" placeholder="如：宝莲灯" value="${sq.aname}"  name="aname" id="aname" class="form-control" />
                                        </div>
                                    </div>
                                </div>


                                <div class="control-group">
                                    <label for="tid" class="control-label">流派</label>

                                    <div class="controls form-group">
                                        <select id="tid" name="tid" class="form-control ">
                                            <option value="">-----请选择-----</option>
                                            <c:forEach var="mtype" items="${mtypes}">
                                                <option value="${mtype.tid}" <c:if test="${mtype.tid == sq.tid}">selected</c:if>>${mtype.tname}</option>
                                            </c:forEach>
                                        </select>

                                    </div>
                                </div>

                            </fieldset>
                            <div class="form-actions text-right">
                                <div>
                                    <button class="btn btn-primary" type="submit">搜索</button>
                                    <button id="addSong" class="btn btn-primary" type="button" >添加歌曲</button>
                                    <button id="toggleSearch" flag = "2" class="btn btn-default" type="button">收缩↑</button>
                                </div>
                            </div>


                        </div>
                        <div class="widget-content" >
                            <div class="body">
                                <table class="table table-striped table-images" style="color: white;font-size: 14px">
                                    <thead>
                                    <tr>
                                        <th class="hidden-xs-portrait">序号</th>
                                        <th>封面</th>
                                        <th>歌名</th>
                                        <th class="hidden-xs-portrait">歌手</th>
                                        <th class="hidden-xs">专辑</th>
                                        <th class="hidden-xs">流派</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach items="${page.list}" var="song" varStatus="status">
                                        <tr>
                                            <td class="hidden-xs-portrait">${status.count}</td>
                                            <td><img src="${path}${song.pic}" /></td>
                                            <td> ${song.sname} </td>
                                            <td class="hidden-xs-portrait">${song.songer.srname}</td>
                                            <td class="hidden-xs"> <p><strong>${song.album.aname}</strong></p></td>
                                            <td class="hidden-xs"> ${song.mtype.tname} </td>
                                            <td><button class="btn btn-sm btn-primary"> 修改 </button>
                                                <button data-toggle="button" class="btn btn-sm btn-warning sc" sid="${song.sid}"> 删除 </button></td>
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
<script>$("#song").addClass("current");</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

</body>
</html>
