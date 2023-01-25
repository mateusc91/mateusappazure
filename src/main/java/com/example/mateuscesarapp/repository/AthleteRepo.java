package com.example.mateuscesarapp.repository;

import com.example.mateuscesarapp.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepo extends JpaRepository<Athlete,Long> {
}
