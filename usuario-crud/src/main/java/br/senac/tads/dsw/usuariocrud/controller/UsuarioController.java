package br.senac.tads.dsw.usuariocrud.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.senac.tads.dsw.usuariocrud.Usuario;
import br.senac.tads.dsw.usuariocrud.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("usuarios", usuarioService.buscarTodos());

		return "/usuario/listagem";
	}

	@GetMapping("/cadastrar")
	public String cadastrar(Usuario usuario) {

		return "/usuario/cadastro";
	}

	@PostMapping("/salvar")
	public String salvar(@ModelAttribute @Valid Usuario usuario, BindingResult bindiResult, RedirectAttributes attr) {
		List<Usuario> usuarios = usuarioService.buscarTodos();

		for (Usuario u : usuarios) {
			if (u.getUsername().equalsIgnoreCase(usuario.getUsername())) {
				attr.addFlashAttribute("fail", "Username ja existe.");

				return "redirect:/usuarios/cadastrar";
			}
		}

		usuario.setDataHoraCadastro(LocalDateTime.now());
		usuarioService.salvar(usuario);
		attr.addFlashAttribute("success", "Usuario salvo com sucesso.");

		return "redirect:/usuarios/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("usuario", usuarioService.buscarPorId(id));

		return "/usuario/cadastro";
	}

	@PostMapping("/editar")
	public String editar(Usuario usuario, RedirectAttributes attr) {
		Usuario u = usuarioService.buscarPorId(usuario.getId());
		usuario.setPapeis(u.getPapeis());
		usuario.setDataHoraCadastro(LocalDateTime.now());
		
		usuarioService.salvar(usuario);
		attr.addFlashAttribute("success", "Usuario editado com sucesso");

		return "redirect:/usuarios/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		usuarioService.excluir(id);
		model.addAttribute("success", "Usuario excluido com sucesso.");

		return listar(model);
	}
}
