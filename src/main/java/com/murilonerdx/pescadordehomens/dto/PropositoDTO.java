package com.murilonerdx.pescadordehomens.dto;

import com.murilonerdx.pescadordehomens.entity.Passagem;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PropositoDTO {
    private Long id;
    private String nomeDoProposito;
    private String motivoDoProposito;
    private int qtdDiasProposito;
    private List<Integer> passagemDoPropositoIds;
}
