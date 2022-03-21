<%-- 
    Document   : BDJKNMDisplayBooks
    Created on : Mar. 10, 2022, 5:08:29 p.m.
    Author     : Jisung Kim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="BDJKNMBanner.jsp" />

<div class="container">
    <h2>List of Books</h2>

    <table class="list-of-books">
        <tr>
            <th>Code</th>
            <th>Description</th>
            <th>Quantity</th>        
        </tr>
    <c:forEach var="item" items="${books}">
        <tr>
            <td>${item.code}</td>
            <td>${item.description}</td>
            <td>${item.quantity}</td>
        </tr>
    </c:forEach>
    </table>
    
    <a href="BDJKNMAddBook.jsp">
        <input class="list-of-books__btn" type="button" value="Add Book"/>
    </a>
</div>

<jsp:include page="BDJKNMFooter.jsp" />