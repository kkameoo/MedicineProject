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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>약정보제공</title>
    <link rel="stylesheet" type="text/css" href="css/medicine.css">
</head>
<body>
<%
    String No = request.getParameter("pages");
    if (No == null) {
        No = "1";
    } else {
        No = request.getParameter("pages");
    }
    DrugDAO drugDAO = new DrugDAO();
    ArrayList<DrugDTO> DrugList = drugDAO.drugInsert(No);
    request.setAttribute("DrugList", DrugList);

    int pages = 1;

    int itemInAPage = 3;
    int totalCount = 15;
    int totalPage = (int) Math.ceil(totalCount/ (double) itemInAPage);

    int pageCount = 5;
    int startPage = ((pages - 1)/pageCount)*pageCount + 1;
    int endPage = startPage + pageCount - 1;

    if (totalPage < pages) {
        pages = totalPage;
    }

    if (endPage > totalPage) {
        endPage = totalPage;
    }

    request.setAttribute("totalCount", totalCount);
    request.setAttribute("totalPage", totalPage);
    request.setAttribute("page", page);

    request.setAttribute("pageCount", pageCount);
    request.setAttribute("startPage", startPage);
    request.setAttribute("endPage", endPage);
%>

<div class="header">
    <div class="header_center">
        <!-- 로고 -->
        <image src="image/logo.png" class="logo"></image>
        <!-- 우측a태그 -->
        <div class="header_center">
            <ul class="header_center_list">
                <li class="header_center_item">
                    <a href="divide.html">홈</a>
                </li>
                <li class="header_center_item">
                    <a href="qr_barcode_scanner.html">바코드</a>
                </li>
                <li class="header_center_item">
                    <a href="medicine.html">약품</a>
                </li>
                <li class="header_center_item">
                    <a href="store.html">약국</a>
                </li>

            </ul>
        </div>
    </div>
</div>
<hr />



<!-- 테이블 -->
<div class="table-container">
<table>
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
</table>
</div>

<!-- 페이지바 -->
<div class="board_page">
<%
    if ( pages != 1 ) {
        int k = pages;
%>
<td><a href="?pages=<%=k-1 %>"> < </a></td>
<%
    }
    for ( int i = startPage; i <= endPage; i++ ) {
%>
<td><a href="?pages=<%=i %>" class="num"><%=i %></a></td>
<%
    }
    if ( pages != totalPage ) {
        int k = pages;
%>
<td><a href="?pages=<%=k+1 %>" class="bt next"> > </a></td>
<%
    }
%>
</div>
</body>
</html>
