package catalizator.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Nazar Lelyak.
 */
@Service
public class ConfigService {
    @Getter
    @Setter
    private long reloadPeriod = 300L;

    private final Map<String, String> config = new ConcurrentHashMap<>();

    public Collection<String> configKeys() {
        return new ArrayList<>(config.keySet());
    }

    public String getConfig(String key) {
        return config.get(key);
    }

    public void setConfig(String key, String value) {
        config.put(key, value);
    }


}
