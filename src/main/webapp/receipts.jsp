<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${customer != null}">
        Name: ${customer.name}<br>
        Email: ${customer.email}<br>
        <c:forEach items="${customer.receiptSet}" var="receipt" varStatus="status">
            Receipt #${receipt.id}<br>
            <c:set var="total" value="0"/>
            <c:forEach items="${receipt.detailList}" var="detail">
                - Product: ${detail.receiptDetailID.product.name}
                - Price: $${detail.price}<br>
                <c:set var="total" value="${total + detail.price}"/>
            </c:forEach>
            Total: $${total}
        </c:forEach>
    </c:when>
    <c:otherwise>
        <h3>You haven't buy anything!</h3>
        <a href="<c:url value="/"/>">Continue shopping!</a>
    </c:otherwise>
</c:choose>