package br.senac.tads.dsw.usuariocrud.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.senac.tads.dsw.usuariocrud.Usuario;

@Repository
public interface UsuarioService {

	void salvar(Usuario usuario);

	void excluir(Long id);

	Usuario buscarPorId(Long id);

	List<Usuario> buscarTodos();

}
