package connexion.ui;

import java.util.Comparator;
import java.util.logging.Logger;

import connexion.commons.core.LogsCenter;
import connexion.model.person.Person;
import connexion.model.tag.Tag;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;



/**
 * Panel containing the list of persons.
 */
public class PersonViewPanel extends UiPart<Region> {
    private static final String FXML = "PersonViewPanel.fxml";

    public final Person person;

    private final Logger logger = LogsCenter.getLogger(PersonViewPanel.class);

    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label company;
    @FXML
    private Label job;
    @FXML
    private Label email;
    @FXML
    private Label markStatus;
    @FXML
    private FlowPane tags;
    @FXML
    private Label lastModifiedDateTime;

    @FXML
    private Label noteHeader;
    @FXML
    private Label note;

    @FXML
    private Label scheduleHeader;

    @FXML
    private Label schedule;

    /**
     * Creates a {@code PersonViewPanel} with the given {@code Person} and index to display.
     */
    public PersonViewPanel(Person person) {
        super(FXML);
        this.person = person;
        name.setText(person.getName().getDetailString());
        phone.setText(person.getPhone().getDetailString());
        company.setText(person.getCompany().getDetailString());
        job.setText(person.getJob().getDetailString());
        email.setText(person.getEmail().getDetailString());
        markStatus.setText(person.getMarkStatus().toString());
        person.getTags().stream()
                .sorted(Comparator.comparing(Tag::getValue));
        //schedule.setText(person.getSchedule().getDetailString());
        schedule.setText("Upcoming Meeting: 10 Oct (in 1 year)");
        //note.setText(person.getNote.getDetailString());
        note.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam volutpat, quam ac vehicula.");
    }

    /**
     * Constructor for PersonViewPanel
     * */
    public PersonViewPanel() {
        super(FXML);
        this.person = null;
        this.noteHeader.setText("");
        this.name.setText("Welcome to Connexion!");
    }

}