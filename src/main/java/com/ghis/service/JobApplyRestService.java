package com.ghis.service;

import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.ghis.model.JobApplicationModel;
import com.ghis.util.HibernateUtil;

@Path("/jobapplications")
public class JobApplyRestService {
	@POST
	@Path("/apply")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, String> addJobApplicationModel(JobApplicationModel jobApplicationModel){
		System.out.println(jobApplicationModel);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(jobApplicationModel);
		session.getTransaction().commit();
		session.close();
		
		HashMap<String, String> result = new HashMap<>();
		result.put("status", "success");
		result.put("msg", "Job Application Submitted");
		return result;
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public JobApplicationModel getJobApplicationModel(@PathParam("id") String id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		JobApplicationModel jobApplicationModel = (JobApplicationModel) session.createQuery("FROM JOB_APPLICATION_MODEL WHERE applicationId=?").setString(0, id).uniqueResult();
		session.close();
		return jobApplicationModel;
	}
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<JobApplicationModel> getJobApplicationModels(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<JobApplicationModel> jobApplicationModels = session.createQuery("FROM JOB_APPLICATION_MODEL").list();
		session.close();
		return jobApplicationModels;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, String> deleteJobApplicationModel(@PathParam("id") String id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		int flag = session.createQuery("DELETE FROM JOB_APPLICATION_MODEL WHERE applicationId=?").setString(0, id).executeUpdate();
		session.getTransaction().commit();
		session.close();

		HashMap<String, String> result = new HashMap<>();
		if(flag>0){
			result.put("status", "success");
			result.put("msg", "Deleted succesfully");
		}
		else{
			result.put("status", "error");
			result.put("msg", "Delete error occured");
		}
		return result;
	}
}
