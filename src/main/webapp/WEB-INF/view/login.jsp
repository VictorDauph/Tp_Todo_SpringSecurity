<%-- 
    Document   : login
    Created on : 4 août 2022, 10:16:43
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
   <head>
      <title>Login Form</title>
   </head>

   <body>
      <h2>Todo Login</h2>
      <form method="POST" action="/login">
         <table>
            <tr>
                <td>
                    <label for="username">Username</label>
                </td>
               <td><input id="username" name="username" /></td>
            </tr>
            <tr>
               <td>
                   <label for="password">Password</label>
               </td>
               <td>
                   <input type="password" id="password" name="password" />
               </td>
            </tr>            
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form>
   </body>
   
</html>
