<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        ${pageContext.request.contextPath}
        <form method="POST">
            <input type="text" name="username" placeholder="Username" required autofocus="autofocus" value="admin" />
            <input type="password" name="password" placeholder="Password" required="required" value="admin@12345" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <hr>
            <button type="submit">Sign in</button>
        </form>
    </body>
</html>
