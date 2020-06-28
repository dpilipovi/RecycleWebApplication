package hr.zavrsni.pilipovic.recycle.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.zavrsni.pilipovic.recycle.entities.ScheduleCommand;
import hr.zavrsni.pilipovic.recycle.entities.UserCommand;
import hr.zavrsni.pilipovic.recycle.services.UserService;
import hr.zavrsni.pilipovic.recycle.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;



    @Test
    void getCurrentUser() throws Exception {

        // OK
        this.mockMvc.perform(get("/api/user/current-user")
                .with(user("admin").password("pass").roles("ADMIN")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        // Bad token
        mockMvc.perform(
                get("/api/user/current-user")
                        .header("Authorization", "Bearer test-bearertoken123.123")
        )
                .andExpect(status().isUnauthorized());


        // Bad request
        mockMvc.perform(
                get("/api/user/current-user")
        )
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "admin", password = "pass", roles = {"ADMIN"})
    //@DirtiesContext
    void editUser() throws Exception{

        //OK

        UserCommand userCommand = new UserCommand(2,"pero","peric","pperic@email.com","Ilica","pperic", "pass");

        this.mockMvc.perform( MockMvcRequestBuilders
                .put("/api/user")
                .content(objectMapper.writeValueAsString(userCommand))
            .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
}

    @Test
        //@DirtiesContext
    void addUser() throws Exception {

        //CREATED

        UserCommand userCommand = new UserCommand("testime","testprezime","test@email.com","testadresa","test","testpass");

        this.mockMvc.perform( MockMvcRequestBuilders
                .post("/api/user")
                .content(objectMapper.writeValueAsString(userCommand))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @WithMockUser(username = "admin", password = "pass", roles = {"ADMIN"})
    //@DirtiesContext
    void delete() throws Exception {

        //NO CONTENT
        this.mockMvc.perform( MockMvcRequestBuilders.delete("/api/user/{id}", "admin"))
                .andExpect(status().isNoContent());


    }

    @Test
    @WithMockUser(username = "admin", password = "pass", roles = {"ADMIN"})
    //@DirtiesContext
    void deleteShouldReturnForbidden() throws Exception {

        //FORBIDDEN
        this.mockMvc.perform( MockMvcRequestBuilders.delete("/api/user/{id}", "admin")
                .with(user("pperic").password("pass").roles("USER")))
                .andExpect(status().isForbidden());
    }

    @Test
        //@WithMockUser(username = "admin", password = "pass", roles = {"ADMIN"})
    void findAll() {

        //OK

        try {
            this.mockMvc.perform(get("/api/user")
                    .with(user("admin").password("pass").roles("ADMIN")))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            fail();
        }


    }

    @Test
    void findAllShouldReturnForbidden() {
        try {
            this.mockMvc.perform(get("/api/user")
                    .with(user("pperic").password("pass").roles("USER")))
                    .andExpect(status().isForbidden());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    @WithMockUser(username = "admin", password = "pass", roles = {"ADMIN"})
    void findByUsername() throws Exception{

        //OK

        this.mockMvc.perform(get("/api/user/","pperic")
                .with(user("admin").password("pass").roles("ADMIN")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        //NOT FOUND

        this.mockMvc.perform(get("/api/user/","fakeuser")
                .with(user("admin").password("pass").roles("ADMIN")))
                .andExpect(status().isNotFound());

    }

    @Test
    @WithMockUser(username = "admin", password = "pass", roles = {"ADMIN"})
        //@DirtiesContext
    void makeAdmin() throws Exception {

        //OK

        this.mockMvc.perform(put("/api/user/makeAdmin/", "pperic"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        //NOT FOUND

        this.mockMvc.perform(put("/api/user/makeAdmin/", "fake"))
                .andExpect(status().isNotFound());


    }
}