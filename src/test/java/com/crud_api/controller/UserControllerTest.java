package com.crud_api.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.crud_api.controller.UserController;
import com.crud_api.model.User;
import com.crud_api.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
public class UserControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;
    
    @Autowired
    private ObjectMapper objectMapper;
    
	@Test
	public void getAllUsers() throws Exception {
		User user = new User();
        user.setId(1);
        user.setFirstname("Praveen");
        user.setLastname("Gowda");
        user.setEmail("praveen.v@practo.com");
        user.setPhone(9876543210L);

        List<User> users = Arrays.asList(user);
        given(userService.getAll()).willReturn(users);

        // when + then
        this.mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 1,'firstname': 'Praveen','lastname': 'Gowda','email': 'praveen.v@practo.com','phone': 9876543210}]"));
	}
	
	@Test
	public void getUser() throws Exception {
		User user = new User();
        user.setId(1);
        user.setFirstname("Praveen");
        user.setLastname("Gowda");
        user.setEmail("praveen.v@practo.com");
        user.setPhone(9876543210L);

        given(userService.get(1)).willReturn(user);

        // when + then
        this.mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': 1,'firstname': 'Praveen','lastname': 'Gowda','email': 'praveen.v@practo.com','phone': 9876543210}"));
	}
	@Test
	public void addUser() throws Exception {
		User user = new User();
        user.setId(1);
        user.setFirstname("Praveen");
        user.setLastname("Gowda");
        user.setEmail("praveen.v@practo.com");
        user.setPhone(9876543210L);
        
        given(userService.create(user)).willReturn(ResponseEntity.ok("User data is valid"));
        
        this.mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(objectMapper.writeValueAsString(user)))
        	.andExpect(status().isOk());
	}
	@Test
	public void updateUser() throws Exception {
		User user = new User();
        user.setId(1);
        user.setFirstname("Praveen");
        user.setLastname("Gowda");
        user.setEmail("praveen.v@practo.com");
        user.setPhone(9876543210L);
        
        given(userService.update(1,user)).willReturn(ResponseEntity.ok(""));
        
        this.mockMvc.perform(put("/users/1").contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(objectMapper.writeValueAsString(user)))
        	.andExpect(status().isOk());
	}
	@Test
	public void deleteUser() throws Exception {
		User user = new User();
        user.setId(1);
        user.setFirstname("Praveen");
        user.setLastname("Gowda");
        user.setEmail("praveen.v@practo.com");
        user.setPhone(9876543210L);
        
        doNothing().when(userService).delete(1);
        
        this.mockMvc.perform(delete("/users/1"))
        	.andExpect(status().isOk());
	}
}
