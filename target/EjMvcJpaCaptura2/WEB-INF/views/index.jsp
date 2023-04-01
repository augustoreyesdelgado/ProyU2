<%-- 
    Document   : index
    Author     : BAOZ
--%>
<%@include file="cabecera.jspf"%>
<%@include file="menu.jspf"%>
    <main id="main-content">
        <section>
            <header>
                <h3>¿Qu&eacute; se ofrece?</h3>
            </header>
            Banquetes S.A de C.V es una empresa dedicada a la elaboraci&oacute;n de banquetes para eventos varios. Los detalles de nuestros servicios se pueden consultar a continuaci&oacute;n.
            <div id="inner-grid">
                <div>
                    <h4>Temas</h4><a href="${pageContext.request.contextPath}/temasc" class="menu"><image alt="${prod.nombre}"
                                    src="<spring:url 
                                        value="/resources/public/imgs/proceso.png"/>"/></a>
                </div>
                <div>
                    <h4>Men&uacute;s</h4><a href="${pageContext.request.contextPath}/menusc" class="menu"><image alt="${prod.nombre}"
                                    src="<spring:url 
                                        value="/resources/public/imgs/compromiso.png"/>"/></a>
                </div>
                <div>
                    <h4>Tipos de Banquetes</h4>
                    <a href="${pageContext.request.contextPath}/banquete" 
           class="menu"><image alt="${prod.nombre}"
                                    src="<spring:url 
                                        value="/resources/public/imgs/materiales.png"/>"/></a>
                </div>
                <div>
                    <h4>Proceso de Contrataci&oacute;n</h4>
                    <a href="${pageContext.request.contextPath}/proceso" 
           class="menu"><image alt="${prod.nombre}"
                                    src="<spring:url 
                                        value="/resources/public/imgs/responsabilidad.png"/>"/></a>
                </div>
            </div>
        </section>
    </main>
<%@include file="lateral.jspf"%>
<%@include file="pie.jspf"%>
