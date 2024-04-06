package com.links.Personal.Links.dto;

import lombok.Data;

@Data
public class PersonalLinkUserDto {

    private Long pkUserId;
    private String name;
    private String userEmail;
    private String username;
    private Character active;
    private String linkName;
    private String link;

}
