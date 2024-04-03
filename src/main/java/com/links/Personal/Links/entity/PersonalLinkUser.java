package com.links.Personal.Links.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "personal_link_user")
public class PersonalLinkUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkUserId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private Character active;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserLinks> userLinks;

}
