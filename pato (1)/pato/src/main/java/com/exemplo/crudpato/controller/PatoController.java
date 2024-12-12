package com.exemplo.crudpato.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.exemplo.crudpato.model.PatoCrud;
import com.exemplo.crudpato.repository.PatoRepository;

@RestController
@RequestMapping("/patos")
public class PatoController {

    private final PatoRepository patoRepository;

    public PatoController(PatoRepository patoRepository) {
        this.patoRepository = patoRepository;
    }

    //Criar um pato
    @PostMapping
    public PatoCrud criarPato(@RequestBody PatoCrud pato) {
        return patoRepository.save(pato);
    }

    //Listar os patos
    @GetMapping
    public List<PatoCrud> listarPatos() {
        return patoRepository.findAll();
    }

    //pato por ID
    @GetMapping("/{id}")
    public ResponseEntity<PatoCrud> buscarPato(@PathVariable Long id) {
        Optional<PatoCrud> pato = patoRepository.findById(id);
        return pato.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    //Atualizar pato
    @PutMapping("/{id}")
    public ResponseEntity<PatoCrud> atualizarPato(@PathVariable Long id, @RequestBody PatoCrud detalhesPato) {
        Optional<PatoCrud> patoExistente = patoRepository.findById(id);

        if (patoExistente.isPresent()) {
            PatoCrud pato = patoExistente.get();
            pato.setNome(detalhesPato.getNome());
            pato.setCor(detalhesPato.getCor());
            pato.setIdade(detalhesPato.getIdade());
            return ResponseEntity.ok(patoRepository.save(pato));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //deleta pato
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPato(@PathVariable Long id) {
        if (patoRepository.existsById(id)) {
            patoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
