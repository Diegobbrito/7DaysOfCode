
package dto.marvel;

import java.util.List;

public class Stories {

    private Integer available;
    private String collectionURI;
    private List<ItemType> items;
    private Integer returned;


    public Stories() {
    }

    public Stories(Integer available, String collectionURI, List<ItemType> items, Integer returned) {
        super();
        this.available = available;
        this.collectionURI = collectionURI;
        this.items = items;
        this.returned = returned;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<ItemType> getItems() {
        return items;
    }

    public void setItems(List<ItemType> items) {
        this.items = items;
    }

    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

}
