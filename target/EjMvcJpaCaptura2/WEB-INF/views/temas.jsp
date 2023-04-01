<%-- 
    Document   : principal
    Created on : 26 feb. 2023, 13:21:14
    Author     : augus
--%>
<%@include file="cabecera.jspf"%>
<%@include file="menu.jspf"%>
    <main id="main-content">
		<section>
            <header>
                <h3><fmt:message key="index.tit" /></h3>
            </header>
            <h4><fmt:message key="tema.msj" /></h4>
                <table>
                    <thead>
                        <tr>
                            <th>Temas</th>
                            <th>Imagen ilustrativa</th>
                            <th>Generalidades</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos.listaTemas}" var="prod">
                            <tr>
                                 <td>
                                    <c:out value="${prod.nombre}"/>
                                </td>
                                <td>
                                    <image alt="${prod.imagen}"
                                    src="<spring:url 
                                        value="/resources/public/imgs/${prod.imagen}"/>"/>
                                </td>
                                <td>
                                    <c:out value="${prod.descripcion}"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <label>Las imagenes utilizadas pertenecen a: https://www.bodas.com.mx</label>
        </section>
    </main>
<%@include file="lateral.jspf"%>
<%@include file="pie.jspf"%>
