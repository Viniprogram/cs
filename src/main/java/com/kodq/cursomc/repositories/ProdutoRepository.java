package com.kodq.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kodq.cursomc.domain.Categoria;
import com.kodq.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	//Busca produtos por categoria no BD paginando (Aula 50)
	/*
	 * @Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias"
	 * ) Page<Produto> search(@Param("nome") String nome, @Param("categorias")
	 * List<Categoria> categorias, Pageable pageRequest);
	 */
	
	
	//Busca produtos por categoria no BD paginando, utilizando PADRÃO DE NOMES DO SPRING DATA. Faz a mesma coisa do método de cima com a QUERY(Aula 51)		
	@Transactional(readOnly = true)
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);
}
