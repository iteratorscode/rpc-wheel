package com.iterators.common.service.discovery;

import com.iterators.common.service.instance.ServiceInstance;

import java.util.List;

/**
 * 服务发现 Client
 *
 * @author iterators
 * @since  2021/8/10 下午7:52
 */
public interface DiscoveryClient {

    /**
     * A human-readable description of the implementation, used in HealthIndicator.
     * @return The description.
     */
    String description();

    /**
     * Gets all ServiceInstances associated with a particular serviceId.
     * @param serviceId The serviceId to query.
     * @return A List of ServiceInstance.
     */
    List<ServiceInstance> getInstances(String serviceId);

    /**
     * @return All known service IDs.
     */
    List<String> getServices();
}
