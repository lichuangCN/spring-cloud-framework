package site.muzhi.result;

import lombok.Data;

/**
 * @author lichuang
 * @date 2021/05/10
 * @description
 */
@Data
public class Result<T> {
    /**
     * 响应码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;

    protected Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    protected Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
