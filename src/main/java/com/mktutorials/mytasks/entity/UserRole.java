package com.mktutorials.mytasks.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tbl_user_role")
public class UserRole {

    @Id
    @GeneratedValue(generator = "user_role_gen", strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private String role;

    @Column(length = 30)
    private String roleName;

    @Column(length = 10)
    private Integer isActive;

    @OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL)
    private List<User> user = new ArrayList<>();

    @PrePersist
    @PreUpdate
    private void updateRoleName() {
        this.roleName = this.role.toUpperCase();
    }
}
