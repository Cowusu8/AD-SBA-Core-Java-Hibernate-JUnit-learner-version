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
    @Column(length = 50, name = "email")
    String email;
    @NonNull
    @Column(length = 50, name = "name", nullable = false)
    String name;
    @Column(length = 50, name = "password")
    String password;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
