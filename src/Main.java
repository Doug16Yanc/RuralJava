import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Cadastro> cadastrosProdutores;

    public static void main(String[] args)
    {
        cadastrosProdutores = new ArrayList<>();
        realizacoes();
    }

    public static void realizacoes()
    {
        System.out.println("=======================================================");
        System.out.println("===========Bem-vindo(a) ao nosso sistema online que auxilia o produtor rural=========");
        System.out.println("========================================================================================");
        System.out.println("============Selecione uma opção que desejas realizar======================================");
        System.out.println("===========================================================================================");
        System.out.println("| Alternativa 1:  Realizar cadastro de produtor  |");
        System.out.println("| Alternativa 2:  Realizar adição de cabeças de gado   |");
        System.out.println("| Alternativa 3:  Realizar exclusão de cabeças de gado  |");
        System.out.println("| Alternativa 4:  Realizar transferência(inclui vendas, trocas ou doações) de cabeças de gadp |");
        System.out.println("| Alternativa 5:  Gerar uma lista de produtores cadastrados");
        System.out.println("| Alternativa 6:  Encerrar o programa |");

        int alternativa = scan.nextInt();

        switch(alternativa)
        {
            case 1:
                criarCadastro();
                break;
            case 2:
                adicionarRebanho();
                break;
            case 3:
                excluirRebanho();
                break;
            case 4:
                transferirCabeca();
                break;
            case 5:
                percorrerCadastros();
                break;
            case 6:
                System.out.println("Agradeço sua interação comigo. Até logo!");
                System.exit(0);
            default:
                System.out.println("Alternativa inexistente!");
                break;
        }

    }
    public static void criarCadastro()
    {
        System.out.println("Você está criando um cadastro.");

        System.out.printf("Digite um número identificador:");
        int numeroID = scan.nextInt();

        System.out.printf("Digite um CPF válido:");
        String cpf= scan.next();

        System.out.printf("Digite a localidade do produtor:");
        String localidade = scan.next();

        Produtor usuario = new Produtor(numeroID, cpf, localidade);

        Cadastro cadastro = new Cadastro(usuario);

        cadastrosProdutores.add(cadastro);

        System.out.println("Cadastro realizado com sucesso.");

        realizacoes();
    }
    private static Cadastro encontrarCadastro(int numeroCadastro)
    {
        Cadastro cadastro = null;

        if (cadastrosProdutores.size() > 0)
        {
            for (Cadastro cadastro1: cadastrosProdutores)
            {
                if (cadastro1.getNumeroCadastro() == numeroCadastro)
                {
                    cadastro = cadastro1;
                }
            }
        }
        return cadastro;
    }
    public static void adicionarRebanho()
    {
        System.out.println("Número do cadastro:\n");
        int numeroCadastro = scan.nextInt();

        Cadastro cadastro = encontrarCadastro(numeroCadastro);

        if (cadastro != null)
        {
            System.out.println("Quantas cabeças de gado desejas adicionar:");
            int valorAdicao = scan.nextInt();

            cadastro.adicionarRebanho(valorAdicao);
        }
        else
        {
            System.out.println("Cadastro não localizado.");
        }
        realizacoes();
    }
    public static void excluirRebanho()
    {
        System.out.println("Número do cadastro:");
        int numeroCadastro = scan.nextInt();

        Cadastro cadastro = encontrarCadastro(numeroCadastro);

        if (cadastro != null)
        {
            System.out.println("Quantas cabeças de gado desejas excluir:");
            int valorExclusao = scan.nextInt();

            cadastro.excluirRebanho(valorExclusao);

            System.out.println("Exclusão realizada com sucesso.");
        }
        else
        {
            System.out.println("Cadastro não encontrado.");
        }
        realizacoes();
    }
    public static void transferirCabeca()
    {
        System.out.println("Número de cadastro que desejas realizar transferência de cabeças de gado:");
        int numcadastroRemetente = scan.nextInt();

        Cadastro cadastroRemetente = encontrarCadastro(numcadastroRemetente);

        if (cadastroRemetente != null)
        {
            System.out.println("Cadastro encontrado com sucesso.");
            System.out.println("Digite o número de cadastro o qual receberá a transferência:");
            int numcadastroDestinatario = scan.nextInt();

            Cadastro cadastroDestinatario = encontrarCadastro(numcadastroDestinatario);

            if (cadastroDestinatario != null)
            {
                System.out.println("Digite a quantidade de cabeças a ser transferidas:");
                int quantidade = scan.nextInt();

                cadastroRemetente.transferirRebanho(cadastroDestinatario, quantidade);
            }
            else
            {
                System.out.println("Cadastro de destinatário não localizado.");
            }
        }
        else
        {
            System.out.println("Cadastro de remetente não localizado.");
        }
        realizacoes();
    }
    public static void percorrerCadastros()
    {
        if (cadastrosProdutores.size() > 0)
        {
            for (Cadastro cadastro: cadastrosProdutores)
            {
                System.out.println(cadastro);
            }
        }
        else
        {
            System.out.println("Não há cadastros feitos.");
        }
        realizacoes();
    }
}