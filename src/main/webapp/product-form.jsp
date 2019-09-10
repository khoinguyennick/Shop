<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form modelAttribute="productModel" method="post" action="${action}">
    <form:hidden path="id"/>
    <form:label path="name">Name:</form:label>
    <form:input path="name"/><br>
    <form:errors path="name" cssStyle="color: red"/><br>
    <form:label path="categoryID">Category:</form:label>
    <form:select path="categoryID" items="${categoryList}" itemValue="id" itemLabel="name"/><br>
    <form:errors path="categoryID" cssStyle="color: red"/><br>
    <form:label path="description">Description:</form:label>
    <form:textarea path="description"/><br>
    <form:errors path="description" cssStyle="color: red"/><br>
    <form:label path="price">Price:</form:label>
    <form:input path="price" type="number" min="1"/><br>
    <form:errors path="price" cssStyle="color: red"/><br>
    <button type="submit">${buttonText}</button>
</form:form>