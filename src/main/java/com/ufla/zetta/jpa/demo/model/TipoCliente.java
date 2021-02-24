package com.ufla.zetta.jpa.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoCliente {
    PESSOAFISICA (0, "Pessoa Fisica"),
    PESSOAJURIDICA(1, "Pessoa Juridica");

    private int cod;
    private String descricao;


    public static TipoCliente toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for(TipoCliente x: TipoCliente.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw  new IllegalArgumentException("Id invalido " + cod);
    }


}
