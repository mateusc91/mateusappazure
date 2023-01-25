package com.example.mateuscesarapp.service;

import com.example.mateuscesarapp.dto.ClubDTO;
import com.example.mateuscesarapp.entity.Club;
import com.example.mateuscesarapp.repository.ClubRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClubServiceImpl implements ClubService {
    @Autowired
    ClubRepo clubRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ClubDTO> getAllClubs() {
        return clubRepo.findAll().stream().map(club -> modelMapper.map(club, ClubDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClubDTO getClub(Long clubId) {
        Club club = clubRepo.findById(clubId).orElse(null);

        ClubDTO clubMapped = modelMapper.map(club, ClubDTO.class);

        return clubMapped;
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
