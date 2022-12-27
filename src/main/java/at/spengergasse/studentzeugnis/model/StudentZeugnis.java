package at.spengergasse.studentzeugnis.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Embedded;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Setter
@Getter



@Data
@Document("students_zeugnis")
public class StudentZeugnis {
    @NotNull(message = "Version can not be null")
    private String version;
    @Id
    @NotNull(message = "ID can not be null")
    private String id;
    @NotNull(message = "Firstname can not be null")
    private String firstname;
    @NotNull(message = "Lastname can not be null")
    private String lastname;
    @NotNull(message = "Gender can not be null")
    private Gender gender;
    @NotNull(message = "Birthdate can not be null")
    private LocalDate birthDate;
    @NotNull(message = "Age can not be null")
    private double age;

    @DocumentReference
    private Class studentClass;
     List<WP> WP;
    @NotNull(message = "Subjects can not be null")
    @Field("subjects")
    @Embedded
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List <Subject> subjects;
    @NotNull(message = "Passed can not be null")
    private boolean passed;
    @NotNull(message = "Time Stamp can not be null")
    private LocalDateTime timeStamp;

    @Builder
    public StudentZeugnis(String version, String firstname, String lastname, Gender gender, LocalDate birthDate, double age, List<WP> WP, List<Subject> subjects, boolean passed) {
        this.version = version;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.age = age;
        this.WP = WP;
        this.subjects = subjects;
        this.passed = passed;
        this.timeStamp = LocalDateTime.now();

    }


    public String getStudentInfo() {
        return "StudentZeugnis{" +
                "version='" + version + '\'' +
                ", id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", age=" + age +
                ", studentClass=" + studentClass +
                ", WP=" + WP +
                ", subjects=" + subjects +
                ", passed=" + passed +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
