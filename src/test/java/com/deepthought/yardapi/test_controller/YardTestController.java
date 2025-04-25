package com.deepthought.yardapi.test_controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Request;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.deepthought.yardapi.model.Container;
import com.deepthought.yardapi.model.Slot;
import com.deepthought.yardapi.model.YardRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class YardTestController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testPickSpot_shouldReturnBestSlot() throws Exception {
        YardRequest request = new YardRequest(null, null);

        // Mock container
        Container container = new Container(null, null, false, 0, 0);
        container.setId("C1");
        container.setX(1);
        container.setY(1);
        container.setSize("SMALL");
        container.setNeedsCold(false);
        request.setContainer(container);

        // Mock yard slots
        List<Slot> yardMap = new ArrayList<>();
        yardMap.add(new Slot(1, 2, "SMALL", false, false));
        yardMap.add(new Slot(2, 2, "BIG", true, false));
        request.setSlot(yardMap);

        mockMvc.perform(post("/pickSpot")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.x").value(1))
                .andExpect(jsonPath("$.y").value(2));
    }
}

