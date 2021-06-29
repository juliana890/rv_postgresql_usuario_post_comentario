package entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Post {
	
	private Long id;
	private String titulo;
	private String textoPost;
	private Instant dataCriacao;
	
	private List<Comentario> comentarios = new ArrayList<>();
	
	public Post() {}

	public Post(Long id, String titulo, String textoPost, Instant dataCriacao, List<Comentario> comentarios) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.textoPost = textoPost;
		this.dataCriacao = dataCriacao;
		this.comentarios = comentarios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTextoPost() {
		return textoPost;
	}

	public void setTextoPost(String textoPost) {
		this.textoPost = textoPost;
	}

	public Instant getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Instant dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", titulo=" + titulo + ", textoPost=" + textoPost + ", dataCriacao=" + dataCriacao
				+ "]";
	}	
	
}
