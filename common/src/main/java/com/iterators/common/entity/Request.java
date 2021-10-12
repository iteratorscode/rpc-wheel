package com.iterators.common.entity;

import lombok.Data;

/**
 * 请求
 *
 * @author iterators
 * @since  2021/8/10 下午5:02
 */
@Data
public class Request {

    private Long id;

    private String className;

    private String methodName;

    private Class<?>[] parameterTypes;

    private Object[] parameters;

}
