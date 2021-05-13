package site.muzhi.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author lichuang
 * @date 2021/05/13
 * @description
 */
@FeignClient(name = "b-service")
public interface BServiceFeignClient {

}
