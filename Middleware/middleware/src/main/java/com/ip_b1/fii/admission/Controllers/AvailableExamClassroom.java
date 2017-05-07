package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.ServerProperties;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.AvailableExamClassromEntity;
import com.ip_b1.fii.admission.DTO.ClassroomInEntity;

import com.ip_b1.fii.admission.Utils.AuthUtils;

@RestController
@RequestMapping("/controller/available_classroom")
public class AvailableExamClassroom {

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AvailableExamClassromEntity> getClassRoomById(@RequestBody ClassroomInEntity classroom) {

		if (AuthUtils.checkAuth(classroom.getAuth())) {
			return new ResponseEntity<AvailableExamClassromEntity>(new AvailableExamClassromEntity(),
					HttpStatus.UNAUTHORIZED);
		}

		RestTemplate template = new RestTemplate();

		ResponseEntity<AvailableExamClassromEntity> entity = template.getForEntity(
				"/get_by_id_available_classroom/?classID={classID}", AvailableExamClassromEntity.class,
				classroom.getClassroomId());

		if (entity.getBody().getClass() == null) {
			return new ResponseEntity<AvailableExamClassromEntity>(new AvailableExamClassromEntity(),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AvailableExamClassromEntity>(entity.getBody(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<List<AvailableExamClassromEntity>> getAllClassrooms(@RequestBody AuthEntity authEntity) {

		if (AuthUtils.checkAuth(authEntity)) {
			return new ResponseEntity<List<AvailableExamClassromEntity>>(HttpStatus.UNAUTHORIZED);
		}

		RestTemplate template = new RestTemplate();

		ResponseEntity<List<AvailableExamClassromEntity>> entity = template.exchange("/get_all_available_classroom/",
				HttpMethod.POST, null, new ParameterizedTypeReference<List<AvailableExamClassromEntity>>() {
				});

		if (entity.getBody().getClass() == null) {
			return new ResponseEntity<List<AvailableExamClassromEntity>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AvailableExamClassromEntity>>(entity.getBody(), HttpStatus.OK);
	}
}
