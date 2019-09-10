<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>${category.name}</h3>
<c:forEach items="${productList}" var="product" varStatus="status">
    <c:out value="${product.name}"/> - <a href="<c:url value="/add-to-cart/${product.id}"/>">Add to cart</a>
</c:forEach>