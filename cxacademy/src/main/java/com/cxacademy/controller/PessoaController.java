package com.cxacademy.controller;

import com.cxacademy.model.PessoaModel;
import com.cxacademy.model.dto.PessoaDto;
import com.cxacademy.service.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<PessoaDto>> findAll() {

        List<PessoaDto> response = pessoaService.findAll();

        return response == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> findById(@PathVariable Long id) {

        PessoaDto response = pessoaService.findById(id);

        return response == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<PessoaDto> insert(@RequestBody PessoaModel pessoaModel) {

        PessoaDto response = pessoaService.insert(pessoaModel);

        return response == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PessoaDto> update(@PathVariable Long id, @RequestBody PessoaModel pessoaModel) {

        PessoaDto response = pessoaService.update(id, pessoaModel);

        return response == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {

        Boolean success = pessoaService.delete(id);

        return success ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }

}
