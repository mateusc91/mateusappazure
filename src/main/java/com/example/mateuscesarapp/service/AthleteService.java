package com.example.mateuscesarapp.service;

import com.example.mateuscesarapp.model.Athlete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/athletes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AthleteService {
    @GET
    List<Athlete> getAllAthletes();
    @GET
    @Path("/athlete/{id}")
    Athlete getAthlete(@PathParam("id") Long athleteId);
    @POST
    @Path("/save")
    void saveAthlete(Athlete athlete);

    @DELETE
    @Path("/delete/{id}")
    void deleteAthlete(@PathParam("id") Long athleteId);

    @PUT
    @Path("/update-athlete/{id}")
    Athlete updateAthlete(@PathParam("id") Long athleteId, Athlete athlete);

}
