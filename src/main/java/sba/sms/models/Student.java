package sba.sms.models;

import lombok.*;
import jakarta.persistence.*;
/*
 * Models requires:
    - no args constructor
     - all args constructor
required args constructor
setters and getter
toString (exclude collections to avoid infinite loops)
override equals and hashcode methods (((don't use lombok here)))
----helper methods
 */
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "student")

public class Student {
    @Id
    @Column(length = 50, name = "email", unique=true)
    String email;
    @NonNull
    @Column(length = 50, name = "name", nullable = false)
    String name;
    @Column(length = 50, name = "password")
    String password;

    @ToString.Exclude
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(name = "student_courses",
            joinColumns = @JoinColumn(name = "student_email"),
             inverseJoinColumns = @JoinColumn(name = "courses_id"))
     Set<Course> courses = new HashSet<>();
    
    public void addCourse(Course course){
        courses.add(course);
        course.getStudents().add(this);
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
