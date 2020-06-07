package hr.zavrsni.pilipovic.recycle.controllers;


import java.util.List;

import hr.zavrsni.pilipovic.recycle.entities.Schedule;
import hr.zavrsni.pilipovic.recycle.entities.ScheduleCommand;
import hr.zavrsni.pilipovic.recycle.entities.ScheduleDTO;

import hr.zavrsni.pilipovic.recycle.services.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



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
    

    @PostMapping
    public ResponseEntity<ScheduleDTO> saveSchedule(@RequestBody ScheduleCommand scheduleCommand) {

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
    
    /*@GetMapping("")
    public List<Schedule> getByAddress(@RequestParam String address)
    {
        return repository.findByAddress(address);
    }*/

    @GetMapping
    public List<ScheduleDTO> getSchedule()
    {
        return scheduleService.findAll();
    }

}