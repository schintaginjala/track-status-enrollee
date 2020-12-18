package com.hcms.status.track.enrolleetrackstatus.service;

import com.hcms.status.track.enrolleetrackstatus.vo.EnrolleeRequest;

public interface EnrolleeService {
	String add(EnrolleeRequest enrolleeRequest);

	String remove(String id);
	
	String removeDependents(String id);
}
