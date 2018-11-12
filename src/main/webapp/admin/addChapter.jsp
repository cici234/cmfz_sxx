<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="text-align: center">
    <form id="addChapterInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id">
        <div style="margin-top: 60px">
            章节名字：<input type="text" name="title" class="easyui-textbox">
        </div>
        <%--<div style="margin-top: 30px">
            音频大小：<input type="text" name="size" class="easyui-textbox">
        </div>
        <div style="margin-top: 30px">
            音频时长：<input name="duration" class="easyui-textbox">
        </div>--%>
        <div style="margin-top: 30px">
            音频路径：<input name="multipartFile" class="easyui-filebox">
        </div>
        <div style="margin-top: 30px">
            时间：<input type="text" name="uploadTime" class="easyui-datebox">
        </div>
       <div style="margin-top: 30px">
            <input type="hidden" name="al_id" value="${param.id}">
        </div>
    </form>

</div>