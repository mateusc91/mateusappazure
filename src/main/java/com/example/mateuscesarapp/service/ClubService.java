package com.example.mateuscesarapp.service;

import com.example.mateuscesarapp.dto.ClubDTO;
import com.example.mateuscesarapp.entity.Club;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/clubs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public interface ClubService {
    @GET
    List<ClubDTO> getAllClubs();
    @GET
    @Path("/club/{id}")
    ClubDTO getClub(@PathParam("id") Long clubId);

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
