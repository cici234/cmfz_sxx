<%@ page pageEncoding="UTF-8" isELIgnored="false"%>
<script>

</script>
<form id="addArticleInputForm" class="easyui-from" method="post" enctype="multipart/form-data">
    <div style="margin-top: 30px;margin-left: 60px">
        <input type="hidden" id="id">
        <div style="margin-top: 30px">
            文章名字：<input name="title" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px">
            文章插图：<input name="partfile" class="easyui-filebox">
        </div>
        <div style="margin-top: 20px">
            文章内容：<input name="content" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px">
            创建时间：<input name="publishDate" class="easyui-datebox">
        </div>
        <div style="margin-top: 20px">
            所属上师：
            <input id="cc" class="easyui-combobox" name="guru_id"
                   data-options="valueField:'id',textField:'name',url:'${pageContext.request.contextPath}/guru/query'" />

        </div>
    </div>
</form>