package com.autobots.automanager;

import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@SpringBootApplication
public class AutomanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutomanagerApplication.class, args);
    }

    @Component
    public static class Runner implements ApplicationRunner {
        @Autowired
        public ClienteRepositorio repositorio;

        @Override
        public void run(ApplicationArguments args) throws Exception {
            // Verifica se o banco de dados está vazio
            if (repositorio.count() == 0) {
                Calendar calendario = Calendar.getInstance();
                calendario.set(2002, 05, 15);

                // Criação de um cliente
                Cliente cliente = new Cliente();
                cliente.setNome("Pedro Alcântara de Bragança e Bourbon");
                cliente.setDataCadastro(Calendar.getInstance().getTime());
                cliente.setDataNascimento(calendario.getTime());
                cliente.setNomeSocial("Dom Pedro");

                // Adiciona um telefone ao cliente
                Telefone telefone = new Telefone();
                telefone.setDdd("21");
                telefone.setNumero("981234576");
                cliente.addTelefone(telefone);

                // Adiciona um endereço ao cliente
                Endereco endereco = new Endereco();
                endereco.setEstado("Rio de Janeiro");
                endereco.setCidade("Rio de Janeiro");
                endereco.setBairro("Copacabana");
                endereco.setRua("Avenida Atlântica");
                endereco.setNumero("1702");
                endereco.setCodigoPostal("22021001");
                endereco.setInformacoesAdicionais("Hotel Copacabana palace");
                cliente.setEndereco(endereco);

                // Inicializa a lista de documentos se for nula
                if (cliente.getDocumentos() == null) {
                    cliente.setDocumentos(new ArrayList<>());
                }

                Documento rg = new Documento();
                rg.setTipo("RG");
                rg.setNumero("1500");
                rg.setCliente(cliente); // Configura a referência ao cliente
                cliente.getDocumentos().add(rg);

                // Adiciona um documento CPF ao cliente
                Documento cpf = new Documento();
                cpf.setTipo("CPF");
                cpf.setNumero("00000000001");
                cpf.setCliente(cliente); // Configura a referência ao cliente
                cliente.getDocumentos().add(cpf);

                // Salva o cliente
                repositorio.save(cliente);
            }
        }
    }

}
