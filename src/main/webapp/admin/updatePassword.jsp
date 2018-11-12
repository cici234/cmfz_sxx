<%@ page pageEncoding="UTF-8" isELIgnored="false" %>


<div style="text-align: center">
	<form id="updatePasswordInputForm" class="easyui-form" method="post">
		<input type="hidden" name="id" value="${sessionScope.admin.id}">
		<div style="margin-top: 70px">

			登录名：<input type="text" value="${sessionScope.admin.name}" name="name" class="easyui-textbox" data-options="readonly:true">
		</div>

		<div style="margin-top: 30px">
			新密码：<input type="text" name="password" class="easyui-textbox">
		</div>
		<%--<div>
			确认密码：<input type="text" name="password" class="easyui-passwordbox">
		</div>--%>
	</form>
</div>