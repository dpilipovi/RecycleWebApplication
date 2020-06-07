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
        return Optional.of(mapToScheduleDTO(scheduleRepository.save(scheduleCommand)));
    }

    private ScheduleDTO mapToScheduleDTO(Schedule schedule)
    {
      ScheduleDTO scheduleDTO = new ScheduleDTO();

      scheduleDTO.setAddress(schedule.getAddress());
      scheduleDTO.setDay(schedule.getDay());
      scheduleDTO.setType(schedule.getType());

      return scheduleDTO;
    }
}
