package com.realdolmen.fleet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import java.util.Collections;

@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration {
    @Bean
    public MvcViewFactoryCreator mvcViewFactoryCreator(ThymeleafViewResolver viewResolver) {
        MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
        factoryCreator.setViewResolvers(Collections.<ViewResolver>singletonList(viewResolver));
        factoryCreator.setUseSpringBeanBinding(true);
        return factoryCreator;
    }

    @Bean
    public FlowBuilderServices flowBuilderServices(MvcViewFactoryCreator mvcViewFactoryCreator) {
        return getFlowBuilderServicesBuilder().setViewFactoryCreator(mvcViewFactoryCreator).build();
    }

    @Bean
    public FlowExecutor flowExecutor(FlowDefinitionRegistry flowDefinitionRegistry) {
        return getFlowExecutorBuilder(flowDefinitionRegistry).build();
    }

    @Bean
    public FlowDefinitionRegistry flowRegistry(FlowBuilderServices flowBuilderServices) {
        return getFlowDefinitionRegistryBuilder(flowBuilderServices)
                .setBasePath("classpath:flows")
                .addFlowLocationPattern("/**/*-flow.xml")
                .build();
    }
}
