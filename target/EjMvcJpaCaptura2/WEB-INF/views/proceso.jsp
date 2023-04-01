<%-- 
    Document   : principal
    Created on : 26 feb. 2023, 13:21:14
    Author     : augus
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="oErr" class="edu.aplic.utils.ErroresAplic" scope="page"/>

<%@include file="cabecera.jspf"%>
<%@include file="menu.jspf"%>
    <main id="main-content">
        <section>
            <header>
                <h3>Proceso de Contrataci&oacute;n</h3>
            </header>
            Aqui se da información sobre el proceso de contrataci&oacute;n:
            <div id="inner-grid">
                <div>
                    <h4>Paso 1</h4>
                    <a href="${pageContext.request.contextPath}/banquete" 
           class="menu"><image alt="${prod.nombre}"
                                    src="<spring:url 
                                        value="/resources/public/imgs/placeholder.png"/>"/></a>
                </div>
                <div>
                    <h4>Paso 2</h4><image alt="${prod.nombre}"
                                    src="<spring:url 
                                        value="/resources/public/imgs/placeholder.png"/>"/>
                </div>
                <div>
                    <h4>Paso 3</h4><image alt="${prod.nombre}"
                                    src="<spring:url 
                                        value="/resources/public/imgs/placeholder.png"/>"/>
                </div>
                <div>
                    <h4>Paso 4</h4>
                    <image alt="${prod.nombre}"
                                    src="<spring:url 
                                        value="/resources/public/imgs/placeholder.png"/>"/>
                </div>
            </div>
            Puedes registrarte pulsando <a href="${pageContext.request.contextPath}/editaprod1" >aqu&iacute</a>
        </section>
    </main>
<%@include file="lateral.jspf"%>
<%@include file="pie.jspf"%>
