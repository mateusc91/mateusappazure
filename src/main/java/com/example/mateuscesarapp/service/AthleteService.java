package com.example.mateuscesarapp.service;

import com.example.mateuscesarapp.dto.AthleteDTO;
import com.example.mateuscesarapp.entity.Athlete;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/athletes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public interface AthleteService {
    @GET
    List<AthleteDTO> getAllAthletes();
    @GET
    @Path("/athlete/{id}")
    Athlete getAthlete(@PathParam("id") Long athleteId);
    @POST
    @Path("/save")
    void saveAthlete(AthleteDTO athlete);

    @DELETE
    @Path("/delete/{id}")
    void deleteAthlete(@PathParam("id") Long athleteId);

    @DELETE
    @Path("/delete-athletes")
    void deleteAllAthletes();

    @PUT
    @Path("/update-athlete/{id}")
    Athlete updateAthlete(@PathParam("id") Long athleteId, Athlete athlete);

}
