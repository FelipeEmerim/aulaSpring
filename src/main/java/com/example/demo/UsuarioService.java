package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Iterable<Usuario> lista(){
		return usuarioRepository.findAll();
	}
	
	public void apaga(Long id){
		usuarioRepository.deleteById(id);
	}
	
	public void salva(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public Usuario busca(Long id) {
		return usuarioRepository.getOne(id);
	}
}
