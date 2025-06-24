package com.github.arturflacon.backend.exception;

public class NegocioExcessao extends RuntimeException{
    
    public NegocioExcessao(String mensagem){
        super(mensagem);
    }
}
