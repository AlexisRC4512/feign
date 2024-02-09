package com.codigo.feign.service.impl;

import com.codigo.feign.aggregates.constants.Constantes;
import com.codigo.feign.aggregates.request.EmpresaRequest;
import com.codigo.feign.aggregates.response.BaseResponse;
import com.codigo.feign.aggregates.response.SunatResponse;
import com.codigo.feign.feignClient.SunatClient;
import com.codigo.feign.repository.PersonaRepository;
import com.codigo.feign.service.EmpresaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmpresaServiceImpl implements EmpresaService {
    private final PersonaRepository personaRepository;
    private final SunatClient sunatClient;
    @Value("${token.api}")
    private String tokenApi;
    public EmpresaServiceImpl(PersonaRepository personaRepository, SunatClient sunatClient) {
        this.personaRepository = personaRepository;
        this.sunatClient = sunatClient;
    }

    @Override
    public BaseResponse crearEmpresa(EmpresaRequest empresaRequest) {
        return null;
    }

    @Override
    public BaseResponse getInfoSunat(String numero) {
        SunatResponse response = getExecution(numero);
        if(response != null){
            return new BaseResponse(Constantes.CODE_SUCCESS,Constantes.MESS_SUCCESS, Optional.of(response));
        }else{
            return new BaseResponse(Constantes.CODE_ERROR,Constantes.MESS_ERROR, Optional.empty());
        }
    }
    private SunatResponse getExecution(String numero){
        String authorization = "Bearer "+tokenApi;
        return sunatClient.getInfo(numero,authorization);
    }
}
