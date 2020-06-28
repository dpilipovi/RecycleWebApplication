package hr.zavrsni.pilipovic.recycle.services;

import hr.zavrsni.pilipovic.recycle.entities.ScheduleCommand;
import hr.zavrsni.pilipovic.recycle.entities.ScheduleDTO;
import org.springframework.security.access.annotation.Secured;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {

    List<ScheduleDTO> findAll();

    @Secured({"ROLE_ADMIN"})
    Optional<ScheduleDTO> save(ScheduleCommand scheduleCommand);

    @Secured({"ROLE_ADMIN"})
    void deleteById(long id);

    @Secured({"ROLE_ADMIN"})
    Optional<ScheduleDTO> editSchedule(ScheduleCommand scheduleCommand);
}
