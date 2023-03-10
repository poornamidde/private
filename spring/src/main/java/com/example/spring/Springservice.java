package com.example.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class Springservice {
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public Map<String, Object> insert(Springpojo springpojo) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			String insertquery = "insert into emp (id,name,address) values(:id,:name,:address)";
			SqlParameterSource parameter = new MapSqlParameterSource().addValue("id", springpojo.getId())
					.addValue("name", springpojo.getName()).addValue("address", springpojo.getAddress());
			int result = namedParameterJdbcTemplate.update(insertquery, parameter);
			if (result > 0)
				response.put("success", "inserted");
			else
				response.put("fail", "not inserted");
		} catch (Exception e) {
			System.out.println(e);
		}

		return response;
	}

	public List<?> display() {
		String selectquery ="Select*from emp";
		SqlParameterSource a= new MapSqlParameterSource();
	
		return namedParameterJdbcTemplate.queryForList(selectquery, a);
	}

}
