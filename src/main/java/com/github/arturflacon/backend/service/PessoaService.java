package com.github.arturflacon.backend.service;

import com.github.arturflacon.backend.exception.NaoEncontradoExcessao;
import com.github.arturflacon.backend.model.Pessoa;
import com.github.arturflacon.backend.repository.PessoaRepository;

import jakarta.transaction.Transactional;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private MessageSource messageSource;

    @Transactional
    public Pessoa inserir(Pessoa pessoa) {
        System.out.println(pessoa);
        return pessoaRepository.save(pessoa);
    }

    public Pessoa alterar(Pessoa pessoa) {
        // return pessoaRepository.save(pessoa);
        Pessoa pessoaBanco = pessoaRepository.findById(pessoa.getId())
                .orElseThrow(() -> new NoSuchElementException(
                        messageSource.getMessage("pessoa.notfound", new Object[] { pessoa.getId() },
                                LocaleContextHolder.getLocale())));
        pessoaBanco.setNome(pessoa.getNome());

        pessoaBanco.setEmail(pessoa.getEmail());
        return pessoaRepository.save(pessoaBanco);
    }

    public void excluir(Long id) {
        Pessoa pessoaBanco = buscarPorId(id);
        pessoaRepository.delete(pessoaBanco);

    }

    public Pessoa buscarPorId(Long id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new NaoEncontradoExcessao(
                messageSource.getMessage("pessoa.notfound", new Object[] { id }, LocaleContextHolder.getLocale())));

    }

    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }
}
