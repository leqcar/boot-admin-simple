package org.efire.net;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "spring.cloud.discovery.client.simple")
public class InstancesProperties {

    private Map<String, String> instances;

    public Map<String, String> getInstances() {
        return instances;
    }

    public void setInstances(Map<String, String> instances) {
        this.instances = instances;
    }
}
