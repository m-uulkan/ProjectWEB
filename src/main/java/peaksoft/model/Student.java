package peaksoft.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.DETACH;


@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private Long id;
    private String surname;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;

    @ManyToOne(cascade = {PERSIST,MERGE,REFRESH,DETACH},fetch = FetchType.LAZY)
    @JoinColumn(name="group_id")
    private Group group;

    public Student() {
    }
    public Student(Long id, String surname, String name, String email, StudyFormat studyFormat) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.studyFormat = studyFormat;
    }
    public void setGroup1(Group group){
        this.group=group;
        group.setStudentToGroup(this);
    }

}
