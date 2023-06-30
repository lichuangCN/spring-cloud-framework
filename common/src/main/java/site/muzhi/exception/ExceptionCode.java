package site.muzhi.exception;

import lombok.Getter;

/**
 * @author lichuang
 * @date 2021/05/12
 * @description
 */
@Getter
public enum ExceptionCode {

    SERVICE_ERROR("50000", "服务内部错误"),
    ;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 响应码
     */
    private String code;
    /**
     * 响应信息
     */
    private String message;
}
