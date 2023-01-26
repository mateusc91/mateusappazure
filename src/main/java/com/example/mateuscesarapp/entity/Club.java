package com.example.mateuscesarapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
            strategy = GenerationType.IDENTITY,
            generator = "club_sequence"
    )
    private Long clubId;
    private String clubName;
    private String coach;
    @OneToMany(mappedBy = "club",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Athlete> athletes = new HashSet<>() ;
}
