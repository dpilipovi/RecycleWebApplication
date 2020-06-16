package hr.zavrsni.pilipovic.recycle.repositories;

import java.util.List;
import java.util.Optional;

import hr.zavrsni.pilipovic.recycle.entities.Schedule;

import hr.zavrsni.pilipovic.recycle.entities.ScheduleCommand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long>
{

	List<Schedule> findByAddress(String address);

	Schedule save(ScheduleCommand scheduleCommand);

	void deleteById(Long id);

	Optional<Schedule> findById(long id);

}