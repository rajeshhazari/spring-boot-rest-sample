package com.rajesh.service.test.controller;

import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ApiControllerTest.class)
public class ApiControllerTest{


    @Autowired
    private MockMvc mockMvc;

    List<String> expectedList = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @Test
    public void main() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/home"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attribute("message", StringContains.containsString("C3Transcribe")));
                //.andExpect(model().attribute("tasks", (expectedList)));
                //.andExpect(content().string("Hello, Mkyong"));

        MvcResult mvcResult = resultActions.andReturn();
        ModelAndView mv = mvcResult.getModelAndView();
        //
    }

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
                /*.andExpect(content().string(
                        containsString("Welcome to...")));*/
    }
}