<%-- 
    Document   : BDJKNMAddMember
    Created on : Apr. 12, 2022, 2:37:23 a.m.
    Author     : Jisung Kim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="BDJKNMBanner.jsp" />

<div class="container">
    <h3 class="member-form__title">Add a New Member</h3>
    <div class="message"><i>${message}</i></div>
    <form class="member-form" action="BDJKNMMemberAdmin?action=saveMember" method="post">
        <label for="email">Email:</label>
        <input type="text" name="email" value="${member.emailAddress}" style="width:300px"/><br/>
        <label for="fullName">Full Name:</label>
        <input type="text" name="fullName" value="${member.fullName}" style="width:200px"/><br/>
        <label for="phone">Phone:</label>
        <input type="text" name="phone" value="${member.phoneNumber}" style="width:100px"/><br/>
        <label for="program">IT Program:</label>
        <select name="program">
            <c:forEach items="${programs}" var="program">
                <option value="${program}"  
                    <c:if test="${program == member.programName}">
                        selected="selected"
                    </c:if>>
                    ${program}
                </option>
            </c:forEach>
        </select><br/>
        <label for="year">Year Level:</label>
        <select name="year">
            <c:forEach begin="1" end="4" var="year">
                <option value="${year}"  
                    <c:if test="${year == member.yearLevel}">
                        selected="selected"
                    </c:if>>
                    ${year}
                </option>
            </c:forEach>
        </select><br />
        <label hidden></label>
        <input class="member-form__btn" type="submit" value="Save"/>
        <input class="member-form__btn" type="reset" value="Reset"/>
    </form>
</div>

<jsp:include page="BDJKNMFooter.jsp" />
