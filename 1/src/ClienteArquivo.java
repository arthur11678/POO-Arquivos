import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ClienteArquivo {
    static void inserir(Cliente cliente) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("clientes.txt"));
        buffWrite.append(cliente.getNome()+";" + cliente.getCPF() + ";" + cliente.getEndereco() + ";" + cliente.getDataNascimento());
        buffWrite.close();
    }

    static Cliente buscarPorCPF(String CPF) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader("clientes.txt"));
        String linha = "";
        ArrayList<String> conteudo = new ArrayList<String>();
        while (true) {
            linha = buffRead.readLine();
            if(linha == null){
                break;
            }
            for(String palavra : linha.split(";")){
                conteudo.add(palavra);
            }
            if(conteudo.contains(CPF)){
                buffRead.close();
                return new Cliente(conteudo.get(1), conteudo.get(0), conteudo.get(2), conteudo.get(3));

            }else{
                conteudo.clear();
            }
        }
        buffRead.close();
        throw new ClienteInexistenteException("O CPF não foi encontrado");
		
    }
    static ArrayList<Cliente> bucasPorNome(String nome) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader("clientes.txt"));
        String linha = "";
        ArrayList<String> conteudo = new ArrayList<String>();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        while (true) {
            linha = buffRead.readLine();
            if(linha == null){
                break;
            }
            for(String palavra : linha.split(";")){
                conteudo.add(palavra);
            }
            if(conteudo.contains(nome)){
                clientes.add(new Cliente(conteudo.get(1), conteudo.get(0), conteudo.get(2), conteudo.get(3)));

            }
            conteudo.clear();
        }
        buffRead.close();
        if(clientes.isEmpty()){
            throw new ClienteInexistenteException("Não foi encontrado nenhum cliente com esse nome");
        }else{
            return clientes;
        }

    }
    static ArrayList<Cliente> listar() throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader("clientes.txt"));
        String linha = "";
        ArrayList<String> conteudo = new ArrayList<String>();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        while (true) {
            linha = buffRead.readLine();
            if(linha == null){
                break;
            }
            for(String palavra : linha.split(";")){
                conteudo.add(palavra);
            }
            clientes.add(new Cliente(conteudo.get(1), conteudo.get(0), conteudo.get(2), conteudo.get(3)));
            conteudo.clear();
        }
        buffRead.close();
        return clientes;
    }
    static void excluir(String CPF) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader("clientes.txt"));
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("clientes.txt"));
        buffWrite.write("");
        String linha = "";
        ArrayList<String> conteudo = new ArrayList<String>();
        while (true) {
            linha = buffRead.readLine();
            if(linha == null){
                break;
            }
            for(String palavra : linha.split(";")){
                conteudo.add(palavra);
            }
            if(!conteudo.contains(CPF)){
                buffWrite.append(linha);
            }
        }
        buffRead.close();
        buffWrite.close();

    }
}
