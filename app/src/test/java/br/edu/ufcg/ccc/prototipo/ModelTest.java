package br.edu.ufcg.ccc.prototipo;

import org.junit.Test;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.ufcg.ccc.prototipo.model.Atividade;
import br.edu.ufcg.ccc.prototipo.model.Tag;
import br.edu.ufcg.ccc.prototipo.model.TempoInvestido;

import static junit.framework.Assert.*;

public class ModelTest {
    @Test
    public void criaTiTest() {
        TempoInvestido t = new TempoInvestido();
        t.setHours(4);
        assertEquals(4, t.getHours());
    }

    @Test
    public void criaAtividadeTest() throws Exception {
        Atividade a = new Atividade();
        Logger.getAnonymousLogger().log(Level.INFO, String.valueOf(a.getId()));
        a.setCreatedAt(new Date());
        assertNotSame("As datas devem ser diferentes.", a.getCreatedAt(), new Date());
    }

    @Test
    public void integracaoEntreModels() throws Exception {
        Atividade a = new Atividade();

        Tag t = new Tag();
        t.setTitle("abc");
        a.getTags().add(t);

        assertFalse(a.getTags().isEmpty());
        assertTrue(a.getTags().contains(t));
    }
}
