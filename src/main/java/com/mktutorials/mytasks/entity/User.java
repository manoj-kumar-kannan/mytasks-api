package com.mktutorials.mytasks.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(generator = "user_gen", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "user_gen", sequenceName = "tbl_user_seq", initialValue = 1001, allocationSize = 1)
    private Long id;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50)
    private String middleName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 100, nullable = false)
    private String userName;

    @Column(length = 75, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 10)
    private int isVerified = 1;

    @Column(length = 10)
    private int isActive = 1;

    @CreationTimestamp
    @Column(updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    private Date lastLogin;

    @ManyToOne
    private UserRole userRole;

    @PrePersist
    private void userName() {
        this.userName = this.firstName + " " + this.lastName;
    }
}
