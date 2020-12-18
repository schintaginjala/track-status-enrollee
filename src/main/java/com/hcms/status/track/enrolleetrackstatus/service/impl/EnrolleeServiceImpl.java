package com.hcms.status.track.enrolleetrackstatus.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.hcms.status.track.enrolleetrackstatus.dao.EnrolleeDao;
import com.hcms.status.track.enrolleetrackstatus.enums.StatusEnum;
import com.hcms.status.track.enrolleetrackstatus.exception.InvalidDataException;
import com.hcms.status.track.enrolleetrackstatus.model.Enrollee;
import com.hcms.status.track.enrolleetrackstatus.service.EnrolleeService;
import com.hcms.status.track.enrolleetrackstatus.vo.EnrolleeRequest;
import com.hcms.status.track.enrolleetrackstatus.vo.EnrolleeVo;

@Service
public class EnrolleeServiceImpl implements EnrolleeService {

	@Autowired
	private EnrolleeDao enrolleeDao;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	/**
	 * To add or modify enrollee or dependents
	 * 
	 * @param enolleeRequest
	 * @return
	 */
	@Override
	public String add(EnrolleeRequest enrolleeRequest) {
		String status = StatusEnum.SUCCSS.toString();
		List<Enrollee> enrolleeList = new ArrayList<>();
		try {
			if (!CollectionUtils.isEmpty(enrolleeRequest.getEnrolleeList())) {
				enrolleeRequest.getEnrolleeList().forEach(enrolleeVo -> {
					if (StringUtils.isEmpty(enrolleeVo.getName())) {
						throw new RuntimeException("Invalid name");
					}
					if (StringUtils.isEmpty(enrolleeVo.getBirthDate())) {
						throw new RuntimeException("Invalid name");
					}
					Enrollee enrollee = new Enrollee();
					BeanUtils.copyProperties(enrolleeVo, enrollee);
					enrollee.setBirthDate(LocalDate.parse(enrolleeVo.getBirthDate(), formatter));
					enrollee.setStatus(Boolean.TRUE);
					enrolleeList.add(enrollee);
				});
			}
			enrolleeDao.add(enrolleeList);
		} catch (Exception e) {
			status = StatusEnum.FAIL.toString();
		}
		return status;
	}

	/**
	 * To remove enrollee and dependents
	 * 
	 * @param enrolleId
	 * @return
	 */
	@Override
	public String remove(String id) {
		String status = StatusEnum.SUCCSS.toString();
		try {
			enrolleeDao.remove(id);
		} catch (Exception e) {
			status = StatusEnum.FAIL.toString();
		}
		return status;
	}

	/**
	 * To remove only dependents
	 * 
	 * @param enrolleeId
	 * @return
	 */
	@Override
	public String removeDependents(String id) {
		String status = StatusEnum.SUCCSS.toString();
		try {
			enrolleeDao.removeDependents(id);
		} catch (Exception e) {
			status = StatusEnum.FAIL.toString();
		}
		return status;
	}

}
