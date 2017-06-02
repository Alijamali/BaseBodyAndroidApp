package exampel.com.myapplication.RecyclerView;

/**
 * Created by Ali on 16/05/2017.
 */

public class Item {
    private String id;
    private String name;
    private String title, location, year;
    private int image;

    public Item(){
    }
    public Item(String title, String location, String year, int image) {
        this.year = year;
        this.title = title;
        this.location = location;
        this.image = image;
    }


    public Item(String id ,String name ){
        this.id=id;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getYear() {
        return year;
    }

    public int getImage() {
        return image;
    }
}
