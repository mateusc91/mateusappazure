package com.example.mateuscesarapp.dto;

import com.example.mateuscesarapp.entity.Athlete;
import com.example.mateuscesarapp.entity.Club;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ClubDTO {

    private Long clubId;
    private String clubName;
    private String coach;
    private List<Athlete> athletes;
}
