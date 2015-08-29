<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container-fliud">
    <div clas="row">

        <!-- Examen de evaluación -->
        <div class="col-xs-9">
            
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <i class="fa fa-list-alt pull-left"></i>
                        <spring:message code="testEngine.appraisal.heading.label" />
                        <c:out value="${exam.courseName}"/> - <c:out value="${exam.moduleName}"/>
                    </h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-10 col-sm-offset-2">
                            <spring:message code="testEngine.appraisal.info1.label" arguments="${exam.numPreguntas}; ${exam.numRespuestasPregunta}" argumentSeparator=";"/>
                        </div>
                    </div>
                    <br/>
                    <div class="row">
                        <div class="col-sm-10 col-sm-offset-2">
                            <spring:message code="testEngine.appraisal.info2.label" />
                        </div>
                    </div>
                </div>
            </div>
            
            <h3><spring:message code="testEngine.addQuestionsAnswers.heading2.label"/></h3>

            <div class="well">
                <form:form method="POST" action="${target}" commandName="exam" cssClass="form-horizontal">
                    <form:hidden path="${exam.examenId}" />
                    <form:hidden path="${exam.moduloId}" />
                    <form:hidden path="${exam.usuarioId}" />
                    <c:forEach items="${exam.preguntas}" var="pregunta">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="panel-title">
                                    <c:out value="${pregunta.textoPregunta}"/>
                                </div>
                            </div>
                            <div class="panel panel-body">
                                <c:forEach items="${pregunta.respuestas}" var="respuesta">
                                    <div>
                                        <input type="radio" name="${pregunta.preguntaId}" value="${respuesta.respuestaId}" />&nbsp;<c:out value="{$respuesta.textoRespuesta}"/>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </c:forEach>
                </form:form>
            </div>
            
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#menu_${course.cursoId}').addClass('active');
    });
</script>