package com.codechimp.oAuth.controller;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.security.core.annotation.AuthenticationPrincipal;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

import com.codechimp.oAuth.repository.UserRepository;
import com.codechimp.oAuth.userDocument.User;
import com.codechimp.oAuth.userModel.UserDTO;

    @RestController
    @RequestMapping("/api/users")
    public class UserController {
        @Autowired
        UserRepository userRepository;

        @GetMapping("/{id}")
        @PreAuthorize("#user.id == #id")
        public ResponseEntity user(@AuthenticationPrincipal User user, @PathVariable String id) {
            return ResponseEntity.ok(UserDTO.from(userRepository.findById(id).orElseThrow()));
        }
    }