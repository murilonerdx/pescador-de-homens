package com.murilonerdx.pescadordehomens.controller;

import com.murilonerdx.pescadordehomens.dto.OracaoDTO;
import com.murilonerdx.pescadordehomens.entity.Oracao;
import com.murilonerdx.pescadordehomens.entity.Passagem;
import com.murilonerdx.pescadordehomens.entity.Pessoa;
import com.murilonerdx.pescadordehomens.entity.Proposito;
import com.murilonerdx.pescadordehomens.repository.OracaoRepository;
import com.murilonerdx.pescadordehomens.repository.PassagemRepository;
import com.murilonerdx.pescadordehomens.repository.PessoaRepository;
import com.murilonerdx.pescadordehomens.repository.PropositoRepository;
import com.murilonerdx.pescadordehomens.util.DozerConverter;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/oracao")
@Api(tags = "Oração Endpoint")
public class OracaoController {

    @Autowired
    private OracaoRepository oracaoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PropositoRepository propositoRepository;

    @GetMapping()
    public List<Oracao> findAll() {
        return oracaoRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Oracao findById(@PathVariable("id") Long id) {
        return oracaoRepository.findById(id).get();
    }

    @PostMapping()
    public Oracao create(@RequestBody OracaoDTO oracaoDTO) {
        List<Pessoa> pessoas = new ArrayList<>();
        Oracao oracao = DozerConverter.parseObject(oracaoDTO, Oracao.class);
        Proposito proposito = propositoRepository.findById(oracaoDTO.getPropositoId()).get();

        for(Integer id : oracaoDTO.getPessoaIds()){
            Pessoa pessoa = pessoaRepository.findById(Long.valueOf(id)).get();
            pessoas.add(pessoa);
        }
        oracao.setProposito(proposito);
        oracao.setOracaoPara(pessoas);
        return oracaoRepository.save(oracao);
    }

    @PutMapping()
    public Oracao update(@RequestBody OracaoDTO oracaoDTO) {
        Oracao oracao = DozerConverter.parseObject(oracaoDTO, Oracao.class);
        Proposito proposito = propositoRepository.findById(oracaoDTO.getPropositoId()).get();

        oracao.setProposito(proposito);
        return oracaoRepository.save(oracao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        oracaoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
