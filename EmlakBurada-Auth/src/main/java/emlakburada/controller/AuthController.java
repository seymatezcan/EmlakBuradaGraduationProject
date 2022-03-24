package emlakburada.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import emlakburada.dto.AuthRequest;
import emlakburada.dto.AuthResponse;
import emlakburada.service.AuthService;
import lombok.RequiredArgsConstructor;

import java.security.Principal;

@RestController
public final class AuthController {

	@Autowired
	AuthService authService;

	@PostMapping(value = "/auths")
	public ResponseEntity<AuthResponse> getToken(@RequestBody AuthRequest request) {
		authService.getToken(request);
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
