package dtos;

import entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseEntity {
    private Long ID;

    private String Username;

    private String Password;

    private String FirstName;

    private int Age;

    private String Genre;

    private String LastName;

    private String Address;

    private String Email;

    private int NumberPhone;

    private Date Birthday;
}
