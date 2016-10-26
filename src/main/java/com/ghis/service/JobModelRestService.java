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

import com.ghis.model.JobModel;
import com.ghis.util.HibernateUtil;

@Path("/job")
public class JobModelRestService {
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, String> addJobModel(JobModel jobModel){
		System.out.println(jobModel);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(jobModel);
		session.getTransaction().commit();
		session.close();
		
		HashMap<String, String> result = new HashMap<>();
		result.put("status", "success");
		result.put("msg", "New Job Added");
		return result;
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public JobModel getJobModel(@PathParam("id") String id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		JobModel resultJobModel = (JobModel) session.createQuery("FROM JOB_MODEL WHERE id=?").setString(0, id).uniqueResult();
		session.close();
		return resultJobModel;
	}
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<JobModel> getJobModels(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<JobModel> jobModels = session.createQuery("FROM JOB_MODEL").list();
		session.close();
		return jobModels;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, String> deleteJobModel(@PathParam("id") String id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		int flag = session.createQuery("DELETE FROM JOB_MODEL WHERE id=?").setString(0, id).executeUpdate();
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
