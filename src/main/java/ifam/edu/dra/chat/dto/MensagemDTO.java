package ifam.edu.dra.chat.dto;

import java.util.Calendar;

import ifam.edu.dra.chat.model.Contato;
import ifam.edu.dra.chat.model.Mensagem;

public class MensagemDTO {
	private Long id;
	private Calendar dataHora;
	private String conteudo;
	private Long emissorId;
	private Long receptorId;

	public MensagemDTO() {
		this.dataHora = Calendar.getInstance();
	}

	public MensagemDTO(Long id, String conteudo, Long emissorId, Long receptorId) {
		this();
		this.id = id;
		this.conteudo = conteudo;
		this.emissorId = emissorId;
		this.receptorId = receptorId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Long getEmissorId() {
		return emissorId;
	}

	public void setEmissorId(Long emissorId) {
		this.emissorId = emissorId;
	}

	public Long getReceptorId() {
		return receptorId;
	}

	public void setReceptorId(Long receptorId) {
		this.receptorId = receptorId;
	}

	public Mensagem toMensagem() {
		Mensagem mensagem = new Mensagem();
		mensagem.setId(this.id);
		mensagem.setDataHora(this.dataHora);
		mensagem.setConteudo(this.conteudo);

		if (this.emissorId != null) {
			Contato emissor = new Contato();
			emissor.setId(this.emissorId);
			mensagem.setEmissor(emissor);
		}

		if (this.receptorId != null) {
			Contato receptor = new Contato();
			receptor.setId(this.receptorId);
			mensagem.setReceptor(receptor);
		}

		return mensagem;
	}

	public static MensagemDTO fromMensagem(Mensagem mensagem) {
		MensagemDTO dtoMensagem = new MensagemDTO();
		dtoMensagem.setId(mensagem.getId());
		dtoMensagem.setDataHora(mensagem.getDataHora());
		dtoMensagem.setConteudo(mensagem.getConteudo());

		if (mensagem.getEmissor() != null) {
			dtoMensagem.setEmissorId(mensagem.getEmissor().getId());
		}

		if (mensagem.getReceptor() != null) {
			dtoMensagem.setReceptorId(mensagem.getReceptor().getId());
		}

		return dtoMensagem;
	}

	@Override
	public String toString() {
		return "MensagemDTO [id=" + id + ", dataHora=" + dataHora + ", conteudo=" + conteudo + ", emissorId="
				+ emissorId + ", receptorId=" + receptorId + "]";
	}
}