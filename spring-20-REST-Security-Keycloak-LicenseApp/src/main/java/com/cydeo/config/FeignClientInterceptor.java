package com.cydeo.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

// Purpose of this class:
// Access Token does not automatically pass b/w Organization and License app
// This class intercepts the Bearer Token (added under Auth.) and provides it
    // to the License app when we run GET license in Postman

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_TYPE = "Bearer ";

    @Override
    public void apply(RequestTemplate requestTemplate) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SimpleKeycloakAccount details = (SimpleKeycloakAccount) authentication.getDetails();
        requestTemplate.header(AUTHORIZATION_HEADER, TOKEN_TYPE + details.getKeycloakSecurityContext().getTokenString());

    }

}