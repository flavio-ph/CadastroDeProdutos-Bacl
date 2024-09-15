package com.example.produtos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.produtos.model.ModelResponse;
import com.example.produtos.model.Produto;
import com.example.produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ModelResponse responseModel;
	
	public Iterable<Produto> listar() {
		return produtoRepository.findAll();
	}
	
	public ResponseEntity<?> cadastrarAlterar(Produto produto, String action) {
		
		if(produto.getNome().equals("")) {	
			
			responseModel.setMensagem("O nome do produto é obrigatório!");
			return new ResponseEntity<ModelResponse>(responseModel, HttpStatus.BAD_REQUEST);
			
		} else if(produto.getMarca().equals("")) {
			
			responseModel.setMensagem("O nome da marca é obrigatório!");
			return new ResponseEntity<ModelResponse>(responseModel, HttpStatus.BAD_REQUEST);
			
		} else {
			if(action.equals("cadastrar")) {
			return new ResponseEntity<Produto>(produtoRepository.save(produto), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Produto>(produtoRepository.save(produto), HttpStatus.OK);
			}
		}
	}
	
	public ResponseEntity<ModelResponse> remover(long id) {
		
		produtoRepository.deleteById(id);
		
		responseModel.setMensagem("O produto foi removido com sucesso");
		
		return new ResponseEntity<ModelResponse>(responseModel, HttpStatus.OK);
	}
	

}
