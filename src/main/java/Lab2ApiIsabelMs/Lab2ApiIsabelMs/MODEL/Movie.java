package Lab2ApiIsabelMs.Lab2ApiIsabelMs.MODEL;

public class Movie {
    public Movie() {
    }

    public Movie(final int _id,final String _title, final int _year, final String _poster) {
        
        
        this.id = _id;
        this.title = _title;
        this.year = _year;
        this.poster = _poster;
        

    }

    public Movie(String title2) {
	}

    private int id; 
	private String title;
    private int year;
    private String poster;



    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

  
    


}
