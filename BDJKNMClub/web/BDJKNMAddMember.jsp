<%-- 
    Document   : BDJKNMAddMember
    Created on : Apr. 12, 2022, 2:37:23 a.m.
    Author     : Jisung Kim
--%>

<jsp:include page="BDJKNMBanner.jsp" />

<div class="container">
    <h3 class="add-member-form__title">Add a New Member</h3>
    <div class="message"><i>${message}</i></div>
    <form class="add-member-form" action="BDJKNMMemberAdmin" method="post">
        <input type="hidden" name="action" value="saveMember">
        <label for="email">Email:</label>
        <input type="text" name="email" value="${member.email}" style="width:300px"/><br/>
        <label for="fullName">Full Name:</label>
        <input type="text" name="fullName" value="${member.fullName}" style="width:200px"/><br/>
        <label for="phone">Phone:</label>
        <input type="text" name="phone" value="${member.phone}" style="width:100px"/><br/>
        <label for="program">IT Program:</label>
        <select name="program">
            <option value="CAS">CAS</option>
            <option value="SQATE">SQATE</option>
            <option value="CPA" selected>CPA</option>
            <option value="CP">CP</option>
            <option value="ITID">ITID</option>
            <option value="CAD">CAD</option>
            <option value="ITSS">ITSS</option>
        </select><br/>
        <label for="year">Year Level:</label>
        <select name="year">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
        </select><br/>
        <label hidden></label>
        <input class="register-form__btn" type="submit" value="Save"/>
        <input class="register-form__btn" type="reset" value="Reset"/>
    </form>
</div>

<jsp:include page="BDJKNMFooter.jsp" />
