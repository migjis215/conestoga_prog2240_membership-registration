<%-- 
    Document   : BDJKNMRemoveMember
    Created on : Apr. 12, 2022, 6:35:31 p.m.
    Author     : Jisung Kim
--%>

<jsp:include page="BDJKNMBanner.jsp" />

<div class="container">
    <h3 class="member-form__title">Do you want to delete this member?</h3>
    <div class="message"><i>${message}</i></div>
    <form class="member-form" 
          action="BDJKNMMemberAdmin?action=deleteMember&email=${member.emailAddress}" 
          method="post">
        <label for="email">Email:</label>
        <input type="text" name="email" value="${member.emailAddress}" disabled style="width:300px"/><br/>
        <label for="fullName">Full Name:</label>
        <input type="text" name="fullName" value="${member.fullName}" disabled style="width:200px"/><br/>
        <label for="phone">Phone:</label>
        <input type="text" name="phone" value="${member.phoneNumber}" disabled style="width:100px"/><br/>
        <label for="program">IT Program:</label>
        <select name="program" disabled>
            <option value="${member.programName}">${member.programName}</option>
        </select><br/>
        <label for="year">Year Level:</label>
        <select name="year" disabled>
            <option value="${member.yearLevel}">${member.yearLevel}</option>
        </select><br />
        <label hidden></label>
        <input class="member-form__btn" type="submit" value="Yes"/>
        <a class="member-form__link" href="BDJKNMMemberAdmin">
            <input class="member-form__btn" type="button" value="No"/>
        </a>
    </form>
</div>

<jsp:include page="BDJKNMFooter.jsp" />