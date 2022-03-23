package P07CollectionHierarchy;

public class MyListImpl extends Collection
        implements MyList {

    @Override
    public int add(String element) {
        this.getItems().add(0, element);
        return 0;
    }

    @Override
    public String remove() {
        return this.getItems().remove(0);
    }

    @Override
    public int getUsed() {
        return this.getItems().size();
    }
}
