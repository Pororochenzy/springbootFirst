<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="js/jquery.min.js"></script><div align="center">

</div>
<%--reseful ,post仅仅能新增,put可新增可修改--%>

<div style="width:500px;margin:20px auto;text-align: center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.list}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="category/${c.id}">编辑</a></td>
                <td><a class="delete" href="category/${c.id}">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <br>
    <div>
        <a href="?start=1">[首  页]</a>
        <a href="?start=${page.pageNum-1}">[上一页]</a>
        <a href="?start=${page.pageNum+1}">[下一页]</a>
        <a href="?start=${page.pages}">[末  页]</a>
    </div>
    <br>
    <%--加如下input 标签，虽然这个form的method是post, 但是spingboot看到这个_method的值是put后，会把其修改为put.--%>
    <form action="category" method="post">

        <input type="hidden" name="_method" value="PUT">
        name: <input name="name"> <br>
        <button type="submit">提交</button>

    </form>

    <form id="formdelete" action="" method="POST" >
        <input type="hidden" name="_method" value="DELETE">
    </form>


</div>

<script>

    $(function () {
        $(".delete").click(function () {
            var href = $(this).attr("href");
            $("#formdelete").attr("action",href).submit();
            return false;  //这个return false是什么意思

           /* 为了防止冒泡，比如我给ID为d1的DIV加了click事件，
            这个事件默认也会加载到d1的父DIV和document，加return false是为了让事件只加给d1，防止冒泡，产生不必要的麻烦*/
        })
    })
</script>