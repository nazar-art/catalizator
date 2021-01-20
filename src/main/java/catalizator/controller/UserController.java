package catalizator.controller;

import lombok.RequiredArgsConstructor;
import catalizator.config.JwtUtil;
import catalizator.domain.User;
import catalizator.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author Nazar Lelyak.
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final static ResponseEntity<Object> UNAUTHORIZED = ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .build();

    private final JwtUtil jwtUtil;
    private final UserService userService;

    @PostMapping("/login")
    public Mono<ResponseEntity<?>> login(ServerWebExchange swe) {
        return swe.getFormData().flatMap(credentials ->
                userService.findByUsername(credentials.getFirst("username"))
                        .cast(User.class)
                        .map(userDetails ->
                                Objects.equals(
                                        credentials.getFirst("password"),
                                        userDetails.getPassword()
                                )
                                        ? ResponseEntity.ok(jwtUtil.generateToken(userDetails))
                                        : UNAUTHORIZED
                        )
                        .defaultIfEmpty(UNAUTHORIZED)
        );
    }

}
