package com.links.Personal.Links.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "personal_link_user")
public class PersonalLinkUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkUserId;
    @Column(name = "name",nullable = false)
    private String name;

    @Column(unique = true)
    private String userEmail;
    @Column(nullable = false)
    private String userPassword;

    @Column(name = "username", unique = true)
    private String username;

    @Column(nullable = false)
    private Character active='T';

    @Column(name = "create_time", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createTime;

    @Column(name = "update_time", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updateTime;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Transient
    private List<UserLinks> userLinks;

}
