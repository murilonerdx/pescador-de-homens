package com.murilonerdx.pescadordehomens.controller;

import com.murilonerdx.pescadordehomens.dto.PropositoDTO;
import com.murilonerdx.pescadordehomens.entity.Oracao;
import com.murilonerdx.pescadordehomens.entity.Passagem;
import com.murilonerdx.pescadordehomens.entity.Proposito;
import com.murilonerdx.pescadordehomens.repository.PassagemRepository;
import com.murilonerdx.pescadordehomens.repository.PropositoRepository;
import com.murilonerdx.pescadordehomens.util.DozerConverter;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/proposito")
@Api(tags = "Proposito Endpoint")
public class PropositoController {

    @Autowired
    private PropositoRepository propositoRepository;

    @Autowired
    private PassagemRepository passagemRepository;

    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<Proposito> findAll() {
        return propositoRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Proposito findById(@PathVariable("id") Long id) {
        return propositoRepository.findById(id).get();
    }

    @PostMapping()
    public Proposito create(@RequestBody PropositoDTO propositoDTO) {
        return getProposito(propositoDTO);
    }

    @PutMapping()
    public Proposito update(@RequestBody PropositoDTO propositoDTO) {
        return getProposito(propositoDTO);
    }

    private Proposito getProposito(@RequestBody PropositoDTO propositoDTO) {
        List<Passagem> listPassagens = new ArrayList<>();
        Proposito proposito = DozerConverter.parseObject(propositoDTO, Proposito.class);
        for(Integer id: propositoDTO.getPassagemDoPropositoIds()){
            Passagem passagem = passagemRepository.findById(Long.valueOf(id)).get();
            listPassagens.add(passagem);
        }
        proposito.setPassagemDoProposito(listPassagens);
        return propositoRepository.save(proposito);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        propositoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
