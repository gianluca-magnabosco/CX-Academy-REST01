package com.cxacademy.service;

import com.cxacademy.handler.exceptions.ParametroInvalidoException;
import com.cxacademy.handler.exceptions.RecursoNaoEncontradoException;
import com.cxacademy.model.PessoaModel;
import com.cxacademy.model.dto.PessoaDto;
import com.cxacademy.repository.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    private final ModelMapper modelMapper;


    public PessoaService(PessoaRepository pessoaRepository, ModelMapper modelMapper) {
        this.pessoaRepository = pessoaRepository;
        this.modelMapper = modelMapper;
    }


    public List<PessoaDto > findAll() {

        List<PessoaModel> pessoaModels = pessoaRepository.findAll();

        return modelMapper.map(pessoaModels, new TypeToken<List<PessoaDto>>() {
        }.getType());
    }


    public PessoaDto findById(Long id) {

        if (id == null) {
            throw new ParametroInvalidoException("Id informado inválido");
        }

        PessoaModel pessoaModel = new PessoaModel();
        try {
            pessoaModel = pessoaRepository.findById(id).get();

        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

        return modelMapper.map(pessoaModel, PessoaDto.class);
    }


    public PessoaDto insert(PessoaModel pessoaModel) {

        pessoaModel.setId(null);

        return new PessoaDto(pessoaRepository.save(pessoaModel));
    }


    public PessoaDto update(Long id, PessoaModel pessoaModel) {

        if (pessoaModel == null) {
            throw new ParametroInvalidoException("A Pessoa Model deve ser informada!");
        }

        findById(id);

        pessoaModel.setId(id);

        return new PessoaDto(pessoaRepository.save(pessoaModel));
    }


    public boolean delete(Long id) {

        findById(id);

        try {
            pessoaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecursoNaoEncontradoException("Id informado não encontrado!");
        }

    }

}
