package com.example.finacleservice.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserProfileController {

    @GetMapping("/profile")
    public String userProfile(Model model, @AuthenticationPrincipal OAuth2User user) {
        Map<String, Object> attributes = new HashMap<>(user.getAttributes());
        attributes.putIfAbsent("picture", "https://avatars.githubusercontent.com/u/33051420?v=4");
        model.addAttribute("user", attributes);
        return "profile";
    }
}