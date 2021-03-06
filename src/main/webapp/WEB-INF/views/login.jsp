<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

<t:navbar activePage="signin"/>

<div class="container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Sign In</div>
                <div style="float:right; font-size: 80%; position: relative; top:-20px"><a
                        href="/root/forgot">Forgot password?</a></div>
            </div>

            <div style="padding-top:30px" class="panel-body">

                <form id="loginform" class="form-horizontal" method="post"
                      action="/root/login">

                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="login-username" type="text" name="userName"
                               <c:if test="${not empty requestScope.validationUser.getValidationObject().getUserName()}">
                               value="${requestScope.validationUser.getValidationObject().getUserName()}"</c:if>
                        <t:formInputAlert validator="${requestScope.validationUser.getFieldStatuses().get(0)}"/>
                               required placeholder="login" class="form-control">
                    </div>

                    <div style="margin-bottom: 5px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input id="login-password" type="password" name="password"
                        <t:formInputAlert validator="${requestScope.validationUser.getFieldStatuses().get(1)}"/>
                               required placeholder="password">
                    </div>
                    <c:if test="${not empty requestScope.validationUser}"><label
                            class="text-danger">${requestScope.validationUser.getValidationMessage()}</label></c:if>
                    <div class="col-sm-12 controls text-center">
                        <button type="submit" id="btn-login" class="btn btn-success btn-lg ">Login</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
