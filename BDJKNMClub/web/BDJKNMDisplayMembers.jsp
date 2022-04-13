<%-- 
    Document   : BDJKNMDisplayMembers
    Created on : Apr. 11, 2022, 11:16:18 a.m.
    Author     : Jisung Kim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="BDJKNMBanner.jsp" />

<div class="container">
    <h2 class="list-of-members__title">List of Members</h2>

    <table class="list-of-loan-items">
        <tr>
            <th align="left">Email</th>
            <th align="left">Full Name</th>
            <th align="right">Program</th>
            <th align="left">Year</th>
            <th></th>
        </tr>
        <c:forEach items="${members}" var="member">
            <tr>
                <td>
                    ${member.emailAddress}
                </td>
                <td>
                    ${member.fullName}
                </td>
                <td>
                    ${member.programName}
                </td>
                <td>
                    ${member.yearLevel}
                </td>
                <td>
                    <a class="list-of-members__link" 
                       href="BDJKNMMemberAdmin?action=editMember&email=${member.emailAddress}">
                        Edit
                    </a>
                    &nbsp;
                    <a class="list-of-members__link" 
                       href="BDJKNMMemberAdmin?action=removeMember&email=${member.emailAddress}">
                        Remove
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
    
    <a href="BDJKNMMemberAdmin?action=addMember">
        <input class="list-of-members__btn" type="submit" value="Add Member"/>
    </a>
</div>

<jsp:include page="BDJKNMFooter.jsp" />