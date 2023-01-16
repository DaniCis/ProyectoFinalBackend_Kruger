package com.kruger.authserver.security;

import ch.qos.logback.core.subst.Token;
import com.kruger.authserver.dto.RequestDto;
import com.kruger.authserver.entity.AuthUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.crypto.MacProvider;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secret;

    @PostConstruct
    protected void init(){
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    @Autowired
    RouteValidator routeValidator;

    public String createToken(AuthUser authUser){
        Map<String, Object> claims = new HashMap<>();
        claims = Jwts.claims().setSubject(authUser.getUsername());
        claims.put("id", authUser.getId());
        claims.put("role",authUser.getRole());
        Date now = new Date();
        Date exp = new Date( now.getTime() + 3600000); //una hora
        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        return token;
    }

    public Boolean validateToken(String token, RequestDto dto){
        try{
            Jws<Claims> jwt = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        }catch (Exception e){
            return false;
        }
        if(!isAdmin(token) && routeValidator.isAdminPath(dto))
            return false;
        return true;
    }

    public String getUserNameFromToken(String token){
        try{
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        }catch (Exception e){
            return "Bad token";
        }
    }

    private Boolean isAdmin(String token){
        return  Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("role").equals("admin");
    }
}
