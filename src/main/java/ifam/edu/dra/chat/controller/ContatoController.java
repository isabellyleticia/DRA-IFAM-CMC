package ifam.edu.dra.chat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifam.edu.dra.chat.model.Contato;


@RequestMapping("/Contato")
@RestController
public class ContatoController {
	
	List<Contato> contatos = new ArrayList<>();
	
	@GetMapping
	List<Contato> getContatos() {
		return contatos;
		
	}
	
	@GetMapping("/{id}")
	Contato getContato(@PathVariable int id) {
		return contatos.get(id);
		}

	
	@PostMapping
	Contato setContato(@RequestBody Contato contato) {
		contatos.add(contato);
		return contato;
		
	}
	
	@PutMapping("/{id}")
	Contato setContato(@RequestBody Contato contato, @PathVariable int id) {
		contatos.set(id, contato);
		return contato;
		
	}
	
	@DeleteMapping("/{id}")
	void deleteContato(@PathVariable Long id) {
		contatos.remove(id);
		
	}
		
}
	
	
	
