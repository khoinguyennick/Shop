<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${customerList}" var="customer">
    <c:out value="${customer.name}"/> - <c:out value="${customer.email}"/><br>
</c:forEach>