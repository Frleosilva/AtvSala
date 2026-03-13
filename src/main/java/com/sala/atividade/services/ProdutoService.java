package com.sala.atividade.services;

import com.sala.atividade.models.ProdutoModel;
import com.sala.atividade.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> findAll(){
        return produtoRepository.findAll();
    }

    public ProdutoModel criarProduto(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    public Optional<ProdutoModel> buscarid(Long id){
        return produtoRepository.findById(id);
    }


    public ProdutoModel atualizar(Long id, ProdutoModel produtoModel){
        ProdutoModel model = produtoRepository.findById(id).get();
        model.setNome(produtoModel.getNome());
        model.setPreco(produtoModel.getPreco());
        model.setQuantidadeEmEstoque(produtoModel.getQuantidadeEmEstoque());
        model.setStatusProduto(produtoModel.getStatusProduto());
        return produtoRepository.save(model);
    }

    public void deletar(Long id){
        produtoRepository.deleteById(id);
    }
}
