<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<script>

    $(function () {
        $("#editBannerInputForm").form('load','${pageContext.request.contextPath}/banner/queryOne?id=${param.id}')
    })
    console.log("${param.id}");
</script>
<div style="text-align: center">
    <form id="editBannerInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="text" name="id">
        <div style="margin-top: 60px">
            修改图片名称：<input type="text" name="title" class="easyui-textbox">
        </div>
        <div style="margin-top: 30px">
            修改图片路径:<input name="partfile" class="easyui-filebox"><br/>

        </div>
        <div style="margin-top: 30px">
            修改图片描述：<input type="text" name="descr" class="easyui-textbox">
        </div>
        <div style="margin-top: 30px">
            修改图片状态：<input type="text" name="status" class="easyui-textbox">
        </div>
        <div style="margin-top: 30px">
            修改图片创建时间：<input type="text" name="creattime" class="easyui-datebox">
        </div>

    </form>

</div>