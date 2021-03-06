package com.waylau.spring.boot.security.contrller;

// 导入工具包
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Hello World 控制器测试类
 * @author <a href="https://waylau.com">Way Lau</a> 
 * @date 2017年1月26日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
    @Test
    public void testList() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/users"))
    		.andExpect(status().isOk());
    }
    
    @Test
    public void testListWithUser() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/users").with(httpBasic("waylau","123456")));
    	mockMvc.perform(MockMvcRequestBuilders.get("/admins").with(httpBasic("waylau","123456")));
    }
}
