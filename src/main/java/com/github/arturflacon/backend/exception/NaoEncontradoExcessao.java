package com.github.arturflacon.backend.exception;

public class NaoEncontradoExcessao extends RuntimeException {

    public NaoEncontradoExcessao(String mensagem) {
        super(mensagem);
    }
}