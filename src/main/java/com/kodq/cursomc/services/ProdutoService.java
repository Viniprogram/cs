package com.kodq.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kodq.cursomc.domain.Categoria;
import com.kodq.cursomc.domain.Produto;
import com.kodq.cursomc.repositories.CategoriaRepository;
import com.kodq.cursomc.repositories.ProdutoRepository;
import com.kodq.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepositorio;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto find(Integer id) {
		Optional<Produto> produto = produtoRepositorio.findById(id);
		return produto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: "
				+ Produto.class.getName()));
	}
	
	//Busca de pedidos por nome e categorias. Vai selecionando conforme vai digitando o nome (Aula 50) 
	public Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String direction,
			String orderBy){
		
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return produtoRepositorio.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}

}
