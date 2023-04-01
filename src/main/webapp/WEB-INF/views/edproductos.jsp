<%-- 
    Document   : index
    Author     : BAOZ
--%>
<%@include file="cabecera.jspf"%>
<%@include file="menu.jspf"%>
    <main id="main-content">
	<section>
            <header>
                <h3><fmt:message key="edprod.tit" /></h3>
            </header>
            <form:form action="${pageContext.request.contextPath}/guardaprod" 
                  modelAttribute="datos" method="post">
                <form:hidden path="tipoProd" value="0"/>
                <form:hidden path="opeSelec"/>
                <form:hidden path="prodCapt1.clave" readonly="true"/>
                <br/>
                <form:label path="prodCapt1.nombre">
                    <spring:message code="edprod.nombre"/>
                </form:label>
                <form:input path="prodCapt1.nombre" required="true"/>
                <br/>
                <form:label path="prodCapt1.apellidop">
                    <spring:message code="edprod.apellidop"/>
                </form:label>
                <form:input path="prodCapt1.apellidop" required="true"/>
                <br/>
                <form:label path="prodCapt1.apellidom">
                    <spring:message code="edprod.apellidom"/>
                </form:label>
                <form:input path="prodCapt1.apellidom" required="true"/>
                <br/>
                <form:label path="prodCapt1.direccion">
                    <spring:message code="edprod.direccion"/>
                </form:label>
                <form:textarea path="prodCapt1.direccion" required="true"/>
                <br/>
                <form:label path="prodCapt1.telefono">
                    <spring:message code="edprod.telefono"/>
                </form:label>
                <form:input path="prodCapt1.telefono" type="number" required="true"/>
                <br/>
                <form:label path="prodCapt1.correo">
                    <spring:message code="edprod.correo"/>
                </form:label>
                <form:input path="prodCapt1.correo" required="true"/>
                <br/>
                <form:label path="prodCapt1.contrasenia">
                    <spring:message code="edprod.contrasenia"/>
                </form:label>
                <form:input path="prodCapt1.contrasenia" required="true"/>
                <br/>
                <br/>
                <input type="submit" 
                       value="<spring:message code="index.btn"/>"/>
                <br/>
                <c:if test="${not empty textoError}">
                   ${textoError}
                </c:if>
                <br/>
                <form:errors path="*" cssClass="errores"/>
            </form:form>
        </section>
    </main>
<%@include file="lateral.jspf"%>
<%@include file="pie.jspf"%>
