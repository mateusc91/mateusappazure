package com.example.mateuscesarapp.dto;

import com.example.mateuscesarapp.entity.Club;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class AthleteDTO {

    private Long athleteId;
    private String name;
    private String dob;
    private Club club;
}
