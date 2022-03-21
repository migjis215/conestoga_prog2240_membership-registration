<%-- 
    Document   : BDJKNMAddBook
    Created on : Mar. 21, 2022, 5:11:53 p.m.
    Author     : Jisung Kim
--%>

<jsp:include page="BDJKNMBanner.jsp" />

<div class="container">
    <section class="add-book-form__title">
        <h3>Add a Book</h3>
    </section>
    <p class="message"><i>${message}</i></p>
    <form class="add-book-form" action="BDJKNMAddBook" method="post">
        <label for="code">Code:</label>
        <input class="add-book-form__code" type="text" name="code" value="${book.code}" style="width:100px"/><br/>
        <label for="description">Description:</label>
        <input class="add-book-form__description" type="text" name="description" value="${book.description}" style="width:300px"/><br/>
        <label for="quantity">Quantity:</label>
        <input class="add-book-form__quantity" type="text" name="quantity" value="${book.quantity}" style="width:50px"/><br/>
        <label hidden></label>
        <input class="add-book-form__btn" type="submit" value="Save"/>
        <a href="BDJKNMDisplayBooks">
            <input class="add-book-form__btn" type="button" value="Cancel"/>
        </a>
    </form>
</div>

<jsp:include page="BDJKNMFooter.jsp" />
