package recomendador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Collections;
import java.util.*;

public class app {
    private JButton btnPrueba;
    private JPanel mainPanel;

    public app() {
        btnPrueba.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                try {
                    Pelicula[] peliculas = readFile();
                    JOptionPane.showMessageDialog(null, "Todas las peliculas han sido recuperadas");

                    peliculas = normailizarData(peliculas);

                    ArrayList<PeliculaLite> imbd = new ArrayList<PeliculaLite>();
                    for (Pelicula pelicula: peliculas) {
                        imbd.add(new PeliculaLite(pelicula.MovieTitle, pelicula.MovieFaceBookLikes, pelicula.imdbScore));
                    }

                    Collections.sort(imbd, new Comparator<PeliculaLite>(){
                        @Override
                        public int compare(PeliculaLite o1, PeliculaLite o2) {
                            return Integer.valueOf(o2.MovieFaceBookLikes).compareTo(o1.MovieFaceBookLikes);
                        }
                    });

                    JOptionPane.showMessageDialog(null, "Se ha finalizado");

                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }

        });
    }

    public static Pelicula[] normailizarData(Pelicula[] peliculas){
        for (int i = 0; i < peliculas.length; i++){
            // SE CUENTAN LAS REPETICIONES DE LA DATA PARA LOS NORMALIZADORES

            // Variables para revisar si los normalizadores ya existen en ese Feature de la película
            boolean duration = false;
            boolean color = false;
            boolean[] generes = new boolean[peliculas[i].Generes.Valores.length];
            // Variable que define si hay algún nuevo genero para continuar con las busquedas siguientes
            boolean bGeneres = false;
            boolean[] plotKeyWords = new boolean[peliculas[i].PlotKeyWords.Valores.length];
//                        boolean bPlotKeyWords = false;
            boolean language = false;
            boolean country = false;
            boolean titleYear = false;
            boolean director = false;
            boolean actor1 = false;
            boolean actor2 = false;
            boolean actor3 = false;

            // Reviso que los normalizadores aún no existan
            if (peliculas[i].Duration.Normalizador == 0)
                duration = true;
            if (peliculas[i].Color.Normalizador == 0)
                color = true;
            // Reviso cuales de los generos no tienen normalizador. Si alguno no lo tiene se procede a buscar en toda la distribución
            for (int j = 0; j < peliculas[i].Generes.Valores.length; j++) {
                if (peliculas[i].Generes.Valores[j].Normalizador == 0){
                    generes[j] = true;
                    bGeneres = true;
                }
            }
//                        for (int j = 0; j < peliculas[i].PlotKeyWords.Valores.length; j++) {
//                            if (peliculas[i].PlotKeyWords.Valores[j].Normalizador == 0){
//                                plotKeyWords[j] = true;
//                                bPlotKeyWords = true;
//                            }
//                        }
            if (peliculas[i].Language.Normalizador == 0)
                language = true;
            if (peliculas[i].Country.Normalizador == 0)
                country = true;
            if (peliculas[i].TitleYear.Normalizador == 0)
                titleYear = true;
            if (peliculas[i].Director.Normalizador == 0)
                director = true;
            if (peliculas[i].Actor1.Normalizador == 0)
                actor1 = true;
            if (peliculas[i].Actor2.Normalizador == 0)
                actor2 = true;
            if (peliculas[i].Actor3.Normalizador == 0)
                actor3 = true;



            // Se avanza pelicula por película para contar y definir los normalizadores
            for (Pelicula movie : peliculas) {
                if (duration && movie.Duration.Rango == peliculas[i].Duration.Rango)
                    peliculas[i].Duration.Normalizador++;
                if (color && movie.Color.Valor.equals(peliculas[i].Color.Valor))
                    peliculas[i].Color.Normalizador++;
                // Cada genero de la pelicula analizada
                // Si no se encontró ninguna necesidad de normalizador no se cuentan las apariciones en las peliculas
                if (bGeneres){
                    for (int j = 0; j < peliculas[i].Generes.Valores.length; j++) {
                        if (generes[j]){
                            // Generos que aparecen en el resto de peliculas
                            for (sCategoria value : movie.Generes.Valores) {
                                if (peliculas[i].Generes.Valores[j].Valor.equals(value.Valor))
                                    peliculas[i].Generes.Valores[j].Normalizador++;
                            }
                        }
                    }
                }
//                            if(bPlotKeyWords){
//                                for (int j = 0; j < peliculas[i].PlotKeyWords.Valores.length; j++) {
//                                    if (plotKeyWords[j]){
//                                        // Palabras clave que aparecen en el resto de peliculas
//                                        for (sCategoria value : movie.PlotKeyWords.Valores) {
//                                            if (peliculas[i].PlotKeyWords.Valores[j].Valor.equals(value.Valor))
//                                                peliculas[i].PlotKeyWords.Valores[j].Normalizador++;
//                                        }
//                                    }
//                                }
//                            }
                if (language && movie.Language.Valor.equals(peliculas[i].Language.Valor))
                    peliculas[i].Language.Normalizador++;
                if (country && movie.Country.Valor.equals(peliculas[i].Country.Valor))
                    peliculas[i].Country.Normalizador++;
                if (titleYear && movie.TitleYear.Rango == peliculas[i].TitleYear.Rango)
                    peliculas[i].TitleYear.Normalizador++;
                if (director && movie.Director.Valor.equals(peliculas[i].Director.Valor))
                    peliculas[i].Director.Normalizador++;
                if (actor1){
                    if (movie.Actor1.Normalizador != 0 && movie.Actor1.Valor.equals(peliculas[i].Actor1.Valor))
                        peliculas[i].Actor1.Normalizador++;
                    else if (movie.Actor2.Normalizador != 0 && movie.Actor2.Valor.equals(peliculas[i].Actor1.Valor))
                        peliculas[i].Actor1.Normalizador++;
                    if (movie.Actor3.Normalizador != 0 && movie.Actor3.Valor.equals(peliculas[i].Actor1.Valor))
                        peliculas[i].Actor1.Normalizador++;
                }
                if (actor2){
                    if (movie.Actor1.Normalizador != 0 && movie.Actor1.Valor.equals(peliculas[i].Actor2.Valor))
                        peliculas[i].Actor2.Normalizador++;
                    else if (movie.Actor2.Normalizador != 0 && movie.Actor2.Valor.equals(peliculas[i].Actor2.Valor))
                        peliculas[i].Actor2.Normalizador++;
                    else if (movie.Actor3.Normalizador != 0 && movie.Actor3.Valor.equals(peliculas[i].Actor2.Valor))
                        peliculas[i].Actor2.Normalizador++;
                }
                if (actor3){
                    if (movie.Actor1.Normalizador != 0 && movie.Actor1.Valor.equals(peliculas[i].Actor3.Valor))
                        peliculas[i].Actor3.Normalizador++;
                    else if (movie.Actor2.Normalizador != 0 && movie.Actor2.Valor.equals(peliculas[i].Actor3.Valor))
                        peliculas[i].Actor3.Normalizador++;
                    else if (movie.Actor3.Normalizador != 0 && movie.Actor3.Valor.equals(peliculas[i].Actor3.Valor))
                        peliculas[i].Actor3.Normalizador++;
                }

            }

            // Se establece el normalizador encontrado para quienes aún no lo tengan
            for (Pelicula movie : peliculas) {
                if (movie.Duration.Normalizador == 0 && movie.Duration.Rango == peliculas[i].Duration.Rango)
                    movie.Duration.Normalizador = peliculas[i].Duration.Normalizador;
                if (movie.Color.Normalizador == 0 && movie.Color.Valor.equals(peliculas[i].Color.Valor))
                    movie.Color.Normalizador = peliculas[i].Color.Normalizador;
                // Si no se encontró un nuevo normalizador no se busca a quién asignarselo porque no existe
                if (bGeneres){
                    for (int j = 0; j < movie.Generes.Valores.length; j++){
                        for (sCategoria gen : peliculas[i].Generes.Valores) {
                            if (movie.Generes.Valores[j].Valor.equals(gen.Valor))
                                movie.Generes.Valores[j].Normalizador = gen.Normalizador;
                        }
                    }
                }
//                            if (bPlotKeyWords){
//                                for (int j = 0; j < movie.PlotKeyWords.Valores.length; j++){
//                                    for (sCategoria gen : peliculas[i].PlotKeyWords.Valores) {
//                                        if (movie.PlotKeyWords.Valores[j].Valor.equals(gen.Valor))
//                                            movie.PlotKeyWords.Valores[j].Normalizador = gen.Normalizador;
//                                    }
//                                }
//                            }
                if (movie.Language.Normalizador == 0 && movie.Language.Valor.equals(peliculas[i].Language.Valor))
                    movie.Language.Normalizador = peliculas[i].Language.Normalizador;
                if (movie.Country.Normalizador == 0 && movie.Country.Valor.equals(peliculas[i].Country.Valor))
                    movie.Country.Normalizador = peliculas[i].Country.Normalizador;
                if (movie.TitleYear.Normalizador == 0 && movie.TitleYear.Rango == peliculas[i].TitleYear.Rango)
                    movie.TitleYear.Normalizador = peliculas[i].TitleYear.Normalizador;
                if (movie.Director.Normalizador == 0 && movie.Director.Valor.equals(peliculas[i].Director.Valor))
                    movie.Director.Normalizador = peliculas[i].Director.Normalizador;
                if (actor1){
                    if (movie.Actor1.Normalizador != 0 && movie.Actor1.Valor.equals(peliculas[i].Actor1.Valor))
                        movie.Actor1.Normalizador = peliculas[i].Actor1.Normalizador;
                    else if (movie.Actor2.Normalizador != 0 && movie.Actor2.Valor.equals(peliculas[i].Actor1.Valor))
                        peliculas[i].Actor1.Normalizador = peliculas[i].Actor1.Normalizador;
                    else if (movie.Actor3.Normalizador != 0 && movie.Actor3.Valor.equals(peliculas[i].Actor1.Valor))
                        peliculas[i].Actor1.Normalizador = peliculas[i].Actor1.Normalizador;
                }
                if (actor2){
                    if (movie.Actor1.Normalizador != 0 && movie.Actor1.Valor.equals(peliculas[i].Actor2.Valor))
                        movie.Actor2.Normalizador = peliculas[i].Actor2.Normalizador;
                    else if (movie.Actor2.Normalizador != 0 && movie.Actor2.Valor.equals(peliculas[i].Actor2.Valor))
                        movie.Actor2.Normalizador = peliculas[i].Actor2.Normalizador;
                    else if (movie.Actor3.Normalizador != 0 && movie.Actor3.Valor.equals(peliculas[i].Actor2.Valor))
                        movie.Actor2.Normalizador = peliculas[i].Actor2.Normalizador;
                }
                if (actor3){
                    if (movie.Actor1.Normalizador != 0 && movie.Actor1.Valor.equals(peliculas[i].Actor3.Valor))
                        movie.Actor3.Normalizador = peliculas[i].Actor3.Normalizador;
                    else if (movie.Actor2.Normalizador != 0 && movie.Actor2.Valor.equals(peliculas[i].Actor3.Valor))
                        movie.Actor3.Normalizador = peliculas[i].Actor3.Normalizador;
                    else if (movie.Actor3.Normalizador != 0 && movie.Actor3.Valor.equals(peliculas[i].Actor3.Valor))
                        movie.Actor3.Normalizador = peliculas[i].Actor3.Normalizador;
                }

            }

            //JOptionPane.showMessageDialog(null, "Ya hizo una vuelta, hay " + peliculas[i].Duration.Normalizador + "con rango 170 - 180");
        }

        return peliculas;
    }

    // Lee el archivo con Data y lo introduce a un array de objeto película
    public static Pelicula[] readFile() throws FileNotFoundException {
        String txt = "";
        File file = new File("/Users/pabloalvarado/Desktop/movie_metadata.csv");
        Scanner myReader = new Scanner(file);
        myReader.nextLine();

        Pelicula[] peliculas = new Pelicula[5043];
        int i = 0;

        int cero = 0;

        while (myReader.hasNextLine()) {
            String[] data = myReader.nextLine().split("ˆ");
            String[] Generets = data[9].trim().split("}");
            String[] PlotKeyWords = data[16].trim().split("}");

            Pelicula pelicula = new Pelicula(data[11].trim(), data[3].trim().equals("") ? 0 : Integer.parseInt(data[3].trim()),
                    data[0].trim(), Generets, PlotKeyWords, data[19].trim(), data[20].trim(), data[21].trim(),
                    data[23].trim().equals("") ? 0 : Integer.parseInt(data[23].trim()), data[27].trim().equals("") ? 0 : Integer.parseInt(data[27].trim()),
                    Double.parseDouble(data[25].trim()), data[1].trim(), data[10].trim(), data[6].trim(), data[14].trim());

            //System.out.println(i);
            peliculas[i] = pelicula;
            i++;
        }
        myReader.close();

        return peliculas;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("app");
        frame.setContentPane(new app().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
