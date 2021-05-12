package site.muzhi.exception;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * @author lichuang
 * @date 2021/05/12
 * @description
 */
public class CastException {
    private static final Log log = LogFactory.get();

    public static void cast(ExceptionCode code) throws BusinessRuntimeException {
        log.error("异常信息：" + code.getMessage());
        throw new BusinessRuntimeException(code.getCode(), code.getMessage());
    }
}
