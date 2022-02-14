package com.murilonerdx.pescadordehomens.dto;

import com.murilonerdx.pescadordehomens.entity.Pessoa;
import com.murilonerdx.pescadordehomens.entity.Proposito;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OracaoDTO {
    private Long id;
    private List<Integer> pessoaIds;

    @NotNull
    private Long propositoId;

    @NotEmpty(message="O motivo da oração não pode estar vazio")
    private String motivoOracao;
}
