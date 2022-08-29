package com.example.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "UserHasRole")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHasRole {
    @Id
    @Column(name = "ID", nullable = false)
    private Long ID;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "RoleID")
    private Role role;

}
