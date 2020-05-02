package recomendador;

public class Pelicula {
    String MovieTitle = "";
    int Duration = 0;
    String Color = "";
    String[] Generes = new String[] {};
    String[] PlotKeyWords = new String[] {};
    String Language = "";
    String Country = "";
    String ContentRating = "";
    int TitleYear = 0;
    int MovieFaceBookLikes = 0;
    double imdbScore = 0.0;
    String Director = "";
    String Actor1 = "";
    String Actor2 = "";
    String Actor3 = "";

    public Pelicula(String MovieTitle, int Duration, String Color, String[] Generes, String[] PlotKeyWords, String Language, String Country,
                    String ContentRating, int TitleYear, int MovieFaceBookLikes, double imdbScore, String Director, String Actor1,
                    String Actor2, String Actor3){
        this.MovieTitle = MovieTitle;
        this.Duration = Duration;
        this.Color = Color;
        this.Generes = Generes;
        this.PlotKeyWords = PlotKeyWords;
        this.Language = Language;
        this.Country = Country;
        this.ContentRating = ContentRating;
        this.TitleYear = TitleYear;
        this.MovieFaceBookLikes = MovieFaceBookLikes;
        this.imdbScore = imdbScore;
        this.Director = Director;
        this.Actor1 = Actor1;
        this.Actor2 = Actor2;
        this.Actor3 = Actor3;
    }
}
