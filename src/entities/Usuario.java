package entities;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	private List<Post> posts = new ArrayList<>();
	
	public Usuario() {}

	public Usuario(Long id, String nome, String email, String senha, List<Post> posts) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.posts = posts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Post> getPosts() {
		return posts;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}
	
}
