package ifam.edu.dra.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ifam.edu.dra.chat.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
