package com.hcms.status.track.enrolleetrackstatus.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.hcms.status.track.enrolleetrackstatus.service.EnrolleeService;
import com.hcms.status.track.enrolleetrackstatus.vo.EnrolleeRequest;
import com.hcms.status.track.enrolleetrackstatus.vo.EnrolleeVo;

@WebMvcTest(EnrolleeController.class)
public class EnrolleeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EnrolleeService enrolleService;

	@Test
	public void testGetStatus() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/health").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());

	}

	@Test
	public void testRemoveEnrolleEntirely() throws Exception {
		when(enrolleService.remove(any())).thenReturn("SUCCESS");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/remove-enrollee-entirely/{enrolleId}", 1)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
		String content = result.getResponse().getContentAsString();
		assertEquals("SUCCESS", content);
	}

	@Test
	public void testRemoveDependents() throws Exception {
		when(enrolleService.removeDependents(any())).thenReturn("SUCCESS");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/remove-dependents/{enrolleId}", 1)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
		String content = result.getResponse().getContentAsString();
		assertEquals("SUCCESS", content);
	}

	@Test
	public void testAdd() throws Exception {
		when(enrolleService.add(any())).thenReturn("SUCCESS");
		EnrolleeVo enrolleeVo = new EnrolleeVo();
		enrolleeVo.setId("1");
		enrolleeVo.setName("Test");
		EnrolleeRequest enrolleeRequest = new EnrolleeRequest();
		List<EnrolleeVo> voList = new ArrayList<>();
		voList.add(enrolleeVo);
		enrolleeRequest.setEnrolleeList(voList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/add-or-modify-enrollee-or-dependents")
				.content("{\r\n" + "   \"enrolleeList\":[\r\n" + "      {\r\n"
						+ "         \"name\":\"Deborah  Mccoy\",\r\n" + "         \"birthDate\":\"05/15/1983\",\r\n"
						+ "         \"phoneNumber\":\"5512207824\"\r\n" + "      }\r\n" + "   ]\r\n" + "} ")
				.contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
		String content = result.getResponse().getContentAsString();
		assertEquals("SUCCESS", content);
	}
}
