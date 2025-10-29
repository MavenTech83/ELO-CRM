package com.maventech.elocrm.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maventech.elocrm.model.Oportunidade;

	@Repository
	public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long> {
	
	//Buscar oportunidades pela descrição (contém texto)//
	 List<Oportunidade> findByDescricaoContainingIgnoreCase(String descricao);
	 
	 //Buscar por status (aberta ou fechada)//
	 List<Oportunidade> findByStatus(Boolean status);
	 
	 //Buscar por tipo de oportunidade (Seguro Auto, Vida, etc.)//
	 List<Oportunidade> findByTipoOportunidadeContainingIgnoreCase(String tipoOportunidade);
	 
	 //Buscar oportunidades acima de um determinado valor potencial//
	 List<Oportunidade> findByValorPotencialGreaterThan(BigDecimal valor);
	 
	 //Buscar oportunidades abaixo de um determinado valor potencial//
	 List<Oportunidade> findByValorPotencialLessThan(BigDecimal valor);
	 
	 //Buscar oportunidades criadas por um cliente específico//
	 List<Oportunidade> findByClienteId(Long clienteId);
	 
	 //Buscar oportunidades criadas por um usuário específico (corretor)//
	 List<Oportunidade> findByUsuarioId(Long usuarioId);

}
