package com.example.mateuscesarapp.repository;

import com.example.mateuscesarapp.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepo extends JpaRepository<Club,Long> {
}
