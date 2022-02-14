package com.murilonerdx.pescadordehomens.controller;

import com.murilonerdx.pescadordehomens.entity.Passagem;
import com.murilonerdx.pescadordehomens.repository.PassagemRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passagem")
@Api(tags = "Passagem Endpoint")
public class PassagemController {

    @Autowired
    private PassagemRepository passagemRepository;

    @GetMapping()
    public List<Passagem> findAll() {
        return passagemRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Passagem findById(@PathVariable("id") Long id) {
        return passagemRepository.findById(id).get();
    }

    @PostMapping()
    public Passagem create(@RequestBody Passagem passagem) {
        return passagemRepository.save(passagem);
    }

    @PutMapping()
    public Passagem update(@RequestBody Passagem passagem) {
        return passagemRepository.save(passagem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        passagemRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
