package at.spengergasse.studentzeugnis.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter



@Data
@Document("teacher")
public class Teacher {
    private String version;
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private LocalDateTime timeStamp;

    @Builder
    public Teacher(String version, String firstname, String lastname) {
        this.version = version;
        this.firstname = firstname;
        this.lastname = lastname;
        this.timeStamp = LocalDateTime.now();
    }

    @Builder
    public Teacher(String id,String version, String firstname, String lastname) {
        this.id = id;
        this.version = version;
        this.firstname = firstname;
        this.lastname = lastname;
        this.timeStamp = LocalDateTime.now();
    }
}
