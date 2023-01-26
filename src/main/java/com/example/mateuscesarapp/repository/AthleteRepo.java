package com.example.mateuscesarapp.repository;

import com.example.mateuscesarapp.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.ws.rs.QueryParam;
import java.util.List;

@Repository
public interface AthleteRepo extends JpaRepository<Athlete,Long> {
    List<Athlete> findAthletesByClub_ClubId(@QueryParam("clubId") Long clubId);
}
