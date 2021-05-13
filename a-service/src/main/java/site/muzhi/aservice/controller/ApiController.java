package site.muzhi.aservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.muzhi.aservice.service.ApiService;
import site.muzhi.entity.User;
import site.muzhi.result.Result;
import site.muzhi.result.ResultFactory;

/**
 * @author lichuang
 * @date 2021/05/13
 * @description
 */
@RestController()
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/user/query")
    public Result<User> query() {
        return ResultFactory.ok(apiService.query());
    }
}
