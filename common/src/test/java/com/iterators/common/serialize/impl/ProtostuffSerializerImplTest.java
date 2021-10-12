package com.iterators.common.serialize.impl;

import com.iterators.common.entity.Request;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ProtostuffSerializerImplTest {

    @Test
    void serialize() {
        ProtostuffSerializerImpl serializer = new ProtostuffSerializerImpl();
        Request request = new Request();
        request.setId(1L);
        byte[] contents = serializer.serialize(request);
        System.out.println("contents = " + Arrays.toString(contents));
    }

    @Test
    void deserialize() {
        ProtostuffSerializerImpl serializer = new ProtostuffSerializerImpl();
        byte[] contents = {8, 1};
        Request request = serializer.deserialize(contents, Request.class);
        System.out.println("request = " + request);
    }
}