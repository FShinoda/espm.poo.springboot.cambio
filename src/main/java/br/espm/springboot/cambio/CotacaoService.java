package br.espm.springboot.cambio;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.espm.springboot.cambio.common.datatype.Cotacao;

@Component
public class CotacaoService {

    @Autowired
    private MoedaService moedaService;

    @Autowired 
    private CotacaoRepository cotacaoRepository;


    public Cotacao findById(String id){
        return fill(
                cotacaoRepository
                        .findById(id)
                        .map(CotacaoModel::to)
                        .orElse(null)
        );
    }

    public Cotacao findBy(String idMoeda, Date data) {
        Cotacao cotacao = cotacaoRepository
                .listByMoedaData(idMoeda, data).stream()
                .map(CotacaoModel::to)
                .findFirst()
                .orElse(null);
        // relacionamento
        return fill(cotacao);            
    }

    public List<Cotacao> listBy(String idMoeda, Date dtInicio, Date dtFim) {
        return cotacaoRepository
                .listBy(idMoeda, dtInicio, dtFim).stream()
                .map(CotacaoModel::to)
                .collect(Collectors.toList());
    }

    private Cotacao fill(Cotacao c) {
        if (c != null) {
            c.setMoeda(moedaService.findBy(UUID.fromString(c.getMoeda().getId())));
        }
        return c;
    }

    
}
