package com.codigo.feign.aggregates.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaRequest {
    public String tipoDoct;
    private String numDoc;
}
