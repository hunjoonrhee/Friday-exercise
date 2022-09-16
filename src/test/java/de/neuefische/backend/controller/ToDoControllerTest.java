package de.neuefische.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ToDoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllToDos_Returns_AllToDosInRepo() throws Exception {

        // GIVEN
        String expectedJson= """
                [
                    {
                        "description": "Friday-Exercise",
                        "status": "OPEN",
                        "id": "1"
                    }
                ]
                
                """;

        // WHEN & THEN
        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));

    }

    @Test
    void getToDoById_Returns_ToDoForGivenId() throws Exception {

        // GIVEN
        String expectedJson= """
                
                {
                    "description": "Friday-Exercise",
                    "status": "OPEN",
                    "id": "1"
                }
                
                
                """;

        // WHEN & THEN
        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));

    }

    @Test
    void postNewToDo_Returns_AddedToDo() throws Exception{

        //GIVEN
        String requestBody = """
                    {
                        "description": "new to do",
                        "status": "OPEN",
                        "id": "2"
                    }
                """;

        String expectedResponseBody = """
                    {
                        "description": "new to do",
                        "status": "OPEN",
                        "id": "2"
                    }
                """;

        mockMvc.perform(
                        post("/api/todo")
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponseBody));
    }

}