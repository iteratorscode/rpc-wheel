package transport;

/**
 * RpcClient
 *
 * @author iterators
 * @since 2021/10/12 下午4:38
 */
public interface RpcClient {

    void open() throws Throwable;

    void close() throws Throwable;

    void connect() throws Throwable;

    void disConnect() throws Throwable;

}
