package com.farm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


	@Entity 
	@Table(name = "itemExecucao")
	public class ItemExecucao {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotNull
		@NotBlank
		@Column(name = "percentual")
		private String percentual;
		
		@NotNull
		@NotBlank
		@Column(name = "descricao")
		private String descricao;
		
		@NotNull
		@NotBlank
		@Column(name = "dataExecucao")
		private String dataExecucao;
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getPercentual() {
			return percentual;
		}
		public void setPercental(String percentual) {
			this.percentual = percentual;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public String getDataExecucao() {
			return dataExecucao;
		}
		public void setDataExecucao(String dataExecucao) {
			this.dataExecucao = dataExecucao;
		}
}
