<%@ page import="com.example.sqlapp.models.Notepad" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: dmizi
  Date: 17.04.2024
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/index.jsp">Назад</a>
    <br>
    <br>
<%--    <a href="create">Создать запись</a>--%>
    <%Notepad notepadToUpdate = (Notepad)request.getAttribute("Notepad");%>
    <form method="post" action="task5">
        <%
            if(notepadToUpdate != null){%>
            <input type="hidden" name="method" value="edit">
            <input type="number" name="id" value="<%=notepadToUpdate.getId()%>" readonly><br>
            <%}
        %>
        <input type="text" value="<%=notepadToUpdate != null ?  notepadToUpdate.getFirm().getName() : ""%>" placeholder="Фирма" name="firm"><br>
        <input type="text" value="<%=notepadToUpdate != null ?  notepadToUpdate.getName() : ""%>" placeholder="Название" name="name"><br>
        <input type="number" value="<%=notepadToUpdate != null ?  notepadToUpdate.getPages() : ""%>" placeholder="Кол-во страниц" name="pages"><br>
        <input type="text" value="<%=notepadToUpdate != null ?  notepadToUpdate.getSkin() : ""%>" placeholder="Тип обложки" name="skinType"><br>
        <input type="text" value="<%=notepadToUpdate != null ?  notepadToUpdate.getCountry().getName() : ""%>" placeholder="Страна" name="country"><br>
        <input type="text" value="<%=notepadToUpdate != null ?  notepadToUpdate.getPageView() : ""%>" placeholder="Разметка" name="pageView"><br>
        <input type="submit" value="<%=notepadToUpdate != null ?  "Редактировать" : "Сохранить"%>">
    </form>
    <br>
    <br>
    <table>
        <caption><b>Все блокноты</b></caption>
        <thead>
        <tr>
            <th>id</th>
            <th>firm</th>
            <th>name</th>
            <th>pages</th>
            <th>skin</th>
            <th>country</th>
            <th>pageView</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Notepad> notepads = (List<Notepad>)request.getAttribute("allNotepads");
            for (Notepad n :notepads) {%>
        <tr>
            <td><%=n.getId()%></td>
            <td><%=n.getFirm().getName()%></td>
            <td><%=n.getName()%></td>
            <td><%=n.getPages()%></td>
            <td><%=n.getSkin()%></td>
            <td><%=n.getCountry().getName()%></td>
            <td><%=n.getPageView()%></td>
            <td>
                <form action="task5" method="get">
                    <input type="hidden" name="method" value="edit">
                    <input type="hidden" id="id" name="id" value="<%=n.getId()%>">
                    <input type="submit" value="Edit">
                </form>
            </td>
            <td>
                <form action="task5" method="post">
                    <input type="hidden" name="method" value="delete">
                    <input type="hidden" name="id" value="<%=n.getId()%>">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</body>
</html>
