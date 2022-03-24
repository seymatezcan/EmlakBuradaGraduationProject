package com.EmlakBuradaGateway.EmlakBuradaGateway.util;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import javax.annotation.PostConstruct;

import com.nimbusds.jwt.JWT;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtil {

    private static final String SECRET_KEY = "hepsiemlak-real-software-world-errors-debugs-infos-hard-secret-key";

    private Key key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public Claims getAllClaimsFromToken(String token) {

        //// @formatter:off
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        // @formatter:on

    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public String getUserName(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    /*//id için burası eklendi
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
            .getPrincipal();
    String username = userDetails.getUsername();

    //id için bu da eklendi*/
    /*Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    UserDetails userDetails = (UserDetails) auth.getPrincipal();*/
    //System.out.println("User has authorities: " + userDetails.getAuthorities());

    public Date getExpirationDate(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public boolean isTokenExpired(String token) {

         try {
        return this.getExpirationDate(token).before(new Date());
		} catch (Exception e) {
			log.error("token is expired" + token);
		}
    	return true;
    }

    public boolean isValidToken(String token) {

         //UserDetails userDetail = customUserServiceDetail.loadUserByUsername(getUserName(token));
        try {
            return isTokenExpired(token);
        } catch (Exception e) {
            log.error("token is expired"); //süresi dolmuş
        }

        return true;
    }

}