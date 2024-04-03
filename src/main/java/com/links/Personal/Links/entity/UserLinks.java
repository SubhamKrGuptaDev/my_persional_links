package com.links.Personal.Links.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_links")
public class UserLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkUserLinkId;
    private String linkName;
    private String link;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private PersonalLinkUser user;

}
