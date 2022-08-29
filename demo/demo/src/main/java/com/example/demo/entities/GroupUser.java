package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GroupUser")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupUser extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false, length = 50)
    private String Name;

    @OneToMany(mappedBy = "groupUser")
    private List<GroupHasUser> groupUsers = new ArrayList<>();
}
