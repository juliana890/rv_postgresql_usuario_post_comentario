package entities;

import java.time.Instant;

public class Comentario {
	
	private Long id;
	private String textoComentario;
	private Instant dataCriacao;
	
	public Comentario() {}

	public Comentario(Long id, String textoComentario, Instant dataCriacao) {
		super();
		this.id = id;
		this.textoComentario = textoComentario;
		this.dataCriacao = dataCriacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTextoComentario() {
		return textoComentario;
	}

	public void setTextoComentario(String textoComentario) {
		this.textoComentario = textoComentario;
	}

	public Instant getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Instant dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", textoComentario=" + textoComentario + ", dataCriacao=" + dataCriacao + "]";
	}
	
}
