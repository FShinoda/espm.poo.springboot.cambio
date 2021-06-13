package br.espm.springboot.cambio;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CotacaoRepository extends CrudRepository<CotacaoModel, String> {
    @Override
    Iterable<CotacaoModel> findAll();

    @Override
    Optional<CotacaoModel> findById(String s);

    @Query("SELECT c from CotacaoModel c WHERE c.idMoeda = :idMoeda AND c.dtData <= :data ORDER BY c.dtData DESC")
    List<CotacaoModel> listByMoedaData(
            @Param("idMoeda") String idMoeda,
            @Param("data") Date data);

    @Query("SELECT c FROM CotacaoModel c " +
            "WHERE " +
            "(c.idMoeda is null or c.idMoeda = :idMoeda) AND " +
            "(c.dtData is null or c.dtData >= :dtInicio) AND " +
            "(c.dtData is null or c.dtData <= :dtFim)"
    )
    List<CotacaoModel> listBy(
            @Param("idMoeda") String idMoeda,
            @Param("dtInicio") Date dtInicio,
            @Param("dtFim") Date dtFim
    );
}
