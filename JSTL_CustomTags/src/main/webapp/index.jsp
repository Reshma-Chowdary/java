<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/MyTagLib.tld" prefix="mytag"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Custom Tag Example</title>
</head>
<body>
    <h1>Custom JSP Tag Example</h1>

  
    <mytag:index columnName="from_station" tableName="train_schedule"/>

    <p>This is regular JSP content.</p>
</body>
</html>