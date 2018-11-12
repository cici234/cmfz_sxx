<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%--<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>--%>

    <script>
        $(function () {
            $("#al").treegrid({
                url:'${pageContext.request.contextPath}/album/query',
                idField:'id',
                treeField:'title',
                pagination:true,
                pageNumber:1,
                pageSize:2,
                pageList:[2,4,6,8,10],
                animate:true,
                checkbox:true,
                cascadeCheck:true,
                fit:true,
                fitColumns:true,

                columns:[[
                    {title:'名字',field:'title',width:180},
                    {field:'downPath',title:'下载路径',width:80},
                    {field:'size',title:'章节大小',width:80},
                    {field:'duration',title:'章节时长',width:80},


                ]],
                toolbar:'#alb',


            });
        });

        function openaddAlbum() {

            $("#addAblum").dialog({
                buttons:[
                    {
                        iconCls:'icon-save',
                        text:'保存',
                        handler:function () {

                            $("#addAlbumInputForm").form('submit',{
                                url:'${pageContext.request.contextPath}/album/save',
                                success:function (result) {
                                    var resultObj = $.parseJSON(result);
                                    if(resultObj.success){
                                        $.messager.show({title:'提示',msg:"添加成功"});
                                    }else{
                                        $.messager.show({title:"提示",msg:resultObj.message});
                                    }


                                    //关闭对话框
                                    $("#addAblum").dialog('close');
                                    //刷新datagrid
                                    $("#al").datagrid('reload');
                                }


                            });
                        }
                    },{iconCls:'icon-cancel',
                        text:'关闭',
                        handler:function () {
                            $("#addAblum").dialog('close');
                        }}
                ]
            });
        }





        function openrealAlbum() {
            var selectRow1=$("#al").treegrid("getSelected");
            if(selectRow1.star!=null){
                $("#albumDia").dialog({
                    href:'${pageContext.request.contextPath}/admin/reaAlbum.jsp?id='+selectRow1.id,
                    buttons:[
                        {
                            iconCls:'icon-cancel',
                            text:'关闭',
                            handler:function () {
                                //关闭对话框
                                $("#albumDia").dialog('close');
                                //刷新
                                $("#albumDia").treegrid('reload');
                            }
                        }
                    ]
                })
            }
        }

        function openAddChapter() {
            var selectRow1=$("#al").treegrid("getSelected");
            if(selectRow1!=null){
                if(selectRow1.size==null){
                    //添加章节
                    $("#addChapter").dialog({
                        href:'${pageContext.request.contextPath}/admin/addChapter.jsp?id='+selectRow1.id,
                        draggable:false,
                        buttons:[
                            {
                                iconCls:'icon-save',
                                text:'保存',
                                handler:function () {

                                    $("#addChapterInputForm").form('submit',{
                                        url:'${pageContext.request.contextPath}/chapter/save',
                                        success:function (result) {
                                            var resultObj = $.parseJSON(result);
                                            if (resultObj.success) {
                                                $.messager.show({title: '提示', msg: "添加成功"});
                                            } else {
                                                $.messager.show({title: "提示", msg: resultObj.message});
                                            }

                                            //关闭对话框
                                            $("#addChapter").dialog('close');
                                            //刷新datagrid
                                            $("#al").treegrid('reload');
                                        }
                                    });
                                }
                            },{iconCls:'icon-cancel',
                                text:'关闭',
                                handler:function () {
                                    $("#addChapter").dialog('close');
                                }}
                        ]
                    })
                }else{
                    $.messager.show({title: "提示", msg: "请选择专辑！！！"});
                }
            }else{
                $.messager.show({title: "提示", msg: "请选择一行！！！"});
            }
        }

        

        function chapdownload() {
            var selectRow=$("#al").treegrid("getSelected");
            if(selectRow!=null){
                if(selectRow.size!=null){
                    location.href='${pageContext.request.contextPath}/chapter/download?fileName='+selectRow.downPath;
                }else{
                    $.messager.show({title: "提示", msg: "请先选择章节！！！"});
                }

            }else{
                $.messager.show({title: "提示", msg: "请先选择一行！！！"});
            }
        }

    </script>
<%--</head>
<body>--%>
    <table id="al"></table>

    <div id="alb">
        <a href="#" id="realAlbum" class="easyui-linkbutton" onclick="openrealAlbum()" data-options="iconCls:'icon-tip',plain:true">专辑详情</a>
        <a href="#" class="easyui-linkbutton" onclick="openaddAlbum();" data-options="iconCls:'icon-save',plain:true">添加专辑</a>
        <a href="#" class="easyui-linkbutton" onclick="openAddChapter()" data-options="iconCls:'icon-save',plain:true">添加章节</a>
        <a href="#" class="easyui-linkbutton" onclick="chapdownload()" data-options="iconCls:'icon-back',plain:true">下载音频</a>
    </div>

    <%--专辑详情对话框--%>
    <div id="albumDia" data-options="iconCls:'icon-save',width:500,height:530,title:'专辑详情页'">

    </div>
    <%--添加专辑对话框--%>
    <div id="addAblum"
         data-options="href:'${pageContext.request.contextPath}/admin/addAlbum.jsp',iconCls:'icon-save',width:600,height:500,title:'添加专辑'">

    </div>

    <%--添加章节对话框--%>
    <div id="addChapter"
         data-options="href:'${pageContext.request.contextPath}/admin/addChapter.jsp',iconCls:'icon-save',width:600,height:400,title:'添加章节'">

    </div>
<%--
</body>
</html>--%>
