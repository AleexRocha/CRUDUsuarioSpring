package br.senac.tads.dsw.usuariocrud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.senac.tads.dsw.usuariocrud.Usuario;

@Repository
public interface UsuarioDao {

	void save(Usuario usuario);

	void update(Usuario usuario);

	void delete(Long id);

	Usuario findById(Long id);

	List<Usuario> findAll();
}
