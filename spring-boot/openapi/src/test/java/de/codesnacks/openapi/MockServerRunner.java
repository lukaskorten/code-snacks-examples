package de.codesnacks.openapi;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import de.codesnacks.openapi.client.ApiProvider;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

public class MockServerRunner implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback {

	private WireMockServer wireMockServer;


	@Override
	public void beforeAll(ExtensionContext extensionContext) {
		wireMockServer = new WireMockServer(wireMockConfiguration(extensionContext));
		wireMockServer.start();
		WireMock.configureFor(wireMockServer.port());
	}

	private WireMockConfiguration wireMockConfiguration(ExtensionContext extensionContext) {
		ApiProvider providerProperties = getProviderProperties(extensionContext);
		return WireMockConfiguration.wireMockConfig().port(providerProperties.getPort());
	}

	private ApiProvider getProviderProperties(ExtensionContext extensionContext) {
		ApplicationContext ac = SpringExtension.getApplicationContext(extensionContext);
		return ac.getBean(ApiProvider.class);
	}

	@Override
	public void beforeEach(ExtensionContext extensionContext) {
		WireMock.reset();
	}

	@Override
	public void afterAll(ExtensionContext extensionContext) throws Exception {
		wireMockServer.stop();
	}
}
