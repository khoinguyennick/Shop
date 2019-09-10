<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="<c:url value="/admin/new-product"/>">New Product</a><br>
<c:forEach items="${productList}" var="product">
    <c:out value="${product.name}"/> -
    <a href="<c:url value="/admin/edit-product/${product.id}"/>">Edit</a> -
    <a href="<c:url value="/admin/delete-product/${product.id}"/>">Delete</a><br>
</c:forEach>