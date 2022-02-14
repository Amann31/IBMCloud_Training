<%@ page import="java.util.List" %>
<%@ page import="org.example.League" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error page</title>
</head>
<body>
<%
    out.println("<span><hr/>Please correct the bellow error(s)</span><br/>");
    List<String> list=(List<String>) request.getAttribute("ERROR");
    for(String str:list)
    {
        out.println("<i><u><font color='red'>"+str+"</font></u></i><br/>");
    }
%>
<br/>
<a href="add_league.html">try again..</a>
</body>
</html>