package com.ufla.zetta.jpa.demo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PagamentoComCartao extends Pagamento{
    private Integer numeroDeParcelas;
}
