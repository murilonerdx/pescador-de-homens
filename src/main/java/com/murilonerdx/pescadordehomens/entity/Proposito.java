package com.murilonerdx.pescadordehomens.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Proposito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDoProposito;
    private String motivoDoProposito;
    private int qtdDiasProposito;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Passagem> passagemDoProposito;
}
