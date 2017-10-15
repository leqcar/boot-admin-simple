package org.efire.net;

import de.codecentric.boot.admin.config.EnableAdminServer;
import de.codecentric.boot.admin.discovery.ApplicationDiscoveryListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.event.InstanceRegisteredEvent;
import org.springframework.context.ApplicationEventPublisher;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
@EnableAdminServer
public class BootAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootAdminApplication.class, args);
	}

	@Autowired
	private InstancesProperties instancesProperties;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@PostConstruct
	public void init() {
		Iterator<Map.Entry<String, String>> it = instancesProperties.getInstances().entrySet().iterator();
		while (instancesProperties.getInstances().entrySet().iterator().hasNext()) {
			eventPublisher.publishEvent(it.next().getKey());
		}
	}
}
