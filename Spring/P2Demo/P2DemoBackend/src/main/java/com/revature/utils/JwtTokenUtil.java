package com.revature.utils;

import com.revature.models.User;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

//This Util Class is what generates and manages our JWTs and
@Component
public class JwtTokenUtil {
    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour life for our JWT

    @Value("${app.jwt.secret}") //taken out of application.properties
    private String SECRET_KEY;

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);


    //verify a given JWT. It returns true if the JWT is verified, or false otherwise.
    public boolean validateAccessToken(String token) {
        System.out.println("in validateAccessToken");
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            LOGGER.error("JWT expired", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            LOGGER.error("Token is null, empty or only whitespace", ex.getMessage());
        } catch (MalformedJwtException ex) {
            LOGGER.error("JWT is invalid", ex);
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("JWT is not supported", ex);
        } catch (SignatureException ex) {
            LOGGER.error("Signature validation failed");
        }

        return false;
    }

    //This method does the actual creation of our JWT! The user's unique identifier token
    //This gets called after successful login
    public String generateAccessToken(User u) {
        return Jwts.builder()
                .setSubject(String.format("%s", u.getUserId())) //subject is typically ID
                .claim("username", u.getUsername()) //any other data can be set as a claim
                .claim("role", u.getRole())
                .setIssuer("Project2")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    //The below 3 methods are like getters for your JWT - they'll extract info out of them


    //we need this method to get the userID from the JWT (stored in the subject)
    //the subject tends to be used for unique identifiers
    public UUID extractUserId(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
        String subject = claimsJws.getBody().getSubject();
        return UUID.fromString(subject);
    }

    //we need the following 2 method to get the username and role from the JWT (stored in the claims)
    //claims tend to be used for other non-id information about the user. email, full name, etc.
    public String extractUsername(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
        return claimsJws.getBody().get("username", String.class);
    }

    public String extractRole(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
        return claimsJws.getBody().get("role", String.class);
    }

}
