package com.iterators.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * RpcReference Processor
 *
 * @author iterators
 * @since 2021/10/12 下午12:41
 */
public class RpcReferenceAnnotationPostProcessor implements BeanFactoryPostProcessor, ApplicationContextAware {

    public static final String BEAN_NAME = "rpcReferenceAnnotationPostProcessor";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
