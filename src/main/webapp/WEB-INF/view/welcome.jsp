<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Index</title>
        </head>
        <body>
            <h1>Index</h1>
            <security:authorize access="hasRole('USER')">
               <p>
                   Welcome <security:authentication property="principal.username"/>
                   <br><br>
                   <a href="/list-todos">Click here</a> to manage your todo's!!               
               </p>
            </security:authorize>    
        </body>
    </html>

