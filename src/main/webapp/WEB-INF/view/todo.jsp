<%-- 
    Document   : login
    Created on : 4 août 2022, 10:16:43
    Author     : Victor
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<html>
   <head>
      <title>Todo Form</title>
   </head>

   <body>
      <h1>Todo Form</h1>
      
      <c:choose>
          <c:when test="${todo.id==null}" >
              <c:set var="path" value="/add-todo" />
          </c:when>
          <c:otherwise>
              <c:set var="path" value="/update-todo" />
          </c:otherwise>
      </c:choose>
      
      <form:form method="POST"  action="${path}" modelAttribute="todo">
          <form:hidden path="id" /> 
          <fieldset>
            <form:label path="name">Name</form:label>
            <form:input path="name" type="text"/>
          </fieldset>
          <fieldset>
            <form:label path="description">Description</form:label>
            <form:input path="description" type="textarea"/>
          </fieldset>
          <fieldset>
            <label for = "targetDate">Target date (yyyy-MM-dd)</label>
            <input type="date" name="targetDate" value="${todo.targetDate}" id="targetDate"/>
          </fieldset>
          <input type="submit" value="Soumettre todo" />
      </form:form>
   </body>
   
</html>
