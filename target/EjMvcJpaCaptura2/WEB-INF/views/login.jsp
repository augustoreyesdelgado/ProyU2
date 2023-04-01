<%-- 
    Document   : login
    Created on : 26 mar. 2023, 12:28:28
    Author     : augus
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="cabecera.jspf"%>
<%@include file="menu.jspf"%>
    <main id="main-content">
        <section>
            <header>
                <h3>Inicia Sesi&oacute;n</h3>
            </header>
            
            <!--<form method="post" action="CtrlLogin">-->
            
            <label for="correo">Correo Electr&oacute;nico:</label>
            <input type="email" id="correo" name="correo" required/><br/>
            
            <label for="contraseña">Contraseña:</label>
            <input type="text" id="contrasena" name="contrasena" required/><br/>
                
                <input type="submit" value="Enviar"/>
            <!--</form>-->
        </section>
    </main>
<%@include file="lateral.jspf"%>
<%@include file="pie.jspf"%>
