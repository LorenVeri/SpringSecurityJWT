package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role  extends BaseEntity{
    @Id
    @GeneratedValue
    private Long ID;

    @Column(nullable = false)
    private String Name;

    @Column(length = 10)
    private String Code;
}
