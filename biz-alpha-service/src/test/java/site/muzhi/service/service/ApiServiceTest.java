package site.muzhi.service.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import site.muzhi.entity.User;

@RunWith(MockitoJUnitRunner.class)
public class ApiServiceTest {

    @InjectMocks
    ApiService apiService;

    @Test
    public void query() {
        // mock结果
        User user = apiService.query();

        Assert.assertNotNull(user);
        Assert.assertEquals("查询结果错误", user.getName(), "Jack");
    }
}