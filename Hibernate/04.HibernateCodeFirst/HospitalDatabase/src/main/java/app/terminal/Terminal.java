package app.terminal;

import app.entities.*;
import app.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;

@Component
public class Terminal implements CommandLineRunner {

    private final CommentService commentService;

    private final DiagnoseService diagnoseService;

    private final MedicamentService medicamentService;

    private final PatientService patientService;

    private final VisitationService visitationService;

    @Autowired
    public Terminal(CommentService commentService, DiagnoseService diagnoseService, MedicamentService medicamentService, PatientService patientService, VisitationService visitationService) {
        this.commentService = commentService;
        this.diagnoseService = diagnoseService;
        this.medicamentService = medicamentService;
        this.patientService = patientService;
        this.visitationService = visitationService;
    }

    @Override
    public void run(String... strings) throws Exception {

        Patient patient = new Patient();
        patient.setFirstName("John");
        patient.setLastName("Smith");
        patient.setAddress("Sofia");
        patient.setEmail("john@em.com");
        patient.setHasMedicalInsurance(true);
        patient.setDateOfBirth(new Date());
        this.patientService.persist(patient);

        Visitation visitation = new Visitation();
        visitation.setDate(new Date());
        visitation.setPatient(patient);
        this.visitationService.persist(visitation);

        Diagnose diagnose = new Diagnose();
        diagnose.setName("Hrema");
        diagnose.setPatient(patient);
        this.diagnoseService.persist(diagnose);

        Comment comment = new Comment();
        comment.setText("Cool comment");
        comment.setVisitation(visitation);
        this.commentService.persist(comment);

        Medicament medicament = new Medicament();
        medicament.setName("Aspirin");
        medicament.setPatients(new HashSet<>());
        medicament.getPatients().add(patient);
        this.medicamentService.persist(medicament);
    }
}
