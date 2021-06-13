package br.espm.springboot.cambio;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.espm.springboot.cambio.common.controller.CambioController;
import br.espm.springboot.cambio.common.datatype.Cotacao;
import br.espm.springboot.cambio.common.datatype.Moeda;

@RestController
public class CambioResource implements CambioController {

    @Override
    public List<Moeda> listMoedas(){
        // Acessar database aqui
        List<Moeda> moedas = new ArrayList<>();
        Moeda m1 = new Moeda();
        m1.setId(UUID.randomUUID().toString());
        m1.setNome("real");
        m1.setSimbolo("R$");
        moedas.add(m1);
        Moeda m2 = new Moeda();
        m2.setId(UUID.randomUUID().toString());
        m2.setNome("dolar");
        m2.setSimbolo("USD");
        moedas.add(m2);
        return moedas;
    }

    @Override
    public Cotacao getCotacao(String id){
        return null;
    }

    @Override
    public List<Cotacao> listCotacoes(String moeda){
        return null;
    }
}
