package hr.zavrsni.pilipovic.recycle.repositories;

import hr.zavrsni.pilipovic.recycle.entities.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    List<Announcement> findAll();

    Optional<Announcement> findById(long id);

    Announcement save(Announcement announcement);

    void deleteById(long id);
}
