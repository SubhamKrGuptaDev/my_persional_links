package com.links.Personal.Links.service;

import com.links.Personal.Links.entity.PersonalLinkUser;
import com.links.Personal.Links.entity.UserLinks;
import com.links.Personal.Links.exception.GlobalException;
import com.links.Personal.Links.repository.PersonalLinkUserRepository;
import com.links.Personal.Links.repository.UserLinksRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalLinkUserService {

    @Autowired
    private PersonalLinkUserRepository userRepository;

    @Autowired
    private UserLinksRepository userLinksRepository;

    // GET ALL
    public List<PersonalLinkUser> getAllPersonalLinkUser() {
        return userRepository.findAll();
    }

    // GET BY ID
    public PersonalLinkUser getByIdPersonalLinkUser(Long userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(() -> new GlobalException("User not Found"));
    }

    // CREATE
    @Transactional
    public PersonalLinkUser createPersonalLinkUser(PersonalLinkUser personalLinkUser) {

        if(personalLinkUser.getUserEmail() == null || checkEmail(personalLinkUser.getUserEmail())) {
            throw new GlobalException("Email Already present.");
        }

        if(personalLinkUser.getName() == null || checkUsername(personalLinkUser.getName())) {
            throw new GlobalException("Username Already present.");
        }

        if(personalLinkUser.getUserLinks().isEmpty()) {
            throw new GlobalException("Links are mandatory");
        }
        List<UserLinks> userLinks = personalLinkUser.getUserLinks();
        PersonalLinkUser userSave = userRepository.save(personalLinkUser);


        for (UserLinks tempLink : userLinks) {
            tempLink.setFkUserId(userSave.getPkUserId());
            userLinksRepository.save(tempLink);
        }

        return userSave;
    }

    // UPDATE
    public PersonalLinkUser updatePersonalLinkUser(Long userId, PersonalLinkUser personalLinkUser) {
        if(personalLinkUser.getUserLinks().isEmpty()) {
            throw new GlobalException("Links are mandatory");
        }

        PersonalLinkUser user = userRepository
                .findById(userId)
                .orElseThrow(() -> new GlobalException("User not Found"));

        if (personalLinkUser.getPkUserId() == null || !personalLinkUser.getPkUserId().equals(user.getPkUserId())) {
            throw new GlobalException("Access Deny");
        }

        if (personalLinkUser.getUserEmail() == null || !personalLinkUser.getUserEmail().equals(user.getUserEmail())) {
            throw new GlobalException("Email can't be change");
        }

        if(personalLinkUser.getUsername() == null || !personalLinkUser.getUsername().equals(user.getUsername())) {
            throw new GlobalException("Username can't be change");
        }

        user.setName(personalLinkUser.getName());
        user.setUserPassword(personalLinkUser.getUserPassword());
        user.setUserLinks(personalLinkUser.getUserLinks());
        return userRepository.save(user);
    }

    // DEACTIVATE
    public Boolean deactivatePersonalLinkUser(Long userId) {
        PersonalLinkUser user = userRepository.findById(userId).orElseThrow();
        if (user.getActive() != 'F') {
            user.setActive('F');
            userRepository.save(user);
        }
        return true;
    }

    private boolean checkEmail(String email) {
        return userRepository.existsByUserEmail(email);
    }

    private boolean checkUsername(String username) {
        return userRepository.existsByUsername(username);
    }

}
