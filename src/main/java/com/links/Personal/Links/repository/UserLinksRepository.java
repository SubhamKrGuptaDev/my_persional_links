package com.links.Personal.Links.repository;

import com.links.Personal.Links.entity.UserLinks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserLinksRepository extends JpaRepository<UserLinks, Long> {


    List<UserLinks> findByFkUserId(Long pkUserId);

}
