package com.iterators.common.service.annotation;

/**
 * Rpc服务引用
 *
 * @author iterators
 * @since 2021/10/12 10:07 上午
 */
public @interface RpcReference {

    String serviceName() default "";
}
