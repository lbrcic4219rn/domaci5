<%--
  Created by IntelliJ IDEA.
  User: sbg
  Date: 27.4.22.
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Title</title>
        <%@include file="styles.jsp"%>
    </head>
    <body>
        <%@include file="navbar.jsp"%>

        <div class="container">
            <%
                if (request.getSession().getAttribute("imeTima") != null) {
            %>
            <div class="row text-center">
                <h1><%= request.getSession().getAttribute("imeTima") %>, hvala na prijavi!</h1>
                <h2>Nas tim pregleda prijavu i obavestice vas o konacnoj odluci do 11. decembra na email: mail@mail.com</h2>
                <h3>Za sva dodatna pitanja mozete pisati na: mail@raf.rs</h3>
            </div>
            <%
                }
            %>
        </div>
    </body>
</html>
