package hr.zavrsni.pilipovic.recycle.services;

import hr.zavrsni.pilipovic.recycle.entities.*;
import hr.zavrsni.pilipovic.recycle.repositories.AnnouncementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository)
    {
        this.announcementRepository = announcementRepository;
    }


    @Override
    public Optional<AnnouncementDTO> findById(long id) {
        return announcementRepository.findById(id).map(this::mapToAnnouncementDTO);
    }

    @Override
    public List<AnnouncementDTO> findAll() {
        return announcementRepository.findAll().stream().map(this::mapToAnnouncementDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<AnnouncementDTO> save(AnnouncementCommand announcementCommand) {

        Announcement a = new Announcement(announcementCommand.getMessage(),announcementCommand.getTitle());

        return Optional.of(mapToAnnouncementDTO(announcementRepository.save(a)));
    }

    @Override
    public void deleteById(long id) {
        announcementRepository.deleteById(id);
    }

    @Override
    public Optional<AnnouncementDTO> editAnnouncement(AnnouncementCommand announcementCommand) {

        Optional<Announcement> optional = announcementRepository.findById(announcementCommand.getId());

        Announcement announcement = optional.get();

        announcement.setId(announcementCommand.getId());
        announcement.setTitle(announcementCommand.getTitle());
        announcement.setMessage(announcementCommand.getMessage());


        return Optional.of(mapToAnnouncementDTO(announcementRepository.save(announcement)));
    }

    private AnnouncementDTO mapToAnnouncementDTO(final Announcement announcement)
    {
        AnnouncementDTO announcementDTO = new AnnouncementDTO();

        announcementDTO.setId(announcement.getId());
        announcementDTO.setTitle(announcement.getTitle());
        announcementDTO.setMessage(announcement.getMessage());
        announcementDTO.setCreated(announcement.getCreated());
        if(announcement.getUpdated() != null) announcementDTO.setUpdated(announcement.getUpdated());

        return announcementDTO;
    }
}
