package product;

public interface ProductInterface<E> {
    E create();
    E update();
    E delete();
    E getByID();
    void displayAll();
}
