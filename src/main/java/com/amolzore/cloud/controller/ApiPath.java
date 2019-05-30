package com.amolzore.cloud.controller;

public final class ApiPath {
    public static final String
            API = "api",
            V1 = "v1",
            V = "v?",
            SERVICE = "public-gateway",
            USER_SERVICE = "user",
            IDENTITY_PROVIDER_SERVICE = "identity-provider",
            ID = "{id}",
            TOKEN = "token",
            VALIDATE = "validate",
            AUTHENTICATION = "auth",
            USER = "user";

    public static final String
            API_V_PATH = "/" + API + "/" + V,
            API_V1_PATH = "/" + API + "/" + V1,
            SERVICE_PATH = "/" + SERVICE,
            ID_PATH = "/" + ID,
            TOKEN_PATH = "/" + TOKEN,
            VALIDATE_PATH = "/" + VALIDATE,
            IDENTITY_PROVIDER_SERVICE_PATH = "/" + IDENTITY_PROVIDER_SERVICE,
            AUTHENTICATION_PATH = "/" + AUTHENTICATION,
            USER_SERVICE_PATH = "/" + USER_SERVICE,
            USER_PATH = "/" + USER;

    public static final String
            API_DOT = API + "." + V1,
            SERVICE_DOT = "." + SERVICE,
            ID_DOT = "." + ID;

    private ApiPath() {
    }
}