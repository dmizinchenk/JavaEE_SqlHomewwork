<%@ page import="com.example.sqlapp.models.Notepad" %><%--
  Created by IntelliJ IDEA.
  User: dmizi
  Date: 18.04.2024
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="task5">Задание 5</a><br>

<%
    Notepad notepad = (Notepad)request.getAttribute("notepad");
%>
<form method="post" action="task5">
    <input type="hidden" name="method" value="put">
    <input type="text" value="<%=notepad.getFirm().getName()%>" placeholder="Фирма" name="firm">
    <input type="text" value="<%=notepad.getName()%>" placeholder="Название" name="name">
    <input type="number" value="<%=notepad.getPages()%>" placeholder="Кол-во страниц" name="pages">
    <input type="text" value="<%=notepad.getSkin()%>" placeholder="Тип обложки" name="skinType">
    <input type="text" value="<%=notepad.getCountry().getName()%>" placeholder="Страна" name="country">
    <input type="text" value="<%=notepad.getPageView()%>" placeholder="Разметка" name="pageView">
    <input type="submit" value="Редактировать">
</form>

</body>
</html>
