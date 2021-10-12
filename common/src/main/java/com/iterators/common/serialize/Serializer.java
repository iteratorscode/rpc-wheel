package com.iterators.common.serialize;

/**
 * 序列化
 *
 * @author iterators
 * @since 2021/8/10 下午3:33
 */
public interface Serializer {

    <T> byte[]  serialize(T obj);

    <T> T deserialize(byte[] content, Class<T> clazz);
}
