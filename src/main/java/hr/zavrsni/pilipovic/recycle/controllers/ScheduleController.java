package hr.zavrsni.pilipovic.recycle.controllers;


import java.util.List;

import hr.zavrsni.pilipovic.recycle.entities.Schedule;
import hr.zavrsni.pilipovic.recycle.repositories.ScheduleRepository;

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

    @Autowired
    private ScheduleRepository repository ;
    

    @PostMapping
    public Schedule saveSchedule(@RequestBody Schedule schedule) {

      return repository.save(schedule);
        
    }
    
    /*@GetMapping("")
    public List<Schedule> getByAddress(@RequestParam String address)
    {
        return repository.findByAddress(address);
    }*/

    @GetMapping
    public List<Schedule> getSchedule()
    {
        return repository.findAll();
    }

}