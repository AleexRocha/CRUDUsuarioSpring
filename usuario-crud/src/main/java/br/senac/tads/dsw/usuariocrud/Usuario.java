package br.senac.tads.dsw.usuariocrud;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String nomeCompleto;

	@Column(nullable = false)
	private String senha;

	@Column(nullable = false)
	private boolean ativado;

	@Column(nullable = false)
	private LocalDateTime dataHoraCadastro;

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuario_papel",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns
            = @JoinColumn(name = "id_papel"))
	private Set<Papel> papeis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivado() {
		return ativado;
	}

	public void setAtivado(boolean ativado) {
		this.ativado = ativado;
	}

	public LocalDateTime getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	public Set<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(Set<Papel> papeis) {
		this.papeis = papeis;
	}

}
