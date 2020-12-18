package com.hcms.status.track.enrolleetrackstatus.vo;

import java.io.Serializable;
import java.util.List;

public class EnrolleeRequest  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public List<EnrolleeVo> enrolleeList;

	public EnrolleeRequest() {

	}

	public List<EnrolleeVo> getEnrolleeList() {
		return enrolleeList;
	}

	public void setEnrolleeList(List<EnrolleeVo> enrolleeList) {
		this.enrolleeList = enrolleeList;
	}

}
