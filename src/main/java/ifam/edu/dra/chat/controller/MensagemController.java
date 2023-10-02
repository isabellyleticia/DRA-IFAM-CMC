package ifam.edu.dra.chat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifam.edu.dra.chat.dto.MensagemDTO;
import ifam.edu.dra.chat.model.Mensagem;
import ifam.edu.dra.chat.service.MensagemService;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

	@Autowired
	MensagemService mensagemService;

	@GetMapping
	ResponseEntity<List<MensagemDTO>> getMensagens() {
		List<Mensagem> mensagens = mensagemService.getMensagens();
		List<MensagemDTO> mensagemDTOs = new ArrayList<>();

		for (Mensagem mensagem : mensagens) {
			mensagemDTOs.add(new MensagemDTO(mensagem.getId(), mensagem.getConteudo(), mensagem.getEmissor().getId(),
					mensagem.getReceptor().getId()));
		}

		if (mensagemDTOs.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagemDTOs);
		return ResponseEntity.ok(mensagemDTOs);
	}

	@GetMapping("/{id}")
	ResponseEntity<MensagemDTO> getMensagem(@PathVariable Long id) {
		try {
			Mensagem mensagem = mensagemService.getMensagem(id);
			MensagemDTO mensagemDTO = new MensagemDTO(mensagem.getId(), mensagem.getConteudo(),
					mensagem.getEmissor().getId(), mensagem.getReceptor().getId());
			return ResponseEntity.ok(mensagemDTO);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MensagemDTO());
		}
	}

	@GetMapping("/receptor/{receptorId}")
	ResponseEntity<List<MensagemDTO>> getMensagensByReceptor(@PathVariable Long receptorId) {
		List<Mensagem> mensagens = mensagemService.getMensagensByReceptor(receptorId);
		List<MensagemDTO> mensagemDTOs = new ArrayList<>();

		for (Mensagem mensagem : mensagens) {
			mensagemDTOs.add(new MensagemDTO(mensagem.getId(), mensagem.getConteudo(), mensagem.getEmissor().getId(),
					mensagem.getReceptor().getId()));
		}

		if (mensagemDTOs.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagemDTOs);
		return ResponseEntity.ok(mensagemDTOs);
	}

	@PostMapping
	ResponseEntity<MensagemDTO> setMensagem(@RequestBody MensagemDTO mensagemDTO) {
		MensagemDTO mensagemDTOCriada = mensagemService.setMensagem(mensagemDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(mensagemDTOCriada);
	}
}
