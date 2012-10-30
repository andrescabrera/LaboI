<%-- 
    Document   : fechaHora
    Created on : 07/02/2011, 04:52:21
    Author     : acabrera
--%>

<%@tag description="archivo FechaHora" pageEncoding="UTF-8"%>

<%@variable name-given="hora" %>
<%@variable name-given="minutos" %>
<%@variable name-given="fecha" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="bFecha" class="beans.BeanFecha"></jsp:useBean>

<!-- Obtener la hora y la fecha actuales -->
<fmt:formatNumber value="${bFecha.hora}" pattern="00" var="hora"></fmt:formatNumber>
<fmt:formatNumber value="${bFecha.minutos}" pattern="00" var="minutos"></fmt:formatNumber>
<c:set var="fecha" value="${bFecha.fecha}"></c:set>

<!-- Actualizar y mostrar el contador de visitas a esta página -->
<c:set var="cuenta" scope="application" value="${cuenta + 1}"></c:set>
<jsp:doBody></jsp:doBody>
