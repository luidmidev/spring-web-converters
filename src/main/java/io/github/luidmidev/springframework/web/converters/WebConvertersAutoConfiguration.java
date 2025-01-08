package io.github.luidmidev.springframework.web.converters;

import io.github.luidmidev.springframework.web.converters.http.ArrayHttpMessageConverterDelegate;
import io.github.luidmidev.springframework.web.converters.http.CollectionHttpMessageConverter;
import io.github.luidmidev.springframework.web.converters.http.FromStringMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Slf4j
@AutoConfiguration
@ConditionalOnWebApplication
public class WebConvertersAutoConfiguration {

    @Configuration
    public static class WebConvertersConfig implements WebMvcConfigurer {

        @Override
        public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
            log.info("Registering http message converters");
            converters.add(new CollectionHttpMessageConverter());
            converters.add(new ArrayHttpMessageConverterDelegate());
            converters.add(new FromStringMessageConverter());
        }
    }
}
