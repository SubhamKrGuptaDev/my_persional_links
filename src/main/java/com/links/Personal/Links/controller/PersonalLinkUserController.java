package com.links.Personal.Links.controller;

import com.links.Personal.Links.entity.PersonalLinkUser;
import com.links.Personal.Links.service.PersonalLinkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.links.Personal.Links.util.ResponseUtil.successResponse200;
import static com.links.Personal.Links.util.ResponseUtil.successResponse201;

@RestController
@RequestMapping("/personal-link-user")
public class PersonalLinkUserController {

    @Autowired
    private PersonalLinkUserService personalLinkUserService;

    @GetMapping
    public ResponseEntity<List<PersonalLinkUser>> getAllUsers() {
        return successResponse200(personalLinkUserService.getAllPersonalLinkUser());
    }

    @GetMapping
    public ResponseEntity<PersonalLinkUser> getUserById(@RequestParam Long userId) {
        return successResponse200(personalLinkUserService.getByIdPersonalLinkUser(userId));
    }

    @PostMapping
    public ResponseEntity<PersonalLinkUser> createUser(@RequestBody PersonalLinkUser personalLinkUser) {
        return successResponse201(personalLinkUserService.createPersonalLinkUser(personalLinkUser));
    }

    @PutMapping
    public ResponseEntity<PersonalLinkUser> updateUser(@RequestParam Long userId,
                                                       @RequestBody PersonalLinkUser personalLinkUser) {
        return successResponse201(personalLinkUserService.updatePersonalLinkUser(userId, personalLinkUser));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deactivateUser(@RequestParam Long userId) {
        return successResponse200(personalLinkUserService.deactivatePersonalLinkUser(userId));
    }


}
