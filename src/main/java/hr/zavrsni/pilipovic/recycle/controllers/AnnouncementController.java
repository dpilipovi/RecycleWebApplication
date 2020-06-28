package hr.zavrsni.pilipovic.recycle.controllers;


import hr.zavrsni.pilipovic.recycle.entities.AnnouncementCommand;
import hr.zavrsni.pilipovic.recycle.entities.AnnouncementDTO;
import hr.zavrsni.pilipovic.recycle.services.AnnouncementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/announcement")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService)
    {
        this.announcementService = announcementService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<AnnouncementDTO> findAll()
    {
        return announcementService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementDTO> findById(@PathVariable long id)
    {
        return announcementService.findById(id)
                .map(
                        announcement -> ResponseEntity
                                .status(HttpStatus.OK)
                                .body(announcement))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .build()
                );
    }

    @PostMapping
    public ResponseEntity<AnnouncementDTO> save(@Valid @RequestBody AnnouncementCommand announcementCommand)
    {
        return announcementService.save(announcementCommand)
                .map(
                        announcement -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(announcement))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){

        announcementService.deleteById(id);
    }

    @PutMapping
    public ResponseEntity<AnnouncementDTO> editVehicle(@Valid @RequestBody AnnouncementCommand announcementCommand)
    {
        return announcementService.editAnnouncement(announcementCommand)
                .map(
                        announcement -> ResponseEntity
                                .status(HttpStatus.OK)
                                .body(announcement))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }
}
