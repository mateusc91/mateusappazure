package com.example.mateuscesarapp.repository;

import com.example.mateuscesarapp.model.Athlete;
import com.example.mateuscesarapp.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepo extends JpaRepository<Club,Long> {
}
