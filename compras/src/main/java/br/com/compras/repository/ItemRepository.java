package br.com.compras.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.compras.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{

	Item findByDescricao(String descricao);
}
