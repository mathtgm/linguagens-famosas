package br.com.matheus.linguagensapi;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LinguagemController {

    @Autowired
    LinguagemRepository linguagemRepository;

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        return linguagemRepository.findByOrderByRank();
    }

    @GetMapping("/linguagens/{id}")
    public List<Linguagem> obterLinguagens(@PathVariable String id) {
        return linguagemRepository.findAll();
    }

    @PostMapping("/linguagens")
    public ResponseEntity<Linguagem> cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        return ResponseEntity.status(201).body(linguagemRepository.save(linguagem));

    }

    @DeleteMapping(value = "/linguagens/{id}")
    public ResponseEntity<Linguagem> removerImagem(@PathVariable String id) {
        Linguagem linguagem = linguagemRepository.findById(id).get();
        linguagemRepository.deleteById(id);
        return ResponseEntity.ok().body(linguagem);
    }

    @PutMapping("/linguagens/")
    public ResponseEntity<Linguagem> atualizarLinguagem(@RequestBody Linguagem linguagem) {
        return ResponseEntity.ok().body(linguagemRepository.save(linguagem));

    }

}
