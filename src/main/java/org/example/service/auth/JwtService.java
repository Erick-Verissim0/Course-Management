package org.example.service.auth;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
  private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
  private static final String SECRET = dotenv.get("SECRET_KEY");
  private static final Long EXPIRATION_TIME = Long.parseLong(dotenv.get("EXPIRATION_TIME"));

  private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

  public String generateToken(String email) {
    return Jwts.builder()
        .setSubject(email)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
        .compact();
  }
}
