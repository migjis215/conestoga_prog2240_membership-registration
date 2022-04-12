<%-- 
    Document   : index
    Created on : Feb. 17, 2022, 12:53:00 p.m.
    Author     : Jisung Kim
--%>

<jsp:include page="BDJKNMBanner.jsp" />

<div class="container">
    <section class="main__title">
        <h3>Java Web Technologies: Section 3</h3>
    </section>
    <section class="main__team">
        <p>Pair Programming Team:</p>
        <h3>Assignment 4</h3>
        <h3>Driver: Jisung Kim</h3>
        <h3>Observer: Brendan Donnachie</h3>
        <h3>Observer: Nate Mrakava</h3>
    </section>
    <section class="main__time">
        <p>Current Date and Time</p>
        <h3><%= new java.util.Date() %></h3>
    </section>
</div>
                
<jsp:include page="BDJKNMFooter.jsp" />