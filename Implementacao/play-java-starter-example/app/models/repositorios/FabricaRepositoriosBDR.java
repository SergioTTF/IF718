package models.repositorios;

public class FabricaRepositoriosBDR extends FabricaAbstrataRepositorio{

    @Override
    public IRepositorioLivro criarRepositorioLivro() {
        return new RepositorioLivroBDR();
    }
}
