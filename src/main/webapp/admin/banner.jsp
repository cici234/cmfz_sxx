<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%--<!doctype html>
<html lang="en">
<head>--%>
<%--    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>--%>

    <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>--%>

    <script>
        $(function () {
            $("#ban").datagrid({
                url:'${pageContext.request.contextPath}/banner/findByPage',
                pagination:true,
                pageNumber:1,
                pageSize:2,
                pageList:[2,4,6,8,10],
                fit:true,
                fitColumns:true,

                columns:[[
                    {field:'cks',title:'cks',checkbox:true},
                    {field:'id',title:'id',width:120},
                    {field:'title',title:'title',width:120},
                    {field:'imgPath',title:'imgPath',width:120},
                    {field:'descr',title:'descr',width:120},
                    {field:'status',title:'status',width:120},
                    {field:'creattime',title:'creattime',width:120},
                    {title:'options',field:'options',width:200,
                        formatter:function (value,row,index) {
                            return "<a href='javascript:;' class='options' onclick=\"delRow('"+row.id+"')\" data-options=\"iconCls:'icon-remove',plain:true\">删除</a>&nbsp;&nbsp;"
                                +"<a href='javascript:;' class='options' onclick=\"openEditBanner('"+row.id+"')\" data-options=\"iconCls:'icon-edit',plain:true\">修改</a>";
                        }
                    }
                ]],
                onLoadSuccess:function () {
                    $(".options").linkbutton();
                },
                toolbar:'#da',
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.imgPath + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>Title: ' + rowData.title + '</p>' +
                        '<p>Attribute: ' + rowData.descr + '</p>' +
                        '<p>Status: ' + rowData.status + '</p>' +
                        '<p>Creattime: ' + rowData.creattime + '</p>' +
                        '</td>' +
                        '</tr></table>';
                }

            });



        });

        function openAddBanner() {

            $("#addBanner").dialog({
                buttons:[
                    {
                      iconCls:'icon-save',
                        text:'保存',
                        handler:function () {

                            $("#addBannerInputForm").form('submit',{
                                url:'${pageContext.request.contextPath}/banner/save',
                                success:function (result) {
                                    var resultObj = $.parseJSON(result);
                                    if(resultObj.success){

                                        $.messager.show({title:'提示',msg:"添加成功"});
                                    }else{
                                        $.messager.show({title:"提示",msg:resultObj.message});
                                    }
                                    //关闭对话框
                                    $("#addBanner").dialog('close');
                                    //刷新datagrid
                                    $("#ban").datagrid('reload');
                                }


                            });
                        }
                    },{iconCls:'icon-cancel',
                        text:'关闭',
                        handler:function () {
                            $("#addBanner").dialog('close');
                        }}

                ]
            });
        }


    function delRow(id) {

            $.post('${pageContext.request.contextPath}/banner/delete',{"id":id},
                function (result) {
                    $("#ban").datagrid('reload');
            });
    }


       function openEditBanner(id) {
            $("#editBanner").dialog({
                href:'${pageContext.request.contextPath}/admin/editBanner.jsp?id='+id,
                buttons:[
                    {iconCls:'icon-save',
                        text:"修改",
                        handler:function () {
                            $("#editBannerInputForm").form('submit',{
                                url:'${pageContext.request.contextPath}/banner/update',
                                success:function (result) {
                                    //关闭dialog
                                    $("#editBanner").dialog('close');
                                    //刷新datagrid
                                    $("#ban").datagrid('reload');
                                    //提示修改信息
                                    $.messager.show({title:'提示',msg:"用户修改信息成功！"})
                                }
                            })
                        }

                    },
                    {
                        iconCls:'icon-cancel',
                        text:"取消",
                        handler:function () {
                            $("#editBanner").dialog('close');
                        }
                    },
                ]

            });
        }




        function delBatchRows() {
            var rows = $("#ban").datagrid('getSelections');
            if(rows.length<=0){
                $.messager.show({title:'提示',msg:"至少选中一行"});

            }else{
                var ids=[];
                for(var i=0;i < rows.length;i++){
                    //console.log(rows[i].id);
                    ids.push(rows[i].id);
                }
                console.log(ids);
                $.ajax({
                    url:'${pageContext.request.contextPath}/banner/deleteMany',
                    type:"POST",
                    traditional:true,
                    data:{id:ids},
                    success:function (result) {
                        //消息提示
                        $.messager.show({title:'提示',msg:"删除成功"});
                        //刷新datagrid
                        $("#ban").datagrid('reload');

                    },
                    error:function () {
                        //消息提示
                        $.messager.show({title:'提示',msg:"删除失败"});
                        //刷新datagrid
                        $("#ban").datagrid('reload');
                    }



                })

            }

        }

    </script>
<%--
</head>
<body>--%>
    <table id="ban"></table>
    <div id="da">
        <a href="#" class="easyui-linkbutton" onclick="openAddBanner()" data-options="iconCls:'icon-add',plain:true">添加</a>
        <a href="#" class="easyui-linkbutton" onclick="delBatchRows()" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">保存</a>
    </div>

    <%--添加对话框--%>
    <div id="addBanner"
         data-options="href:'${pageContext.request.contextPath}/admin/addBanner.jsp',iconCls:'icon-add',width:600,height:400,title:'添加轮播图'">

    </div>

    <%--修改对话框--%>
    <div id="editBanner"
    data-options="href:'${pageContext.request.contextPath}/admin/editBanner.jsp',iconCls:'icon-edit',width:600,height:400,title:'修改轮播图'">

    </div>
<%--</body>
</html>--%>
