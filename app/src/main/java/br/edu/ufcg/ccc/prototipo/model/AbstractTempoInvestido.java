package br.edu.ufcg.ccc.prototipo.model;

import java.util.Date;

import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;
import io.requery.ManyToOne;

@Entity
public abstract class AbstractTempoInvestido {

    @Key
    @Generated
    long id;

    Date date;

    int hours;

    @ManyToOne
    AbstractAtividade atividade;
}
