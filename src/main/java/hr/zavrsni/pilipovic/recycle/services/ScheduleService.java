package hr.zavrsni.pilipovic.recycle.services;

import hr.zavrsni.pilipovic.recycle.entities.ScheduleCommand;
import hr.zavrsni.pilipovic.recycle.entities.ScheduleDTO;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {

    List<ScheduleDTO> findAll();

    Optional<ScheduleDTO> save(ScheduleCommand scheduleCommand);
}
