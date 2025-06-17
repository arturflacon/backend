package com.github.arturflacon.backend.service;

import com.github.arturflacon.backend.model.Calculadora;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class HelloService {
    public Calculadora somar(@RequestBody Calculadora calculadora) {
        calculadora.setResultado(calculadora.getValor1() + calculadora.getValor2());
        return calculadora;
    }
}
