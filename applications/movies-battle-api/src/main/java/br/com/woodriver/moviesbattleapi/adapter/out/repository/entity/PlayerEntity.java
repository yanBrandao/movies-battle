package br.com.woodriver.moviesbattleapi.adapter.out.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "Players")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerEntity {
    @Id
    String id;
    String name;
    @OneToMany(mappedBy = )
    List<BattleEntity> battles;
}
