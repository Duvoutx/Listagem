package com.dustore.dustore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import com.dustore.dustore.entities.Cliente;
import com.dustore.dustore.repositories.ClienteRepository;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/api")
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;

	// CRUD Cliente

	@GetMapping("/listaclientes")
	public String listarClientes(Model model) {
		List<Cliente> clientes = clienteRepository.findAll();
		model.addAttribute("clientes", clientes);
		return "listagem"; 
	}

	@PostMapping("/salvaclientes")
	public RedirectView salvarCliente(@RequestParam String nome, @RequestParam String email, @RequestParam String cpf,
			@RequestParam String data_nascimento) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dataNascimento = new Date(dateFormat.parse(data_nascimento).getTime());

			Cliente cliente = new Cliente();
			cliente.setNome(nome);
			cliente.setEmail(email);
			cliente.setCpf(cpf);
			cliente.setDataNascimento(dataNascimento);

			clienteRepository.save(cliente);
		} catch (ParseException e) {
		}

		return new RedirectView("/api/listaclientes");
	}

	@RequestMapping("/excluircliente/{cpf}")
	public RedirectView excluirCliente(@PathVariable String cpf) {
		Cliente clienteParaExcluir = clienteRepository.findByCpf(cpf);
		if (clienteParaExcluir != null) {	
			clienteRepository.delete(clienteParaExcluir);
		}
		return new RedirectView("/api/listaclientes");
	}
}
