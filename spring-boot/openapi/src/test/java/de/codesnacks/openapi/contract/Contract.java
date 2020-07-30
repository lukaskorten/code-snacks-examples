package de.codesnacks.openapi.contract;

import com.github.tomakehurst.wiremock.http.HttpHeaders;
import de.codesnacks.openapi.client.OperationId;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contract {

	Map<OperationId, OperationContract> users;

	public OperationContract forUsers(OperationId operationId) {
		return users.get(operationId);
	}

	@Data
	@NoArgsConstructor
	@FieldDefaults(level = AccessLevel.PRIVATE)
	public static class OperationContract {
		Map<Integer, UseCaseContract> useCases;

		public UseCaseContract forUseCase(HttpStatus status) {
			return useCases.get(status.value());
		}
	}

	@Data
	@NoArgsConstructor
	@FieldDefaults(level = AccessLevel.PRIVATE)
	public static class UseCaseContract {
		Request request;
		Response response;
	}

	@Data
	@NoArgsConstructor
	@FieldDefaults(level = AccessLevel.PRIVATE)
	public static class Request {
		String path;
		HttpHeaders headers;
		JSONObject body;
	}

	@Data
	@NoArgsConstructor
	@FieldDefaults(level = AccessLevel.PRIVATE)
	public static class Response {
		Integer status;
		HttpHeaders headers;
		JSONObject body;
	}
}
