import java.io.IOException;
import java.util.ArrayList;

public class CadastroCliente {
    ArrayList<Cliente> cadastro = new ArrayList<Cliente>();

    static void inserir(Cliente cliente) throws IOException {
        try {
            buscar_cpf(cliente.getCPF());
            throw new ClienteJaExistenteException("“Não foi possível cadastrar o cliente");
        } catch (ClienteInexistenteException e) {
            ClienteArquivo.inserir(cliente);
        }
    }

    static Cliente buscar_cpf(String cpf) throws IOException {
        return ClienteArquivo.buscarPorCPF(cpf);
    }
    static ArrayList<Cliente> buscar_nome(String nome) throws IOException {
        return ClienteArquivo.bucasPorNome(nome);
    }

    static void listar() throws IOException {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        clientes = ClienteArquivo.listar();
        for(Cliente cliente: clientes){
            System.out.println(cliente);
        }
    }

    static boolean excluir(String cpf) throws IOException {
        try{
            ClienteArquivo.excluir(cpf);
            return true;
        }catch(IOException err){
            return false;
        }
    }
}