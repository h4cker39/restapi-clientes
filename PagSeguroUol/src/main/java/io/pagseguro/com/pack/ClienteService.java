package io.pagseguro.com.pack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
 * Classe de serviço
 * Luis Giordano
 * */

@Service
public class ClienteService implements Serializable{

	
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> getAllCliente(){
		Ipvigilante ips =  new Ipvigilante();
    List<Cliente> cliente = new ArrayList<>();
	 cliente = (List<Cliente>) clienteRepository.findAll();
	 
	 return cliente;
	}
	public Optional<Cliente> getCliente(String id) {
	   Optional<Cliente> cliente;
		 cliente = clienteRepository.findById(id);
		
		 
		 return cliente;
	}
	public void createCliente(Cliente cliente, javax.servlet.http.HttpServletRequest http) {
		    // Rest Template para salvar IP e associar
          
			clienteRepository.save(cliente);
	}
	//Aqui coloquei o ID caso precise atualizar via ID, então fica aqui a lógica, somente..
	public void updateCliente(String id,Cliente cliente) {
		clienteRepository.save(cliente);
	}
	public void deleteCliente(String id) {
		clienteRepository.deleteById(id);
	}
	
}
