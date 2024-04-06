package com.links.Personal.Links.repository;

import com.links.Personal.Links.dto.PersonalLinkUserDto;
import com.links.Personal.Links.entity.PersonalLinkUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonalLinkUserRepository extends JpaRepository<PersonalLinkUser, Long> {


    Boolean existsByUsername(String username);

    Boolean existsByUserEmail(String email);

    Optional<PersonalLinkUser> findByUserEmail(String email);
    Optional<PersonalLinkUser> findByUsername(String username);

    @Query(name = "PersonalLinkUser.getAllPersonalLinkUser", nativeQuery = true)
    List<PersonalLinkUserDto> getAllPersonalLinkUser();

}
