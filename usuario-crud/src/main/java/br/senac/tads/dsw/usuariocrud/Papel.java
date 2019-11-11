package br.senac.tads.dsw.usuariocrud;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "PAPEL")
public class Papel implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String nome;

    @ManyToMany(mappedBy = "papeis")
	private Set<Usuario> usuarios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
