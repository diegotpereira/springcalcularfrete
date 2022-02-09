package br.spring.com.springcalcularfrete.model;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class CotacaoEntrega {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private Double peso;
	private String cepOrigem;
	private String cepDestino;
	private String nomeDestinatario;
	private Double vlTotalFrete;
	private LocalDate dataPrevistaEntrega;
	private LocalDate dataConsulta;
}
