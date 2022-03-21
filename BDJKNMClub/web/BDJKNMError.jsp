<%-- 
    Document   : BDJKNMError
    Created on : Mar. 21, 2022, 5:29:53 p.m.
    Author     : Jisung Kim
--%>

<jsp:include page="BDJKNMBanner.jsp" />

<h1>Java Error</h1>
<p>Sorry, Java has thrown an exception.</p>
<p>To continue, click the Back button.</p>

<h2>Details</h2>
<p>Type: ${pageContext.exception["class"]}</p>
<p>Message: ${pageContext.exception.message}</p>

<jsp:include page="BDJKNMFooter.jsp" />
