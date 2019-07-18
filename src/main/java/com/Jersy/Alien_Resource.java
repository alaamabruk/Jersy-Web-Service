package com.Jersy;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("aliens")
public class Alien_Resource {
	
	Alien_Repositry repo = new Alien_Repositry(); 
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Alien> get_alien() {
		
		System.out.println(repo.get_Aliens());
		return repo.get_Aliens();
	}
	
	
	@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien get_alien(@PathParam("id") int id) {
	
		return repo.get_Alien(id);
	}
	
	
	
	@POST
	@Path("alienC")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien Add_alien(Alien a3) {
	
		System.out.println(a3);
		repo.create(a3);
		return a3;
	}

	
	@PUT
	@Path("alienU")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien update_alien(Alien a3) {
	
		System.out.println(a3);
		if(repo.get_Alien(a3.getId()).getId() == 0) {
			repo.create(a3);
		}
		else
		repo.update(a3);
		return a3;
	}
	
	
	@DELETE
	@Path("alienD/{id}")
    public Alien delete_alien(@PathParam ("id") int id) {
	
		Alien a =  repo.get_Alien(id); 
		if(a.getId()!=0)
		repo.delete(id);
		return a;
	}
	
}
