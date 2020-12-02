import java.util.ArrayList;

public class CadastroCliente {
    ArrayList<Cliente> cadastro = new ArrayList<Cliente>();

    static void inserir(Cliente cliente) {
        try{
            buscar_cpf(cliente.getCPF());
            throw new ClienteJaExistenteException("“Não foi possível cadastrar o cliente");
        } catch (ClienteInexistenteException e){
            ClienteArquivo.inserir(cliente);
        }
    }

    static Cliente buscar_cpf(String cpf) {
        return ClienteArquivo.buscarPorCPF(cpf);
    }
    static ArrayList<Cliente> buscar_nome(String nome){
        return ClienteArquivo.bucasPorNome(nome);
    }

    static void listar(){
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        clientes = ClienteArquivo.listar();
        for(Cliente cliente: clientes){
            System.out.println(cliente);
        }
    }

    static boolean excluir(String cpf){
        return ClienteArquivo.excluir(cpf);
    }
}