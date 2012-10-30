<%-- 
    Document   : fechaHoraFragmentos
    Created on : 07/02/2011, 05:37:47
    Author     : acabrera
--%>

<%@tag description="archivo fechaHora pero esta vez usando fragmentos " pageEncoding="UTF-8"%>

<%@attribute name="mostrarFechaHora" fragment="true" %>
<%@attribute name="mostrarCuenta" fragment="true" %>
<%@variable name-given="hora" %>
<%@variable name-given="minutos" %>
<%@variable name-given="fecha" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="beanFecha" class="beans.BeanFecha"></jsp:useBean>

<!-- obtener la fecha y hora actuales -->
<fmt:formatNumber value="${beanFecha.hora}" pattern="00" 
                  var="hora"></fmt:formatNumber>
<fmt:formatNumber value="${beanFecha.minutos}" pattern="00"
                  var="minutos"></fmt:formatNumber>
<c:set var="fecha" value="${beanFecha.fecha}"></c:set>
<jsp:invoke fragment="mostrarFechaHora"></jsp:invoke>

<!-- Actualizar y mostrar el contador de visitas  a esta página -->
<c:set var="cuenta" scope="application" value="${cuenta + 1}"></c:set>
<jsp:invoke fragment="mostrarCuenta"></jsp:invoke>