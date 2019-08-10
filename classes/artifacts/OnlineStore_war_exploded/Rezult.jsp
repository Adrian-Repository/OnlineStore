<%--
  Created by IntelliJ IDEA.
  User: Mustafa
  Date: 8/4/2019
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Hello ${name}</h1>
</body>
<body>
<form method="POST" action="Search">
    Search: <input type="text" name="Search">
    <input type="submit" value="Search">
</form>
<form method="POST" action="Filtre">
    <input type="submit" value="Filtreza">
</form>
</body>
</html>
