package catalizator.repo;

import catalizator.domain.Message;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author Nazar Lelyak.
 */
public interface MessageRepo extends ReactiveCrudRepository<Message, Long> {
}
