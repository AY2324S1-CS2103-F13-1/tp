package connexion.testutil;

import static connexion.testutil.ClockUtil.DEFAULT_TEST_TIME;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import connexion.model.person.Company;
import connexion.model.person.Email;
import connexion.model.person.Job;
import connexion.model.person.LastModifiedDateTime;
import connexion.model.person.Mark;
import connexion.model.person.Name;
import connexion.model.person.Person;
import connexion.model.person.Phone;
import connexion.model.tag.Tag;
import connexion.model.util.SampleDataUtil;




/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_COMPANY = "Mandai Wildlife Group";
    public static final String DEFAULT_JOB = "Machine Learning Analyst";

    public static final LocalDateTime DEFAULT_LAST_MODIFIED = DEFAULT_TEST_TIME;

    private Name name;
    private Phone phone;
    private Email email;
    private Company company;
    private Job job;
    private Set<Tag> tags;
    private Mark markStatus;
    private LastModifiedDateTime lastModifiedDateTime;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        company = new Company(DEFAULT_COMPANY);
        job = new Job(DEFAULT_JOB);
        tags = new HashSet<>();
        lastModifiedDateTime = new LastModifiedDateTime(DEFAULT_LAST_MODIFIED);
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        company = personToCopy.getCompany();
        job = personToCopy.getJob();
        tags = new HashSet<>(personToCopy.getTags());
        lastModifiedDateTime = personToCopy.getLastModifiedDateTime();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Company} of the {@code Person} that we are building.
     */
    public PersonBuilder withCompany(String company) {
        this.company = new Company(company);
        return this;
    }

    /**
     * Sets the {@code Job} of the {@code Person} that we are building.
     */
    public PersonBuilder withJob(String job) {
        this.job = new Job(job);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code LastModifiedDateTime} of the {@code Person} that we are building.
     */
    public PersonBuilder withLastModifiedDateTime(LocalDateTime lastModifiedDateTime) {
        this.lastModifiedDateTime = new LastModifiedDateTime(lastModifiedDateTime);
        return this;
    }

    public Person build() {
        return new Person(name, phone, email, company, job, tags, lastModifiedDateTime);
    }

    /**
     * Sets the {@code markStatus} of the {@code Person} that we are building.
     */
    public PersonBuilder withMarkStatus(boolean b) {
        this.markStatus = new Mark(b);
        return this;
    }
}