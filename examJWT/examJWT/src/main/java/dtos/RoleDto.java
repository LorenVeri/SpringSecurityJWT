package dtos;

import entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto extends BaseEntity {
    private Long ID;

    private String Name;

    private String Code;
}
