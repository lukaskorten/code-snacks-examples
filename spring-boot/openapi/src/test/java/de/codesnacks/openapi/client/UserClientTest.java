package de.codesnacks.openapi.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import de.codesnacks.openapi.MockServerRunner;
import de.codesnacks.openapi.contract.Contract;
import de.codesnacks.openapi.contract.Contract.*;
import de.codesnacks.openapi.contract.ContractProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockServerRunner.class)
class UserClientTest {

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	UserClient userClient;

	@Autowired
	ContractProvider contractProvider;

	@Test
	void findUserByUsername() {

		Contract contract = contractProvider.getContract();
		OperationContract usersByNameContract = contract.getUsers().get(OperationId.USERS_BY_NAME);
		UseCase useCase = usersByNameContract.getUseCases().get(HttpStatus.OK);
		Request expectedRequest = useCase.getRequest();
		Response expectedResponse = useCase.getResponse();

		givenThat(get(urlMatching(expectedRequest.getPath()))
						  .willReturn(aResponse()
											  .withHeaders(expectedResponse.getHeaders())
											  .withStatus(expectedResponse.getStatus())
											  .withBody(expectedResponse.getBody().toString())));

		User john = userClient.findByUsername("john-doe");

		assertThat(john.getFirstName()).isEqualTo("John");
	}
}