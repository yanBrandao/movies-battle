package br.com.woodriver.moviesbattleapi.adapter.out.repository.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class PlayerEntity {
    @Id
    Integer id;
    @OneToMany(cascade = CascadeType.ALL)
    List<BattleEntity> battles;
}
