package com.iterators.annotation;

import com.iterators.listener.RpcServerBootstrapApplicationListener;
import com.iterators.processor.RpcReferenceAnnotationPostProcessor;
import com.iterators.processor.RpcServiceAnnotationPostProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Rpc Configuration register
 *
 * @author iterators
 * @since 2021/10/12 下午12:47
 */
@Slf4j
public class RpcConfigurationRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        registerCommonBeans(registry);
    }

    private void registerCommonBeans(BeanDefinitionRegistry registry) {
        // Register RpcServerBootstrapApplicationListener as an infrastructure Bean
        registerInfrastructureBean(registry, RpcServerBootstrapApplicationListener.BEAN_NAME, RpcServerBootstrapApplicationListener.class);
        registerInfrastructureBean(registry, RpcServiceAnnotationPostProcessor.BEAN_NAME, RpcServiceAnnotationPostProcessor.class);
        registerInfrastructureBean(registry, RpcReferenceAnnotationPostProcessor.BEAN_NAME, RpcReferenceAnnotationPostProcessor.class);
    }

    private boolean registerInfrastructureBean(BeanDefinitionRegistry registry, String beanName, Class<?> beanType) {
        boolean registered = false;
        if (!registry.containsBeanDefinition(beanName)) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
            beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
            registry.registerBeanDefinition(beanName, beanDefinition);
            registered = true;

            if (log.isDebugEnabled()) {
                log.debug("The Infrastructure bean definition [" + beanDefinition
                    + "with name [" + beanName + "] has been registered.");
            }
        }
        return registered;
    }
}
