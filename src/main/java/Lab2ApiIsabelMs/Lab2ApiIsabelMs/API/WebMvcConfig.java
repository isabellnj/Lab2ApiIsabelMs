package Lab2ApiIsabelMs.Lab2ApiIsabelMs.API;

import org.springframework.web.servlet.LocaleResolver;

import org.springframework.context.MessageSource;
//import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
@ComponentScan("com.example.API")
public class WebMvcConfig implements WebMvcConfigurer {
    
    @Bean
    public LocaleResolver localeResolver(){
        return new CookieLocaleResolver();

     }

     @Bean
     public LocaleChangeInterceptor localeChangeInterceptor(){

        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
        localeInterceptor.setParamName("lang");
        return localeInterceptor;

     }

     
     @Override
     public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(localeChangeInterceptor());

     }


     @Bean(name = "messageSource")
     public MessageSource getMessageSource(){

      ReloadableResourceBundleMessageSource messageResource= new ReloadableResourceBundleMessageSource();

     
      messageResource.setBasenames("classpath:i18n/mesagges");
      messageResource.setDefaultEncoding("UTF-8");
      return messageResource;
     }



}
