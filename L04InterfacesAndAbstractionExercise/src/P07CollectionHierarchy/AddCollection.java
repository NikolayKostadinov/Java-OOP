package P07CollectionHierarchy;


public class AddCollection extends Collection
        implements Addable {

    @Override
    public int add(String element) {
        this.getItems().add(element);
        return this.getItems().size() - 1;
    }
}
