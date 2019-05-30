package com.amolzore.cloud.service;

import com.amolzore.cloud.client.IdentityProviderClient;
import com.amolzore.cloud.client.UserManagerClient;
import com.amolzore.cloud.dataaccess.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PublicGatewayService {
    @Autowired
    IdentityProviderClient identityProviderClient;

    @Autowired
    UserManagerClient userManagerClient;

    public User getUser(int userId) { return userManagerClient.getUser(userId); }

    public JwtResponse login(String username, String password) {
        User user = userManagerClient.getUserByUsername(username,password);
        return new JwtResponse(identityProviderClient.getToken(user.getId()),user);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private class JwtResponse {
        String jwtToken;
        User user;
    }
}