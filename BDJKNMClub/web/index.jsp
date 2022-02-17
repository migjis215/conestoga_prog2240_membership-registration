<%-- 
    Document   : index
    Created on : Feb. 17, 2022, 12:53:00 p.m.
    Author     : Jisung Kim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="banner.jsp" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BDJKNM Computer Programming Club</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <section class="main__title">
                <h3>Java Web Technologies: Section 3</h3>
            </section>
            <section class="main__team">
                <p>Pair Programming Team:</p>
                <h3>Assignment 1</h3>
                <h3>Driver: Jisung Kim</h3>
                <h3>Observer: Brendan Donnachie</h3>
                <h3>Observer: Nate Mrakava</h3>
            </section>
            <section class="main__time">
                <p>Current Date and Time</p>
                <h3><%= new java.util.Date() %></h3>
            </section>
        </div>
    </body>
</html>

<jsp:include page="footer.jsp" />