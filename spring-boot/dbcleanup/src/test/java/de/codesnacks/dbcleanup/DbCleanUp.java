package de.codesnacks.dbcleanup;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

public class DbCleanUp implements BeforeAllCallback, BeforeEachCallback {

	DbCleanUpService cleanUpService;

	@Override
	public void beforeAll(ExtensionContext context) {
		ApplicationContext applicationContext = SpringExtension.getApplicationContext(context);
		cleanUpService = applicationContext.getBean(DbCleanUpService.class);
	}

	@Override
	public void beforeEach(ExtensionContext context) {
		cleanUpService.cleanUp();
	}
}
