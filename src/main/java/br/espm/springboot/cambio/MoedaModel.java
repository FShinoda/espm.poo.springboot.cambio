package br.espm.springboot.cambio;

import javax.persistence.*;

import br.espm.springboot.cambio.common.datatype.Moeda;

@Entity
@Table(name = "meoda")
public class MoedaModel {

    @Id 
    @Column(name = "moeCodi")
    private String idMoeda;

    @Column(name = "moeNome")
    private String txNome;

    @Column(name = "moeSimb")
    private String txSimbolo;

    public MoedaModel(){ // Construtor vazio

    }

    public MoedaModel(Moeda m){
        this.idMoeda = m.getId();
        this.txNome = m.getNome();
        this.txSimbolo = m.getSimbolo();
    }

    public Moeda to(){
        Moeda m = new Moeda();
        m.setId(idMoeda);
        m.setNome(txNome);
        m.setSimbolo(txSimbolo);
        return m;
    }
    
}
