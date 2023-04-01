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
                <h3>Banquetes</h3>
            </header>
            Aqui se da información sobre los banquetes:
            <div id="inner-grid">
                <div>
                    <h4>Desayunos</h4><image alt="${prod.nombre}"
                                    src="<spring:url 
                                        value="/resources/public/imgs/placeholder.png"/>"/>
                </div>
                <div>
                    <h4>Comidas</h4><image alt="${prod.nombre}"
                                    src="<spring:url 
                                        value="/resources/public/imgs/placeholder.png"/>"/>
                </div>
                <div>
                    <h4>Cenas</h4><image alt="${prod.nombre}"
                                    src="<spring:url 
                                        value="/resources/public/imgs/placeholder.png"/>"/>
                </div>
                <div>
                    <h4>Proceso de Contrataci&oacute;n</h4>
                    <image alt="${prod.nombre}"
                                    src="<spring:url 
                                        value="/resources/public/imgs/placeholder.png"/>"/>
                </div>
            </div>
        </section>
    </main>
<%@include file="lateral.jspf"%>
<%@include file="pie.jspf"%>
