package ie.damien.Internationilization;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class ConfigLang implements WebMvcConfigurer  {
	
	@Bean
	public CookieLocaleResolver localeResolver() {
		
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setDefaultLocale(Locale.UK);
		
		return localeResolver;
		
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry intRegistry) {
		
		intRegistry.addInterceptor(localChangeInterceptor());
		
		
	}
	
	@Bean
	public LocaleChangeInterceptor localChangeInterceptor() {
		
		LocaleChangeInterceptor lChangeInter = new LocaleChangeInterceptor();
		lChangeInter.setParamName("lang");
		
		return lChangeInter;
		
		
		
	}
	
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource
	      = new ReloadableResourceBundleMessageSource();
	     
	    messageSource.setBasename("classpath:messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
	
	
	@Bean
	public LocalValidatorFactoryBean getValidator() {
	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	    bean.setValidationMessageSource(messageSource());
	    return bean;
	}

}
