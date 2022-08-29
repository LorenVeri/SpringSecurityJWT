package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "RoleHasPermission")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleHasPermission {
    @Id
    @Column(name = "ID", nullable = false)
    private Long ID;

    @ManyToOne
    @JoinColumn(name = "RoleID")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "PermissionID")
    private Permission permission;

}
