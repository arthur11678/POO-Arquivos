import java.util.ArrayList;
import java.util.Scanner;

public class criaMenu {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int acao;
        System.out.println("1 - Cadastrar novo cliente");
        System.out.println("2 - Buscar cliente pelo nome");
        System.out.println("3 - Buscar cliente pelo CPF");
        System.out.println("4 - Excluir cliente");
        System.out.println("5 - Listar cliente");
        acao = teclado.nextInt();
        if(acao == 1){
            String cpf;
            String nome;
            String endereco;
            String dataNascimento;
            System.out.println("Digite o CPF do cliente");
            cpf = teclado.nextLine();
            System.out.println("Digite o nome");
            nome = teclado.nextLine();
            System.out.println("Digite o endereço");
            endereco = teclado.nextLine();
            System.out.println("Digite a data de nascimento");
            dataNascimento = teclado.nextLine();
            try{
            CadastroCliente.inserir(new Cliente(cpf, nome, endereco, dataNascimento));
            }
            catch (ClienteInexistenteException err){
                System.out.println("Cliente cadastrado com sucesso");
            }
        }
        else if(acao == 2){
            System.out.println("Digite o nome do cliente");
            String nome = teclado.nextLine();
            ArrayList<Cliente> clientes = new ArrayList<Cliente>();
            try{
                clientes = CadastroCliente.buscar_nome(nome);
                for(Cliente cliente : clientes)
                System.out.println(cliente);
            } catch (ClienteInexistenteException err){
                System.out.println(err);
            }
        }
        else if(acao ==3){
            String cpf;
            System.out.println("Digite o CPF do cliente");
            cpf = teclado.nextLine();
            Cliente cliente = new Cliente();
            try{
                cliente = CadastroCliente.buscar_cpf(cpf);
                System.out.println(cliente);
            }catch (ClienteInexistenteException err){
                System.out.println(err);
            }
        }
        else if(acao == 4){
            String cpf;
            System.out.println("Digite o CPF do cliente");
            cpf = teclado.nextLine();
            boolean corretamente = CadastroCliente.excluir(cpf);
            if(corretamente){
                System.out.println("O cliente foi excluido com sucesso!");
            }else{
                System.out.println("Não foi possivel excluir o cliente");
            }
        }
        else if(acao == 4){
            try{
                CadastroCliente.listar();
            } catch (ClienteInexistenteException err){
                System.out.println(err);
            }
        }
        teclado.close();
    }
}
