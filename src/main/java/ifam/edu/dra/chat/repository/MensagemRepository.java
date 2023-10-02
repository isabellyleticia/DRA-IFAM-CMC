package ifam.edu.dra.chat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ifam.edu.dra.chat.model.Contato;
import ifam.edu.dra.chat.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

	List<Mensagem> findAllByReceptor(Contato receptor);

}
