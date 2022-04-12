<%-- 
    Document   : BDJKNMDisplayBooks
    Created on : Mar. 21, 2022, 5:08:29 p.m.
    Author     : Jisung Kim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="BDJKNMBanner.jsp" />

<div class="container">
    <h2>List of Books</h2>

    <table class="list-of-loan-items">
        <tr>
            <th align="left">Code</th>
            <th align="left">Description</th>
            <th align="right">QOH</th>
            <th align="left">Action</th>
            <th></th>
        </tr>
        <c:forEach var="item" items="${applicationScope.loanitems}">
            <tr>
                <td align="left">
                    ${item.code}
                </td>
                <td align="left">
                    ${item.description}
                </td>
                <td align="right">
                    <c:if test="${item.quantity > 0}">
                        ${item.quantity}
                    </c:if>
                    <c:if test="${item.quantity < 1}">
                        0
                    </c:if>
                </td>
                <td align="right">
                    <c:if test="${item.quantity >= 1}">
                        <a class="list-of-loan-items__link" href="<c:url value="BDJKNMCart?action=reserve&code=${item.code}" />">
                            Reserve
                        </a>
                    </c:if>
                    <c:if test="${item.quantity < 1}">
                        N/A
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
    
    <a href="BDJKNMAddBook.jsp">
        <input class="list-of-books__btn" type="button" value="Add Book"/>
    </a>
</div>

<jsp:include page="BDJKNMFooter.jsp" />