package site.muzhi.exception;

import lombok.Getter;

/**
 * @author lichuang
 * @date 2021/05/12
 * @description
 */
@Getter
public enum ExceptionCode {

    PARAMETER_ERROR("x00001", "参数错误"),
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
