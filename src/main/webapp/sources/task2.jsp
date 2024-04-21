<%@ page import="java.util.List" %>
<%@ page import="com.example.sqlapp.models.Notepad" %>
<%@ page import="com.example.sqlapp.models.Country" %>
<%@ page import="com.example.sqlapp.models.CountryWithCount" %>
<%@ page import="com.example.sqlapp.models.FirmWithCount" %><%--
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
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <br>
    <br>

    <table>
        <caption><b>Все страны</b></caption>
        <thead>
        <tr>
            <th>country</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Country> countries = (List<Country>)request.getAttribute("allCountries");
            for (Country country :countries) {%>
                <tr>
                    <td><%= country.getName()%></td>
                </tr>
        <%
            }
        %>
        </tbody>
</table>
    <br>
    <br>

    <table>
        <caption><b>Страны с количеством блокнотов в каждой стране</b></caption>
        <thead>
        <tr>
            <th>country</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<CountryWithCount> countriesCount = (List<CountryWithCount>)request.getAttribute("allCountryWithCount");
            for (CountryWithCount country :countriesCount) {%>
                <tr>
                    <td><%= country.getCountry().getName()%></td>
                    <td><%= country.getCount()%></td>
                </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <br
    ><br>

    <table>
        <caption><b>Название производителя и количество блокнотов каждого производителя</b></caption>
        <thead>
            <tr>
                <th>country</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<FirmWithCount> firmsCount = (List<FirmWithCount>)request.getAttribute("allFirmWithCount");
                for (FirmWithCount country :firmsCount) {%>
            <tr>
                <td><%= country.getFirm().getName()%></td>
                <td><%= country.getCount()%></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
