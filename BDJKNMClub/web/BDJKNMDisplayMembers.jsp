<%-- 
    Document   : BDJKNMDisplayMembers
    Created on : Apr. 11, 2022, 11:16:18 a.m.
    Author     : Jisung Kim
--%>

<%@page import="club.data.DBUtil"%>
<%@page import="java.sql.*"%>

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
        <%
            Connection con = DBUtil.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM member");
            while (resultSet.next()) {
        %>
        <tr>
            <td>
                <%
                    out.print(resultSet.getString(3));
                %>
            </td>
            <td>
                <%
                    out.print(resultSet.getString(2));
                %>
            </td>
            <td>
                <%
                    out.print(resultSet.getString(5));
                %>
            </td>
            <td>
                <%
                    out.print(resultSet.getInt(6));
                %>
            </td>
            <td>
                <a class="list-of-members__link" href="editRecords.jsp?id=<%=resultSet.getInt(1)%>&firstName=<%=resultSet.getString(2)%>&lastName=<%=resultSet.getString(3)%>&email=<%=resultSet.getString(4)%>">Edit</a>
                <a class="list-of-members__link" href="UserServlet?action=delete&id=<%=resultSet.getInt(1)%>">Remove</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    
    <a href="BDJKNMAddBook.jsp">
        <input class="list-of-members__btn" type="button" value="Add Member"/>
    </a>
</div>

<jsp:include page="BDJKNMFooter.jsp" />