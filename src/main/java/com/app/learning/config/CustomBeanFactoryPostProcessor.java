package com.app.learning.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    private static final Logger LOGGER = Logger.getLogger(CustomBeanFactoryPostProcessor.class.getName());

    @Override
    public void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition("com.app.learning.service.Helper").
                addConstructorArgValue(1).addConstructorArgValue("john").setScope("prototype").applyCustomizers(new InstanceCustomeizer());

        ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("helper", beanDefinitionBuilder.getBeanDefinition());
    }

    private static class InstanceCustomeizer implements BeanDefinitionCustomizer {
        @Override
        public void customize(final BeanDefinition bd) {
            LOGGER.log(Level.INFO, "Initializing bean with classname " + bd.getBeanClassName());
        }
    }

}
