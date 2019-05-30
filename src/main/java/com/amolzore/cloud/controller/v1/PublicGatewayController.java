package com.amolzore.cloud.controller.v1;

import com.amolzore.cloud.service.PublicGatewayService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.amolzore.cloud.controller.ApiPath.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@CrossOrigin()
@Slf4j
@RestController("publicGatweayControllerV1")
@RequestMapping(API_V1_PATH)
@RequiredArgsConstructor
public class PublicGatewayController {
    @Autowired
    private final PublicGatewayService publicGatewayService;


    @RequestMapping(value = IDENTITY_PROVIDER_SERVICE_PATH + AUTHENTICATION_PATH, method = GET, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity login(@RequestParam(value = "username") String username,
                                @RequestParam(value = "password") String password, HttpServletRequest request) throws Exception {
        return new ResponseEntity(publicGatewayService.login(username, password), HttpStatus.OK);
    }

    @RequestMapping(value = USER_SERVICE_PATH + "/" + ID, method = GET, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getUser(@ApiParam(value = "User ID", required = true)
                                  @PathVariable("id") int userId,
                                  HttpServletRequest request) throws Exception {
        return new ResponseEntity(publicGatewayService.getUser(userId), HttpStatus.OK);
    }
}