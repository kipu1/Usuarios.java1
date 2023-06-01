package com.example.models.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.entity.Usuario;
import com.example.models.services.IUsuarioService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UsuarioRestController {

	@Autowired
	private IUsuarioService UsuarioService;
	//LISTAR
	@GetMapping("/Usuario")
	public List<Usuario> indext() {
		return UsuarioService.findAll();
	}
	//buscar
	@GetMapping("/Usuario/{id}")
	public Usuario show(@PathVariable Long id) {
		return UsuarioService.findById(id);
	
	}
	//guardar
	@PostMapping("/Usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {
		return UsuarioService.save(usuario);
	}
	
	
	@PutMapping("/Usuario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {

		Usuario usuarioactual = UsuarioService.findById(id);
		usuarioactual.setNombre(usuario.getNombre());
		usuarioactual.setClave(usuario.getClave());
		usuarioactual.setEmail(usuario.getEmail());
		usuarioactual.setEstado(true);
		return UsuarioService.save(usuarioactual);

	}
	
	@DeleteMapping("/usuario/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		UsuarioService.delete(id);
	}
	
}
