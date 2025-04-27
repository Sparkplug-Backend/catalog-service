package com.sparkplug.catalog.infrastructure.security.service;

import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.SignedJWT;

import java.security.interfaces.RSAPublicKey;

public class JwtValidator {

    private final RSAPublicKey publicKey;

    public JwtValidator(RSAPublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public boolean validateToken(String token) {
        try {
            var signedJWT = SignedJWT.parse(token);

            JWSVerifier verifier = new RSASSAVerifier(publicKey);

            return signedJWT.verify(verifier);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
