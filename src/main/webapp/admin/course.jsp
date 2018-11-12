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
            $("#cou").datagrid({
                url:'${pageContext.request.contextPath}/course/queryByPage',
                striped:true,//是否显示斑马线效果
                pagination:true,//显示分页工具栏
                pageNumber:1,//显示初始化页码
                pageSize:2,//初始化页面大小
                pageList:[2,4,6,8],//初始化页面大小选择列表
                fit:true,
                fitColumns:true,

                columns:[[
                    {field:'cks',title:'cks',checkbox:true},
                    {field:'title',title:'标题',width:120},
                    {field:'flag',title:'标识',width:120},
                    {field:'creatTime',title:'创建时间',width:120},
                    {field:'options',title:'options',width:120,
                        formatter:function (value,row,index) {
                            return "<a href='javascript:;' class='options' onclick=\"delRow('"+row.id+"')\" data-options=\"iconCls:'icon-remove',plain:true\">删除</a>&nbsp;&nbsp;";


                        }
                    }

                ]],
                onLoadSuccess:function () {
                    $(".options").linkbutton();
                },
                toolbar:'#courseDia'


            })
        })



        function openAddCourse() {
            $("#addCourse").dialog({
                buttons:[
                    {
                        iconCls:'icon-add',
                        text:'保存',
                        handler:function () {
                            $("#addCourseInputForm").form('submit',{
                                url:'${pageContext.request.contextPath}/course/save',
                                success:function (result) {

                                   var resultObj = $.parseJSON(result);
                                   if(resultObj.success){
                                       $.messager.show({title:"提示",msg:"添加成功！！！"});
                                   }else{
                                        $.messager.show({title:'提示',msg:resultObj.message});
                                   }
                                    //关闭对话框
                                    $("#addCourse").dialog('close');
                                    //刷新datagrid
                                    $("#cou").datagrid('reload');
                                }
                            })
                        }
                    },{
                        iconCls:'icon-cancel',
                        text:'关闭',
                        handler:function () {
                            $("#addCourse").dialog("close");
                        }
                    }

                ]
            })
        }

        function delRow(id) {

            $.post('${pageContext.request.contextPath}/course/delete',{"id":id},
                function (result) {
                    $("#cou").datagrid('reload');
                });
        }


    </script>


<%--</head>
<body>--%>


    <table id="cou"></table>
    <div id="courseDia">
        <a href="#" class="easyui-linkbutton" onclick="openAddCourse()" data-options="iconCls:'icon-add',plain:true">添加</a>

    </div>

    <%--打开增加对话框--%>
    <div id="addCourse"
         data-options="href:'${pageContext.request.contextPath}/admin/addCourse.jsp',iconCls:'icon-add',width:400,height:300,title:'添加功课'">

    </div>
<%--
</body>
</html>--%>
