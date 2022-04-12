<%-- 
    Document   : BDJKNMEditMember
    Created on : Apr. 12, 2022, 5:52:52 a.m.
    Author     : Jisung Kim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="BDJKNMBanner.jsp" />

<div class="container">
    <h3 class="add-member-form__title">Edit an Existing Member</h3>
    <div class="message"><i>${message}</i></div>
    <form class="add-member-form" 
          action="BDJKNMMemberAdmin?email=${member.emailAddress}&action=saveMember&db_operation=update" 
          method="post">
        <label for="email">Email:</label>
        <input type="text" name="email" value="${member.emailAddress}" disabled style="width:300px"/><br/>
        <label for="fullName">Full Name:</label>
        <input type="text" name="fullName" value="${member.fullName}" style="width:200px"/><br/>
        <label for="phone">Phone:</label>
        <input type="text" name="phone" value="${member.phoneNumber}" style="width:100px"/><br/>
        <label for="program">IT Program:</label>
        <select name="program">
            <c:forEach items="${programs}" var="program" varStatus="loop">
                <option value="${program}"  
                    <c:if test="${program eq member.programName}">
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
                    <c:if test="${year eq member.yearLevel}">
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
