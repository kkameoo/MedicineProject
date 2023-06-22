<%@ page import="DAO.DrugDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DTO.DrugDTO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-06-22
  Time: 오후 4:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
    <title>Drug</title>
</head>
<body>
<%
    DrugDAO drugDAO = new DrugDAO();
    ArrayList<DrugDTO> DrugList = drugDAO.drugInsert();
    request.setAttribute("DrugList", DrugList);
%>
<table>
    <caption>약 정보</caption>
    <thead>
    <tr>
        <th>약 코드</th>
        <th>약 이름</th>
        <th>제형 코드</th>
        <th>제형 이름</th>
        <th>투여 경로</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${DrugList}" var="item" varStatus="i">
    <tr>
        <th><c:out value="${item.drugcode}"/></th>
        <td><c:out value="${item.drugname}"/></td>
        <td><c:out value="${item.formcode}"/></td>
        <td><c:out value="${item.formname}"/></td>
        <td><c:out value="${item.path}"/></td>
    </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    </tfoot>
</table>
</body>
</html>
