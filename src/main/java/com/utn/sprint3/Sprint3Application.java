package com.utn.sprint3;

import com.utn.sprint3.entidades.*;
import com.utn.sprint3.enumeraciones.*;
import com.utn.sprint3.repositorios.ClienteRepository;
import com.utn.sprint3.repositorios.RubroArticuloRepository;
import com.utn.sprint3.repositorios.UnidadMedidaRepository;
import com.utn.sprint3.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class Sprint3Application {

	@Autowired
	RubroArticuloRepository rubroArticuloRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	UnidadMedidaRepository unidadMedidaRepository;


	public static void main(String[] args) {
		SpringApplication.run(Sprint3Application.class, args);
		System.out.println("Iniciando...");
	}

}