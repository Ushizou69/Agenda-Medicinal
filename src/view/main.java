/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import model.*;

/**
 *
 * @author 2025001861
 */
public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CadastroDAO dao = new CadastroDAO();
        Agenda agendaAtual = null;

        int opcao;

        try {
            do {
                System.out.println("\n===== MENU =====");
                System.out.println("1 - Cadastrar usuario/pessoa/remedio");
                System.out.println("2 - Listar cadastros");
                System.out.println("3 - Buscar cadastro por usuario");
                System.out.println("4 - Criar tarefa e agenda");
                System.out.println("5 - Mostrar agenda atual");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opcaoo: ");
                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {

                    case 1 -> {
                        System.out.println("\n=== CADASTRO ===");

                        // -------- USUARIO --------
                        System.out.print("Nome do usuario: ");
                        String nomeUsuario = sc.nextLine();

                        System.out.print("Email do usuario: ");
                        String email = sc.nextLine();

                        System.out.print("Senha do usuario: ");
                        String senha = sc.nextLine();

                        Usuario usuario = new Usuario(nomeUsuario, email, senha);

                        // -------- PESSOA --------
                        System.out.print("Nome da pessoa: ");
                        String nomePessoa = sc.nextLine();

                        System.out.print("Idade: ");
                        int idade = Integer.parseInt(sc.nextLine());

                        System.out.print("Altura (ex: 1.75): ");
                        double altura = Double.parseDouble(sc.nextLine());

                        System.out.print("Peso (ex: 78.5): ");
                        double peso = Double.parseDouble(sc.nextLine());

                        Pessoa pessoa = new Pessoa(nomePessoa, idade, altura, peso);

                        // -------- REMEDIO --------
                        System.out.print("Nome do remedio: ");
                        String nomeRemedio = sc.nextLine();

                        System.out.print("Descricao do remedio: ");
                        String descricao = sc.nextLine();

                        System.out.print("Quantidade de pilulas: ");
                        int qtdPilulas = Integer.parseInt(sc.nextLine());

                        System.out.print("Data de inicio da medicacao - ano: ");
                        int ano = Integer.parseInt(sc.nextLine());

                        System.out.print("Mes: ");
                        int mes = Integer.parseInt(sc.nextLine());

                        System.out.print("Dia: ");
                        int dia = Integer.parseInt(sc.nextLine());

                        LocalDate dataInicio = LocalDate.of(ano, mes, dia);

                        System.out.print("Preco do remedio: ");
                        double preco = Double.parseDouble(sc.nextLine());

                        System.out.print("Pilulas por dia: ");
                        int pilulasPorDia = Integer.parseInt(sc.nextLine());

                        Remedio remedio = new Remedio(
                                nomeRemedio,
                                descricao,
                                qtdPilulas,
                                dataInicio,
                                preco,
                                pilulasPorDia
                        );

                        Cadastro cadastro = new Cadastro(pessoa, usuario, remedio);

                        // Perguntar se quer adicionar mais remédios
                        String continuar;
                        do {
                            System.out.print("Adicionar outro remedio? (s/n): ");
                            continuar = sc.nextLine();
                            if (continuar.equalsIgnoreCase("s")) {
                                // coletar dados do novo remédio
                                Remedio novoRemedio = new Remedio(nomeRemedio,descricao,qtdPilulas,dataInicio,preco,pilulasPorDia);
                                cadastro.adicionarRemedio(novoRemedio);
                            }
                        } while (continuar.equalsIgnoreCase("s"));
                        dao.add(cadastro);
                    }

                    case 2 -> {
                        System.out.println("\n=== LISTA DE CADASTROS ===");
                        dao.getDados();
                    }

                    case 3 -> {
                        System.out.println("\n=== BUSCAR CADASTRO POR USUARIO ===");

                        System.out.print("Nome do usuario: ");
                        String nomeUsuario = sc.nextLine();

                        System.out.print("Email do usuario: ");
                        String email = sc.nextLine();

                        System.out.print("Senha do usuario: ");
                        String senha = sc.nextLine();

                        Usuario usuarioBusca = new Usuario(nomeUsuario, email, senha);

                        Cadastro resultado = dao.acharPorUsuario(usuarioBusca);

                        if (resultado != null) {
                            System.out.println("Cadastro encontrado:");
                            System.out.println(resultado);
                        } else {
                            System.out.println("Usuario nao encontrado.");
                        }
                    }

                    case 4 -> {
                        System.out.println("\n=== CRIAR TAREFA E AGENDA ===");

                        System.out.print("Titulo da tarefa: ");
                        String titulo = sc.nextLine();

                        System.out.print("Descricao da tarefa: ");
                        String descricaoTarefa = sc.nextLine();

                        System.out.println("Data e hora da tarefa:");

                        System.out.print("Ano: ");
                        int ano = Integer.parseInt(sc.nextLine());

                        System.out.print("Mes: ");
                        int mes = Integer.parseInt(sc.nextLine());

                        System.out.print("Dia: ");
                        int dia = Integer.parseInt(sc.nextLine());

                        System.out.print("Hora: ");
                        int hora = Integer.parseInt(sc.nextLine());

                        System.out.print("Minuto: ");
                        int minuto = Integer.parseInt(sc.nextLine());

                        LocalDateTime dataHora = LocalDateTime.of(ano, mes, dia, hora, minuto);
                        
                        // Buscar cadastro para pegar o remédio
                        System.out.print("Nome do usuario para vincular o remedio: ");
                        String nomeVinculo = sc.nextLine();
                        Cadastro cadastroVinculado = dao.acharPorUsuario(new Usuario(nomeVinculo, "@", "000000"));

                        Remedio remedioAgenda = null;
                        if (cadastroVinculado != null && !cadastroVinculado.getRemedios().isEmpty()) {
                            System.out.println("Remedios disponiveis:");
                            List<Remedio> lista = cadastroVinculado.getRemedios();
                            for (int i = 0; i < lista.size(); i++) {
                                System.out.println((i + 1) + " - " + lista.get(i).getNome());
                            }
                            System.out.print("Escolha o numero do remedio: ");
                            int escolha = Integer.parseInt(sc.nextLine()) - 1;
                            if (escolha >= 0 && escolha < lista.size()) {
                                remedioAgenda = lista.get(escolha);
                            }
                        } else {
                            System.out.println("Nenhum cadastro/remedio encontrado. Agenda sem remedio vinculado.");
                        }

                        Categoria categoria = null;

                        while (categoria == null) {
                            System.out.println("\nEscolha a categoria:");
                            System.out.println("1 - ANTIBIOTICO");
                            System.out.println("2 - SUPLEMENTO");
                            System.out.println("3 - USO_CONTINUO");
                            System.out.print("Opção: ");
                            int opCategoria = Integer.parseInt(sc.nextLine());

                            switch (opCategoria) {
                                case 1 ->
                                    categoria = Categoria.ANTIBIOTICO;
                                case 2 ->
                                    categoria = Categoria.SUPLEMENTO;
                                case 3 ->
                                    categoria = Categoria.USO_CONTINUO;
                                default ->
                                    System.out.println("Opcao invalida. Digite 1, 2 ou 3.");
                            }
                        }

                        System.out.print("Prioridade da tarefa (1 a 3): ");
                        int prioridade = Integer.parseInt(sc.nextLine());

                        System.out.print("Tarefa concluida? (true/false): ");
                        boolean concluida = Boolean.parseBoolean(sc.nextLine());

                        Tarefa tarefa = new Tarefa(
                                titulo,
                                descricaoTarefa,
                                dataHora,
                                categoria,
                                prioridade,
                                concluida
                        );

                        System.out.print("Titulo da agenda: ");
                        String tituloAgenda = sc.nextLine();

                        System.out.print("Descricao da agenda: ");
                        String descricaoAgenda = sc.nextLine();

                        System.out.print("Agenda concluida? (true/false): ");
                        boolean agendaConcluida = Boolean.parseBoolean(sc.nextLine());

                        agendaAtual = new Agenda(
                            dataHora, 
                            tituloAgenda, 
                            descricaoAgenda,
                            remedioAgenda, 
                            tarefa, 
                            agendaConcluida
                        );

                        System.out.println("\nAgenda criada com sucesso!");
                        System.out.println(agendaAtual);
                    }

                    case 5 -> {
                        System.out.println("\n=== AGENDA ATUAL ===");
                        if (agendaAtual != null) {
                            System.out.println(agendaAtual);
                        } else {
                            System.out.println("Nenhuma agenda foi criada ainda.");
                        }
                    }

                    case 0 ->
                        System.out.println("Encerrando o programa...");

                    default ->
                        System.out.println("Opcao invalida.");
                }

            } while (opcao != 0);

            sc.close();
        } catch (NumberFormatException e) {
            System.out.println("Erro: valor numerico invalido.");
        } catch (DateTimeException e) {
            System.out.println("Erro: data ou hora invalida.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }

        //Mudar agenda para focar em remedio
        //Criar lista de remedio no cadastro
    }
}
