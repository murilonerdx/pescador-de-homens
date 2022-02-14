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
public class Oracao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch=FetchType.EAGER)
    private List<Pessoa> oracaoPara;

    @OneToOne(fetch = FetchType.LAZY)
    private Proposito proposito;

    private String motivoOracao;
}
