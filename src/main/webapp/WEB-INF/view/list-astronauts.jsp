<%--
  Created by IntelliJ IDEA.
  User: Doma
  Date: 19.02.2019
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Astronauti</title>

    <!-- reference stylesheet --->
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>
<div class="center-content-area">

    <div id="limiter">

            <div id="wrapper">
                <div id="header">
                    <h2>Astronauti</h2>
                </div>
            </div>



    </div>


    <div id="container">
        <div id="content">
            <%--put new button: Add Astronaut--%>
            <div class="buttons">
                <div class = "add-button-left">
                    <input type="button" value="Přidat astronauta"
                     onclick="window.location.href='showFormForAdd'; return false;"
                    class="add-button"
                    />
                </div>
                <div class="search-button-right">
                <form:form action="search" method="get">
                    Hledej astronauta: <input type="text" name="theSearchName"/>
                    <input type="submit" value="Hledat" class="add-button"/>
                </form:form>
                </div>
            </div>
                <table>
                    <thead>
                    <tr>
                        <th>Křestní jméno</th>
                        <th>Přijmení</th>
                        <th>Datum narození</th>
                        <th>Superschopnost</th>
                        <th>Akce</th>
                    </tr>
                    </thead>
                    <%--Loop over and print astronauts--%>
                    <c:forEach var="tempAstronaut" items="${astronauts}">

                        <%--construct an update link with customer id--%>
                        <c:url var="updateLink" value="/astronaut/showFormForUpdate">
                            <c:param name="astronautId" value="${tempAstronaut.id}"/>
                        </c:url>
                        <c:url var="deleteLink" value="/astronaut/delete">
                            <c:param name="astronautId" value="${tempAstronaut.id}"/>
                        </c:url>

                        <tr>
                            <td>${tempAstronaut.firstName}</td>
                            <td>${tempAstronaut.lastName}</td>
                            <td>${tempAstronaut.dateOfBirth}</td>
                            <td>${tempAstronaut.superPower}</td>
                            <td>
                                    <%--dipsplay the update link--%>
                                <a href="${updateLink}">Upravit</a>
                                |
                                    <%--display the delete link--%>
                                <a href="${deleteLink}" onclick="if (!( confirm('Opravdu chcete vymazat ${tempAstronaut.firstName} ${tempAstronaut.lastName}?')))return false">Vymazat</a>

                            </td>

                        </tr>

                    </c:forEach>



            </table>
        </div>
    </div>
</div>

</body>
</html>
