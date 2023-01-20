package com.example.mateuscesarapp.service;

import com.example.mateuscesarapp.model.Athlete;
import com.example.mateuscesarapp.model.Club;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/clubs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ClubService {
    @GET
    List<Club> getAllClubs();

    @GET
    @Path("/club/{id}")
    Club getClub(@PathParam("id") Long clubId);

    @POST
    @Path("/save")
    void saveClub(Club club);

    @DELETE
    @Path("/delete/{id}")
    void deleteClub(@PathParam("id") Long clubId);

    @DELETE
    @Path("/delete-clubs")
    void deleteAllClubs();

    @PUT
    @Path("/update-club/{id}")
    Club updateClub(@PathParam("id") Long clubId, Club club);

}
