<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="margin-top: 40px;margin-left: 50px">
    <form id="addCourseInputForm" action="${pagecontext.request.contextPath}/chapter/save" method="post" class="easyui-form">
        <input type="hidden" name="id">
        <div style="margin-top: 20px">
            标题：<input type="text" name="title" class="easyui-textbox">
        </div>

        <div style="margin-top: 20px">
            标识：<input type="text" name="flag" class="easyui-textbox">
        </div>

        <div style="margin-top: 20px">
            时间：<input type="text" name="creatTime" class="easyui-datebox">
        </div>

    </form>


</div>