<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<tiles:importAttribute name="courses"/>
<!-- Listado de cursos -->
<div class="col-xs-3">
    <p class="lead"><i class="fa fa-university"></i> Cursos</p>

    <div class="list-group">
        <c:forEach items="${courses}" var="course">
            <a id="menu_${course.id}" href="<c:url value='/cursos/${course.id}'/>"
               class="list-group-item">${course.name}</a>
        </c:forEach>
    </div>
</div>
