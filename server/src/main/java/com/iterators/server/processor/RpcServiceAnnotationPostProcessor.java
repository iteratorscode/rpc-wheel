package com.iterators.server.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * RpcService Register
 *
 * @author iterators
 * @since 2021/10/12 下午12:27
 */
public class RpcServiceAnnotationPostProcessor implements BeanDefinitionRegistryPostProcessor {

    public static final String BEAN_NAME = "rpcServiceAnnotationPostProcessor";


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
