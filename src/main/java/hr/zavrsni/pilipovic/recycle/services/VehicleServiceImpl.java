package hr.zavrsni.pilipovic.recycle.services;

import hr.zavrsni.pilipovic.recycle.entities.*;
import hr.zavrsni.pilipovic.recycle.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository)
    {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Optional<VehicleDTO> findById(long id) {
        return vehicleRepository.findById(id).map(this::mapToVehicleDTO);
    }

    @Override
    public List<VehicleDTO> findAll() {
        return vehicleRepository.findAll().stream().map(this::mapToVehicleDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<VehicleDTO> save(VehicleCommand vehicleCommand) {
        Vehicle vehicle = new Vehicle(vehicleCommand.getBrand(), vehicleCommand.getFirstRegistrationYear(),vehicleCommand.getLocation());

        return Optional.of(mapToVehicleDTO(vehicleRepository.save(vehicle)));
    }

    @Override
    public void deleteById(long id) {
        vehicleRepository.deleteById(id);
    }

    private VehicleDTO mapToVehicleDTO(final Vehicle vehicle)
    {
        VehicleDTO vehicleDTO = new VehicleDTO();

        vehicleDTO.setId(vehicle.getId());
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setFirstRegistrationYear(vehicle.getFirstRegistrationYear());

        return vehicleDTO;
    }
}
