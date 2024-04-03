package com.links.Personal.Links.service;

import com.links.Personal.Links.entity.PersonalLinkUser;
import com.links.Personal.Links.repository.PersonalLinkUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalLinkUserService {

    @Autowired
    private PersonalLinkUserRepository userRepository;

    // GET ALL
    public List<PersonalLinkUser> getAllPersonalLinkUser() {
        return userRepository.findAll();
    }

    // GET BY ID
    public PersonalLinkUser getByIdPersonalLinkUser(Long userId) {
        return userRepository
                .findById(userId)
                .orElseThrow();
    }

    // CREATE
    public PersonalLinkUser createPersonalLinkUser(PersonalLinkUser personalLinkUser) {
        if(personalLinkUser.getUserLinks().isEmpty()) {
            throw new RuntimeException();
        }
        return userRepository.save(personalLinkUser);
    }

    // UPDATE
    public PersonalLinkUser updatePersonalLinkUser(Long userId, PersonalLinkUser personalLinkUser) {
        if(personalLinkUser.getUserLinks().isEmpty()) {
            throw new RuntimeException();
        }
        PersonalLinkUser user = userRepository.findById(userId).orElseThrow();
        if (!personalLinkUser.getPkUserId().equals(user.getPkUserId()) ||
                !personalLinkUser.getUserEmail().equals(user.getUserEmail())) {
            throw new RuntimeException();
        }

        user.setUserName(personalLinkUser.getUserName());
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

}
