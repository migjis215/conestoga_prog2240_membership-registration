<%-- 
    Document   : register
    Created on : Feb. 17, 2022, 2:22:54 p.m.
    Author     : Jisung Kim
--%>

<jsp:include page="banner.jsp" />

<div class="container">
    <section class="register-form__title">
        <h3>New Member Registration Form</h3>
    </section>
    <form class="register-form" action="displayMember.jsp" method="post">
        <label for="fullName">Full Name:</label>
        <input class="register-form__fullName" type="text" name="fullName" style="width:200px" required/><br/>
        <label for="email">Email:</label>
        <input class="register-form__email" type="text" name="email" style="width:300px" required/><br/>
        <label for="phone">Phone:</label>
        <input class="register-form__phone" type="text" name="phone" style="width:100px"/><br/>
        <label for="program">IT Program:</label>
        <select class="register-form__program" name="program">
            <option value="cas">CAS</option>
            <option value="sqate">SQATE</option>
            <option value="cpa">CPA</option>
            <option value="cp">CP</option>
            <option value="itid">ITID</option>
            <option value="cad">CAD</option>
            <option value="itss">ITSS</option>
        </select><br/>
        <label for="year">Year Level:</label>
        <select class="register-form__year" name="year">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
        </select><br/>
        <label hidden></label>
        <input class="register-form__btn" type="submit" value="Register Now!"/>
        <input class="register-form__btn" type="reset" value="Reset"/>
    </form>
</div>

<jsp:include page="footer.jsp" />