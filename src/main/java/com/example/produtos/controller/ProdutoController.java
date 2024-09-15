package com.example.produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.produtos.model.ModelResponse;
import com.example.produtos.model.Produto;
import com.example.produtos.service.ProdutoService;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<ModelResponse> remover (@PathVariable long id) {
		return produtoService.remover(id);
	}
	
	@PutMapping("alterar")
	public ResponseEntity<?> alterar(@RequestBody Produto produto) {
		return produtoService.cadastrarAlterar(produto, "alterar");
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrar(@RequestBody Produto produto) {
		return produtoService.cadastrarAlterar(produto, "cadastrar");
		
	}
	
	@GetMapping("/listar")
	public Iterable<Produto> listar() {
		
		return produtoService.listar();	
	}
	
	@GetMapping("/")
	public String rota() {
		return "Hellow world";
	}
	

}
