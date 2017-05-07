package com.ip_b1.fii.admission.Controllers;

import com.ip_b1.fii.admission.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.AvailableExamClassromEntity;
import com.ip_b1.fii.admission.Utils.AuthUtils;

@RestController
@RequestMapping("/controller/available_classroom")
public class AvailableExamClassroom {

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AvailableExamClassromEntity> getAllHalls(@RequestBody AuthEntity authEntity) {

		if (AuthUtils.checkAuth(authEntity)) {
			return new ResponseEntity<AvailableExamClassromEntity>(new AvailableExamClassromEntity(),
					HttpStatus.UNAUTHORIZED);
		}

		RestTemplate template = new RestTemplate();

		ResponseEntity<AvailableExamClassromEntity> entity = template.getForEntity(
				ServerProperties.modelUrl + "}/get_available_classroom", AvailableExamClassromEntity.class);

		if (entity == null) {
			return new ResponseEntity<AvailableExamClassromEntity>(new AvailableExamClassromEntity(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AvailableExamClassromEntity>(entity.getBody(),HttpStatus.OK);

	}
}
