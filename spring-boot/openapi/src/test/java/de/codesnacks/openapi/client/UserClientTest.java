package de.codesnacks.openapi.client;

import de.codesnacks.openapi.MockServerRunner;
import de.codesnacks.openapi.contract.Contract;
import de.codesnacks.openapi.contract.Contract.Request;
import de.codesnacks.openapi.contract.Contract.Response;
import de.codesnacks.openapi.contract.Contract.UseCaseContract;
import de.codesnacks.openapi.contract.ContractProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.givenThat;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockServerRunner.class)
class UserClientTest {

	@Autowired
	UserClient userClient;

	@Autowired
	ContractProvider contractProvider;

	@Test
	void findUserByUsername() {

		Contract contract = contractProvider.getContract();
		UseCaseContract useCaseContract = contract.forUsers(OperationId.USERS_BY_NAME).forUseCase(HttpStatus.OK);

		Request expectedRequest = useCaseContract.getRequest();
		Response expectedResponse = useCaseContract.getResponse();

		givenThat(get(urlMatching(expectedRequest.getPath()))
						  .willReturn(aResponse()
											  .withHeaders(expectedResponse.getHeaders())
											  .withStatus(expectedResponse.getStatus())
											  .withBody(expectedResponse.getBody().toString())));

		User john = userClient.findByUsername("john-doe");

		assertThat(john.getFirstName()).isEqualTo("John");
	}
}