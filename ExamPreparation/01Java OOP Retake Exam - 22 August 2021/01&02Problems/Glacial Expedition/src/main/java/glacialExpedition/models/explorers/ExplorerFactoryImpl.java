package glacialExpedition.models.explorers;

public class ExplorerFactoryImpl implements ExplorerFactory {
    @Override
    public Explorer getInstance(String type, String explorerName) {
        switch (type) {
            case "AnimalExplorer":
                return new AnimalExplorer(explorerName);
            case "GlacierExplorer":
                return new GlacierExplorer(explorerName);
            case "NaturalExplorer":
                return new NaturalExplorer(explorerName);
            default:
                throw new IllegalArgumentException("Explorer type doesn't exists.");
        }
    }
}
