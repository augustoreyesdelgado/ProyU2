<%-- 
    Document   : index
    Author     : BAOZ
--%>
<%@include file="cabecera.jspf"%>
<%@include file="menu.jspf"%>
    <main id="main-content">
		<section>
            <header>
                <h3><fmt:message key="index.tit" /></h3>
            </header>
            <h4><fmt:message key="catprod.msj" /></h4>
             <form:form action="${pageContext.request.contextPath}/editaprod" 
                  modelAttribute="datos" method="post">
                <form:hidden path="tipoProd" value="0"/>
                <form:hidden path="opeSelec"/>
                <form:hidden path="claveSelec"/>
                <table border="1">
                    <thead>
                        
                        <tr>
                            <th>Clave</th>
                            <th>Nombre</th>
                            <th>Apellido Paterno</th>
                            <th>Apellido Materno</th>
                            <th>T&eacute;lefono</th>
                            <th>Direcci&oacute;n</th>
                            <th>Correo Electronico</th>
                            <th>Contrasenia</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos.listaProductos}" var="prod">
                            <tr>
                                <td>
                                    <c:out value="${prod.clave}"/>
                                </td>
                                <td>
                                    <c:out value="${prod.nombre}"/>
                                </td>
                                <td>
                                    <c:out value="${prod.apellidop}"/>
                                </td>
                                <td>
                                    <c:out value="${prod.apellidom}"/>
                                </td>
                                <td>
                                    <c:out value="${prod.telefono}"/>
                                </td>
                                <td>
                                    <c:out value="${prod.direccion}"/>
                                </td>
                                <td>
                                    <c:out value="${prod.correo}"/>
                                </td>
                                <td>
                                    <c:out value="${prod.contrasenia}"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <br>
             </form:form>
                <label>Nota del desarrollador, ósea Augusto: se muestran los datos para corroborar su registro. En producción ni siquiera se cargarían en el DAO de usuarios. *Este comentario se repite dentro del código, giño giño* </label>
        </section>
    </main>
<%@include file="lateral.jspf"%>
<%@include file="pie.jspf"%>
