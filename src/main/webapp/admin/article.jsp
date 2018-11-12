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

            $("#ar").datagrid({
                url:'${pageContext.request.contextPath}/article/findByPage',
                pagination:true,
                pageNumber:1,
                pageSize:2,
                pageList:[2,4,6,8,10],
                fit:true,
                fitColumns:true,

                columns:[[
                    {field:'cks',title:'cks',checkbox:true},
                    {field:'title',title:'文章名字',width:120},
                    {field:'imgPath',title:'文章插图',width:120},
                    {field:'content',title:'文章内容',width:120},
                    {field:'publishDate',title:'创建时间',width:120},
                    {field:'name',title:'上师名字',width:120,
                        formatter:function (value,row,index) {
                            /*if(row.guru){
                                if(row.guru.name!='')
                                    return row.guru.name;
                                else{
                                    return '';
                                }
                            }else{
                                return "";
                            }*/

                                return row.guru.name;

                        }
                    },
                    {field:'heasPic',title:'上师头像',width:120,
                        formatter:function (value,row,index) {
                            if(row.guru){
                                if(row.guru.heasPic!='')
                                    return row.guru.heasPic;
                                else{
                                    return '';
                                }
                            }else{
                                return "";
                            }
                        }
                    },


                    {title:'options',field:'options',width:200,
                        formatter:function (value,row,index) {
                            return "<a href='javascript:;' class='options' onclick=\"delRow('"+row.id+"')\" data-options=\"iconCls:'icon-remove',plain:true\">删除</a>&nbsp;&nbsp;"


                        }


                    }


                ]],
                onLoadSuccess:function () {
                    $(".options").linkbutton();
                },
                toolbar:'#arti',
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.imgPath + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>Title: ' + rowData.title + '</p>' +
                        '<p>ImgPath: ' + rowData.imgPath + '</p>' +
                        '<p>Content: ' + rowData.content + '</p>' +
                        '<p>PublishDate: ' + rowData.publishDate + '</p>' +
                        '</td>' +
                        '</tr></table>';
                }
            });

        });


        function openAddArticle() {
            $("#addArticle").dialog({
                buttons:[
                    {
                        iconCls:'icon-add',
                        text:'保存',
                        handler:function () {
                            $("#addArticleInputForm").form('submit',{
                                url:'${pageContext.request.contextPath}/article/save',
                                success:function (result) {
                                    var resultObj = $.parseJSON(result);
                                    if(resultObj.success){
                                        $.messager.show({title:'提示',msg:'添加成功'});
                                    }else{
                                        $.messager.show({title:'提示',msg:resultObj.message});
                                    }

                                    $("#addArticle").dialog('close');
                                    $("#ar").datagrid('reload');

                                }
                            })
                        }
                    },
                    {
                        iconCls:'icon-cancel',
                        text:'关闭',
                        handler:function () {
                            $("#addArticle").dialog('close');
                        }
                    }
                ]
            })
        }

        function delRow(id) {

            $.post('${pageContext.request.contextPath}/article/delete',{"id":id},
                function (result) {
                    $("#ar").datagrid('reload');
                });
        }


    </script>
<%--</head>
<body>--%>
    <table id="ar"></table>
    <div id="arti">

        <a href="#" class="easyui-linkbutton" onclick="openAddArticle()" data-options="iconCls:'icon-add',plain:true">添加</a>
    </div>


    <%--打开添加文章表--%>
    <div id="addArticle"
        data-options="href:'${pageContext.request.contextPath}/admin/addArticle.jsp',iconCls:'icon-add',width:400,height:400,title:'添加文章'">

    </div>
<%--
</body>
</html>--%>
