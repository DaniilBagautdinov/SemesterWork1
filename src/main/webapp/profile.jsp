<%@ page contentType="text/html;UTF-8" %>
<html lang="en">
<head>
    <title>Main Page</title>
</head>
<body>

<%

    String sessionUser = (String) session.getAttribute("login");
    if (sessionUser == null) {
        response.sendRedirect("login.html");

    }

    String userLoginCookie = null;
    String userFirstNameCookie = null;
    String userSecondNameCookie = null;
    String sessionId = null;
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie c: cookies) {
            if ("firstName".equals(c.getName())) userFirstNameCookie = c.getValue();
            if ("lastName".equals(c.getName())) userSecondNameCookie = c.getValue();
            if ("login".equals(c.getName())) userLoginCookie = c.getValue();
            if ("JSESSIONID".equals(c.getName())) sessionId = c.getValue();
        }
    } else {
        sessionId = session.getId();
    }
%>

<h1>
    Profile
    <br>
</h1>

<h3>
    Login: <%=userLoginCookie%>
    <br>
    First Name: <%=userFirstNameCookie%>
    <br>
    Second Name: <%=userSecondNameCookie%>
</h3>

</body>
</html>
