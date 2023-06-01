package com.example.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.models.entity.Usuario;


@Service
public interface IUsuarioService {

	
	public List<Usuario> findAll();
	
	public Usuario save(Usuario usuario);
	
	public Usuario findById(Long id);
	
	public void delete(Long id);
}
