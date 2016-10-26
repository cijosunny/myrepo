package com.ghis.service;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ghis.util.EmailUtil;

@Path("/rest")
public class GetHiredRestService {
	@GET
	@Path("/sendEmail")
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, String> sendEmail(@QueryParam("toEmail") String toEmail,
			@QueryParam("subject") String subject,
			@QueryParam("body") String body){
		int flag = EmailUtil.sendEmail(toEmail, subject, body);
		HashMap<String, String> result = new HashMap<>();
		if(flag>0){
			result.put("status", "success");
			result.put("msg", "Email sent succesfully");
		}
		else{
			result.put("status", "error");
			result.put("msg", "Some error occured");
		}
		return result;
	}
	
	
}
