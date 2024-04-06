package com.links.Personal.Links.controller;


import com.links.Personal.Links.dto.UserLoginDto;
import com.links.Personal.Links.dto.UserLoginResponseDto;
import com.links.Personal.Links.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.links.Personal.Links.util.ResponseUtil.successResponse200;

@RestController
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> userLogin(@RequestBody UserLoginDto userLoginDto) {
        return successResponse200(userLoginService.userLoginChecker(userLoginDto));
    }

    @PostMapping("/logout")
    public ResponseEntity<Boolean> userLogout(@RequestBody UserLoginResponseDto userLoginResponseDto) {

        // TODO Logout Feature
        return successResponse200(true);
    }


}
