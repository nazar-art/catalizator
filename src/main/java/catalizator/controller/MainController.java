package catalizator.controller;

import lombok.RequiredArgsConstructor;
import catalizator.domain.Message;
import catalizator.service.MessageService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Nazar Lelyak.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/controller")
public class MainController {

    private final MessageService messageService;

    @GetMapping
    public Flux<Message> list(
            @RequestParam(defaultValue = "0") Long start,
            @RequestParam(defaultValue = "3") Long count
    ) {
        return messageService.list();
    }

    @PostMapping
    public Mono<Message> add(@RequestBody Message message) {
        return messageService.addOne(message);
    }
}
