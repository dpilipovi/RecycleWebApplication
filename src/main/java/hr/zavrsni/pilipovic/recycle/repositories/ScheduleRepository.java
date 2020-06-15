package hr.zavrsni.pilipovic.recycle.repositories;

import java.util.List;

import hr.zavrsni.pilipovic.recycle.entities.Schedule;

import hr.zavrsni.pilipovic.recycle.entities.ScheduleCommand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ScheduleRepository extends JpaRepository<Schedule,Long>
{

	List<Schedule> findByAddress(String address);

	Schedule save(ScheduleCommand scheduleCommand);

	void deleteById(Long id);

}