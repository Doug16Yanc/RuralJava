import java.util.Date;

public class Produtor {

    private static int contador = 1;

    private int numeroID;
    private String cpf;
    private String localidade;
    private Date accountCreation;

    public Produtor(int numeroID, String cpf, String localidade)
    {
        this.numeroID = numeroID;
        this.cpf = cpf;
        this.localidade = localidade;
        this.accountCreation = new Date();
        Produtor.contador += 1;
    }
    public int getNumeroID()
    {
        return numeroID;
    }
    public void setNumeroID(int numeroID)
    {
        this.numeroID = numeroID;
    }
    public String getCpf()
    {
        return cpf;
    }
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }
    public String getLocalidade()
    {
        return localidade;
    }
    public void setLocalidade(String localidade)
    {
        this.localidade = localidade;
    }
    public Date getAccountCreation()
    {
        return this.accountCreation;
    }
    @Override
    public String toString()
    {
        return "\nNúmero de identificação:" + this.getNumeroID() +
                "\nCadastro de pessoa física:" + this.getCpf() +
                "\nLocalidade:" + this.getLocalidade() +
                "\nAccount Creation Date: " + Utils.dateToString(this.getAccountCreation());
    }
}
