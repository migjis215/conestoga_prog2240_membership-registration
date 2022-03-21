<%-- 
    Document   : displayMember
    Created on : Feb. 17, 2022, 5:30:12 p.m.
    Author     : Jisung Kim
--%>

<jsp:include page="BDJKNMBanner.jsp" />

<div class="container">
    <section class="display-member__title">
        <h3>Thanks for joining our club!</h3>
    </section>
    <section class="display-member__details">
        <p>Here is the information you entered:</p>
        <label>Full Name:</label>
        <span>${param.fullName}</span><br/>
        <label>Email:</label>
        <span>${param.email}</span><br/>
        <label>Phone:</label>
        <span>${param.phone}</span><br/>
        <label>IT Program:</label>
        <span>${param.program}</span><br/>
        <label>Year Level:</label>
        <span>${param.year}</span><br/>
        <p>
            To register anoter member, click on the Back button in your browser or <br/>
            the Return button shown below.
        </p>
        <form action="BDJKNMRegister.jsp">
            <input class="display-member__btn" type="submit" value="Return"/>
        </form>
    </section>
</div>

<jsp:include page="BDJKNMFooter.jsp" />