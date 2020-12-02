import java.util.Scanner;

public class criaMenu {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        String cpf;
        String nome;
        String endereco;
        String dataNascimento;
        int acao;
        while(true){
            System.out.println("1 - Cadastrar novo cliente");
            System.out.println("2 - Buscar cliente pelo nome");
            System.out.println("3 - Buscar cliente pelo CPF");
            System.out.println("4 - Excluir cliente");
            System.out.println("5 - Listar cliente");
            acao = teclado.nextInt();
            if(acao == 1){
                System.out.println("Digite o CPF do cliente");
                cpf = teclado.nextLine();
                System.out.println("Digite o nome");
                nome = teclado.nextLine();
                System.out.println("Digite o endereço");
                endereco = teclado.nextLine();
                System.out.println("Digite a data de nascimento");
                dataNascimento = teclado.nextLine();
                CadastroCliente.inserir(new Cliente(cpf, nome, endereco, dataNascimento));
            }
             
         }
    }
}
