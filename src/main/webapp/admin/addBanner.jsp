<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="text-align: center">
    <form id="addBannerInputForm" action="${pageContext.request.contextPath}/banner/save" enctype="multipart/form-data" class="easyui-form" method="post">
        <input type="hidden" name="id">
        <div style="margin-top: 60px">
            图片名称：<input type="text" name="title" class="easyui-textbox">
        </div>
        <div style="margin-top: 30px">
            图片路径:<input name="partfile" class="easyui-filebox"><br/>

        </div>
        <div style="margin-top: 30px">
            图片描述：<input type="text" name="descr" class="easyui-textbox">
        </div>
        <div style="margin-top: 30px">
            图片状态：<input type="text" name="status" class="easyui-textbox">
        </div>
        <div style="margin-top: 30px">
            图片创建时间：<input type="text" name="creattime" class="easyui-datebox">
        </div>
    </form>

</div>
