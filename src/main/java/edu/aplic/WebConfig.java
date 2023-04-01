package edu.aplic;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Configuración de Spring MVC
 * @author BAOZ
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "edu.aplic.controller" })
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();

        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        return bean;
    }
	
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        //Indica dónde buscar los recursos
        //handler -> la URL que incluya /resources/ y algo más
        //la va a buscar en webapp/resources
        registry.addResourceHandler("/resources/**").addResourceLocations(
                "/resources/");
    }
    
    @Bean("messageSource") //Método para indicar de dónde tomar textos de msjs
    public MessageSource messageSource() {
    ResourceBundleMessageSource 
            messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("languages/message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    
    @Bean //Método para indicar qué idioma considerar, en este caso,el del
          //navegador
    public LocaleResolver localeResolver() {
        return new AcceptHeaderLocaleResolver();
    }
    
    @Override //Método para atrapar llamada antes de llegar al servlet y
              //considerar el idioma
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor 
                localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }
}