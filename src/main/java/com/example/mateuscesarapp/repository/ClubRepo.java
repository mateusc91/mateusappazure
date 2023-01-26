package com.example.mateuscesarapp.repository;

import com.example.mateuscesarapp.entity.Athlete;
import com.example.mateuscesarapp.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepo extends JpaRepository<Club,Long> {

}
