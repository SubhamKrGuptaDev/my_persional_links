package com.links.Personal.Links.entity;


import com.links.Personal.Links.dto.PersonalLinkUserDto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@NamedNativeQuery(
        name = "PersonalLinkUser.getAllPersonalLinkUser",
        query = "SELECT " +
                " plu.pk_user_id AS pkUserId, plu.name, plu.user_email AS userEmail, " +
                " plu.username, plu.active, ul.link_name AS linkName, ul.link " +
                " FROM personal_link_user plu " +
                "   JOIN user_links ul " +
                "   ON plu.pk_user_id = ul.fk_user_id ",
        resultSetMapping = "Mapping.getAllPersonalLinkUser"
)
@SqlResultSetMapping(
    name = "Mapping.getAllPersonalLinkUser",
        classes = {
            @ConstructorResult(
                    targetClass = PersonalLinkUserDto.class,
                    columns = {
                            @ColumnResult(name = "pkUserId", type = Long.class),
                            @ColumnResult(name = "name", type = String.class),
                            @ColumnResult(name = "userEmail", type = String.class),
                            @ColumnResult(name = "username", type = String.class),
                            @ColumnResult(name = "active", type = Character.class),
                            @ColumnResult(name = "linkName", type = String.class),
                            @ColumnResult(name = "link", type = String.class)
                    }
            )
        }
)
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
