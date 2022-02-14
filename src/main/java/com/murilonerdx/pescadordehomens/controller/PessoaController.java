package com.murilonerdx.pescadordehomens.controller;

import com.murilonerdx.pescadordehomens.entity.Passagem;
import com.murilonerdx.pescadordehomens.entity.Pessoa;
import com.murilonerdx.pescadordehomens.repository.PassagemRepository;
import com.murilonerdx.pescadordehomens.repository.PessoaRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
@Api(tags = "Pessoa Endpoint")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping()
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Pessoa findById(@PathVariable("id") Long id) {
        return pessoaRepository.findById(id).get();
    }

    @PostMapping()
    public Pessoa create(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @PutMapping()
    public Pessoa update(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        pessoaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
