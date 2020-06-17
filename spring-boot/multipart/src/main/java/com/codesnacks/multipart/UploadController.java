package com.codesnacks.multipart;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UploadController {

	@PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> upload(@RequestPart("request") RequestDTO data, @RequestPart(
			"file") MultipartFile file) {
		log.info("uploaded data: '{}'", data);
		log.info("uploaded file - name: '{}', content-type: '{}'", file.getName(), file.getContentType());
		return ResponseEntity.ok().build();
	}
}
