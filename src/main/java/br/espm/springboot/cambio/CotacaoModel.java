package br.espm.springboot.cambio;

import javax.persistence.Entity;

import br.espm.springboot.cambio.common.datatype.Cotacao;
import br.espm.springboot.cambio.common.datatype.Moeda;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="cotacao")
public class CotacaoModel {

    @Id
    @Column(name = "cotCodi")
    private String idCotacao;

    @Column(name = "moeCodi")
    private String idMoeda;

    @Column(name= "cotData")
    @Temporal(TemporalType.DATE)
    private Date dtData;

    @Column(name= "cotValor")
    private BigDecimal vrValor;

    public CotacaoModel(){ // Construtor vazio
        
    }

    public CotacaoModel(Cotacao c){ // Construtor banco
        this.idCotacao = c.getId();
        this.idMoeda = c.getMoeda().getId();
        this.dtData = c.getData();
        this.vrValor = c.getValor();
    }

    public Cotacao to(){ // Cria cotacao
        Moeda m = new Moeda();
        m.setId(idMoeda);

        Cotacao c = new Cotacao();
        c.setId(idCotacao);
        c.setMoeda(m);
        c.setData(dtData);
        c.setValor(vrValor);
        return c;
    }
    
}
