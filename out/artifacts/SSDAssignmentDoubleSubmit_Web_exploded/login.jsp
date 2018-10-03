<%--
  Created by IntelliJ IDEA.
  User: Movinda
  Date: 10/3/2018
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
    <h3>
        Login
    </h3>
</div>
<div>
    <form method="post" action="LoginCheck">
        <table>
            <tr>
                <td>User Name:</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="login"></td>
            </tr>

        </table>

    </form>
</div>
</body>
</html>
