package catalizator.service;

import lombok.RequiredArgsConstructor;
import catalizator.repo.UserRepo;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Nazar Lelyak.
 */
@Service
@RequiredArgsConstructor
public class UserService implements ReactiveUserDetailsService {

    private final UserRepo userRepo;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepo.findByUsername(username)
                .cast(UserDetails.class);
    }
}
