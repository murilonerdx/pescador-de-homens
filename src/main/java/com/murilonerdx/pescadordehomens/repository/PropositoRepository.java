package com.murilonerdx.pescadordehomens.repository;

import com.murilonerdx.pescadordehomens.entity.Passagem;
import com.murilonerdx.pescadordehomens.entity.Proposito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropositoRepository extends JpaRepository<Proposito, Long> {
}
