package br.com.projeto.ws.client.service;

import org.springframework.stereotype.Service;

import br.com.projeto.util.WsProcessamento;
import br.com.projeto.ws.client.model.ListaUsuarios;

@Service
public class ClientActionsImpl implements ClientActions{
	
	public ListaUsuarios singleUserById(int id) {
	String url = "https://reqres.in/api/users?page"+id;
	Object object = WsProcessamento.getWs(url, new ListaUsuarios());
	if(object != null)
		return (ListaUsuarios) object;
	else
		return null;
}
}



