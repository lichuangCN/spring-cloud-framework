package site.muzhi.result;

import lombok.Getter;

/**
 * @author lichuang
 * @date 2021/05/10
 * @description
 */
@Getter
public enum ResultCode {
    SUCCESS(200, "请求成功"),
    FAIL(500, "请求失败"),
    ;
    /**
     * 响应码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
