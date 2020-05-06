package recomendador;

import java.util.ArrayList;

public class PeliculaLite{

    boolean bPositivo = false;
    boolean bNegativo = false;

    String MovieTitle = "";
    int MovieFaceBookLikes = 0;
    double imdbScore = 0.0;
    String Director;
    String ContentRating;
    int TitleYear;
    String Language;

    public PeliculaLite(String MovieTitle, String Language, String ContentRating, int TitleYear, String Director,
                        int MovieFaceBookLikes, double imdbScore){

        this.MovieTitle = MovieTitle;
        this.Language = Language;
        this.ContentRating = ContentRating;
        this.TitleYear = TitleYear;
        this.Director = Director;
        this.MovieFaceBookLikes = MovieFaceBookLikes;
        this.imdbScore = imdbScore;

    }

    public double getIMDB(){
        return imdbScore;
    }


}
