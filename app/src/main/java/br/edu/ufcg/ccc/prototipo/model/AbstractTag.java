package br.edu.ufcg.ccc.prototipo.model;

import java.util.List;

import io.requery.Column;
import io.requery.Entity;
import io.requery.Key;
import io.requery.ManyToMany;

@Entity
public abstract class AbstractTag {

    @Key
    @Column(unique = true, nullable = false)
    String title;

    @ManyToMany
    List<AbstractAtividade> atividades;
}
