package com.iterators.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * RpcServer 启动器
 *
 * @author iterators
 * @since 2021/10/12 上午11:50
 */
@Import(value = {RpcConfigurationRegistrar.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface EnableRpcConfig {
}
