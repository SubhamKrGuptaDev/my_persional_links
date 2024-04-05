package com.links.Personal.Links.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_links")
public class UserLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkUserLinkId;
    private String linkName;
    private String link;


    @Column(name = "create_time", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createTime;

    @Column(name = "update_time", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updateTime;

    @Column(name = "fk_user_id")
    private Long fkUserId;

}
