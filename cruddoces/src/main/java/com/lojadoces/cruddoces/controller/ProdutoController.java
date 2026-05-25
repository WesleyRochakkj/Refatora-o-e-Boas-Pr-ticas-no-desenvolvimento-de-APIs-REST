package com.lojadoces.cruddoces.controller;

import com.lojadoces.cruddoces.model.Produto;
import com.lojadoces.cruddoces.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    // POST
    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    // GET
    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    // PUT
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id,
                             @RequestBody Produto produtoAtualizado) {

        Optional<Produto> produtoExistente = repository.findById(id);

        if (produtoExistente.isPresent()) {

            Produto produto = produtoExistente.get();

            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setCategoria(produtoAtualizado.getCategoria());

            return repository.save(produto);
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {

        repository.deleteById(id);

        return "Produto removido com sucesso!";
    }
}