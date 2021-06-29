package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import DB.DB;
import entities.Comentario;
import entities.Post;
import entities.Usuario;

public class Program {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		
		conn = DB.getConnection();
		
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM tb_usuario " + 
				"INNER JOIN tb_usuario_post_comentario ON tb_usuario.id = tb_usuario_post_comentario.usuario_id " + 
				"INNER JOIN tb_post ON tb_post.id = tb_usuario_post_comentario.post_id " + 
				"FULL OUTER JOIN tb_comentario ON tb_comentario.id = tb_usuario_post_comentario.comentario_id");
		
		Map<Long, Usuario> usuarioMap = new HashMap<>();
		Map<Long, Post> postMap = new HashMap<>();
		Map<Long, Comentario> comentarioMap = new HashMap<>();
		
		while(rs.next()) {
			Long usuario_id = rs.getLong("usuario_id");
			Long post_id = rs.getLong("post_id");
			Long comentario_id = rs.getLong("comentario_id");
			
			if(usuarioMap.get(usuario_id) == null) {
				Usuario usuario = instantiateUsuario(rs);
				usuarioMap.put(usuario_id, usuario);	
			}
			
			if(postMap.get(post_id) == null) {
				Post post = instantiatePost(rs);
				postMap.put(post_id, post);
			}
			
			if(comentarioMap.get(comentario_id) == null) {
				Comentario comentario = instantiateComentario(rs);
				comentarioMap.put(comentario_id, comentario);
			}
			
			usuarioMap.get(usuario_id).getPosts().add(postMap.get(post_id));
			postMap.get(post_id).getComentarios().add(comentarioMap.get(comentario_id));
		}
		
		for(Long usuarioId : usuarioMap.keySet()) {
			System.out.println(usuarioMap.get(usuarioId));
			
			for(Post p : usuarioMap.get(usuarioId).getPosts()) {
				System.out.println(p);
				
				for(Comentario c : postMap.get(p.getId()).getComentarios()) {
					if(c.getId() != 0) {
						System.out.println(c);	
					}
				}
				
				System.out.println();
			}
			
			System.out.println();
		}
		
		DB.closeConnection(conn);
		DB.closeStatement(st);
		DB.closeResultSet(rs);

	}
	
	private static Usuario instantiateUsuario(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setId(rs.getLong("usuario_id"));
		usuario.setNome(rs.getString("nome"));
		usuario.setEmail(rs.getString("email"));
		usuario.setSenha(rs.getString("senha"));
		
		return usuario;
	}
	
	private static Post instantiatePost(ResultSet rs) throws SQLException {
		Post post = new Post();
		post.setId(rs.getLong("post_id"));
		post.setTitulo(rs.getString("titulo"));
		post.setTextoPost(rs.getString("texto_post"));
		post.setDataCriacao(rs.getTimestamp("data_criacao").toInstant());
		
		return post;
	}
	
	private static Comentario instantiateComentario(ResultSet rs) throws SQLException {
		Comentario comentario = new Comentario();
		comentario.setId(rs.getLong("comentario_id"));
		comentario.setTextoComentario(rs.getString("texto_comentario"));
		comentario.setDataCriacao(rs.getTimestamp("data_criacao").toInstant());
		
		return comentario;
	}

}
