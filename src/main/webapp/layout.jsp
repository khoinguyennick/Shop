<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: khoin
  Date: 09/09/2019
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><tiles:insertAttribute name="title"/></title>
</head>
<body>
<tiles:insertAttribute name="menu"/>
<tiles:insertAttribute name="body"/>
</body>
</html>
