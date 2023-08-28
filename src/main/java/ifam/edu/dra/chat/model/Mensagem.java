package ifam.edu.dra.chat.model;

import java.util.Calendar;

public class Mensagem {

	private Calendar dataHora;
	private String conteudo;
	private Contato emissor;
	private Contato receptor;

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

	public Contato getEmissor() {
		return emissor;
	}

	public void setEmissor(Contato emissor) {
		this.emissor = emissor;
	}

	public Contato getReceptor() {
		return receptor;
	}

	public void setReceptor(Contato receptor) {
		this.receptor = receptor;
	}

	@Override
	public String toString() {
		return "Mensagem [dataHora=" + dataHora + ", conteudo=" + conteudo + ", emissor=" + emissor + ", receptor="
				+ receptor + "]";
	}
}
