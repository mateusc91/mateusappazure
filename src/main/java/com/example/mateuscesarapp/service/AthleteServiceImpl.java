package com.example.mateuscesarapp.service;

import com.example.mateuscesarapp.dto.AthleteDTO;
import com.example.mateuscesarapp.entity.Athlete;
import com.example.mateuscesarapp.entity.Club;
import com.example.mateuscesarapp.repository.AthleteRepo;
import com.example.mateuscesarapp.repository.ClubRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.currentTimeMillis;
import static javax.ws.rs.core.Response.Status.*;

@Service
@Transactional
public class AthleteServiceImpl implements AthleteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AthleteServiceImpl.class);
    @Autowired
    AthleteRepo athleteRepo;

    @Autowired
    ClubRepo clubRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Athlete> getAllAthletesFromClub(Long clubId){
        List<Athlete> allAthletesByClubId;

        allAthletesByClubId = athleteRepo.findAthletesByClub_ClubId(clubId);
             if(allAthletesByClubId.isEmpty()){
                 throw new WebApplicationException(Response
                         .status(NOT_FOUND)
                         .entity(new ErrorMessage("Club " + clubId + " does not have any athlete"))
                         .type(MediaType.APPLICATION_JSON_TYPE)
                         .build());
             }
        return allAthletesByClubId;
    }

    @Override
    public Athlete getAthlete(Long athleteId) {
        return athleteRepo.findById(athleteId)
                .orElseThrow( () -> new WebApplicationException(Response
                                .status(NOT_FOUND)
                                .entity(new ErrorMessage("The Athlete " + athleteId + " does not exist"))
                                .type(MediaType.APPLICATION_JSON_TYPE)
                                .build()));
    }

    @Override
    public void saveAthlete(AthleteDTO athlete){
        long timeStart = System.currentTimeMillis();

       clubRepo.findById(athlete.getClub().getClubId()).orElseThrow( () ->
         new WebApplicationException(Response
                .status(NOT_FOUND)
                .entity(new ErrorMessage("The club " + athlete.getClub().getClubId() + " does not exist"))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build()));
       try{
           Athlete athleteMapped= modelMapper.map(athlete, Athlete.class);
           athleteRepo.save(athleteMapped);
           LOGGER.info("Athlete saved successfully with " + (System.currentTimeMillis()-timeStart) + "ms");
       }catch (WebApplicationException e){
           throw new WebApplicationException(Response
                   .status(INTERNAL_SERVER_ERROR)
                   .entity("Athlete was not saved " + e.getMessage())
                   .type(MediaType.APPLICATION_JSON_TYPE)
                   .build());
       }
    }

    @Override
    public void deleteAthlete(Long athleteId) {
        athleteRepo.deleteById(athleteId);
    }

    @Override
    public void deleteAllAthletes() {
        athleteRepo.deleteAll();
    }

    @Override
    public Athlete updateAthlete(Long athleteId, Athlete newAthlete) {
        Athlete oldAthlete = athleteRepo.findById(athleteId)
                .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));

        oldAthlete.setName(newAthlete.getName());
        oldAthlete.setDob(newAthlete.getDob());

        athleteRepo.save(oldAthlete);

        return oldAthlete;
    }
}
