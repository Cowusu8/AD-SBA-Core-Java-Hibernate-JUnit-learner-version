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
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name = "course")
public class Course {
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
    
    public Set<Student> students = new HashSet<>();
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

