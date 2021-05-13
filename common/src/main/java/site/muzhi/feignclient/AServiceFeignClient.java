package site.muzhi.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import site.muzhi.entity.User;
import site.muzhi.result.Result;

/**
 * @author lichuang
 * @date 2021/05/13
 * @description
 */
@FeignClient(name = "a-service")
public interface AServiceFeignClient {

    @GetMapping("/user/query")
    Result<User> query();
}
