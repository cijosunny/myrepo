package com.cs.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rest")
public class AppService {
	@GET
	@Path("/version")
	public String showVersion(){
		return "Method: GET \nJersey Version:2.23.2";
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
