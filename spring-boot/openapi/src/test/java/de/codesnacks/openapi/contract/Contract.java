package de.codesnacks.openapi.contract;

import com.github.tomakehurst.wiremock.http.HttpHeaders;
import de.codesnacks.openapi.client.OperationId;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contract {

	Map<OperationId, OperationContract> users;

	@Data
	@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
	public static class OperationContract {

		OperationId operationId;
		Map<HttpStatus, UseCase> useCases;
	}

	@Data
	@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
	public static class UseCase {
		Request request;
		Response response;
	}

	@Data
	@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
	public static class Request {
		String path;
		HttpHeaders headers;
		JSONObject body;
	}

	@Data
	@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
	public static class Response {
		int status;
		HttpHeaders headers;
		JSONObject body;
	}
}
