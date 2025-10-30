package com.maventech.elocrm.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name = "tb_oportunidades")
public class Oportunidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotBlank(message = "A descrição é obrigatória.") //Texto breve explicando o tipo ou objetivo da oportunidade
    private String descricao;
    
    @NotNull(message = "O status é obrigatório.")
    private Boolean status; // Indica se a oportunidade está aberta (false) ou fechada (true)
    
    @NotNull(message = "O valor potencial é obrigatório.")
    @Column(precision = 10, scale = 2) // Valor estimado do negócio (potencial de fechamento até 99999999.99)
    private BigDecimal valorPotencial;
    
    @JsonFormat(pattern = "yyyy-MM-dd") // Data em que a oportunidade foi criada
    private LocalDate dataCriacao = LocalDate.now();
    
    @NotBlank(message = "O tipo de oportunidade é obrigatório.") // Categoria da oportunidade (ex: Seguro de Vida, Seguro Auto, etc.)
    private String tipoOportunidade;
    
    //Relacionamentos//
    
   @ManyToOne
   @JoinColumn(name = "usuario_id")
  private Usuario usuario;

   @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;
    

    
 // Getters e Setters //
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public BigDecimal getValorPotencial() {
		return valorPotencial;
	}

	public void setValorPotencial(BigDecimal valorPotencial) {
		this.valorPotencial = valorPotencial;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getTipoOportunidade() {
		return tipoOportunidade;
	}

	public void setTipoOportunidade(String tipoOportunidade) {
		this.tipoOportunidade = tipoOportunidade;
	}
 
}
