public class Cliente {
    private String nome;
    private TipoVeiculo tipoVeiculo;
    private TipoServico tipoServico;
    private double valorServico;

    public Cliente(){

    }

    public Cliente(String nome, TipoServico tipoServico, TipoVeiculo tipoVeiculo, double valorServico){
        this.nome = nome;
        this.tipoServico = tipoServico;
        this.tipoVeiculo = tipoVeiculo;
        this.valorServico = valorServico;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    public void apresentarCliente(){
        System.out.println("[OUT]: Cliente Atual: ");
        System.out.println("[OUT]: NOME - "+this.nome);
        System.out.println("[OUT]: SERVIÇO - "+this.tipoServico.getDescricao());
        System.out.println("[OUT]: VEÍCULO - "+this.tipoVeiculo + " - " + this.tipoVeiculo.getDescricao());
        System.out.println("[OUT]: VALOR - R$ "+this.valorServico);
    }
}