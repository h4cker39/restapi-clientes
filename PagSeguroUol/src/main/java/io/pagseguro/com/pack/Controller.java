package io.pagseguro.com.pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.net.ssl.SSLEngineResult.Status;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
/*
 * Luis Giordano
 * RestApi Spring Boot 
 * 24/09/2018
 *
 * */
@RestController
public class Controller {
	//Lembra de verificar se não existe null na req
	//Um cliente é composto apenas por nome e idade
	public static String woeid;
	
	@Autowired
	ClienteService clienteService;
	
	//Retorna todos os clientes
	@RequestMapping(value="/cliente", method=RequestMethod.GET)
	public List<Cliente> getClientes() {
		return clienteService.getAllCliente();
	}
	//Acha cliente por id e e
	@RequestMapping(value="/cliente/{id}",method=RequestMethod.GET)
		public Optional<Cliente> getCliente(@PathVariable ("id") String id){
		return clienteService.getCliente(id);
		}
	//Cria cliente
	/**
	 * HttpServlet pra achar o IP...
	 * Se voce executar a aplicação localmente o httpServlet irá resgatar o IP interno por exemplo 192.168.0.1 e vai identificar ip de outro pais
	 * Como no meu caso .... Australia  ;)
	 */
	@RequestMapping(value="/cliente",method=RequestMethod.POST)
	public void createCliente( @RequestBody Cliente cliente, HttpServletRequest http) throws IOException {
			RestTemplate restTemplate = new RestTemplate();
			Ipvigilante ip =  restTemplate.getForObject("https://ipvigilante.com/" + http.getRemoteAddr() , Ipvigilante.class);
		     cliente.setIp(ip);
		  String weather =  read(cliente.getIp().getData().getCity_name(),cliente.getIp().getData().getLatitude(),cliente.getIp().getData().getLongitude());
			cliente.setCurrent_weather(weather);
		   
		   System.out.println(cliente.getIp());
		     clienteService.createCliente(cliente,http);
	}
	//Update Cliente
	@RequestMapping(value="/cliente/{id}",method=RequestMethod.PUT)
	public void UpdateCliente(@RequestBody Cliente cliente, @PathVariable("id")String id) {	
		clienteService.updateCliente(id,cliente);
	}
	//Delete Cliente
	@RequestMapping(value="/cliente/{id}", method=RequestMethod.DELETE)
	public void deleteCliente(@PathVariable ("id") String id) {
		clienteService.deleteCliente(id);
	}
	
	
	/*
	 * Método extrai informações do JSON das APIS de clima...
	 * O Objetive é extrair da primeira query o woeid do localidade onde o cliente esta, sendo ela não identificado na segunda
	 * api de extrair o clima, utilizo o latitude e longitude, sendo mais preciso e extraindo o mais próximo a sua localidade.
	 * ... Muitas variáveis, porém cada um tem um objetivo especifico
	 * */
	public String read(String location,String latitude,String longitude) throws IOException {
		
		//Caso a resposta seja 404, achar woeid pelo latitude e longitude chamar na outra api.
	  List<String> list1 = new ArrayList<>() ;
	  String realValue;
	  Cliente cliente = new Cliente();
	  RestTemplate rest = new RestTemplate();
	  HttpHeaders headers =  new HttpHeaders();
	  ResponseEntity<String> respo = null;
	  ResponseEntity<String> locate = null;
	  String local = location;
	
	 try {
		 locate = rest.getForEntity("https://www.metaweather.com/api/location/search/?lattlong="+latitude+","+ longitude,String.class);	
	 }catch(HttpClientErrorException  e) {
		 
		 respo = rest.getForEntity("https://www.metaweather.com/api/location/search/?query=" + location,String.class);
	 }

	 if(!locate.getStatusCode().equals(Status.OK)) {
		 ObjectMapper map = new ObjectMapper(); 
		JsonNode root2 = map.readTree(locate.getBody());
		  root2.forEach( y->{
			  System.out.println(y.get("woeid").toString());
			  woeid = y.get("woeid").toString();
		  });
	}else {
		 ObjectMapper map = new ObjectMapper();
	 JsonNode root2 = map.readTree(respo.getBody());
	  root2.forEach( y->{
		  woeid = y.get("woeid").toString();
	  });
	  
	}
	  System.out.println(woeid);
	  ResponseEntity<String> response  = rest.getForEntity("https://www.metaweather.com/api/location/" + woeid + "/", String.class);
	 ObjectMapper map = new ObjectMapper(); 
	  JsonNode root = map.readTree(response.getBody());
	  JsonNode consolidated_weather =root.get("consolidated_weather");
	  consolidated_weather.forEach(x -> {
	        	  list1.add(x.get("weather_state_name").toString());
	        	  System.out.println(x.get("weather_state_name").toString());
	          });
	 realValue= list1.get(0);
	 System.out.println(realValue);
	 
	 return realValue;
	 }      
}
