package com.generation.blogpessoal.repository;

import java.util.List;

import com.generation.blogpessoal.model.Postagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * A Anotação @Repository: indica que a Interface é do tipo repositório,
 * ou seja, é responsável pela comunicação com o Banco de dados através dos métodos
 * padrão e das Method Queries (Métodos Personalizados), que são as consultas personalizadas 
 * criadas através de palavras chave que representam as instruções da linguagem SQL.
 * 
 * Estes 2 parâmetros são do tipo Java Generics (podem receber qualquer tipo de Objeto <T, T>). 
 * Dentro contexto do JPA são o mínimo necessário para executar os Métodos padrão da 
 * Interface JpaRepository, que serão implementados na próxima etapa na Classe PostagemController. 
 * 
 * Alguns métodos básicos já ficam automaticamente disponíveis no Recurso Postagem a partir do 
 * momento que a Interface PostagemRepository herda a Interface JpaRepository.
 * 
 */
@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    /**
	 * Method Query equivalente a instrução SQL: 
	 * 
	 * SELECT * FROM tb_postagem where titulo like "%titulo%";
	 */
	public List <Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);

}
