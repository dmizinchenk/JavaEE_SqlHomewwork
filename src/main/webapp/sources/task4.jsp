<%@ page import="java.util.List" %>
<%@ page import="com.example.sqlapp.models.Country" %>
<%@ page import="com.example.sqlapp.models.Notepad" %><%--
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
    <form method="get" action="task4">
        <select name="chosenCountry">
            <option value="">Выберите страну</option>
            <%
                List<Country> countries = (List<Country>)request.getAttribute("allCountries");
                for (Country country: countries) {%>
                    <option value="<%=country.getName()%>"><%=country.getName()%></option>
                <%
                }
            %>
        </select>
        <input type="submit" value="Выбрать">
    </form>

    <table>
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
            List<Notepad> notepads = (List<Notepad>)request.getAttribute("allNotepadsByCountry");
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

    <form method="get" action="task4">
        <select name="pageView">
            <option value="">Тип обложки</option>
            <%
                List<String> skins = (List<String>)request.getAttribute("allSkins");
                for (String skin: skins) {%>
                    <option value="<%=skin%>"><%=skin%></option>
                <%
                }
            %>
        </select>
        <input type="submit" value="Выбрать">
    </form>

    <table>
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
            List<Notepad> notepadsByPageView = (List<Notepad>)request.getAttribute("allNotepadsByPageView");
            for (Notepad n :notepadsByPageView) {%>
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


    <form method="get" action="task4">
        <select name="chosenPage">
            <option value="">Кол-во страниц</option>
            <%
                List<Integer> pages = (List<Integer>)request.getAttribute("pages");
                for (Integer p: pages) {%>
            <option value="<%=p%>"><%=p%></option>
            <%
                }
            %>
        </select>
        <input type="submit" value="Выбрать">
    </form>

    <table>
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
            List<Notepad> notepadsByPages = (List<Notepad>)request.getAttribute("allNotepadsByPagesCount");
            for (Notepad n :notepadsByPages) {%>
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
