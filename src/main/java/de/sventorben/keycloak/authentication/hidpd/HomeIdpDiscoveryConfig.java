package de.sventorben.keycloak.authentication.hidpd;

import org.keycloak.models.AuthenticatorConfigModel;

import java.util.Optional;

final class HomeIdpDiscoveryConfig {

    static final String FORWARD_TO_LINKED_IDP = "forwardToLinkedIdp";
    static final String USER_ATTRIBUTE = "userAttribute";

    private final AuthenticatorConfigModel authenticatorConfigModel;

    HomeIdpDiscoveryConfig(AuthenticatorConfigModel authenticatorConfigModel) {
        this.authenticatorConfigModel = authenticatorConfigModel;
    }

    boolean forwardToLinkedIdp() {
        return Optional.ofNullable(authenticatorConfigModel)
            .map(it -> Boolean.parseBoolean(it.getConfig().getOrDefault(FORWARD_TO_LINKED_IDP, "false")))
            .orElse(false);
    }

    String userAttribute() {
        return Optional.ofNullable(authenticatorConfigModel)
            .map(it -> it.getConfig().getOrDefault(USER_ATTRIBUTE, "email").trim())
            .orElse("email");
    }
}
