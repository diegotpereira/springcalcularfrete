package br.spring.com.springcalcularfrete.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.spring.com.springcalcularfrete.dto.CotacaoEntregaDTO;
import br.spring.com.springcalcularfrete.dto.EncomendaDTO;
import br.spring.com.springcalcularfrete.model.Cep;
import br.spring.com.springcalcularfrete.model.CotacaoEntrega;
import br.spring.com.springcalcularfrete.model.Encomenda;
import br.spring.com.springcalcularfrete.repository.CotacaoEntregaRepository;

@Service
public class EncomendaService {

	@Autowired
	private CotacaoEntregaRepository repo;

	public Cep getCep(String cep) {
		String url = String.format("https://viacep.com.br/ws/%s/json", cep);
		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.getForObject(url, Cep.class);
	}

	public EncomendaDTO getEncomenda(EncomendaDTO encomendaDTO) {
		Cep cepOrigem = this.getCep(encomendaDTO.getCepOrigem());
		Cep cepDestino = this.getCep(encomendaDTO.getCepDestino());

		Encomenda encomenda = new Encomenda(encomendaDTO.getPeso(), cepOrigem, cepDestino, encomendaDTO.getNomeDestinatario());

		EncomendaDTO encomendaResponse = encomenda.createEncomendaDTO();
		CotacaoEntrega cotacaoEntrega = createCotacaoEntrega(encomenda);

		return encomendaResponse;
	}
	public CotacaoEntrega createCotacaoEntrega(Encomenda encomenda) {
		CotacaoEntrega cotacaoEntrega = new CotacaoEntrega();
		BeanUtils.copyProperties(encomenda, cotacaoEntrega);
		cotacaoEntrega.setDataConsulta(LocalDate.now());
		cotacaoEntrega.setCepDestino(encomenda.getCepDestino().getCep());

		return repo.save(cotacaoEntrega);
	}
	public List<CotacaoEntregaDTO> consultarTodasEntregas() {
		List<CotacaoEntrega> cotacoes = repo.findAll();

		return cotacoes.stream().map(cotacaoEntrega -> {
			CotacaoEntregaDTO cotacaoEntregaDTO = new CotacaoEntregaDTO();
			BeanUtils.copyProperties(cotacaoEntrega, cotacaoEntregaDTO);

			return cotacaoEntregaDTO;
		}).collect(Collectors.toList());
	}
}
