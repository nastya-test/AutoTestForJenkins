package model;

public class Film {
    private String name;
    private String link;
    private String yearAndGenre;

    public Film() {

    }

    public Film(String name, String link, String yearAndGenre) {
        this.name = name;
        this.link = link;
        this.yearAndGenre = yearAndGenre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getYearAndGenre() {
        return yearAndGenre;
    }

    public void setYearAndGenre(String yearAndGenre) {
        this.yearAndGenre = yearAndGenre;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", yearAndGenre='" + yearAndGenre + '\'' +
                '}';
    }
}
