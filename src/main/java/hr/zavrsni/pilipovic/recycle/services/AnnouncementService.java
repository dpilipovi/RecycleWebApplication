package hr.zavrsni.pilipovic.recycle.services;

import hr.zavrsni.pilipovic.recycle.entities.AnnouncementCommand;
import hr.zavrsni.pilipovic.recycle.entities.AnnouncementDTO;
import hr.zavrsni.pilipovic.recycle.entities.VehicleCommand;
import hr.zavrsni.pilipovic.recycle.entities.VehicleDTO;
import org.springframework.security.access.annotation.Secured;

import java.util.List;
import java.util.Optional;

public interface AnnouncementService {

    @Secured({"ROLE_ADMIN"})
    Optional<AnnouncementDTO> findById(long id);

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    List<AnnouncementDTO> findAll();

    @Secured({"ROLE_ADMIN"})
    Optional<AnnouncementDTO> save(AnnouncementCommand announcementCommand);

    @Secured({"ROLE_ADMIN"})
    void deleteById(long id);

    @Secured({"ROLE_ADMIN"})
    Optional<AnnouncementDTO> editAnnouncement(AnnouncementCommand announcementCommand);
}
