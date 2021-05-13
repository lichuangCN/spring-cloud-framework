package site.muzhi.aservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.muzhi.entity.User;

import java.util.Date;

/**
 * @author lichuang
 * @date 2021/05/13
 * @description
 */
@Slf4j
@Service
public class ApiService {

    public User query() {
        User user = new User("Jack", 23, new Date());
        return user;
    }
}
