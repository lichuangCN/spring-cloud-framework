package site.muzhi.exception;

/**
 * @author lichuang
 * @date 2021/05/10
 * @description 通用异常
 */
public class BusinessRuntimeException extends Exception {
    static final long serialVersionUID = 1L;

    private Integer errorCode = 500;
    private String errorMessage = "服务器内部错误";

    public BusinessRuntimeException(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BusinessRuntimeException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
