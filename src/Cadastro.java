public class Cadastro {
    private static int contadorCadastros = 1;

    private int numeroCadastro;
    private Produtor produtor;
    private int rebanho = 0;

    public Cadastro(Produtor produtor)
    {
        this.numeroCadastro = Cadastro.contadorCadastros;
        this.produtor = produtor;
        this.updateRebanho();
        Cadastro.contadorCadastros += 1;

    }
    public int getNumeroCadastro()
    {
        return numeroCadastro;
    }
    public void setNumeroCadastro(int numeroCadastro)
    {
        this.numeroCadastro = numeroCadastro;
    }
    public Produtor getUsuario()
    {
        return produtor;
    }
    public void setUsuario(Produtor produtor)
    {
        this.produtor = produtor;
    }
    public int getRebanho()
    {
        return rebanho;
    }
    public void setRebanho(int rebanho)
    {
        this.rebanho = rebanho;
    }
    private void updateRebanho() {
        this.rebanho = this.getRebanho();
    }
    @Override
    public String toString()
    {
        return "\nNúmero de cadastro" + this.getNumeroCadastro() +
                "\nUsuário:" + this.produtor.getNumeroID() +
                "\nCadastro de pessoa física:" + this.produtor.getCpf() +
                "\nLocalidade:" + this.produtor.getLocalidade() +
                "\nNúmero de cabeças de gado:" + this.getRebanho() + "\n";
    }
    public void adicionarRebanho(int quantidade)
    {
        if (quantidade > 0)
        {
            setRebanho(getRebanho() + quantidade);

            System.out.println("Adição de cabeças de gado realizado com sucesso.");
        }
        else
        {
            System.out.println("Não foi possível realizar adição de animais. Tente novamente");
        }
    }
    public void excluirRebanho(int quantidade)
    {
        if (quantidade > 0 && this.getRebanho() >= quantidade)
        {
            setRebanho(getRebanho() - quantidade);
            System.out.println("Exclusão de cabeças de gado realizada com sucesso.");
        }
        else
        {
            System.out.println("Não foi possível concluir o processo. Tente novamente!");
        }
    }
    public void transferirRebanho(Cadastro cadastroParaTransferir, int quantidade)
    {
        if (quantidade > 0 && this.getRebanho() >= quantidade)
        {
            setRebanho(getRebanho() - quantidade);

            cadastroParaTransferir.rebanho = cadastroParaTransferir.getRebanho() + quantidade;

            System.out.println("Transferência realizada com sucesso.");
        }
        else
        {
            System.out.println("Não foi possível registrar a transferência. Tente novamente!");
        }

    }
}
