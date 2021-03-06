<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${error}">
    <script>
        $(document).ready(function () {
            $('#flashMessagesBox').html($('<p/>', { 'class': 'error center', html: "<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>" }));
        });
    </script>
</c:if>
                
<div class="container-fluid theme-showcase" role="main">
    <div class="row">
        <div class="col-lg-6">
            <div class="jumbotron">
                <h1>¡Bienvenido a Aula Virtual!</h1>
                <p class="info">
                    Bienvenido al portal de capacitación de la Secretaría de Finanzas del Gobierno de Oaxaca. En este espacio virtual, te brindamos una serie de cursos de gran valor público y social que tienen como propósito ofrecerte una solución integral dentro de tus diferentes áreas de competencia. Esperamos que estas herramientas que ponemos a tu disposición cumplan con tus expectativas de capacitación.
                </p>
            </div>
        </div>
        <div class="clearfix" />
        <div class="col-lg-6">
                
            <div class="panel panel-warning">
                <div class="panel-heading">
                    <h3><span class="glyphicon glyphicon-log-in"></span>&nbsp;
                    <spring:message javaScriptEscape="true" code="login.login.label"/></h3>
                </div>
                <div class="panel-body">
                    <c:out value="${sessionScope.LAST_USERNAME}" escapeXml="false"/>
                    <form name='loginForm' action="<c:url value='/j_spring_security_check'/>" method='POST' class="form-horizontal" role="form">
                        
                            <div class="form-group">
                                <label for="username" class="col-sm-4 control-label">
                                    <spring:message htmlEscape="true" javaScriptEscape="true" code="label.email"/>
                                </label>
                                <div class="col-sm-8">
                                    <input name="username" placeholder="Capture correo electr&oacute;nico" class="form-control"
                                       value="<c:out value="${sessionScope.LAST_USERNAME}" escapeXml="false" />"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="password" class="col-sm-4 control-label">
                                    <spring:message javaScriptEscape="true" code="label.password"/>
                                </label>
                                <div class="col-sm-8">
                                <input type="password" name="password" class="form-control"/>
                                </div>
                            </div>

                        <div class="form-group">
                                <div class="col-sm-offset-4 col-sm-8">
                                <input type="submit" class="btn btn-primary"
                                       value="<spring:message javaScriptEscape="true" code="send"/>"
                                       id="submitBtn"/>
                                </div>
                        </div>

                        <div>
                            <spring:message javaScriptEscape="true" code="login.forgotOrChangePassword.label"/>
                            <a href="<c:url value="/login/forgetPassword"/>">
                                <spring:message htmlEscape="true" javaScriptEscape="true" code="click"/>
                                <spring:message htmlEscape="true" javaScriptEscape="true" code="here"/>
                            </a>
                        </div>
                    </form>
                </div>
            </div>
                
        </div>
    </div>
</div>




