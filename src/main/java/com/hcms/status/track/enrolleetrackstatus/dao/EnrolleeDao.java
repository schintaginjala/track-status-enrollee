package com.hcms.status.track.enrolleetrackstatus.dao;

import java.util.List;

import com.hcms.status.track.enrolleetrackstatus.model.Enrollee;

public interface EnrolleeDao {
	int add(List<Enrollee> enrollees);
	
	int remove(String id);
	
	int removeDependents(String enrolleeId);
}
