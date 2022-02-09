package br.spring.com.springcalcularfrete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.spring.com.springcalcularfrete.model.CotacaoEntrega;

@Repository
public interface CotacaoEntregaRepository extends JpaRepository<CotacaoEntrega, Long>{
	
}
