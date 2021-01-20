package catalizator.service;

import lombok.RequiredArgsConstructor;
import catalizator.domain.Message;
import catalizator.repo.MessageRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Nazar Lelyak.
 */
@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepo messageRepo;

    public Flux<Message> list() {
        return messageRepo.findAll();
    }

    public Mono<Message> addOne(Message message) {
        return messageRepo.save(message);
    }

}
