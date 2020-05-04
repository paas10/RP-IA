package recomendador;

import com.sun.media.sound.SF2GlobalRegion;
import com.sun.tools.javah.Gen;

public class Pelicula {
    // Bandera que indica si el titulo ya ha sido votado por el usuario
    boolean votada = false;
    // Bandera que indica si el usuario está interesado en el titulo (Reservado / Watchlist)
    boolean interes = false;
    // Bandera que indica si se han modificado los valores para volver a obtener la probabilidad de Interés
    boolean modificado = false;

    // Probabilidades Reales
    double pGustar = 0.0;
    double pNoGustar = 0.0;

    // Probabilidades De que una pelicula guste o no
    double pPeliculaSi = Math.log(0.50);
    double pPeliculaNo = Math.log(0.50);

    // Suma de logaritmos naturales
    double AFavor = 0.0;
    double EnContra = 0.0;

    String MovieTitle = "";
    iCategoria Duration;
    sCategoria Color;
    sArray Generes;
    sArray PlotKeyWords;
    sCategoria Language;
    sCategoria Country;
    sCategoria ContentRating;
    iCategoria TitleYear;
    int MovieFaceBookLikes = 0;
    double imdbScore = 0.0;
    sCategoria Director;
    sCategoria Actor1;
    sCategoria Actor2;
    sCategoria Actor3;

    public Pelicula(String MovieTitle, int Duration, String Color, String[] Generes, String[] PlotKeyWords, String Language, String Country,
                    String ContentRating, int TitleYear, int MovieFaceBookLikes, double imdbScore, String Director, String Actor1,
                    String Actor2, String Actor3){
        this.votada = false;
        this.interes = false;
        this.modificado = false;

        // Probabilidades
        this.pGustar = 0.0;
        this.pNoGustar = 0.0;

        // Suma de logaritmos naturales
        this.AFavor = 0.0;
        this.EnContra = 0.0;

        this.MovieTitle = MovieTitle;
        this.Duration = new iCategoria(Duration);
        this.Color = new sCategoria(Color);
        this.Generes = new sArray(Generes);
        this.PlotKeyWords = new sArray(PlotKeyWords);
        this.Language = new sCategoria(Language);
        this.Country = new sCategoria(Country);
        this.ContentRating = new sCategoria(ContentRating);
        this.TitleYear = new iCategoria(TitleYear);
        this.MovieFaceBookLikes = MovieFaceBookLikes;
        this.imdbScore = imdbScore;
        this.Director = new sCategoria(Director);
        this.Actor1 = new sCategoria(Actor1);
        this.Actor2 = new sCategoria(Actor2);
        this.Actor3 = new sCategoria(Actor3);
    }

    public Pelicula(String MovieTitle, String Language, String ContentRating , int TitleYear, String Director , double pGustar, double pNoGustar) {

        // Probabilidades
        this.pGustar = pGustar;
        this.pNoGustar = pNoGustar;

        this.MovieTitle = MovieTitle;
        this.Language = new sCategoria(Language);
        this.ContentRating = new sCategoria(ContentRating);
        this.TitleYear = new iCategoria(TitleYear);
        this.Director = new sCategoria(Director);
    }

    public void ObtenerProbabilidades(){
        if (Generes.Modificado) {
            double favor = 0.0;
            double contra = 0.0;

            for (sCategoria value : Generes.Valores) {
                if (value.AFavor != 0)
                    favor += Math.log(value.AFavor/value.Normalizador);
                if (value.EnContra != 0)
                    contra += Math.log(value.EnContra/value.Normalizador);
            }

            Generes.AFavor = favor;
            Generes.EnContra = contra;
            Generes.Modificado = false;
        }

        if (modificado){
            double favor = 0.0;
            double contra = 0.0;

            if (Duration.AFavor != 0)
                favor += Math.log(Duration.AFavor/Duration.Normalizador);
            if (Duration.EnContra != 0)
                contra += Math.log(Duration.EnContra/Duration.Normalizador);

            if (Color.AFavor != 0)
                favor += Math.log(Color.AFavor/Color.Normalizador);
            if (Color.EnContra != 0)
                contra += Math.log(Color.EnContra/Color.Normalizador);

            if (Generes.AFavor != 0)
                favor += Generes.AFavor;
            if (Generes.EnContra != 0)
                contra += Generes.EnContra;

            if (Language.AFavor != 0)
                favor += Math.log(Language.AFavor/Language.Normalizador);
            if (Language.EnContra != 0)
                contra += Math.log(Language.EnContra/Language.Normalizador);

            if (Country.AFavor != 0)
                favor += Math.log(Country.AFavor/Country.Normalizador);
            if (Country.EnContra != 0)
                contra += Math.log(Country.EnContra/Country.Normalizador);

            if (ContentRating.AFavor != 0)
                favor += Math.log(ContentRating.AFavor/ContentRating.Normalizador);
            if (ContentRating.EnContra != 0)
                contra += Math.log(ContentRating.EnContra/ContentRating.Normalizador);

            if (TitleYear.AFavor != 0)
                favor += Math.log(TitleYear.AFavor/TitleYear.Normalizador);
            if (TitleYear.EnContra != 0)
                contra += Math.log(TitleYear.EnContra/TitleYear.Normalizador);

            if (Director.AFavor != 0)
                favor += Math.log(Director.AFavor/Director.Normalizador);
            if (Director.EnContra != 0)
                contra += Math.log(Director.EnContra/Director.Normalizador);

            if (Actor1.AFavor != 0)
                favor += Math.log(Actor1.AFavor/Actor1.Normalizador);
            if (Actor1.EnContra != 0)
                contra += Math.log(Actor1.EnContra/Actor1.Normalizador);

            if (Actor2.AFavor != 0)
                favor += Math.log(Actor2.AFavor/Actor2.Normalizador);
            if (Actor2.EnContra != 0)
                contra += Math.log(Actor2.EnContra/Actor2.Normalizador);

            if (Actor3.AFavor != 0)
                favor += Math.log(Actor3.AFavor/Actor3.Normalizador);
            if (Actor3.EnContra != 0)
                contra += Math.log(Actor3.EnContra/Actor3.Normalizador);

            AFavor = favor + pPeliculaSi;
            EnContra = contra + pPeliculaNo;

            pGustar = Math.exp(AFavor)/(Math.exp(AFavor) + Math.exp(EnContra));
            pNoGustar = Math.exp(EnContra)/(Math.exp(AFavor) + Math.exp(EnContra));

            modificado = false;
        }

    }
}

class sCategoria {
    String Valor = "";
    double AFavor = 0.0;
    double EnContra = 0.0;
    double Normalizador = 0.0;

    public sCategoria (String Valor){
        this.Valor = Valor;
        this.AFavor = 0.0;
        this.EnContra = 0.0;
        this.Normalizador = 0.0;
    }
}

class iCategoria {
    int Valor = 0;
    double AFavor = 0.0;
    double EnContra = 0.0;
    double Normalizador = 0.0;
    double Rango = 0.0;

    public iCategoria (int Valor){
        this.Valor = Valor;
        this.AFavor = 0.0;
        this.EnContra = 0.0;
        this.Normalizador = 0.0;
        this.Rango = Math.floor(Valor/10);
    }
}

class sArray {
    boolean Modificado = false;
    double AFavor = 0.0;
    double EnContra = 0.0;
    sCategoria[] Valores;

    public sArray (String[] Valores){
        this.Modificado = false;
        this.Valores = new sCategoria[Valores.length];
        int i = 0;

        for (String value : Valores) {
            sCategoria temp = new sCategoria(value);
            this.Valores[i] = temp;
            i++;
        }
    }
}

