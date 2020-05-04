package recomendador;

public class Pelicula {
    // Bandera que indica si el titulo ya ha sido votado por el usuario
    boolean votada = false;
    // Bandera que indica si el usuario está interesado en el titulo (Reservado / Watchlist)
    boolean interes = false;
    // Bandera que indica si se han modificado los valores para volver a obtener la probabilidad de Interés
    boolean modificado = false;

    double pGustar = 0.0;
    double pNoGustar = 0.0;
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

        this.pGustar = 0.0;
        this.pNoGustar = 0.0;
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

