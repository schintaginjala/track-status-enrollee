package com.hcms.status.track.enrolleetrackstatus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcms.status.track.enrolleetrackstatus.service.EnrolleeService;
import com.hcms.status.track.enrolleetrackstatus.vo.EnrolleeRequest;
/**
 * This class provides RESTful services for enrollee and dependents managenent.
 * @author Sreenivas Chintaginjala
 *
 */
@RestController
public class EnrolleeController {

	@Autowired
	private EnrolleeService enrolleeService;

	/**
	 * To get health of the application
	 * @return
	 */
	@GetMapping("/health")
	public String getStatus() {
		return "ok";
	}

	/**
	 * To add or modify enrollee or dependents
	 * @param enolleeRequest
	 * @return
	 */
	@PostMapping("/add-or-modify-enrollee-or-dependents")
	public String add(@RequestBody EnrolleeRequest enolleeRequest) {
		return enrolleeService.add(enolleeRequest);
	}

	/**
	 * To remove enrollee and dependents
	 * @param enrolleId
	 * @return
	 */
	@DeleteMapping("/remove-enrollee-entirely/{enrolleId}")
	public String remove(@PathVariable String enrolleId) {
		return enrolleeService.remove(enrolleId);
	}

	/**
	 * To remove only dependents
	 * @param enrolleeId
	 * @return
	 */
	@DeleteMapping("/remove-dependents/{enrolleeId}")
	public String removeDependents(@PathVariable String enrolleeId) {
		return enrolleeService.removeDependents(enrolleeId);
	}

}
