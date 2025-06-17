package com.github.arturflacon.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import com.github.arturflacon.backend.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
