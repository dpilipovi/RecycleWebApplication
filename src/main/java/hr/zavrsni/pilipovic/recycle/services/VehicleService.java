package hr.zavrsni.pilipovic.recycle.services;

import hr.zavrsni.pilipovic.recycle.entities.Vehicle;
import hr.zavrsni.pilipovic.recycle.entities.VehicleCommand;
import hr.zavrsni.pilipovic.recycle.entities.VehicleDTO;
import org.springframework.security.access.annotation.Secured;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    @Secured({"ROLE_ADMIN"})
    Optional<VehicleDTO> findById(long id);

    @Secured({"ROLE_ADMIN"})
    List<VehicleDTO> findAll();

    @Secured({"ROLE_ADMIN"})
    Optional<VehicleDTO> save(VehicleCommand vehicleCommand);

    @Secured({"ROLE_ADMIN"})
    void deleteById(long id);

    @Secured({"ROLE_ADMIN"})
    Optional<VehicleDTO> editVehicle(VehicleCommand vehicleCommand);
}
