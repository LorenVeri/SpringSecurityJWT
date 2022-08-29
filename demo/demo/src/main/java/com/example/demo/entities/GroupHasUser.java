package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GroupHasUser")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupHasUser {
    @Id
    @Column(name = "ID", nullable = false)
    private Long ID;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "GroupID")
    private GroupUser groupUser;
}
