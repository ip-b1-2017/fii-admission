package com.ip_b1.fii.admission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MiddlewareApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiddlewareApplication.class, args);
    }

    @Bean
    EmbeddedServletContainerCustomizer containerCustomizer() throws Exception {
        return (ConfigurableEmbeddedServletContainer container) -> {

            if (container instanceof TomcatEmbeddedServletContainerFactory) {

                TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
                tomcat.addConnectorCustomizers(
                        (connector) -> {
                            connector.setMaxPostSize(10000000);//10MB
                        }
                );
            }
        };
    }
}
