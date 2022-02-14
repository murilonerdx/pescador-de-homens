package com.murilonerdx.pescadordehomens.repository;

import com.murilonerdx.pescadordehomens.entity.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagemRepository  extends JpaRepository<Passagem, Long> {
}
