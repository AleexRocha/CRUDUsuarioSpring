package br.senac.tads.dsw.usuariocrud.dao;

import org.springframework.stereotype.Repository;

import br.senac.tads.dsw.usuariocrud.Usuario;

@Repository
public class AbstractDaoImpl extends AbstractDao<Usuario, Long> implements UsuarioDao {

}
