package ussrfantom.com.example.yellowworld.gamemenu;

public class Winner {
    private String name;
    private String data;
    private String description;

    public Winner(String name, String data, String description) {
        this.name = name;
        this.data = data;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
