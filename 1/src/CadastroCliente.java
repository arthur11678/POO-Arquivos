public class CadastroCliente {
    Cliente[] cadastro = new Cliente[10];
    int clientes = 0;

    static void inserir(Cliente cliente) {
        ClienteArquivo.inserir(cliente);
        }

    public Cliente buscar(String cpf) {
        return ClienteArquivo.buscarPorCPF(cpf);
    }

    public void listar(){
        Cliente[] clientes;
        clientes = ClienteArquivo.listar();
        for(Cliente cliente: clientes){
            System.out.println(cliente);
        }
    }

    public boolean excluir(String cpf){
        return ClienteArquivo.excluir(cpf);
    }
}