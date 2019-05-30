package com.amolzore.cloud.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.LinkedHashMap;

import static com.amolzore.cloud.controller.ApiPath.TOKEN_PATH;
import static com.amolzore.cloud.controller.ApiPath.VALIDATE_PATH;

@Slf4j
@Component
public class IdentityProviderClient extends ApiGatewayClient {
    private static final String API_GATEWAY_URL = "http://localhost:8084";
    private static final Integer API_VERSION = 1;
    private static final String APP_NAME = "identity-provider";
    private static final String key = "aesEncryptionKey";
    private static final String initVector = "encryptionIntVec";

    public IdentityProviderClient() {
        super(API_VERSION, APP_NAME, API_GATEWAY_URL);
    }

    public String getToken(int id) {
        UriComponents uri = UriComponentsBuilder.fromPath(TOKEN_PATH + "/" + id).build();
        LinkedHashMap body = (LinkedHashMap) get(uri.toUriString()).getBody();
        return (String) body.get("jwtToken");
    }

    public Boolean validateToken(String token) {
        UriComponents uri = UriComponentsBuilder.fromPath(VALIDATE_PATH)
                .queryParam("token", token)
                .buildAndExpand(token);
        return (Boolean) (post(uri.toUriString(), token).getBody());
    }
}