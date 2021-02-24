package com.ufla.zetta.jpa.demo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PagamentoComBoleto extends Pagamento{
    private Date dataVencimento;
    private Date dataPagamento;
}
