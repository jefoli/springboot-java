package io.github.jefoli.service;

import io.github.jefoli.model.Cliente;
import io.github.jefoli.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    private ClientesRepository repository;

    // vamos criar um construtor para evitar o problema descrito abaixo
    //adicionamos a dependencia:
    // colocamos autowired para fazer a instancia
    @Autowired
    public ClientesService(ClientesRepository repository) {
        this.repository = repository;
    }

    public void salvarCliente(Cliente cliente) {
        validarCliente(cliente);


        //vamos precisar da repository para minupularmos os clientes
        //cliente repository é dependente do ClienteService
        //O ideal é fazer uma instancia para o container do Spring para não pesar já que vai pegar uma pacote
        //externo
        // Dessa forma, nao precisa mais de: ClientesRepository clientesRepository = new ClientesRepository();
        //clientesRepository.persistir(cliente);

        //chamamos o injetado via construtor:
        this.repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente) {
        //aplicar validação
    }
}
