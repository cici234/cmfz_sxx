<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<script>

    $(function () {
        $("#realAlbumInputForm").form('load','${pageContext.request.contextPath}/album/queryOne?id=${param.id}')
        $("#realAlbumInputForm").form({
            onLoadSuccess(data){
                console.log(data);
                $("#coverImg").attr("src","${pageContext.request.contextPath}"+data.coverImg);
            }
        })
    })

</script>
<div style="text-align: center">
    <form id="realAlbumInputForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 50px">
            专辑名字：<input type="text" name="title" class="easyui-textbox">
        </div>

        <div style="margin-top: 20px">
            专辑发布日期：<input type="text" name="publishDate" class="easyui-textbox">
        </div>
        <div style="margin-top: 30px">
            专辑集数：<input type="text" name="count" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;margin-left: 20px">
            专辑封面：
            <img id="coverImg" src="" style="width: 120px;height: 80px">
        </div>
        <div style="margin-top: 20px">
            星级：<input type="text" name="star" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px">
            作者：<input type="text" name="author" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px">
            播音：<input type="text" name="broadCast" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px">
            简介：<input type="text" name="brief" class="easyui-textbox">
        </div>
    </form>

</div>