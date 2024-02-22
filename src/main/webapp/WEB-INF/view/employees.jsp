<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>EMPLOYEES</h2>
<table>
    <tr>
        <th>NAME</th>
        <th>SURNAME</th>
        <th>DEPARTMENT</th>
        <th>SALARY</th>
        <th>OPERATIONS</th>
    </tr>

    <c:forEach var = "emp" items="${emps}">
        <c:url var = "updateButton" value="/employee/update">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>
        <c:url var = "deleteButton" value="/employee/delete">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>



        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td> <input type="button" value="Update"
                        onclick="window.location.href='${updateButton}'">
                 <input type="button" value="Delete"
                        onclick="window.location.href='${deleteButton}'">
            </td>


        </tr>
    </c:forEach>

</table>

<br>

<input type="button" value="Add"
    onclick="window.location.href = '/employee/add'"/>



</body>
</html>
