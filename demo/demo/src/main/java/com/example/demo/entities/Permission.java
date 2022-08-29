package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Permission")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    @Id
    @GeneratedValue
    private Long ID;

    @Column(nullable = false)
    private String Name;

    @Column(length = 10)
    private String Code;

    @OneToMany(mappedBy = "permission")
    private List<RoleHasPermission> roleHasPermissionList = new ArrayList<>();
}
