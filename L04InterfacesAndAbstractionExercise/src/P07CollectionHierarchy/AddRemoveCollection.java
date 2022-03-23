package P07CollectionHierarchy;

public class AddRemoveCollection extends Collection
        implements AddRemovable {

    @Override
    public int add(String element) {
        this.getItems().add(0, element);
        return 0;
    }

    @Override
    public String remove() {
        return this.getItems().remove(this.getItems().size() - 1);
    }
}
