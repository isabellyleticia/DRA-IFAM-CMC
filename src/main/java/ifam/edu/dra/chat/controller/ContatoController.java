package ifam.edu.dra.chat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	ResponseEntity<List<Contato>> getContatos() {
		if(contatos.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(contatos);
		return ResponseEntity.ok(contatos);
		
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Contato> getContato(@PathVariable int id) {
		try {
			return ResponseEntity.ok(contatos.get(id));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Contato());
			
		}
		 
	}

	
	@PostMapping
	ResponseEntity <Contato> setContato(@RequestBody Contato contato) {
		contatos.add(contato);
		return ResponseEntity.created(null).body(contato);
		
	}
	
	@PutMapping("/{id}")
	ResponseEntity<Contato> setContato(@RequestBody Contato contato, @PathVariable int id) {
		try {
			return ResponseEntity.accepted().body(contatos.set(id,contato));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Contato());
			
		}
		
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Contato> deleteContato(@PathVariable int id) {
		try {
			contatos.remove(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new Contato());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Contato());
		}
		
	}
		
}
	
	
	
