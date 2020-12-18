package com.hcms.status.track.enrolleetrackstatus.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.hcms.status.track.enrolleetrackstatus.dao.EnrolleeDao;
import com.hcms.status.track.enrolleetrackstatus.model.Enrollee;

@Repository
public class EnrolleeDaoImpl implements EnrolleeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int add(List<Enrollee> enrollees) {
		int result = 0;
		for (Enrollee enrollee : enrollees) {
			if (StringUtils.isEmpty(enrollee.getId())) {
				result = jdbcTemplate.update(
						"insert into enrollee (id, name, status, phone_no, primary_enrolle_id, birth_date) "
								+ "values(?, ?, ?, ?, ?, ?)",
						new Object[] { enrollee.getId(), enrollee.getName(), enrollee.isStatus(),
								enrollee.getPhoneNumber(), enrollee.getPrimaryEnrolleeId(), enrollee.getBirthDate() });
			} else {
				result = jdbcTemplate.update(
						"update enrollee set name = ?, status = ?, phone_no = ?, primary_enrolle_id = ?, birth_date = ? where id = ? ",
						new Object[] { enrollee.getName(), enrollee.isStatus(), enrollee.getPhoneNumber(),
								enrollee.getPrimaryEnrolleeId(), enrollee.getBirthDate(), enrollee.getId() });
			}
		}
		return result;
	}

	@Override
	public int remove(String id) {
		jdbcTemplate.update("delete from enrollee where primary_enrolle_id = ?", id);
		return jdbcTemplate.update("delete from enrollee where id = ?", id);
	}

	@Override
	public int removeDependents(String enrolleeId) {
		return jdbcTemplate.update("delete from enrollee where primary_enrolle_id = ?", enrolleeId);
	}

}
