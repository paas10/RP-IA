package recomendador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("app");
        frame.setContentPane(new app().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

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

            System.out.println(i);
            peliculas[i] = pelicula;
            i++;
        }
        myReader.close();

        return peliculas;
    }
}
