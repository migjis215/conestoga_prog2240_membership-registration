<%-- 
    Document   : BDJKNMECart
    Created on : Apr. 1, 2022, 4:54:55 p.m.
    Author     : Jisung Kim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="BDJKNMBanner.jsp" />

<c:set var="count" scope="page" value="0"/>

<div class="container">
    <table class="list-of-loan-items">
        <tr>
            <th colspan="3">Your Loan Cart</th>
        </tr>
        <tr>
            <th align="left">Code</th>
            <th align="left">Description</th>
            <th align="left">Quantity</th>
        </tr>
        <c:forEach var="book" items="${sessionScope.myCart.items}">
            <tr>
                <td align="left">
                    ${book.code}
                </td>
                <td align="left">
                    ${book.description}
                </td>
                <td align="right">
                    ${book.quantity}
                </td>
            </tr>
            <c:set var="count" scope="page" value="${count + book.quantity}"/>
        </c:forEach>
            <tr>
                <td colspan="2" height="80" align="right">
                    Total:
                </td>
                <td align="right">
                    ${count}
                </td>
            </tr>
    </table>
                <br />
                <a class="display-cart__link" href="#">Clear the cart</a><br />
                <a class="display-cart__link" href="BDJKNMLoan">Return to eLoan</a>
</div>

<jsp:include page="BDJKNMFooter.jsp" />
