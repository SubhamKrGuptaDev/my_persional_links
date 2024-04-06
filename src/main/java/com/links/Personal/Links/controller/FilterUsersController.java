package com.links.Personal.Links.controller;

import com.links.Personal.Links.entity.PersonalLinkUser;
import com.links.Personal.Links.service.PersonalLinkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.links.Personal.Links.util.ResponseUtil.successResponse200;

@RestController
@RequestMapping("/filter")
public class FilterUsersController {

    @Autowired
    private PersonalLinkUserService personalLinkUserService;

    @GetMapping("/email")
    public ResponseEntity<PersonalLinkUser> getUserByEmail(@RequestParam String email) {
        return successResponse200(personalLinkUserService.getUserByEmail(email));
    }

    @GetMapping("/username")
    public ResponseEntity<PersonalLinkUser> getUserByUsername(@RequestParam String username) {
        return successResponse200(personalLinkUserService.getUserByUsername(username));
    }

}
