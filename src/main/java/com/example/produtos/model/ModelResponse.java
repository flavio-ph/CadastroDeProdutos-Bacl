package com.example.produtos.model;

import org.springframework.stereotype.Component;

@Component
public class ModelResponse {
	
	private String mensagem;
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem () {
		return mensagem;
	}
}
