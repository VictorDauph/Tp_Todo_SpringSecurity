<%-- 
    Document   : list-todos
    Created on : 5 août 2022, 14:01:34
    Author     : Victor
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>


    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>ToDo List</title>
        </head>
        <body>
            <h1>Todo List</h1>
            <ul>
                <c:forEach items="${todoList}" var="todo">
                    <li><c:out value="Nom : ${todo.name}, description : ${todo.description}, due date:${todo.targetDate} "  /></li>
                    <form:form method="GET" action="/update-todo/${todo.id}">
                        <input type="submit" value="Modifier" />
                    </form:form>
                    <form:form method="GET" action="/delete-todo/${todo.id}">
                        <input type="submit" value="Supprimer" />
                    </form:form>
                </c:forEach>                
            </ul>
            <a href="/add-todo">ajouter nouveau Todo</a>
        </body>
    </html>

