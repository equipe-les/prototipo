package br.edu.ufcg.ccc.prototipo.model;

import java.util.Date;
import java.util.List;

import io.requery.Entity;
import io.requery.Generated;
import io.requery.JunctionTable;
import io.requery.Key;
import io.requery.ManyToMany;
import io.requery.OneToMany;

@Entity
public abstract class AbstractAtividade {

    @Key
    @Generated
    long id;

    String photo;
    Date createdAt;

    @OneToMany
    List<AbstractTempoInvestido> TIs;

    @JunctionTable
    @ManyToMany
    List<AbstractTag> tags;
}
