<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="total" value="0"/>
<c:forEach items="${sessionScope.cart}" var="product" varStatus="status">
    <c:out value="${product.name}"/> - <c:out value="${product.price}"/><br>
    <c:set var="total" value="${total + product.price}"/>
</c:forEach>
Total: $${total}

<form:form modelAttribute="customerModel" action="checkout">
    <form:label path="name">Name:</form:label>
    <form:input path="name"/><br>
    <form:errors path="name" cssStyle="color: red"/><br>
    <form:label path="phone">Phone:</form:label>
    <form:input path="phone"/><br>
    <form:label path="birthday">Birthday:</form:label>
    <form:input path="birthday" type="date"/><br>
    <form:label path="email">Email:</form:label>
    <form:input path="email" type="email"/><br>
    <button type="submit">Check Out</button>
</form:form>
