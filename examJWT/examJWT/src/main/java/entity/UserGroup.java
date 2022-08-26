package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "UserGroup")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGroup extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false, length = 50)
    private String Name;

    @Column(nullable = false)
    private Long UserID;

    @Column(nullable = false)
    private Long RoleID;

}
