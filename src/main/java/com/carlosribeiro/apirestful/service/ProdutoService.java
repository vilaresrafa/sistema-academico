package com.carlosribeiro.apirestful.service;

import com.carlosribeiro.apirestful.exception.EntidadeNaoEncontradaException;
import com.carlosribeiro.apirestful.model.Produto;
import com.carlosribeiro.apirestful.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

//    public ProdutoService(ProdutoRepository produtoRepository) {
//        this.produtoRepository = produtoRepository;
//    }

    public List<Produto> recuperarProdutos() {
        return produtoRepository.recuperarProdutos();
    }

    public Produto cadastrarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

//    @Transactional
//    public Produto alterarProduto(Produto produto) {
          // Este método precisa ser transacional uma vez que o método abaixo
          // efetua um lock na linha da tabela referente ao produto recuperado.
          // Observe que o método recuperarProdutoPorIdComLock retorna um
          // Optional<Produto>
          // O método abaixo (recuperarProdutoPorIdComLock) retorna um Produto
//        Produto p = produtoRepository.recuperarProdutoPorIdComLock(produto.getId());    // 3.3.3 ou anterior
//        if (p != null) {
//            return produtoRepository.save(produto);
//        }
//        throw new EntidadeNaoEncontradaException(
//            "Produto com id = " + produto.getId() + " não encontrado.");
//    }

    @Transactional
    public Produto alterarProduto(Produto produto) {
        // Aqui (recuperarProdutoPorIdComLock) retorna um Optional<Produto>
        produtoRepository.recuperarProdutoPorIdComLock(produto.getId())
            .orElseThrow(() -> new EntidadeNaoEncontradaException(
                "Produto com id = " + produto.getId() + " não encontrado."));
        return produtoRepository.save(produto);
    }

    public Produto recuperarProdutoPorId(Long id) {
        return produtoRepository.recuperarProdutoPorIdComCategoria(id)
            .orElseThrow(() -> new EntidadeNaoEncontradaException(
                "Produto com id = " + id + " não encontrado."));
    }

    public void removerProdutoPorId(Long id) {
        recuperarProdutoPorId(id);
        produtoRepository.deleteById(id);
    }
}
