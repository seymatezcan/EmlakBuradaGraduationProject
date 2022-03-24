package emlakburada.util;

import java.io.Serializable;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import lombok.Value;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Component;

import emlakburada.entity.Enrollee;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil implements Serializable {

	private static final String SECRET_KEY = "hepsiemlak-real-software-world-errors-debugs-infos-hard-secret-key";

	private static long EXPIRATION_TIME=3600000;

	private static final int refreshExpirationDateInMs=86400000;


	private Key key;

	@PostConstruct
	public void init() {
		this.key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	}

	private Claims getAllClaimsFromToken(String token) {
		//// @formatter:off
		return Jwts
				.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody();
		// @formatter:on
	}

	public String getUserName(String token) {
		return getAllClaimsFromToken(token).getSubject();
	}


	public Date getExpirationDate(String token) {

		return getAllClaimsFromToken(token).getExpiration();
	}

	public boolean isTokenExpired(String token) {
		return this.getExpirationDate(token).equals(new Date());
	}

	public String generateToken(Enrollee enrollee) {

		Map<String, Object> claims = new HashMap<>();
		//claims.put("enrolleeType", enrollee.getEnrolleeType().toString());
		claims.put("email", enrollee.getEmail());
		claims.put("enrolleeId", enrollee.getEnrolleeId());

		long now = System.currentTimeMillis();

		// @formatter:off


		String JWT = Jwts
				.builder()
				.setClaims(claims)
				.setSubject(enrollee.getEmail())
				.setIssuedAt(new Date())
				.setIssuer("emlakburada")
				.setExpiration( new Date(now + EXPIRATION_TIME))
				.signWith(key, SignatureAlgorithm.HS512)
				.compact();

		System.out.println(JWT);

		return JWT;
		
		// @formatter:on
	}

}
