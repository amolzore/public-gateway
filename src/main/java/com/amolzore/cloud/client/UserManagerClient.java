package com.amolzore.cloud.client;

import com.amolzore.cloud.dataaccess.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.LinkedHashMap;

@Component
public class UserManagerClient extends ApiGatewayClient {
    private static final String API_GATEWAY_URL = "http://localhost:8087";
    private static final Integer API_VERSION = 1;
    private static final String APP_NAME = "user";
    private static final String key = "aesEncryptionKey";
    private static final String initVector = "encryptionIntVec";

    public UserManagerClient() {
        super(API_VERSION, APP_NAME, API_GATEWAY_URL);
    }

    public User getUser(int id) {
        UriComponents uri = UriComponentsBuilder.fromPath("/" + id).build();
        LinkedHashMap body = (LinkedHashMap) get(uri.toUriString()).getBody();
        return new User((Integer) body.get("id"), (String) body.get("username"), "");
    }

    public User getUserByUsername(String username, String password) {
        UriComponents uri = UriComponentsBuilder.fromPath("/").build();
        UserFilterBody userFilterBody = new UserFilterBody(null, username, password);
        LinkedHashMap body = (LinkedHashMap) post(uri.toUriString(), userFilterBody).getBody();
        return new User((Integer) body.get("id"), (String) body.get("username"), "");
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private class UserFilterBody {
        String id;
        String username;
        String password;
    }
}