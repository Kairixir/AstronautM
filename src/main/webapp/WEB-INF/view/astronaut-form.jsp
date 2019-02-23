<%--
  Created by IntelliJ IDEA.
  User: Ondra
  Date: 2/19/2019
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Astronauti</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>


</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>Astronauti</h2>
        </div>
    </div>

    <div id="container">
        <h3>Uložit astronauta</h3>
        <form:form action="addAstronaut" modelAttribute="astronaut" method="POST">
            <form:hidden path="id"/>
            <table>
                <tbody>
                <tr>
                    <td>
                        <label>Křestní jméno: </label>
                    </td>
                    <td><form:input path="firstName"/></td>
                    <td>
                        <form:errors path="firstName" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Přijmení: </label>
                    </td>
                    <td><form:input path="lastName"/></td>
                    <td>
                        <form:errors path="lastName" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Datum narození: </label>
                    </td>
                    <td><form:input type="date" path="dateOfBirth"/></td>
                    <td>
                        <form:errors path="dateOfBirth" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Superschopnost: </label>
                    </td>
                    <td><form:input type="text" path="superPower"/></td>
                    <td>
                        <form:errors path="superPower" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Add" class="save"></td>
                </tr>
                </tbody>
            </table>
        </form:form>
        <div style="clear; both;"></div>
        <p>
            <a href="${pageContext.request.contextPath}/astronaut/list">Zpět na seznam</a>
        </p>

    </div>
</body>
</html>
