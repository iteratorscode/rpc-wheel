package serialize.impl;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import serialize.Serializer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Protostuff
 *
 * @author iterators
 * @since 2021/8/10 下午3:42
 */
public class ProtostuffSerializerImpl implements Serializer {

    //避免每次序列化都重新申请Buffer空间
    private LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
    //缓存Schema
    private Map<Class<?>, Schema<?>> schemas = new ConcurrentHashMap<>();

    @Override
    @SuppressWarnings("unchecked")
    public <T> byte[] serialize(T obj) {
        Class<T> clazz = (Class<T>) obj.getClass();
        Schema<T> schema = getSchema(clazz);
        byte[] data;
        try {
            data = ProtostuffIOUtil.toByteArray(obj, schema, buffer);
        } finally {
            buffer.clear();
        }
        return data;
    }

    @SuppressWarnings("unchecked")
    private <T> Schema<T> getSchema(Class<T> clazz) {
        Schema<T> schema = (Schema<T>) schemas.get(clazz);
        if (schema == null) {
            schema = RuntimeSchema.getSchema(clazz);
            schemas.putIfAbsent(clazz, schema);
        }
        return schema;
    }

    @Override
    public <T> T deserialize(byte[] content, Class<T> clazz) {
        Schema<T> schema = getSchema(clazz);
        T obj = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(content, obj, schema);
        return obj;
    }
}
