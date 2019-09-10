<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="<c:url value="/receipts"/>">Receipts</a><br>
<h1>Categories</h1>
<c:forEach items="${categoryList}" var="category" varStatus="status">
    <a href="<c:url value="/category/${category.id}/products"/>">${category.name}</a> |
</c:forEach>