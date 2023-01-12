package com.example.mateuscesarapp.service;

import com.example.mateuscesarapp.model.Athlete;
import com.example.mateuscesarapp.repository.AthleteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Service
public class AthleteServiceImpl implements AthleteService {
    @Autowired
    AthleteRepo athleteRepo;

    @Override
    public List<Athlete> getAllAthletes(){
        List<Athlete> athletes = athleteRepo.findAll();
        return athletes;
    }

    @Override
    public Athlete getAthlete(Long athleteId) {
        return athleteRepo.findById(athleteId)
                .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @Override
    public void saveAthlete(Athlete athlete){
            athleteRepo.save(athlete);
    }

    @Override
    public void deleteAthlete(Long athleteId) {
        athleteRepo.deleteById(athleteId);
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
