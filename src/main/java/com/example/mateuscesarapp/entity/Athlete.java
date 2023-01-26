package com.example.mateuscesarapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Athlete {
    @Id
    @SequenceGenerator(
            name="athlete_sequence",
            sequenceName="athlete_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "athlete_sequence"
    )
    private Long athleteId;
    private String name;
    private String dob;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE})
    @JoinColumn(name="clubId")
    @JsonIgnore
    private Club club;
}
