package com.iterators.common.manager;

import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Service Manager
 *
 * @author iterators
 * @since 2021/10/12 下午3:22
 */
public class ServiceManager {

    private static final ConcurrentHashMap<String, Object> MAPS = new ConcurrentHashMap<>(16);

    public static <T> T getService(Class<T> clazz) {
        String name = clazz.getName();
        if (MAPS.containsKey(name)) {
            return (T) MAPS.get(name);
        }

        ServiceLoader<?> loader = ServiceLoader.load(clazz);
        loader.forEach(next -> {
            MAPS.put(name, next);
        });
        return (T) MAPS.get(name);
    }
}
