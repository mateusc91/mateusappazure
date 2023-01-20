package com.example.mateuscesarapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Club {
    @Id
    @SequenceGenerator(
            name="club_sequence",
            sequenceName="club_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "club_sequence"
    )
    private Long id;
    private String clubName;
    private String coach;
}
