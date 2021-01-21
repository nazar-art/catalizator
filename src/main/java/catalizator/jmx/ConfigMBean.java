package catalizator.jmx;

import catalizator.service.ConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.jmx.export.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author Nazar Lelyak.
 */
@Component
@RequiredArgsConstructor
@ManagedResource(description = "Application Config Bean")
public class ConfigMBean {

    private final ConfigService configService;


    @ManagedAttribute(description = "set reload attribute")
    public void setReloadPeriod(long reloadPeriod) {
        configService.setReloadPeriod(reloadPeriod);
    }

    @ManagedAttribute(description = "Get reload period")
    public long getReloadPeriod() {
        return configService.getReloadPeriod();
    }


    @ManagedOperation(description = "Get all config keys")
    public Collection<String> getConfigKey() {
        return configService.configKeys();
    }

    @ManagedOperation(description = "Get Config by key")
    @ManagedOperationParameters({
            @ManagedOperationParameter(name = "key", description = "Get a config value")
    })
    public String getConfig(String key) {
        return configService.getConfig(key);
    }

    @ManagedOperation(description = "Set a specific config")
    @ManagedOperationParameters({
            @ManagedOperationParameter(name = "key", description = "Config key"),
            @ManagedOperationParameter(name = "value", description = "Target Config value")
    })
    public void setConfig(String key, String value) {
        configService.setConfig(key, value);
    }


}
