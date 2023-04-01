package edu.aplic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Clase "de arranque" 
 * @author BAOZ
 */

public class MainWebAppInitializer  
        extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { DomainConfig.class };
    }
    
    //Avisa de dónde tomar la configuración Web
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    //Avisa que cualquier llamada pasa por el servlet de Spring MVC
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}