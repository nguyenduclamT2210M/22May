<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" >
        <div>
            <a href="" class="navbar-brand">Employee Management</a>
        </div>
        <ul class="navbar-nav">
            <li><A href="<%=request.getContextPath()%>/list" class="nav-link">Employee</A> </li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${employee != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${employee == null}">
                <form action="insert" method="post">
                    </c:if>
                    <caption>
                        <h2>
                            <c:if test="${employee != null}">
                                Edit Employee
                            </c:if>


                        </h2>
                    </caption>
                    <c:if test="${employee != null}">
                        <input type="hidden" name="id" value="<c:out value="${employee.id}"/>"/>
                    </c:if>
                    <fieldset class="from-group">
                        <label>User name</label><input type="text" value="<c:out value="${employee.cmnd}"/>
"                                               class="from-control" name="name" required="required">
                    </fieldset>
                    <fieldset class="from-group">
                        <label>User name</label><input type="text" value="<c:out value="${employee.fullname}"/>
"                                               class="from-control" name="name" required="required">
                    </fieldset>
                    <fieldset class="from-group">
                        <label>User name</label><input type="text" value="<c:out value="${employee.birthday}"/>
"                                               class="from-control" name="name" required="required">
                    </fieldset>
                    <fieldset class="from-group">
                        <label>User name</label><input type="text" value="<c:out value="${employee.address}"/>
"                                               class="from-control" name="name" required="required">
                    </fieldset>
                    <fieldset class="from-group">
                        <label>User name</label><input type="text" value="<c:out value="${employee.postion}"/>
"                                               class="from-control" name="name" required="required">
                    </fieldset> <fieldset class="from-group">
                    <label>User name</label><input type="text" value="<c:out value="${employee.department}"/>
"                                               class="from-control" name="name" required="required">
                </fieldset>



                    <button type="submit" class="btn btn-success">Save</button>
                </form>

            </form>

        </div>
    </div>
</div>
</body>
</html>