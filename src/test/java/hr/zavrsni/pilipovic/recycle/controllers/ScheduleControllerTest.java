package hr.zavrsni.pilipovic.recycle.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hr.zavrsni.pilipovic.recycle.entities.ScheduleCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


@SpringBootTest
@AutoConfigureMockMvc
class ScheduleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void findAll() {
        try {
            this.mockMvc.perform(get("/api/schedule"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            fail();
        }
    }


    @Test
    @WithMockUser(username = "admin", password = "pass", roles = {"ADMIN"})
    void saveSchedule() {


        ScheduleCommand scheduleCommand = new ScheduleCommand("test", "Plastic", 1);

        try {
            this.mockMvc.perform(MockMvcRequestBuilders
                    .post("/api/schedule")
                    .content(objectMapper.writeValueAsString(scheduleCommand))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            fail();
        }

    }


    @Test
    @WithMockUser(username = "admin", password = "pass", roles = {"ADMIN"})
    void editSchedule() {


        ScheduleCommand scheduleCommand = new ScheduleCommand(1, "test", "Plastic", 1);

        try {

            this.mockMvc.perform(MockMvcRequestBuilders
                    .put("/api/schedule")
                    .content(objectMapper.writeValueAsString(scheduleCommand))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            fail();
        }

    }


    @Test
    @WithMockUser(username = "admin", password = "pass", roles = {"ADMIN"})
    void delete() {

        try {
            this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/schedule/{id}", 2))
                    .andExpect(status().isNoContent());
        } catch (Exception e) {
            fail();
        }

    }


    @Test
    @WithMockUser(username = "admin", password = "pass", roles = {"ADMIN"})
    void deleteExpectBadRequest() {

        try {
            this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/schedule/{id}", "fake"))
                    .andExpect(status().isBadRequest());

        } catch (Exception e) {
            fail();
        }

    }

}

