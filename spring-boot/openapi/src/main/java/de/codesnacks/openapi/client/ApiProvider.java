package de.codesnacks.openapi.client;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Configuration
@ConfigurationProperties(prefix = "provider")
public class ApiProvider {

	String url;
	int port;

	public String getRootUrl() {
		return url + ":" + port;
	}

	public String toUrl(String path) {
		return getRootUrl() + path;
	}
}
