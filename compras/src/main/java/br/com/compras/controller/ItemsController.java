package br.com.compras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.compras.model.Item;
import br.com.compras.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("items")
@Slf4j
public class ItemsController {
	
	@Autowired
	ItemRepository itemRepository;
	
	@GetMapping("")
	public String getListaItens(Model model) {
		model.addAttribute("items",itemRepository.findAll());
		
		log.debug("Items recuperados da base!");
		
		return "items/show";
	}
	
	@GetMapping("/item")
	public String salvarItem(Model model) {
		
		model.addAttribute("item",new Item());
		
		return "items/create";
	}
	
	@PostMapping("/item")
	public String salvarItem(@ModelAttribute Item item) {
		
		itemRepository.save(item);
		
		log.debug("Item salvo!");
		
		return "items/show";
	}
}
