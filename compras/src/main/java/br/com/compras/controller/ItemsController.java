package br.com.compras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.compras.repository.ItemRepository;

@Controller
@RequestMapping("items")
public class ItemsController {
	
	@Autowired
	ItemRepository itemRepository;
	
	@RequestMapping("")
	public String getListaItens(Model model) {
		model.addAttribute("items",itemRepository.findByDescricao("ovo"));
		
		return "items/show";
	}
}
