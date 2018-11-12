<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<form action="${pageContext.request.contextPath}/user/login" class="easyui-form" method="post">

    <div style="margin-left: 100px;margin-top: 100px">
        <input type="hidden" id="id">
        <div style="margin-top: 10px">
            手机号：<input name="phoneNum" class="easyui-textbox">
        </div>
        <div style="margin-top: 10px">
            密码：<input name="password" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px">
            <input type="button" class="button" value="提交" style="margin-left: 100px">
        </div>


    </div>





</form>