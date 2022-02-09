package br.spring.com.springcalcularfrete.dto;

import java.time.LocalDate;

import lombok.*;

@Data
@NoArgsConstructor
public class CotacaoEntregaDTO {
	
	private Double peso;
	private String cepOrigem;
	private String cepDestino;
	private String nomeDestinatario;
	private Double vlTotalFrete;
	private LocalDate  dataPrevistaEntrega;
	private LocalDate dataConsulta;
}
