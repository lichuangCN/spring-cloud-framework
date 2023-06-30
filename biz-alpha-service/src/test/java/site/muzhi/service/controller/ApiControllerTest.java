package site.muzhi.service.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import site.muzhi.service.BizAlphaServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BizAlphaServiceApplication.class)
public class ApiControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void query() throws Exception {
        String url = "/user/query";
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON);
        ResultActions resultActions = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andReturn()
                .getResponse()
                .setCharacterEncoding("UTF-8");
        resultActions.andDo(MockMvcResultHandlers.print());
    }
}