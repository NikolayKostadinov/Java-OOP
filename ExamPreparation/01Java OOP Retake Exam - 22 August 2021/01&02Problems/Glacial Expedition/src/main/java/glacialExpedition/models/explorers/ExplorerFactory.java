package glacialExpedition.models.explorers;

public interface ExplorerFactory {
    Explorer getInstance(String type, String explorerName);
}

