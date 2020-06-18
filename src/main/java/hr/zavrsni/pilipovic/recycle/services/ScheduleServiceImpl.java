package hr.zavrsni.pilipovic.recycle.services;

import hr.zavrsni.pilipovic.recycle.entities.*;
import hr.zavrsni.pilipovic.recycle.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<ScheduleDTO> findAll() {
        return scheduleRepository.findAll().stream().map(this::mapToScheduleDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<ScheduleDTO> save(ScheduleCommand scheduleCommand) {

        Schedule schedule = new Schedule(scheduleCommand.getAddress(),scheduleCommand.getType(),scheduleCommand.getDay());
        return Optional.of(mapToScheduleDTO(scheduleRepository.save(schedule)));
    }

    @Override
    public void deleteById(long id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public Optional<ScheduleDTO> editSchedule(ScheduleCommand scheduleCommand) {

        Optional<Schedule> optional = scheduleRepository.findById(scheduleCommand.getId());

        Schedule schedule = optional.get();

        schedule.setAddress(scheduleCommand.getAddress());
        schedule.setDay(scheduleCommand.getDay());
        schedule.setType(scheduleCommand.getType());

        return Optional.of(mapToScheduleDTO(scheduleRepository.save(schedule)));

    }

    private ScheduleDTO mapToScheduleDTO(Schedule schedule)
    {
      ScheduleDTO scheduleDTO = new ScheduleDTO();

      scheduleDTO.setId(schedule.getId());
      scheduleDTO.setAddress(schedule.getAddress());
      scheduleDTO.setDay(schedule.getDay());
      scheduleDTO.setType(schedule.getType());

      return scheduleDTO;
    }
}
