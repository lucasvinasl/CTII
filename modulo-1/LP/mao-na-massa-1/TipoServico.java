public enum TipoServico {
    LAVACAO_EXTERNA(1, "Lavação Externa"),
    LAVACAO_EXTERNA_INTERNA(2, "Lavação Externa e Interna"),
    LAVACAO_EXTERNA_INTERNA_CERA(3, "Lavação Externa + Interna + Cera");

    public final int opcao;
    public final String descricao;

    TipoServico(int opcao, String descricao){
        this.opcao = opcao;
        this.descricao = descricao;
    }

    public int getOpcao(){
        return this.opcao;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public int fromName(String opcao){
        for(TipoServico s: TipoServico.values()){
            if(s.name().equalsIgnoreCase(opcao)){
                return s.getOpcao();
            }
        }
        throw new IllegalArgumentException("Tipo de Serviço Não existe");
    }

    public static TipoServico fromOpcao(int opcao){
        for(TipoServico s: TipoServico.values()){
            if(s.getOpcao() == opcao){
                return s;
            }
        }
        throw new IllegalArgumentException("Tipo de Serviço Não existe");
    }
}
