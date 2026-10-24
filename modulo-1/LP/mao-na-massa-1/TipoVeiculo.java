public enum TipoVeiculo {
    PEQUENO(1, "Popular"),
    MEDIO(2, "SUV/Picape"),
    GRANDE(3, "Van/Micro-ônibus");

    private final int opcao;
    private final String descricao;
    
    TipoVeiculo(int opcao, String descricao){
        this.opcao = opcao;
        this.descricao = descricao;
    }

    public int getOpcao(){
        return opcao;
    }

    public String getDescricao(){
        return descricao;
    }

    public static int fromName(String nomeOpcao){
        for(TipoVeiculo n: TipoVeiculo.values()){
            if(n.name().equalsIgnoreCase(nomeOpcao)){
                return n.getOpcao();
            }
        }
        throw new IllegalArgumentException("Tipo de Veículo Não existe");
    }

    public static TipoVeiculo fromOpcao(int opcao){
        for(TipoVeiculo v: TipoVeiculo.values()){
            if(v.getOpcao() == opcao){
                return v;
            }
        }
        throw new IllegalArgumentException("Tipo de Veóculo Não existe");
    }
}
