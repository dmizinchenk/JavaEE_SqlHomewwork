<%@ page import="com.example.sqlapp.models.Country" %>
<%@ page import="com.example.sqlapp.models.Firm" %>
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
    <span><b>Страна с максимальным количеством блокнотов: </b>
        <%=((Country)request.getAttribute("countryWithMaxNotepads")).getName()%></span><br><br>
    <span><b>Страна с минимальным количеством блокнотов: </b>
        <%=((Country)request.getAttribute("countryWithMinNotepads")).getName()%></span><br><br>
    <span><b>Производитель с максимальным количеством блокнотов: </b>
        <%=((Firm)request.getAttribute("firmWithMaxNotepads")).getName()%></span><br><br>
    <span><b>Производитель с минимальным количеством блокнотов: </b>
        <%=((Firm)request.getAttribute("firmWithMinNotepads")).getName()%></span><br><br>

    <table>
        <caption><b>Все блокноты c твердой обложкокй</b></caption>
        <thead>
        <tr>
            <th>id</th>
            <th>firm</th>
            <th>name</th>
            <th>pages</th>
            <th>skin</th>
            <th>country</th>
            <th>pageView</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Notepad> notepadsHard = (List<Notepad>)request.getAttribute("hardSkin");
            for (Notepad n :notepadsHard) {%>
        <tr>
            <td><%=n.getId()%></td>
            <td><%=n.getFirm().getName()%></td>
            <td><%=n.getName()%></td>
            <td><%=n.getPages()%></td>
            <td><%=n.getSkin()%></td>
            <td><%=n.getCountry().getName()%></td>
            <td><%=n.getPageView()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <br>
    <br>

    <table>
        <caption><b>Все блокноты c мягкой обложкокй</b></caption>
        <thead>
        <tr>
            <th>id</th>
            <th>firm</th>
            <th>name</th>
            <th>pages</th>
            <th>skin</th>
            <th>country</th>
            <th>pageView</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Notepad> notepadsSoft = (List<Notepad>)request.getAttribute("softSkin");
            for (Notepad n : notepadsSoft) {%>
        <tr>
            <td><%=n.getId()%></td>
            <td><%=n.getFirm().getName()%></td>
            <td><%=n.getName()%></td>
            <td><%=n.getPages()%></td>
            <td><%=n.getSkin()%></td>
            <td><%=n.getCountry().getName()%></td>
            <td><%=n.getPageView()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

</body>
</html>
