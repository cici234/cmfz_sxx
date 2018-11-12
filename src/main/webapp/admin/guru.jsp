<%@page pageEncoding="UTF-8" isELIgnored="false" %>
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
            $("#gu").datagrid({
                url:'${pageContext.request.contextPath}/guru/queryByPage',
                pagination:true,
                pageNumber:1,
                pageSize:2,
                pageList:[2,4,6,8,10],

                fit:true,
                fitColumns:true,

                columns:[[
                    {field:'cks',title:'cks',checkbox:true},

                    {field:'name',title:'name',width:120},
                    {field:'heasPic',title:'heasPic',width:120},
                    {field:'sex',title:'sex',width:120},

                    {title:'options',field:'options',width:200,
                        formatter:function (value,row,index) {
                            return "<a href='javascript:;' class='options' onclick=\"delRow('"+row.id+"')\" data-options=\"iconCls:'icon-remove',plain:true\">删除</a>";

                        }


                    }


                ]],
                onLoadSuccess:function () {
                    $(".options").linkbutton();
                },
                toolbar:'#guda',
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.heasPic + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>Name: ' + rowData.name + '</p>' +
                        '<p>Sex: ' + rowData.sex + '</p>' +


                        '</td>' +
                        '</tr></table>';
                }

            });
        });




    function openAddGuru() {
        $("#addGuru").dialog({
            buttons:[
                {
                    iconCls:'icon-save',
                    text:'保存',
                    handler:function () {

                        $("#addGuruInputForm").form('submit',{
                            url:'${pageContext.request.contextPath}/guru/save',
                            success:function (result) {
                                var resultObj = $.parseJSON(result);
                                if(resultObj.success){

                                    $.messager.show({title:'提示',msg:"添加成功"});
                                }else{
                                    $.messager.show({title:"提示",msg:resultObj.message});
                                }


                                //关闭对话框
                                $("#addGuru").dialog('close');
                                //刷新datagrid
                                $("#gu").datagrid('reload');
                            }


                        });
                    }
                },{iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function () {
                        $("#addGuru").dialog('close');
                    }}

            ]
        });
    }

        function delRow(id) {

            $.post('${pageContext.request.contextPath}/guru/delete',{"id":id},
                function (result) {
                    $("#gu").datagrid('reload');
                });
        }
    </script>
<%--</head>
<body>--%>
    <table id="gu"></table>
    <div id="guda">
        <a href="#" class="easyui-linkbutton" onclick="openAddGuru()" data-options="iconCls:'icon-add',plain:true">添加</a>

    </div>

    <%--添加对话框--%>
    <div id="addGuru"
        data-options="href:'${pageContext.request.contextPath}/admin/addGuru.jsp',iconCls:'icon-add',width:600,height:400,title:'添加上师信息'">

    </div>
<%--
</body>
</html>--%>
