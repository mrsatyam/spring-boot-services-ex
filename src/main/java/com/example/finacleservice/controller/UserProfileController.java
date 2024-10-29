package com.example.finacleservice.controller;

import org.apache.tomcat.util.http.parser.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserProfileController {

    private static final Logger logger = LoggerFactory.getLogger(UserProfileController.class);
    private final OAuth2AuthorizedClientService authorizedClientService;

    public UserProfileController(OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }

    @GetMapping("/profile")
    public String userProfile(Model model, @AuthenticationPrincipal OAuth2User user) {
        Map<String, Object> attributes = new HashMap<>(user.getAttributes());
        attributes.putIfAbsent("picture", "https://avatars.githubusercontent.com/u/33051420?v=4");
        model.addAttribute("user", attributes);

        // Log Access Token (after successful login)
        OAuth2AuthorizedClient authorizedClient = authorizedClientService
                .loadAuthorizedClient("google", user.getName()); // Replace "google" with your client registration ID
        if (authorizedClient != null && authorizedClient.getAccessToken() != null) {
            String accessToken = authorizedClient.getAccessToken().getTokenValue();
            logger.info("Access Token: {}", accessToken);
        } else {
            logger.warn("Access Token not available.");
        }

        return "profile";
    }

}
