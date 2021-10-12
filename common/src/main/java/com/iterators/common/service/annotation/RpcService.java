package service.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Rpc服务 注解
 *
 * @author iterators
 * @since  2021/8/10 下午6:53
 */
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RpcService {

    String serviceName() default "";
}
