package com.murilonerdx.pescadordehomens.repository;

import com.murilonerdx.pescadordehomens.entity.Oracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OracaoRepository  extends JpaRepository<Oracao, Long> {
}
