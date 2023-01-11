package com.shortenServer.security;

import com.shortenServer.data.models.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtGenerator {

    public String generateToken(UserEntity user){
        String username = user.getUsername();
        return generateToken(username);
    }

    public String generateToken(Authentication authentication){
        AuthenticatedUser authenticatedUser = (AuthenticatedUser) authentication.getPrincipal();
        String username = authenticatedUser.getUsername();
        return generateToken(username);
    }

    public String generateToken(String username) {
        Date currentDate = new Date();
        Date expirationDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SecurityConstants.JWT_SECRET_KEY)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.JWT_SECRET_KEY)
                .parseClaimsJwt(token).getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser()
                    .setSigningKey(SecurityConstants.JWT_SECRET_KEY)
                    .parseClaimsJwt(token);

            return true;
        } catch (Exception e){
            throw new AuthenticationCredentialsNotFoundException("Invalid token");
        }
    }
}
