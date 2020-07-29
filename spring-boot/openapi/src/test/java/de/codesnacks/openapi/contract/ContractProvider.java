package de.codesnacks.openapi.contract;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class ContractProvider {

	@Value("classpath:contract/users.json")
	Resource resource;

	final ObjectMapper objectMapper;

	public Contract getContract() {
		try {
			return objectMapper.readValue(resource.getFile(), Contract.class);
		} catch (IOException e) {
			throw new IllegalStateException("Fehler beim Lesen des Contracts...", e);
		}
	}

}
