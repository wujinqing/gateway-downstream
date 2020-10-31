package com.jin.gateway.downstream;

import lombok.Data;

/**
 * @author wu.jinqing
 * @date 2020年09月04日
 */
@Data
public class PersonCode {
    /**
     * 错误码
     */
    private String resultCode;

    /**
     * 错误信息
     */
    private String resultMsg;
}
