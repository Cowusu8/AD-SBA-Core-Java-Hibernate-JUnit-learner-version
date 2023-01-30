package sba.sms.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.*;
import jakarta.persistence.*;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString

@Entity
@Table(name = "course")
public class Course{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    int id;
    @Column(length = 50, name = "name")
    @NonNull
    String name;
    @Column(length = 50, name="instructor")
    @NonNull
    String instructor;

    @ToString.Exclude
    @ManyToMany(mappedBy = "courses", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},fetch = FetchType.EAGER)
    private Set<Student> students = new LinkedHashSet<Student>();
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && name.equals(course.name) && instructor.equals(course.instructor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, instructor);
    }

}

