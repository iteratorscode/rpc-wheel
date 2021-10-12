package service.loadbalancer;

import service.instance.ServiceInstance;

/**
 * 服务选择器
 *
 * @author iterators
 * @since 2021/8/10 下午8:01
 */
public interface ServiceInstanceChooser {

    ServiceInstance choose(String serviceId);
}
