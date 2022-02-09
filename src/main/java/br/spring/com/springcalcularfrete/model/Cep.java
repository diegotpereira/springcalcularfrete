package br.spring.com.springcalcularfrete.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cep {
	
	private String cep;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;
	private String DDD;
}
