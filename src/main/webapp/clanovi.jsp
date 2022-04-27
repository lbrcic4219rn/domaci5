<%--
  Created by IntelliJ IDEA.
  User: sbg
  Date: 27.4.22.
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Prijava tima</title>
        <%@include file="styles.jsp"%>
    </head>

    <body>
    <%@include file="navbar.jsp"%>
    <%! int num = 3; %>

    <div class="container mt-5">
        <div class="row">
            <%
                if (request.getSession().getAttribute("prijavljen") != null &&
                        request.getSession().getAttribute("prijavljen").equals("DA")) {
            %>

            <h1>Vas tim, <%= request.getSession().getAttribute("imeTima") %>, je vec prijavljen.</h1>

            <%
            } else {
            %>

            <form class="w-100" action="/check-submission" method="post">

                <%
                    if (request.getSession().getAttribute("brojClanova") == null) {
                %>

                <h1>Neuspesno prosledjen parametar</h1>

                <%
                } else {
                %>

                <% num = (int)request.getSession().getAttribute("brojClanova");
                    for (int i = 0; i < num; i++) {
                %>

                <h1 class="mb-3"><%= i+1 %>. Clan tima</h1>
                <div class="form-group mb-3">
                    <label for="clan-ime-<%= i+1 %>"> Ime <%= i+1 %>. clana</label>
                    <input class="form-control" required type="text" placeholder="Ime" id="clan-ime-<%= i+1 %>" name="clan-ime-<%= i+1 %>">
                </div>
                <div class="form-group mb-3">
                    <label for="clan-prezime-<%= i+1 %>"> Prezime <%= i+1 %>. clana</label>
                    <input class="form-control" required type="text" placeholder="Prezime" name="clan-prezime-<%= i+1 %>">
                </div>
                <div class="form-group mb-3">
                    <label for="clan-email-<%= i+1 %>"> Email <%= i+1 %>. clana</label>
                    <input class="form-control" required type="email" placeholder="Email" name="clan-email-<%= i+1 %>" >
                </div>
                <div class="form-group mb-3">
                    <label for="clan-uloga-<%= i+1 %>"> Uloga <%= i+1 %>. clana</label>
                    <input class="form-control" required type="text" placeholder="Uloga u timu (npr. developer, dizajner...)" name="clan-uloga-<%= i+1 %>" >
                </div>
                <div class="form-group mb-3">
                    <label for="clan-linkedin-<%= i+1 %>"> Linkedin profil <%= i+1 %>. clana</label>
                    <input class="form-control" required type="url" placeholder="LinkedIn" name="clan-linkedin-<%= i+1 %>" >
                </div>

                <%
                    }
                %>
                <div class="form-group mb-3">
                    <input type="submit" class="btn btn-primary btn-lg" value="Posalji prijavu">
                </div>
            </form>

            <%
                    }
                }
            %>
        </div>
    </div>

    </body>
</html>
