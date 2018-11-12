<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="text-align: center">
    <form id="addAlbumInputForm" action="${pageContext.request.contextPath}/album/save" enctype="multipart/form-data" class="easyui-form" method="post">
        <input type="hidden" name="id">
        <div style="margin-top: 40px">
            专辑名字：<input type="text" name="title" class="easyui-textbox">
        </div>
        <div style="margin-top: 30px">
            出版日期:<input name="publishDate" class="easyui-datebox"><br/>
        </div>
        <div style="margin-top: 30px">
            专辑集数：<input type="text" name="count" class="easyui-textbox">
        </div>
        <div style="margin-top: 30px">
            专辑封面：<input name="partfile" class="easyui-filebox">
        </div>
        <div style="margin-top: 30px">
            星级：<input type="text" name="star" class="easyui-textbox">
        </div>
        <div style="margin-top: 30px">
            作者：<input type="text" name="author" class="easyui-textbox">
        </div>
        <div style="margin-top: 30px">
            播音：<input type="text" name="broadCast" class="easyui-textbox">
        </div>
        <div style="margin-top: 30px">
            简介：<input type="text" name="brief" class="easyui-textbox">
        </div>
    </form>

</div>