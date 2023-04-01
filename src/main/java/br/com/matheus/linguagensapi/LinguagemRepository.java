package br.com.matheus.linguagensapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.matheus.linguagensapi.Linguagem;

import java.util.List;

public interface LinguagemRepository extends MongoRepository<Linguagem, String> {

    List<Linguagem> findByOrderByRank();
}
