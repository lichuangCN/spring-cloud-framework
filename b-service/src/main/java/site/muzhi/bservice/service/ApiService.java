package site.muzhi.bservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.muzhi.entity.User;
import site.muzhi.feignclient.AServiceFeignClient;
import site.muzhi.result.Result;

/**
 * @author lichuang
 * @date 2021/05/13
 * @description
 */
@Service
public class ApiService {

    @Autowired
    private AServiceFeignClient aServiceFeignClient;

    public User query() {
        Result<User> result = aServiceFeignClient.query();
        return result.getData();
    }
}
