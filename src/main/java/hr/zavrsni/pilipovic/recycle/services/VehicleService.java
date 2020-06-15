package hr.zavrsni.pilipovic.recycle.services;

import hr.zavrsni.pilipovic.recycle.entities.Vehicle;
import hr.zavrsni.pilipovic.recycle.entities.VehicleCommand;
import hr.zavrsni.pilipovic.recycle.entities.VehicleDTO;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    Optional<VehicleDTO> findById(long id);

    List<VehicleDTO> findAll();

    Optional<VehicleDTO> save(VehicleCommand vehicleCommand);

    void deleteById(long id);
}
