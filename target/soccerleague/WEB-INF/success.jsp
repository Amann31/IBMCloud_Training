<%@ page import="org.example.League" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
<%
    League league=(League) request.getAttribute("LEAGUE");
    out.println("League Title: "+league.getLeagueName()+"<br/>");
    out.println("League Season: "+league.getLeagueSeason()+"<br/>");
    out.println("League Year: "+league.getLeagueYear());
%>
</body>
</html>