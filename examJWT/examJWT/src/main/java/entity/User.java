package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    private Long ID;

    @Column(nullable = false, unique = true, length = 30)
    private String Username;

    @Column(nullable = false, unique = true)
    private String Password;

    @Column(length = 50)
    private String FirstName;

    @Column
    private int Age;

    @Column(length = 10)
    private String Genre;

    @Column(length = 50)
    private String LastName;

    @Column(length = 255)
    private String Address;

    @Column(length = 150)
    private String Email;

    private int NumberPhone;

    private Date Birthday;

}
