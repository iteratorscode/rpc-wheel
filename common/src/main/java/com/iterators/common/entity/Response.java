package com.iterators.common.entity;

import lombok.Data;

/**
 * 响应
 *
 * @author zhanghui
 * @since  2021/8/10 下午5:02
 */
@Data
public class Response {

    private String requestId;

    private int code;

    private String error_msg;

    private Object data;
}
