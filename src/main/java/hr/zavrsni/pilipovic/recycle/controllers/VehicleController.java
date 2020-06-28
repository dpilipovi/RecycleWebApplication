package hr.zavrsni.pilipovic.recycle.controllers;


import hr.zavrsni.pilipovic.recycle.entities.VehicleCommand;
import hr.zavrsni.pilipovic.recycle.entities.VehicleDTO;
import hr.zavrsni.pilipovic.recycle.services.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService)
    {
        this.vehicleService = vehicleService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<VehicleDTO> findAll()
    {
        return vehicleService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> findById(@PathVariable long id)
    {
        return vehicleService.findById(id)
                .map(
                        vehicle -> ResponseEntity
                                    .status(HttpStatus.OK)
                                    .body(vehicle))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .build()
                );
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> save(@Valid @RequestBody VehicleCommand vehicleCommand)
    {
        return vehicleService.save(vehicleCommand)
                .map(
                        vehicle -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(vehicle))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){

        vehicleService.deleteById(id);
    }

    @PutMapping
    public ResponseEntity<VehicleDTO> editVehicle(@Valid @RequestBody VehicleCommand vehicleCommand)
    {
        return vehicleService.editVehicle(vehicleCommand)
                .map(
                        vehicle -> ResponseEntity
                                .status(HttpStatus.OK)
                                .body(vehicle))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }

}
