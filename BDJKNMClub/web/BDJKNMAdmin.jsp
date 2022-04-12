<%-- 
    Document   : BDJKNMAdmin
    Created on : Feb. 17, 2022, 6:07:11 p.m.
    Author     : Jisung Kim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="BDJKNMBanner.jsp" />

<div class="container">
    <h2>Admin : Data Maintenance</h2>
    <a class="maintain-books__link" href="BDJKNMDisplayBooks">
            Maintain Books
    </a>
    <a class="maintain-books__link" href="<c:url value="BDJKNMMemberAdmin?action=displayMembers"/>">
            Display Members
    </a>
</div>

<jsp:include page="BDJKNMFooter.jsp" />