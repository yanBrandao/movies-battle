package br.com.woodriver.moviesbattleapi.adapter.out.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "Movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieEntity {
    @Id
    String id;
    String name;
    String bannerURL;
    String year;
    String director;
    BigDecimal rating;
}
