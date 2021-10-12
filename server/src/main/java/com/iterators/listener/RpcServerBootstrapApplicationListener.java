package com.iterators.listener;

import com.iterators.common.manager.ServiceManager;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import com.iterators.common.transport.RpcServer;

import java.util.Objects;

/**
 * Rpc Server启动类
 *
 * @implNote 通过Enable启动
 * @author iterators
 * @since 2021/10/12 上午11:41
 */
public class RpcServerBootstrapApplicationListener implements ApplicationListener<ApplicationEvent>, ApplicationContextAware {

    public static final String BEAN_NAME = "rpcServerBootstrapApplicationListener";

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
            startRpcServer();
        }

        if (event instanceof ContextClosedEvent) {
            closeRpcServer();
        }
    }

    private void startRpcServer() {
        RpcServer rpcServer = getRpcServer();
        if (Objects.nonNull(rpcServer)) {
            rpcServer.start();
        }
    }


    private void closeRpcServer() {
        RpcServer rpcServer = getRpcServer();
        if (Objects.nonNull(rpcServer)) {
            rpcServer.stop();
        }
    }


    private RpcServer getRpcServer() {
        return ServiceManager.getService(RpcServer.class);
    }

}
