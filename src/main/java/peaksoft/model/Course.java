package peaksoft.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String courseName;
    private String duration;

    @ManyToOne(cascade = {PERSIST,MERGE},fetch = FetchType.LAZY)
    @JoinColumn(name="company_id")
    private Company company;

    @ManyToMany(cascade = {PERSIST, MERGE, REFRESH, DETACH,REMOVE},fetch = FetchType.EAGER)
    @JoinTable(name="course_group",joinColumns = @JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="group_id"))
    private List<Group> groupList=new ArrayList<>();

    @OneToOne(cascade = {REFRESH,MERGE,DETACH,PERSIST,REMOVE},fetch = FetchType.LAZY)
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    public Course() {
    }

    public Course(Long id, String courseName, String duration) {
        this.id = id;
        this.courseName = courseName;
        this.duration = duration;
    }

    public Course(Long id) {
        this.id = id;
    }
    public void addGroupToCourse(Group group){
        groupList.add(group);
    }
    public void setCompany1(Company company){
        this.company=company;
        company.setCourses1(this);
    }

}
