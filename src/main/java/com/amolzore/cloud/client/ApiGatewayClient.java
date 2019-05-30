package com.amolzore.cloud.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class ApiGatewayClient {
    private String apiGatewayUrl;
    private final static String BASE_URL = "/api";
    private final String appName;
    private String apiVersion;
    RestTemplate restTemplate;


    public ApiGatewayClient(Integer apiVersion,
                            String appName, String apiGatewayUrl) {

        this.appName = appName;
        this.apiVersion = "v" + apiVersion;
        this.apiGatewayUrl = apiGatewayUrl;
        this.restTemplate = new RestTemplate();
    }

    protected String getBaseURL() {
        return BASE_URL + "/" + apiVersion + "/" + appName;
    }

    public ResponseEntity post(String relativeURL, final Object object) throws RestClientException {
        return restTemplate.postForEntity(apiGatewayUrl + getBaseURL() + relativeURL, object, Object.class);
    }

    public ResponseEntity get(String relativeURL) throws RestClientException {
        return restTemplate.getForEntity(apiGatewayUrl + getBaseURL() + relativeURL, Object.class);
    }
}
