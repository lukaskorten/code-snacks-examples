package com.codesnacks.multipart;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UploadTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	void uploadFile() throws Exception {
		String json = new JSONObject().put("foo", "Hallo").put("bar", "Welt").toString();
		mockMvc.perform(multipart("/upload")
								.file(new MockMultipartFile("request", "request.json", "application/json", json.getBytes()))
								.file(new MockMultipartFile("file", "data".getBytes()))
								.contentType(MediaType.MULTIPART_FORM_DATA))
			   .andExpect(status().isOk());
	}
}