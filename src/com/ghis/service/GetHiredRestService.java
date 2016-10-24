package com.ghis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ghis.model.User;
import com.ghis.util.SendEmail;

@Path("/rest")
public class GetHiredRestService {
	@GET
	@Path("/sendEmail")
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, String> sendEmail(@QueryParam("toEmail") String toEmail,
			@QueryParam("subject") String subject,
			@QueryParam("body") String body){
		int flag = SendEmail.sendEmail(toEmail, subject, body);
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
	
	
	@GET
	@Path("/versioninjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> showVersions(){
		List<String> versions = new ArrayList<>();
		versions.add("GET");
		versions.add("v2.23.2");
		
		
		
		
		User user = new User();
		user.setUserID("U45310");
		user.setName("CIJO");
		return versions;
	}
}
