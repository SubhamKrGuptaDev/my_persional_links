package com.links.Personal.Links.service;


import com.links.Personal.Links.dto.UserLoginDto;
import com.links.Personal.Links.dto.UserLoginResponseDto;
import com.links.Personal.Links.entity.PersonalLinkUser;
import com.links.Personal.Links.exception.GlobalException;
import com.links.Personal.Links.util.CheckObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    @Autowired
    private PersonalLinkUserService personalLinkUserService;

    // TODO Login Feature need to be add
    public UserLoginResponseDto userLoginChecker(UserLoginDto userLoginDto) {

        // Email
        if (CheckObjectUtil.checkObject(userLoginDto.getEmail())) {
            PersonalLinkUser user = personalLinkUserService.getUserByEmail(userLoginDto.getEmail());
            // TODO Password encoder
            if(!user.getUserPassword().equals(userLoginDto.getPassword())) {
                throw new GlobalException("Access Deny");
            }

            // TODO JWT Token
            UserLoginResponseDto response = new UserLoginResponseDto();
            response.setToken("SimpleToken");
            return response;
        }

        // username
        if (CheckObjectUtil.checkObject(userLoginDto.getUsername())) {
            PersonalLinkUser user = personalLinkUserService.getUserByUsername(userLoginDto.getUsername());

            // TODO Password encoder
            if(!user.getUserPassword().equals(userLoginDto.getPassword())) {
                throw new GlobalException("Access Deny");
            }

            // TODO JWT Token
            UserLoginResponseDto response = new UserLoginResponseDto();
            response.setToken("SimpleToken");
            return response;
        }

        throw new GlobalException("Invalid Input");
    }



}
