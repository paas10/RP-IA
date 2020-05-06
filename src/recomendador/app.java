package recomendador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Collections;
import java.util.*;

public class app {

    public ArrayList<Pelicula> Recomendaciones;
    public ArrayList<PeliculaLite> imbd;
    Pelicula[] peliculas;

    public int index1 = 0;
    public int index2 = 0;
    public int index3 = 0;
    public int index4 = 0;

    private JButton btnPrueba;
    private JPanel mainPanel;
    private JButton btnSiPelicula1;
    private JButton btnNoPelicula1;
    private JButton btnSiPelicula2;
    private JButton btnNoPelicula2;
    private JButton btnSiPelicula3;
    private JButton btnNoPelicula3;
    private JButton btnSiPelicula4;
    private JButton btnNoPelicula4;
    private JLabel Pelicula1;
    private JLabel Pelicula2;
    private JLabel Pelicula3;
    private JLabel Pelicula4;
    private JButton Derecha1;
    private JButton Izquierda1;
    private JButton button3;
    private JButton button4;
    private JLabel Director1;
    private JLabel Anio1;
    private JLabel Clasificacion1;
    private JLabel Director2;
    private JLabel Director3;
    private JLabel Director4;
    private JLabel Anio2;
    private JLabel Anio3;
    private JLabel Anio4;
    private JLabel Clasificacion2;
    private JLabel Clasificacion3;
    private JLabel Clasificacion4;
    private JButton btnVerRecomendaciones;


    public app() {

        // Se lee el archivo y se inicializa el programa (Normaliza la info)
        try {
            peliculas = readFile();
            //JOptionPane.showMessageDialog(null, "Todas las peliculas han sido recuperadas");

            peliculas = normailizarData(peliculas);

            imbd = new ArrayList<PeliculaLite>();
            for (Pelicula pelicula: peliculas) {
                imbd.add(new PeliculaLite(pelicula.MovieTitle, pelicula.Language.Valor, pelicula.ContentRating.Valor, pelicula.TitleYear.Valor,
                        pelicula.Director.Valor, pelicula.MovieFaceBookLikes, pelicula.imdbScore));
            }

            Collections.sort(imbd, new Comparator<PeliculaLite>(){
                @Override
                public int compare(PeliculaLite o1, PeliculaLite o2) {
                    return Integer.valueOf(o2.MovieFaceBookLikes).compareTo(o1.MovieFaceBookLikes);
                }
            });

            index1 = 0;
            index2 = 1;
            index3 = 2;
            index4 = 3;

            Pelicula1.setText(imbd.get(index1).MovieTitle);
            Director1.setText(imbd.get(index1).Director);
            Anio1.setText(Integer.toString(imbd.get(index1).TitleYear));
            Clasificacion1.setText(imbd.get(index1).ContentRating);

            Pelicula2.setText(imbd.get(index2).MovieTitle);
            Director2.setText(imbd.get(index2).Director);
            Anio2.setText(Integer.toString(imbd.get(index2).TitleYear));
            Clasificacion2.setText(imbd.get(index2).ContentRating);

            Pelicula3.setText(imbd.get(index3).MovieTitle);
            Director3.setText(imbd.get(index3).Director);
            Anio3.setText(Integer.toString(imbd.get(index3).TitleYear));
            Clasificacion3.setText(imbd.get(index3).ContentRating);

            Pelicula4.setText(imbd.get(index4).MovieTitle);
            Director4.setText(imbd.get(index4).Director);
            Anio4.setText(Integer.toString(imbd.get(index4).TitleYear));
            Clasificacion4.setText(imbd.get(index4).ContentRating);

            //JOptionPane.showMessageDialog(null, "Se ha finalizado");

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }


        // Botón que recupera la info y la normaliza
        btnPrueba.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

            }

        });




        Derecha1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (index4 != imbd.size() - 1){
                    index1++;
                    index2++;
                    index3++;
                    index4++;

                    Pelicula1.setText(imbd.get(index1).MovieTitle);
                    Director1.setText(imbd.get(index1).Director);
                    Anio1.setText(Integer.toString(imbd.get(index1).TitleYear));
                    Clasificacion1.setText(imbd.get(index1).ContentRating);
                    if (imbd.get(index1).bPositivo)
                        btnSiPelicula1.setForeground(Color.red);
                    else
                        btnSiPelicula1.setForeground(Color.black);
                    if (imbd.get(index1).bNegativo)
                        btnNoPelicula1.setForeground(Color.blue);
                    else
                        btnNoPelicula1.setForeground(Color.black);


                    Pelicula2.setText(imbd.get(index2).MovieTitle);
                    Director2.setText(imbd.get(index2).Director);
                    Anio2.setText(Integer.toString(imbd.get(index2).TitleYear));
                    Clasificacion2.setText(imbd.get(index2).ContentRating);
                    if (imbd.get(index2).bPositivo)
                        btnSiPelicula2.setForeground(Color.red);
                    else
                        btnSiPelicula2.setForeground(Color.black);
                    if (imbd.get(index2).bNegativo)
                        btnNoPelicula2.setForeground(Color.blue);
                    else
                        btnNoPelicula2.setForeground(Color.black);


                    Pelicula3.setText(imbd.get(index3).MovieTitle);
                    Director3.setText(imbd.get(index3).Director);
                    Anio3.setText(Integer.toString(imbd.get(index3).TitleYear));
                    Clasificacion3.setText(imbd.get(index3).ContentRating);
                    if (imbd.get(index3).bPositivo)
                        btnSiPelicula3.setForeground(Color.red);
                    else
                        btnSiPelicula3.setForeground(Color.black);
                    if (imbd.get(index3).bNegativo)
                        btnNoPelicula3.setForeground(Color.blue);
                    else
                        btnNoPelicula3.setForeground(Color.black);


                    Pelicula4.setText(imbd.get(index4).MovieTitle);
                    Director4.setText(imbd.get(index4).Director);
                    Anio4.setText(Integer.toString(imbd.get(index4).TitleYear));
                    Clasificacion4.setText(imbd.get(index4).ContentRating);
                    if (imbd.get(index4).bPositivo)
                        btnSiPelicula4.setForeground(Color.red);
                    else
                        btnSiPelicula4.setForeground(Color.black);
                    if (imbd.get(index4).bNegativo)
                        btnNoPelicula4.setForeground(Color.blue);
                    else
                        btnNoPelicula4.setForeground(Color.black);

                }
            }
        });
        Izquierda1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (index1 != 0){
                    index1--;
                    index2--;
                    index3--;
                    index4--;

                    Pelicula1.setText(imbd.get(index1).MovieTitle);
                    Director1.setText(imbd.get(index1).Director);
                    Anio1.setText(Integer.toString(imbd.get(index1).TitleYear));
                    Clasificacion1.setText(imbd.get(index1).ContentRating);
                    if (imbd.get(index1).bPositivo)
                        btnSiPelicula1.setForeground(Color.red);
                    else
                        btnSiPelicula1.setForeground(Color.black);
                    if (imbd.get(index1).bNegativo)
                        btnNoPelicula1.setForeground(Color.blue);
                    else
                        btnNoPelicula1.setForeground(Color.black);


                    Pelicula2.setText(imbd.get(index2).MovieTitle);
                    Director2.setText(imbd.get(index2).Director);
                    Anio2.setText(Integer.toString(imbd.get(index2).TitleYear));
                    Clasificacion2.setText(imbd.get(index2).ContentRating);
                    if (imbd.get(index2).bPositivo)
                        btnSiPelicula2.setForeground(Color.red);
                    else
                        btnSiPelicula2.setForeground(Color.black);
                    if (imbd.get(index2).bNegativo)
                        btnNoPelicula2.setForeground(Color.blue);
                    else
                        btnNoPelicula2.setForeground(Color.black);


                    Pelicula3.setText(imbd.get(index3).MovieTitle);
                    Director3.setText(imbd.get(index3).Director);
                    Anio3.setText(Integer.toString(imbd.get(index3).TitleYear));
                    Clasificacion3.setText(imbd.get(index3).ContentRating);
                    if (imbd.get(index3).bPositivo)
                        btnSiPelicula3.setForeground(Color.red);
                    else
                        btnSiPelicula3.setForeground(Color.black);
                    if (imbd.get(index3).bNegativo)
                        btnNoPelicula3.setForeground(Color.blue);
                    else
                        btnNoPelicula3.setForeground(Color.black);


                    Pelicula4.setText(imbd.get(index4).MovieTitle);
                    Director4.setText(imbd.get(index4).Director);
                    Anio4.setText(Integer.toString(imbd.get(index4).TitleYear));
                    Clasificacion4.setText(imbd.get(index4).ContentRating);
                    if (imbd.get(index4).bPositivo)
                        btnSiPelicula4.setForeground(Color.red);
                    else
                        btnSiPelicula4.setForeground(Color.black);
                    if (imbd.get(index4).bNegativo)
                        btnNoPelicula4.setForeground(Color.blue);
                    else
                        btnNoPelicula4.setForeground(Color.black);
                }
            }
        });

        btnSiPelicula1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(imbd != null){
                    String nombrePeli = imbd.get(index1).MovieTitle;
                    imbd.get(index1).bPositivo = true;
                    imbd.get(index1).bNegativo = false;

                    btnSiPelicula1.setForeground(Color.red);
                    btnNoPelicula1.setForeground(Color.black);

                    marcarPositiva(nombrePeli);
                }
            }
        });
        btnNoPelicula1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(imbd != null){
                    String nombrePeli = imbd.get(index1).MovieTitle;
                    imbd.get(index1).bPositivo = false;
                    imbd.get(index1).bNegativo = true;

                    btnNoPelicula1.setForeground(Color.blue);
                    btnSiPelicula1.setForeground(Color.black);

                    marcarNegativa(nombrePeli);
                }

            }
        });

        btnSiPelicula2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(imbd != null){
                    String nombrePeli = imbd.get(index2).MovieTitle;
                    imbd.get(index2).bPositivo = true;
                    imbd.get(index2).bNegativo = false;

                    btnSiPelicula2.setForeground(Color.red);
                    btnNoPelicula2.setForeground(Color.black);

                    marcarPositiva(nombrePeli);
                }

            }
        });
        btnNoPelicula2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(imbd != null){
                    String nombrePeli = imbd.get(index2).MovieTitle;
                    imbd.get(index2).bPositivo = false;
                    imbd.get(index2).bNegativo = true;

                    btnNoPelicula2.setForeground(Color.blue);
                    btnSiPelicula2.setForeground(Color.black);

                    marcarNegativa(nombrePeli);
                }

            }
        });

        btnSiPelicula3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(imbd != null){
                    String nombrePeli = imbd.get(index3).MovieTitle;
                    imbd.get(index3).bPositivo = true;
                    imbd.get(index3).bNegativo = false;

                    btnSiPelicula3.setForeground(Color.red);
                    btnNoPelicula3.setForeground(Color.black);

                    marcarPositiva(nombrePeli);
                }

            }
        });
        btnNoPelicula3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(imbd != null){
                    String nombrePeli = imbd.get(index3).MovieTitle;
                    imbd.get(index3).bPositivo = false;
                    imbd.get(index3).bNegativo = true;

                    btnNoPelicula3.setForeground(Color.blue);
                    btnSiPelicula3.setForeground(Color.black);

                    marcarNegativa(nombrePeli);
                }

            }
        });

        btnSiPelicula4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(imbd != null){
                    String nombrePeli = imbd.get(index4).MovieTitle;
                    imbd.get(index4).bPositivo = true;
                    imbd.get(index4).bNegativo = false;

                    btnSiPelicula4.setForeground(Color.red);
                    btnNoPelicula4.setForeground(Color.black);

                    marcarPositiva(nombrePeli);
                }

            }
        });
        btnNoPelicula4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(imbd != null){
                    String nombrePeli = imbd.get(index4).MovieTitle;
                    imbd.get(index4).bPositivo = false;
                    imbd.get(index4).bNegativo = true;

                    btnNoPelicula4.setForeground(Color.blue);
                    btnSiPelicula4.setForeground(Color.black);

                    marcarNegativa(nombrePeli);
                }

            }
        });

        btnVerRecomendaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Recomendaciones = new ArrayList<Pelicula>();

                for (Pelicula movie : peliculas) {
                    movie.ObtenerProbabilidades();
                    if (movie.votada)
                    {
                        movie.modificado = false;
                    }
                    if (movie.pGustar > 0 && !movie.votada)
                        Recomendaciones.add(new Pelicula(movie.MovieTitle, movie.Language.Valor, movie.ContentRating.Valor,
                            movie.TitleYear.Valor, movie.Director.Valor, movie.pGustar, movie.pNoGustar));
                }

                Collections.sort(Recomendaciones, new Comparator<Pelicula>(){
                    @Override
                    public int compare(Pelicula o1, Pelicula o2) {
                        return Double.valueOf(o2.pGustar).compareTo(o1.pGustar);
                    }
                });

                for (int i = 0; i < (Recomendaciones.size() > 20 ? 20 : Recomendaciones.size()); i++){
                    System.out.println(Recomendaciones.get(i).MovieTitle + " - pGustar: " + Recomendaciones.get(i).pGustar);
                }

            }
        });



    }

    public void marcarPositiva(String nombrePeli){
        System.out.println("Pelicula votada si: " + nombrePeli);

        for (Pelicula movie : peliculas) {
            if (movie.MovieTitle.equals(nombrePeli)){

                // Cambios en película y el resto
                if (!movie.votada && !movie.bPositivo){

                    System.out.println("Votó Positivo");
                    movie.votada = true;
                    movie.modificado = true;

                    movie.Duration.AFavor++;
                    movie.Color.AFavor++;
                    movie.Generes.Modificado = true;
                    for (sCategoria value : movie.Generes.Valores) {
                        value.AFavor++;
                    }
                    movie.Language.AFavor++;
                    movie.Country.AFavor++;
                    movie.ContentRating.AFavor++;
                    movie.TitleYear.AFavor++;
                    movie.Director.AFavor++;
                    movie.Actor1.AFavor++;
                    movie.Actor2.AFavor++;
                    movie.Actor3.AFavor++;

                    // Se actualizan los normalizadores del resto de peliculas
                    for (Pelicula pelicula : peliculas) {
                        if (pelicula.Duration.Rango == movie.Duration.Rango) {
                            pelicula.Duration.AFavor++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Color.Valor.equals(movie.Color.Valor)) {
                            pelicula.Color.AFavor++;
                            pelicula.modificado = true;
                        }

                        for (sCategoria value : pelicula.Generes.Valores) {
                            for (sCategoria movieValue : movie.Generes.Valores) {
                                if (value.Valor.equals(movieValue.Valor)) {
                                    value.AFavor++;
                                    pelicula.Generes.Modificado = true;
                                    pelicula.modificado = true;
                                }
                            }
                        }

                        if (pelicula.Language.Valor.equals(movie.Language.Valor)) {
                            pelicula.Language.AFavor++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Country.Valor.equals(movie.Country.Valor)) {
                            pelicula.Country.AFavor++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.ContentRating.Valor.equals(movie.ContentRating.Valor)){
                            pelicula.ContentRating.AFavor++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.TitleYear.Rango == movie.TitleYear.Rango) {
                            pelicula.TitleYear.AFavor++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Director.Valor.equals(movie.Director.Valor)) {
                            pelicula.Director.AFavor++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Actor1.Valor.equals(movie.Actor1.Valor)) {
                            pelicula.Actor1.AFavor++;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor2.Valor.equals(movie.Actor1.Valor)) {
                            pelicula.Actor2.AFavor++;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor3.Valor.equals(movie.Actor1.Valor)) {
                            pelicula.Actor3.AFavor++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Actor1.Valor.equals(movie.Actor2.Valor)) {
                            pelicula.Actor1.AFavor++;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor2.Valor.equals(movie.Actor2.Valor)) {
                            pelicula.Actor2.AFavor++;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor3.Valor.equals(movie.Actor3.Valor)) {
                            pelicula.Actor3.AFavor++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Actor1.Valor.equals(movie.Actor3.Valor)) {
                            pelicula.Actor1.AFavor++;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor2.Valor.equals(movie.Actor3.Valor)) {
                            pelicula.Actor2.AFavor++;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor3.Valor.equals(movie.Actor3.Valor)) {
                            pelicula.Actor3.AFavor++;
                            pelicula.modificado = true;
                        }

                    }

                    System.out.println("ok");
                    break;

                }
                else if (movie.votada && !movie.bNegativo){

                    System.out.println("Votó Positivo pero Antes fue Negativo");
                    movie.votada = true;
                    movie.modificado = true;

                    movie.Duration.AFavor++;
                    movie.Duration.EnContra--;
                    movie.Color.AFavor++;
                    movie.Color.EnContra--;
                    movie.Generes.Modificado = true;
                    for (sCategoria value : movie.Generes.Valores) {
                        value.AFavor++;
                        value.EnContra--;
                    }
                    movie.Language.AFavor++;
                    movie.Language.EnContra--;
                    movie.Country.AFavor++;
                    movie.Country.EnContra--;
                    movie.ContentRating.AFavor++;
                    movie.ContentRating.EnContra--;
                    movie.TitleYear.AFavor++;
                    movie.TitleYear.EnContra--;
                    movie.Director.AFavor++;
                    movie.Duration.EnContra--;
                    movie.Actor1.AFavor++;
                    movie.Actor1.EnContra--;
                    movie.Actor2.AFavor++;
                    movie.Actor2.EnContra--;
                    movie.Actor3.AFavor++;
                    movie.Actor3.EnContra--;

                    // Se actualizan los normalizadores del resto de peliculas
                    for (Pelicula pelicula : peliculas) {
                        if (pelicula.Duration.Rango == movie.Duration.Rango) {
                            pelicula.Duration.AFavor++;
                            pelicula.Duration.EnContra--;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Color.Valor.equals(movie.Color.Valor)) {
                            pelicula.Color.AFavor++;
                            pelicula.Color.EnContra--;
                            pelicula.modificado = true;
                        }

                        for (sCategoria value : pelicula.Generes.Valores) {
                            for (sCategoria movieValue : movie.Generes.Valores) {
                                if (value.Valor.equals(movieValue.Valor)) {
                                    value.AFavor++;
                                    value.EnContra--;
                                    pelicula.Generes.Modificado = true;
                                    pelicula.modificado = true;
                                }
                            }
                        }

                        if (pelicula.Language.Valor.equals(movie.Language.Valor)) {
                            pelicula.Language.AFavor++;
                            pelicula.Language.EnContra--;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Country.Valor.equals(movie.Country.Valor)) {
                            pelicula.Country.AFavor++;
                            pelicula.Country.EnContra--;
                            pelicula.modificado = true;
                        }

                        if (pelicula.ContentRating.Valor.equals(movie.ContentRating.Valor)){
                            pelicula.ContentRating.AFavor++;
                            pelicula.ContentRating.EnContra--;
                            pelicula.modificado = true;
                        }

                        if (pelicula.TitleYear.Rango == movie.TitleYear.Rango) {
                            pelicula.TitleYear.AFavor++;
                            pelicula.TitleYear.EnContra--;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Director.Valor.equals(movie.Director.Valor)) {
                            pelicula.Director.AFavor++;
                            pelicula.Director.EnContra--;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Actor1.Valor.equals(movie.Actor1.Valor)) {
                            pelicula.Actor1.AFavor++;
                            pelicula.Actor1.EnContra--;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor2.Valor.equals(movie.Actor1.Valor)) {
                            pelicula.Actor2.AFavor++;
                            pelicula.Actor2.EnContra--;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor3.Valor.equals(movie.Actor1.Valor)) {
                            pelicula.Actor3.AFavor++;
                            pelicula.Actor3.EnContra--;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Actor1.Valor.equals(movie.Actor2.Valor)) {
                            pelicula.Actor1.AFavor++;
                            pelicula.Actor1.EnContra--;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor2.Valor.equals(movie.Actor2.Valor)) {
                            pelicula.Actor2.AFavor++;
                            pelicula.Actor3.EnContra--;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor3.Valor.equals(movie.Actor3.Valor)) {
                            pelicula.Actor3.AFavor++;
                            pelicula.Actor3.EnContra--;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Actor1.Valor.equals(movie.Actor3.Valor)) {
                            pelicula.Actor1.AFavor++;
                            pelicula.Actor1.EnContra--;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor2.Valor.equals(movie.Actor3.Valor)) {
                            pelicula.Actor2.AFavor++;
                            pelicula.Actor2.EnContra--;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor3.Valor.equals(movie.Actor3.Valor)) {
                            pelicula.Actor3.AFavor++;
                            pelicula.Actor2.EnContra--;
                            pelicula.modificado = true;
                        }

                    }

                    System.out.println("ok");
                    break;

                }
            }
        }
    }
    public void marcarNegativa(String nombrePeli){
        System.out.println("Pelicula votada no: " + nombrePeli);

        for (Pelicula movie : peliculas) {
            if (movie.MovieTitle.equals(nombrePeli)){

                // Cambios en película y el resto
                if (!movie.votada && !movie.bPositivo){

                    System.out.println("Votó Negativo");
                    movie.votada = true;
                    movie.modificado = true;

                    movie.Duration.EnContra++;
                    movie.Color.EnContra++;
                    movie.Generes.Modificado = true;
                    for (sCategoria value : movie.Generes.Valores) {
                        value.EnContra++;
                    }
                    movie.Language.EnContra++;
                    movie.Country.EnContra++;
                    movie.ContentRating.EnContra++;
                    movie.TitleYear.EnContra++;
                    movie.Director.EnContra++;
                    movie.Actor1.EnContra++;
                    movie.Actor2.EnContra++;
                    movie.Actor3.EnContra++;

                    // Se actualizan los normalizadores del resto de peliculas
                    for (Pelicula pelicula : peliculas) {
                        if (pelicula.Duration.Rango == movie.Duration.Rango) {
                            pelicula.Duration.EnContra++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Color.Valor.equals(movie.Color.Valor)) {
                            pelicula.Color.EnContra++;
                            pelicula.modificado = true;
                        }

                        for (sCategoria value : pelicula.Generes.Valores) {
                            for (sCategoria movieValue : movie.Generes.Valores) {
                                if (value.Valor.equals(movieValue.Valor)) {
                                    value.EnContra++;
                                    pelicula.Generes.Modificado = true;
                                    pelicula.modificado = true;
                                }
                            }
                        }

                        if (pelicula.Language.Valor.equals(movie.Language.Valor)) {
                            pelicula.Language.EnContra++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Country.Valor.equals(movie.Country.Valor)) {
                            pelicula.Country.EnContra++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.ContentRating.Valor.equals(movie.ContentRating.Valor)){
                            pelicula.ContentRating.EnContra++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.TitleYear.Rango == movie.TitleYear.Rango) {
                            pelicula.TitleYear.EnContra++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Director.Valor.equals(movie.Director.Valor)) {
                            pelicula.Director.EnContra++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Actor1.Valor.equals(movie.Actor1.Valor)) {
                            pelicula.Actor1.EnContra++;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor2.Valor.equals(movie.Actor1.Valor)) {
                            pelicula.Actor2.EnContra++;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor3.Valor.equals(movie.Actor1.Valor)) {
                            pelicula.Actor3.EnContra++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Actor1.Valor.equals(movie.Actor2.Valor)) {
                            pelicula.Actor1.EnContra++;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor2.Valor.equals(movie.Actor2.Valor)) {
                            pelicula.Actor2.EnContra++;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor3.Valor.equals(movie.Actor3.Valor)) {
                            pelicula.Actor3.EnContra++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Actor1.Valor.equals(movie.Actor3.Valor)) {
                            pelicula.Actor1.EnContra++;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor2.Valor.equals(movie.Actor3.Valor)) {
                            pelicula.Actor2.EnContra++;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor3.Valor.equals(movie.Actor3.Valor)) {
                            pelicula.Actor3.EnContra++;
                            pelicula.modificado = true;
                        }

                    }

                    System.out.println("ok");
                    break;

                }
                else if (movie.votada && !movie.bNegativo){

                    System.out.println("Votó Negativo pero Antes fue Positivo");
                    movie.votada = true;
                    movie.modificado = true;

                    movie.Duration.AFavor--;
                    movie.Duration.EnContra++;
                    movie.Color.AFavor--;
                    movie.Color.EnContra++;
                    movie.Generes.Modificado = true;
                    for (sCategoria value : movie.Generes.Valores) {
                        value.AFavor--;
                        value.EnContra++;
                    }
                    movie.Language.AFavor--;
                    movie.Language.EnContra++;
                    movie.Country.AFavor--;
                    movie.Country.EnContra++;
                    movie.ContentRating.AFavor--;
                    movie.ContentRating.EnContra++;
                    movie.TitleYear.AFavor--;
                    movie.TitleYear.EnContra++;
                    movie.Director.AFavor--;
                    movie.Duration.EnContra++;
                    movie.Actor1.AFavor--;
                    movie.Actor1.EnContra++;
                    movie.Actor2.AFavor--;
                    movie.Actor2.EnContra++;
                    movie.Actor3.AFavor--;
                    movie.Actor3.EnContra++;

                    // Se actualizan los normalizadores del resto de peliculas
                    for (Pelicula pelicula : peliculas) {
                        if (pelicula.Duration.Rango == movie.Duration.Rango) {
                            pelicula.Duration.AFavor--;
                            pelicula.Duration.EnContra++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Color.Valor.equals(movie.Color.Valor)) {
                            pelicula.Color.AFavor--;
                            pelicula.Color.EnContra++;
                            pelicula.modificado = true;
                        }

                        for (sCategoria value : pelicula.Generes.Valores) {
                            for (sCategoria movieValue : movie.Generes.Valores) {
                                if (value.Valor.equals(movieValue.Valor)) {
                                    value.AFavor--;
                                    value.EnContra++;
                                    pelicula.Generes.Modificado = true;
                                    pelicula.modificado = true;
                                }
                            }
                        }

                        if (pelicula.Language.Valor.equals(movie.Language.Valor)) {
                            pelicula.Language.AFavor--;
                            pelicula.Language.EnContra++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Country.Valor.equals(movie.Country.Valor)) {
                            pelicula.Country.AFavor--;
                            pelicula.Country.EnContra++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.ContentRating.Valor.equals(movie.ContentRating.Valor)){
                            pelicula.ContentRating.AFavor--;
                            pelicula.ContentRating.EnContra++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.TitleYear.Rango == movie.TitleYear.Rango) {
                            pelicula.TitleYear.AFavor--;
                            pelicula.TitleYear.EnContra++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Director.Valor.equals(movie.Director.Valor)) {
                            pelicula.Director.AFavor--;
                            pelicula.Director.EnContra++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Actor1.Valor.equals(movie.Actor1.Valor)) {
                            pelicula.Actor1.AFavor--;
                            pelicula.Actor1.EnContra++;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor2.Valor.equals(movie.Actor1.Valor)) {
                            pelicula.Actor2.AFavor--;
                            pelicula.Actor2.EnContra++;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor3.Valor.equals(movie.Actor1.Valor)) {
                            pelicula.Actor3.AFavor--;
                            pelicula.Actor3.EnContra++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Actor1.Valor.equals(movie.Actor2.Valor)) {
                            pelicula.Actor1.AFavor--;
                            pelicula.Actor1.EnContra++;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor2.Valor.equals(movie.Actor2.Valor)) {
                            pelicula.Actor2.AFavor--;
                            pelicula.Actor3.EnContra++;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor3.Valor.equals(movie.Actor3.Valor)) {
                            pelicula.Actor3.AFavor--;
                            pelicula.Actor3.EnContra++;
                            pelicula.modificado = true;
                        }

                        if (pelicula.Actor1.Valor.equals(movie.Actor3.Valor)) {
                            pelicula.Actor1.AFavor--;
                            pelicula.Actor1.EnContra++;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor2.Valor.equals(movie.Actor3.Valor)) {
                            pelicula.Actor2.AFavor--;
                            pelicula.Actor2.EnContra++;
                            pelicula.modificado = true;
                        } else if (pelicula.Actor3.Valor.equals(movie.Actor3.Valor)) {
                            pelicula.Actor3.AFavor--;
                            pelicula.Actor2.EnContra++;
                            pelicula.modificado = true;
                        }

                    }

                    System.out.println("ok");
                    break;

                }
            }
        }
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
            boolean contentRating = false;
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

            if (peliculas[i].Language.Normalizador == 0)
                language = true;
            if (peliculas[i].Country.Normalizador == 0)
                country = true;
            if (peliculas[i].ContentRating.Normalizador == 0)
                contentRating = true;
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

                if (language && movie.Language.Valor.equals(peliculas[i].Language.Valor))
                    peliculas[i].Language.Normalizador++;
                if (country && movie.Country.Valor.equals(peliculas[i].Country.Valor))
                    peliculas[i].Country.Normalizador++;
                if (contentRating && movie.ContentRating.Valor.equals(peliculas[i].ContentRating.Valor))
                    peliculas[i].ContentRating.Normalizador++;
                if (titleYear && movie.TitleYear.Rango == peliculas[i].TitleYear.Rango)
                    peliculas[i].TitleYear.Normalizador++;
                if (director && movie.Director.Valor.equals(peliculas[i].Director.Valor))
                    peliculas[i].Director.Normalizador++;

                if (actor1){
                    if (movie.Actor1.Valor.equals(peliculas[i].Actor1.Valor))
                        peliculas[i].Actor1.Normalizador++;
                    else if (movie.Actor2.Valor.equals(peliculas[i].Actor1.Valor))
                        peliculas[i].Actor1.Normalizador++;
                    if (movie.Actor3.Valor.equals(peliculas[i].Actor1.Valor))
                        peliculas[i].Actor1.Normalizador++;
                }
                if (actor2){
                    if (movie.Actor1.Valor.equals(peliculas[i].Actor2.Valor))
                        peliculas[i].Actor2.Normalizador++;
                    else if (movie.Actor2.Valor.equals(peliculas[i].Actor2.Valor))
                        peliculas[i].Actor2.Normalizador++;
                    else if (movie.Actor3.Valor.equals(peliculas[i].Actor2.Valor))
                        peliculas[i].Actor2.Normalizador++;
                }
                if (actor3){
                    if (movie.Actor1.Valor.equals(peliculas[i].Actor3.Valor))
                        peliculas[i].Actor3.Normalizador++;
                    else if (movie.Actor2.Valor.equals(peliculas[i].Actor3.Valor))
                        peliculas[i].Actor3.Normalizador++;
                    else if (movie.Actor3.Valor.equals(peliculas[i].Actor3.Valor))
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

                if (movie.Language.Normalizador == 0 && movie.Language.Valor.equals(peliculas[i].Language.Valor))
                    movie.Language.Normalizador = peliculas[i].Language.Normalizador;
                if (movie.Country.Normalizador == 0 && movie.Country.Valor.equals(peliculas[i].Country.Valor))
                    movie.Country.Normalizador = peliculas[i].Country.Normalizador;
                if (movie.TitleYear.Normalizador == 0 && movie.TitleYear.Rango == peliculas[i].TitleYear.Rango)
                    movie.TitleYear.Normalizador = peliculas[i].TitleYear.Normalizador;
                if (movie.Director.Normalizador == 0 && movie.Director.Valor.equals(peliculas[i].Director.Valor))
                    movie.Director.Normalizador = peliculas[i].Director.Normalizador;

                if (actor1){
                    if (movie.Actor1.Normalizador == 0 && movie.Actor1.Valor.equals(peliculas[i].Actor1.Valor))
                        movie.Actor1.Normalizador = peliculas[i].Actor1.Normalizador;
                    else if (movie.Actor2.Normalizador == 0 && movie.Actor2.Valor.equals(peliculas[i].Actor1.Valor))
                        movie.Actor2.Normalizador = peliculas[i].Actor1.Normalizador;
                    else if (movie.Actor3.Normalizador == 0 && movie.Actor3.Valor.equals(peliculas[i].Actor1.Valor))
                        movie.Actor3.Normalizador = peliculas[i].Actor1.Normalizador;
                }
                if (actor2){
                    if (movie.Actor1.Normalizador == 0 && movie.Actor1.Valor.equals(peliculas[i].Actor2.Valor))
                        movie.Actor1.Normalizador = peliculas[i].Actor2.Normalizador;
                    else if (movie.Actor2.Normalizador == 0 && movie.Actor2.Valor.equals(peliculas[i].Actor2.Valor))
                        movie.Actor2.Normalizador = peliculas[i].Actor2.Normalizador;
                    else if (movie.Actor3.Normalizador == 0 && movie.Actor3.Valor.equals(peliculas[i].Actor2.Valor))
                        movie.Actor3.Normalizador = peliculas[i].Actor2.Normalizador;
                }
                if (actor3){
                    if (movie.Actor1.Normalizador != 0 && movie.Actor1.Valor.equals(peliculas[i].Actor3.Valor))
                        movie.Actor1.Normalizador = peliculas[i].Actor3.Normalizador;
                    else if (movie.Actor2.Normalizador != 0 && movie.Actor2.Valor.equals(peliculas[i].Actor3.Valor))
                        movie.Actor2.Normalizador = peliculas[i].Actor3.Normalizador;
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
