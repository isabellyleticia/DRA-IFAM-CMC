package ifam.edu.dra.chat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifam.edu.dra.chat.dto.MensagemDTO;
import ifam.edu.dra.chat.model.Contato;
import ifam.edu.dra.chat.model.Mensagem;
import ifam.edu.dra.chat.repository.MensagemRepository;

@Service
public class MensagemService {

	@Autowired
	MensagemRepository mensagemRepository;

	public List<Mensagem> getMensagens() {
		return mensagemRepository.findAll();
	}

	public Mensagem getMensagem(Long id) {
		Optional<Mensagem> optionalMensagem = mensagemRepository.findById(id);
		if (optionalMensagem.isPresent())
			return optionalMensagem.get();
		return new Mensagem();
	}

	public List<Mensagem> getMensagensByReceptor(Long receptorId) {
		Contato receptor = new Contato();
		receptor.setId(receptorId);
		return mensagemRepository.findAllByReceptor(receptor);
	}

	public MensagemDTO setMensagem(MensagemDTO mensagemDTO) {
		Mensagem mensagem = mensagemDTO.toMensagem();
		Mensagem mensagemSalva = mensagemRepository.save(mensagem);
		return MensagemDTO.fromMensagem(mensagemSalva);
	}

}
