package com.rpdly.rpdlyapi.api.Service.Auth;

import com.rpdly.rpdlyapi.api.response.CommonResponse;
import com.rpdly.rpdlyapi.api.response.ResponseService;
import com.rpdly.rpdlyapi.config.auth.JwtTokenProvider;
import com.rpdly.rpdlyapi.domain.User;
import com.rpdly.rpdlyapi.domain.UserRepository;
import com.rpdly.rpdlyapi.utils.exceptions.EmailSignInFailedException;
import com.rpdly.rpdlyapi.utils.exceptions.EmailSignUpFailedException;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class SignController {

  private final UserRepository userRepository;
  private final JwtTokenProvider jwtTokenProvider;
  private final ResponseService responseService;
  private final PasswordEncoder passwordEncoder;

  @PostMapping("/signin")
  public ResponseEntity<CommonResponse> signIn(@RequestBody User.SigninRequest request) {
    User user = userRepository.findByEmail(request.getEmail())
        .orElseThrow(EmailSignInFailedException::new);

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
      throw new EmailSignInFailedException();
    }

    return responseService.getSingleResponse(jwtTokenProvider
        .createToken(String.valueOf(user.getId()), user.getRoles()));
  }

  @PostMapping("/signup")
  public ResponseEntity<CommonResponse> signUp(@RequestBody User.SignupRequest request) {

    boolean emailExist = userRepository.findByEmail(request.getEmail()).isPresent();
    if (emailExist) {
      throw new EmailSignUpFailedException();
    }

    userRepository.save(User.builder()
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .username(request.getUsername())
        .roles(Collections.singletonList("ROLE_USER"))
        .build());

    return responseService.getSuccessResponse();
  }

  @GetMapping("/whoami")
  public ResponseEntity<CommonResponse> test1(@AuthenticationPrincipal User user) {
    return responseService.getSingleResponse(user);
  }
}
