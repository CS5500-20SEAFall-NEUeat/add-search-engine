package com.cs5500.NEUEat.controller;

import static org.junit.Assert.*;

import com.cs5500.NEUEat.model.Restaurant;
import com.cs5500.NEUEat.repository.DriverRepository;
import java.sql.SQLOutput;
import net.minidev.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import com.alibaba.fastjson.JSON;
import com.cs5500.NEUEat.NeuEatApplication;
import com.cs5500.NEUEat.model.Driver;
import com.cs5500.NEUEat.model.User;
import com.cs5500.NEUEat.repository.RestaurantRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NeuEatApplication.class)
@WebAppConfiguration
public class DriverControllerTest extends AbstractTestNGSpringContextTests {
  Driver d;

  @Autowired
  DriverRepository driverRepository;

  @Autowired
  private WebApplicationContext webApplicationContext;
  private MockMvc mockMvc;

  @Test
  public void getDriverById() throws Exception {
    d = driverRepository.findAll().get(0);
    String id = d.getId();
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    String responseString = mockMvc.perform(MockMvcRequestBuilders.get("/api/driver/" + id)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn().getResponse().getContentAsString();
    System.out.println(responseString);
  }

  @Test
  public void loginDriver() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    User testUser = new User();
    testUser.setUserName("tma");
    testUser.setPassword("123456");
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/driver/login")
        .contentType(MediaType.APPLICATION_JSON)
        .content(JSON.toJSONString(testUser)))
        .andReturn();
    System.out.println(result.getResponse().getContentAsString());
  }

  @Test
  public void registerDriver() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    User testUser = new User();
    testUser.setUserName("tma");
    testUser.setPassword("123456");
    testUser.setPhoneNumber("123456789");
    testUser.setAddress("987654321");
    testUser.setCity("Seattle");
    testUser.setState("WA");
    testUser.setZip("98121");
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/driver/register")
        .contentType(MediaType.APPLICATION_JSON)
        .content(JSON.toJSONString(testUser))
    ).andReturn();
    System.out.println(result.getResponse().getContentAsString());
  }

  @Test
  public void logoutDriver() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/driver/logout")
        .contentType(MediaType.APPLICATION_JSON)
    ).andReturn();
    System.out.println(result.getResponse().getContentAsString());
  }

  @Test
  public void getPendingOrders() {
  }

  @Test
  public void getActiveOrder() {
  }

  @Test
  public void getOrderHistory() {
  }

  @Test
  public void acceptOrder() {
  }

  @Test
  public void finishOrder() {
  }

  @Test
  public void deleterDriver() {
  }

  @Test
  public void resetPassword() {
  }

  @Test
  public void resetPhoneNumber() {
  }

  @Test
  public void resetAddress() {
  }

  @Test
  public void handleException() {
  }
}