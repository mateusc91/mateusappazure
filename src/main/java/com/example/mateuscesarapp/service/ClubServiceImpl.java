package com.example.mateuscesarapp.service;

import com.example.mateuscesarapp.model.Athlete;
import com.example.mateuscesarapp.model.Club;
import com.example.mateuscesarapp.repository.AthleteRepo;
import com.example.mateuscesarapp.repository.ClubRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

@Service
public class ClubServiceImpl implements ClubService {
    @Autowired
    ClubRepo clubRepo;

    @Override
    public List<Club> getAllClubs() {
        return clubRepo.findAll();
    }

    @Override
    public Club getClub(Long clubId) {
        return clubRepo.findById(clubId).orElse(null);
    }

    @Override
    public void saveClub(Club club) {
        clubRepo.save(club);
    }

    @Override
    public void deleteClub(Long clubId) {
        clubRepo.deleteById(clubId);
    }

    @Override
    public void deleteAllClubs() {
        clubRepo.deleteAll();
    }

    @Override
    public Club updateClub(Long clubId, Club newClub) {
        Club oldClub = clubRepo.findById(clubId)
                .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));

        oldClub.setClubName(newClub.getClubName());
        oldClub.setCoach(newClub.getCoach());

        clubRepo.save(oldClub);

        return oldClub;
    }
}
