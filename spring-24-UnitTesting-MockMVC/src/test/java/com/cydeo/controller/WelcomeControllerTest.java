package com.cydeo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(WelcomeController.class)
public class WelcomeControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    void welcome_Test() throws Exception {

    // call /welcome endpoint
        RequestBuilder request = MockMvcRequestBuilders
                .get("/welcome")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(request).andReturn();

    // verify response is "welcome"
        assertEquals(200, result.getResponse().getStatus());
        // ^^ checking if status equals the expected 200
        assertEquals("welcome", result.getResponse().getContentAsString());

    }


}
