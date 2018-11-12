<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="text-align: center">
    <form id="addGuruInputForm" action="${pageContext.request.contextPath}/guru/save" enctype="multipart/form-data" class="easyui-form" method="post">
        <input type="hidden" name="id">
        <div style="margin-top: 60px">
            上师名字：<input type="text" name="name" class="easyui-textbox">
        </div>
        <div style="margin-top: 30px">
            上师头像:<input name="mult" class="easyui-filebox"><br/>

        </div>
        <div style="margin-top: 30px">
            上师性别：<select class="easyui-combobox" name="sex"  data-options="width:159">
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
        </div>

    </form>

</div>
