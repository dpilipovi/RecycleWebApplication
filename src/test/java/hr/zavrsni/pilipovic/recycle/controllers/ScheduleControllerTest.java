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
    void findAll() throws Exception {
        this.mockMvc.perform(get("/api/schedule"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }


    @Test
    @WithMockUser(username = "admin", password = "pass", roles = {"ADMIN"})
    //@DirtiesContext
    void saveSchedule() throws Exception {

        //CREATED

        ScheduleCommand scheduleCommand = new ScheduleCommand("test", "Plastic",1);

        this.mockMvc.perform( MockMvcRequestBuilders
                .post("/api/schedule")
                .content(objectMapper.writeValueAsString(scheduleCommand))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

       /* //EXPECTATION FAILED

        ScheduleCommand scheduleCommand2 = new ScheduleCommand(1,"test", "Plastic",1);

        this.mockMvc.perform( MockMvcRequestBuilders
                .post("/api/schedule")
                .content(objectMapper.writeValueAsString(scheduleCommand2))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isExpectationFailed());

        */
    }


    @Test
    @WithMockUser(username = "admin", password = "pass", roles = {"ADMIN"})
    //@DirtiesContext
    void editSchedule() throws Exception{

        //OK

        ScheduleCommand scheduleCommand = new ScheduleCommand(1,"test", "Plastic",1);

        this.mockMvc.perform( MockMvcRequestBuilders
                .put("/api/schedule")
                .content(objectMapper.writeValueAsString(scheduleCommand))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));


     /*   //NOT FOUND

        ScheduleCommand scheduleCommand2 = new ScheduleCommand(17718317,"test", "Plastic",1);

        this.mockMvc.perform( MockMvcRequestBuilders
                .put("/api/schedule")
                .content(objectMapper.writeValueAsString(scheduleCommand2))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

      */
    }


    @Test
    @WithMockUser(username = "admin", password = "pass", roles = {"ADMIN"})
    //@DirtiesContext
    void delete() throws Exception {

        //NO CONTENT
        this.mockMvc.perform( MockMvcRequestBuilders.delete("/api/schedule/{id}", 2))
                .andExpect(status().isNoContent());

        //BAD REQUEST
        this.mockMvc.perform( MockMvcRequestBuilders.delete("/api/schedule/{id}", "fake"))
                .andExpect(status().isBadRequest());
    }
}