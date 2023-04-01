<%-- 
    Document   : registro
    Created on : 26 feb. 2023, 12:34:56
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
                <h3>Registro de Usuario</h3>
            </header>
            
            <form method="post" action="CtrlRegistra">
            
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required/><br/>
            
            <label for="telefono">Telefono:</label>
            <input type="tel" id="telefono" name="telefono" pattern="[0-9]{10}" required/><br/>
            
            <label for="direccion">Direcci&oacute;n:</label>
            <input type="text" id="direccion" name="direccion" required/><br/>
            
            <label for="correo">Correo Electronico:</label>
            <input type="email" id="correo" name="correo" required/><br/>
            
            <label for="contrasena">Contraseña:</label>
            <input type="text" id="contrasena" name="contrasena" required/><br/>
                
                <input type="submit" value="Enviar"/>
            </form>
        </section>
    </main>
<%@include file="lateral.jspf"%>
<%@include file="pie.jspf"%>
