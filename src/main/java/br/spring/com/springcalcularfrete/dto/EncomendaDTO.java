package br.spring.com.springcalcularfrete.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@NoArgsConstructor
public class EncomendaDTO {
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Double peso;
	private String cepOrigem;
	private String cepDestino;
	private String nomeDestinatario;
	private Double vlTotalFrete;
	private LocalDate dataPrevistaEntrega;

	public EncomendaDTO(String cepOrigem, String cepDestino, 
	String nomeDestinatario, Double vlTotalFrete, LocalDate dataPrevistaEntrega) {
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.nomeDestinatario = nomeDestinatario;
		this.vlTotalFrete = vlTotalFrete;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
	}
}
