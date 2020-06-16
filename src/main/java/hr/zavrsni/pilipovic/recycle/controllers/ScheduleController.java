package hr.zavrsni.pilipovic.recycle.controllers;


import java.util.List;

import hr.zavrsni.pilipovic.recycle.entities.Schedule;
import hr.zavrsni.pilipovic.recycle.entities.ScheduleCommand;
import hr.zavrsni.pilipovic.recycle.entities.ScheduleDTO;

import hr.zavrsni.pilipovic.recycle.services.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/schedule")
public class ScheduleController
{

    private ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService)
    {
        this.scheduleService = scheduleService;
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<ScheduleDTO> saveSchedule(@Valid @RequestBody ScheduleCommand scheduleCommand) {

      return scheduleService.save(scheduleCommand).map(
              schedule -> ResponseEntity
                      .status(HttpStatus.CREATED)
                      .body(schedule))
              .orElseGet(
                      () -> ResponseEntity
                              .status(HttpStatus.EXPECTATION_FAILED)
                              .build()
              );
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ScheduleDTO> findAll()
    {
        return scheduleService.findAll();
    }

    @Secured({"ROLE_ADMIN"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){

        scheduleService.deleteById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping
    public ResponseEntity<ScheduleDTO> editSchedule(@Valid @RequestBody ScheduleCommand scheduleCommand)
    {
        return scheduleService.editSchedule(scheduleCommand).map(
                schedule -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(schedule))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .build()
                );
    }

}