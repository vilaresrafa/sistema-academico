package com.carlosribeiro.apirestful.controller;

import com.carlosribeiro.apirestful.exception.EntidadeNaoEncontradaException;
import com.carlosribeiro.apirestful.model.Produto;
import com.carlosribeiro.apirestful.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("produtos")   // htttp://localhost:8080/produtos
public class ProdutoController {

    private final ProdutoService produtoService;

//    public ProdutoController(ProdutoService produtoService) {
//        this.produtoService = produtoService;
//    }

    @GetMapping
    public List<Produto> recuperarProdutos() {
        return produtoService.recuperarProdutos();
    }

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto produto) {
        return produtoService.cadastrarProduto(produto);
    }

    @PutMapping
    public Produto alterarProduto(@RequestBody Produto produto) {
        return produtoService.alterarProduto(produto);
    }

//    Implementação retornando um objeto Produto
//    // Get para http://localhost:8080/produtos/1
//    @GetMapping("{idProduto}")
//    public Produto recuperarProdutoPorId(@PathVariable("idProduto") Long id) {
//        return produtoService.recuperarProdutoPorId(id);
//    }

//    Implementação retornando um ResponseEntity<Produto>
//    // Get para http://localhost:8080/produtos/10/2024
//    @GetMapping("{idProduto}")
//    public ResponseEntity<Produto> recuperarProdutoPorId(@PathVariable("idProduto") Long id) {
//        Produto produto = produtoService.recuperarProdutoPorId(id);
//        return new ResponseEntity<>(produto, HttpStatus.OK);
//    }

// Implementação utilizando o método estático ok() que retorna um ResponseEntity
//    // Get para http://localhost:8080/produtos/10/2024
//    @GetMapping("{idProduto}")
//    public ResponseEntity<Produto> recuperarProdutoPorId(@PathVariable("idProduto") Long id) {
//        Produto produto = produtoService.recuperarProdutoPorId(id);
//        return ResponseEntity.ok(produto);
//    }

//    Implementação que retorna um Produto ou um String (mensagem de errro) sem utilizar
//    um GlobalExceptionHandler
//    // Get para http://localhost:8080/produtos/10/2024
//    @GetMapping("{idProduto}")
//    public ResponseEntity<?> recuperarProdutoPorId(@PathVariable("idProduto") Long id) {
//        try {
//            Produto produto = produtoService.recuperarProdutoPorId(id);
//            return ResponseEntity
//                .ok()
//                .header("Content-type", "application/json")
//                .body(produto);
//        }
//        catch(EntidadeNaoEncontradaException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }

    // Get para http://localhost:8080/produtos/10/2024
    @GetMapping("{idProduto}")
    public ResponseEntity<Produto> recuperarProdutoPorId(@PathVariable("idProduto") Long id) {
        Produto produto = produtoService.recuperarProdutoPorId(id);
        return ResponseEntity
            .ok()
            .header("Content-type", "application/json")
            .body(produto);
    }

//    // Delete para http://localhost:8080/produtos/1
//    @DeleteMapping("{idProduto}")
//    public void removerProdutoPorId(@PathVariable("idProduto") Long id) {
//        produtoService.removerProdutoPorId(id);
//    }

    // Implementação utilizando um builder
    // Delete para http://localhost:8080/produtos/1
    @DeleteMapping("{idProduto}")
    public ResponseEntity<Void> removerProdutoPorId(@PathVariable("idProduto") Long id) {
        produtoService.removerProdutoPorId(id);
        return ResponseEntity.ok().build();
    }
}
