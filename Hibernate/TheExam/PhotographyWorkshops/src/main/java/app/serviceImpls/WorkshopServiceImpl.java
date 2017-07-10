package app.serviceImpls;

import app.domains.dtos.xmls.inputs.ParticipantDto;
import app.domains.dtos.xmls.inputs.WorkshopDto;
import app.domains.entities.Photographer;
import app.domains.entities.Workshop;
import app.parsers.interfaces.ModelParser;
import app.repositories.PhotographerRepository;
import app.repositories.WorkshopRepository;
import app.services.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class WorkshopServiceImpl implements WorkshopService {

    private final ModelParser modelParser;

    private final WorkshopRepository workshopRepository;

    private final PhotographerRepository photographerRepository;

    @Autowired
    public WorkshopServiceImpl(ModelParser modelParser, WorkshopRepository workshopRepository, PhotographerRepository photographerRepository) {
        this.modelParser = modelParser;
        this.workshopRepository = workshopRepository;
        this.photographerRepository = photographerRepository;
    }

    @Override
    public void create(WorkshopDto workshopDto) {
        Workshop workshop = this.modelParser.convert(workshopDto, Workshop.class);

        String[] trainerTokens = workshopDto.getTrainer().split("\\s+");
        String trainerFirstName = trainerTokens[0];
        String trainerLastName = trainerTokens[1];

        if (workshopDto.getName().equals("Winter in Yellowstone Photography Expedition")) {
            System.out.println();
        }

        Photographer trainer =
                this.photographerRepository.findOneByFirstNameAndLastName(trainerFirstName, trainerLastName);
        workshop.setTrainer(trainer);

        Set<ParticipantDto> participantDtos = workshopDto.getParticipantDtos();
        for (ParticipantDto participantDto : participantDtos) {
            String firstName = participantDto.getFirstName();
            String lastName = participantDto.getLastName();
            Photographer participant =
                    this.photographerRepository.findOneByFirstNameAndLastName(firstName, lastName);
            workshop.getParticipants().add(participant);
        }

        this.workshopRepository.saveAndFlush(workshop);
    }
}
