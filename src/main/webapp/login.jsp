<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Film rating</title>
</head>
<body>
<h1><a href="WEB-INF/views/home.jsp">Home</a></h1>
<div id="intro"></div>
<div id="login-container">
    <form id="login-form" action="controller?command=login" method="post">
        <label for="email">${email_label}</label>
        <input class="text-input" type="email" name="email" id="email" required autofocus/>
        <label for="password">${password_label}</label>
        <input class="text-input" type="password" name="password" id="password" required/>
        <hr>
        <input type="submit" id="login-button" value="${button}"/>
    </form>
</div>
</body>
</html>
