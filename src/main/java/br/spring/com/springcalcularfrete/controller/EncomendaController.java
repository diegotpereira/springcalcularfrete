package br.spring.com.springcalcularfrete.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.spring.com.springcalcularfrete.dto.CotacaoEntregaDTO;
import br.spring.com.springcalcularfrete.dto.EncomendaDTO;
import br.spring.com.springcalcularfrete.service.EncomendaService;

@RestController
@RequestMapping("encomendas")
public class EncomendaController {

	@Autowired
	private EncomendaService service;

	@PostMapping
	public ResponseEntity<EncomendaDTO> consultarValorDataEntrega(@RequestBody EncomendaDTO encomendaRequestDTO) {
		EncomendaDTO encomendaResponse = service.getEncomenda(encomendaRequestDTO);

		return ResponseEntity.ok().body(encomendaResponse);
	}
	@GetMapping
	public ResponseEntity<List<CotacaoEntregaDTO>> consultarEntregas() {

		return ResponseEntity.ok().body(service.consultarTodasEntregas());
	}
}
