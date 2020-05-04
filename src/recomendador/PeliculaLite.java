package recomendador;

import java.util.ArrayList;

public class PeliculaLite{

    String MovieTitle = "";
    int MovieFaceBookLikes = 0;
    double imdbScore = 0.0;

    public PeliculaLite(String MovieTitle, int MovieFaceBookLikes, double imdbScore){

        this.MovieTitle = MovieTitle;
        this.MovieFaceBookLikes = MovieFaceBookLikes;
        this.imdbScore = imdbScore;
    }

    public double getIMDB(){
        return imdbScore;
    }


}
