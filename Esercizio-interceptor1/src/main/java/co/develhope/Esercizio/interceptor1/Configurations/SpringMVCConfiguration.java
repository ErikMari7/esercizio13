package co.develhope.Esercizio.interceptor1.Configurations;

import co.develhope.Esercizio.interceptor1.Interceptors.APILoggingInterceptor;
import co.develhope.Esercizio.interceptor1.Interceptors.LegacyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMVCConfiguration implements WebMvcConfigurer {
    @Autowired
    private APILoggingInterceptor apiLoggingInterceptor;
    @Autowired
    private LegacyInterceptor legacyInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(apiLoggingInterceptor).addPathPatterns("/time/current");
        registry.addInterceptor(legacyInterceptor).addPathPatterns("/legacy/code");
    }
}
