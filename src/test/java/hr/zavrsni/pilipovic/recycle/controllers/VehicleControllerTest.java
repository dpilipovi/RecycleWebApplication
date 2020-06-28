package hr.zavrsni.pilipovic.recycle.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.zavrsni.pilipovic.recycle.entities.UserCommand;
import hr.zavrsni.pilipovic.recycle.entities.VehicleCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class VehicleControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @WithMockUser(username = "admin", password = "pass", roles = {"ADMIN"})
    void findAll() {

        try {
            this.mockMvc.perform(get("/api/vehicle"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    @WithMockUser(username = "admin", password = "pass", roles = {"ADMIN"})
    void findById() {

        try {
            this.mockMvc.perform(get("/api/vehicle/", 1))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    @WithMockUser(username = "admin", password = "pass", roles = {"ADMIN"})
    void save() {


        VehicleCommand vehicleCommand = new VehicleCommand("test", 2020);

        try {
            this.mockMvc.perform(MockMvcRequestBuilders
                    .post("/api/vehicle")
                    .content(objectMapper.writeValueAsString(vehicleCommand))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        }catch (Exception e)
        {
            fail();
        }
    }

    @Test
    @WithMockUser(username = "admin", password = "pass", roles = {"ADMIN"})
    void delete() {

        try {
            this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/vehicle/{id}", 1))
                    .andExpect(status().isNoContent());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    @WithMockUser(username = "admin", password = "pass", roles = {"ADMIN"})
    void editVehicle() {


        VehicleCommand vehicleCommand = new VehicleCommand(1,"test", 2020);

        try {
            this.mockMvc.perform(MockMvcRequestBuilders
                    .put("/api/vehicle")
                    .content(objectMapper.writeValueAsString(vehicleCommand))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        }catch (Exception e)
        {
            fail();
        }
    }
}