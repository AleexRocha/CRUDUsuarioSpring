package br.senac.tads.dsw.usuariocrud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.senac.tads.dsw.usuariocrud.Usuario;

import br.senac.tads.dsw.usuariocrud.dao.UsuarioDao;

@Repository
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao daoUsuario;

	@Override
	@Transactional
	public void salvar(Usuario usuario) {
		if (usuario.getId() == null) {
			daoUsuario.save(usuario);
		} else {
			daoUsuario.update(usuario);
		}
	}

	@Override
	@Transactional
	public void excluir(Long id) {
		daoUsuario.delete(id);
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return daoUsuario.findById(id);
	}

	@Override
	public List<Usuario> buscarTodos() {
		return daoUsuario.findAll();
	}

}
