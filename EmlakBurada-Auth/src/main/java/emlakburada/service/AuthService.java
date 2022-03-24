package emlakburada.service;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakburada.dto.AuthRequest;
import emlakburada.dto.AuthResponse;
import emlakburada.entity.Enrollee;
import emlakburada.exception.EnrolleeNotFoundException;
import emlakburada.exception.EnrolleePasswordNotValidException;
import emlakburada.repository.AuthRepository;
import emlakburada.util.JwtUtil;
import emlakburada.util.EnrolleeUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@Service
public class AuthService {

	@Autowired
	AuthRepository authRepository;

	@Autowired
	JwtUtil jwtUtil;

	public AuthResponse getToken(AuthRequest request)  {
		Enrollee enrollee =authRepository.findByEmail(request.getEmail());



		if (!EnrolleeUtil.isValidPassword(enrollee.getPassword(), request.getPassword())) {
			log.error("Enrollee's password not valid " + request.getEmail());
			throw new EnrolleePasswordNotValidException("Enrollee's password not valid");
		}

		return new AuthResponse(jwtUtil.generateToken(enrollee));
	}


}
