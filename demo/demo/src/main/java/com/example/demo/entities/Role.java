package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role  extends BaseEntity {
    @Id
    @GeneratedValue
    private Long ID;

    @Column(nullable = false)
    private String Name;

    @Column(length = 10)
    private String Code;

    @OneToMany(mappedBy = "role")
    private List<RoleHasPermission> roleHasPermissionList = new ArrayList<>();

    @OneToMany(mappedBy = "role")
    private List<UserHasRole> userHasRoles = new ArrayList<>();
}