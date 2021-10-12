package service.registry;

/**
 * 服务注册
 *
 * @author iterators
 * @since  2021/8/10 下午7:32
 */
public interface ServiceRegistry<R extends Registration> {

    /**
     * Registers the registration. A registration typically has information about an
     * instance, such as its hostname and port.
     * @param registration registration meta data
     */
    void register(R registration);

    /**
     * Deregisters the registration.
     * @param registration registration meta data
     */
    void deregister(R registration);
}
