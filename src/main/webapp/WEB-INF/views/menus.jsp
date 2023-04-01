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
            <h4><fmt:message key="menu.msj" /></h4>
                <table>
                    <thead>
                        <tr>
                            <th>Men&uacute;</th>
                            <th>Imagen ilustrativa</th>
                            <th>Generalidades</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos.listaMenus}" var="prod">
                            <tr>
                                <td>
                                    <c:out value="${prod.nombre}"/>
                                </td>
                                <td>
                    <center><image alt="${prod.imagen}"
                                    src="<spring:url 
                                        value="/resources/public/imgs/${prod.imagen}"/>"/></center>
                                </td>
                                <td>
                                    <c:out value="${prod.descripcion}"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <label>Las imgenes utilizadas fueron extraidas de: https://www.yelp.com/</label>
        </section>
    </main>
<%@include file="lateral.jspf"%>
<%@include file="pie.jspf"%>
