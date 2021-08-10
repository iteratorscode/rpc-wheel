package service.instance;

import java.net.URI;
import java.util.Map;

/**
 * 服务实例
 *
 * @author iterators
 * @since 2021/8/10 下午7:26
 */
public interface ServiceInstance {

    /**
     * @return The unique instance ID as registered.
     */
    default String getInstanceId() {
        return null;
    }

    /**
     * @return The service ID as registered.
     */
    String getServiceId();

    /**
     * @return The hostname of the registered service instance.
     */
    String getHost();

    /**
     * @return The port of the registered service instance.
     */
    int getPort();

    /**
     * @return Whether the port of the registered service instance uses HTTPS.
     */
    boolean isSecure();

    /**
     * @return The service URI address.
     */
    URI getUri();

    /**
     * @return The key / value pair metadata associated with the service instance.
     */
    Map<String, String> getMetadata();
}
