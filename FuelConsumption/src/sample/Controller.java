package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Controller implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadDataCar();
            loadDataRoute();
        } catch (Exception e) {
        }
    }

    // двата метода за началния екран

    public void Known(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("KnownRoute.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Known Route");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
        }
    }

    public void New(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("NewCalculation.fxml"));
            Stage stage = new Stage();
            stage.setTitle("New Calculation");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
        }
    }


    // за работа със ново пресмятане


    @FXML
    TextField textkm;
    @FXML
    TextField textl;
    @FXML
    TextField textlkm;

    public void presmqtane(ActionEvent event) {
        double km = 0;
        double l = 0;
        double lkm = 0;
        try {
            km = Double.parseDouble(textkm.getText());
        } catch (NumberFormatException e) {
        }
        try {
            l = Double.parseDouble(textl.getText());
        } catch (NumberFormatException e) {
        }
        try {
            lkm = Double.parseDouble(textlkm.getText());
        } catch (NumberFormatException e) {
        }
        if (km == 0) {
            km = (l / lkm) * 100;
            textkm.setText(String.valueOf(km));
        } else if (l == 0) {
            l = (km * lkm) / 100;
            textl.setText(String.valueOf(l));
        } else if (lkm == 0) {
            lkm = (l / km) * 100;
            textlkm.setText(String.valueOf(lkm));
        }
    }

    // за работа със познат маршрут

    ObservableList listCar = FXCollections.observableArrayList();
    ObservableList listRoute = FXCollections.observableArrayList();

    @FXML
    ChoiceBox<String> car;
    @FXML
    ChoiceBox<String> route;
    @FXML
    TextField cena;
    @FXML
    TextField povtoreniq;
    @FXML
    TextField cenafinal;

    public void poznat(ActionEvent event) {
        double lkm = 0, km = 0, lv = 0, x = 0, pari = 0;
        //взимане на разхода
        String razhoda = car.getSelectionModel().getSelectedItem();
        int lastSpace = razhoda.lastIndexOf(" ");
        String razhod1 = razhoda.substring(lastSpace + 1);
        lkm = Double.parseDouble(razhod1);
        //взимане на маршрута
        String range = route.getSelectionModel().getSelectedItem();
        int lastSpace1 = range.lastIndexOf(" ");
        String range1 = range.substring(lastSpace1 + 1);
        km = Double.parseDouble(range1);
        try {
            lv = Double.parseDouble(cena.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            x = Double.parseDouble(povtoreniq.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        pari = km / 100 * lkm * lv * x;
        cenafinal.setText(String.valueOf(pari));
    }


    public void newCar(ActionEvent event) {
        String ls = System.lineSeparator();
        String carin = JOptionPane.showInputDialog("Ваведете кола и разход!\n Пример: Golf 4 13.7");
        try {
            if (!carin.isEmpty()) {
                try (Writer writer = new FileWriter("cars.txt", true)) {
                    writer.write(carin + ls);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                loadDataCar();
            }
        } catch (java.lang.RuntimeException e) {
        }
    }

    public void newRoute(ActionEvent event) {
        String ls = System.lineSeparator();
        String route = JOptionPane.showInputDialog("Ваведете маршрут и километри!\n Пример: НБУ 12.4");
        try {
            if (!route.isEmpty()) {
                try (Writer writer = new FileWriter("route.txt", true)) {
                    writer.write(route + ls);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                loadDataRoute();
            }
        } catch (java.lang.RuntimeException e) {
        }
    }


    public void loadDataCar() {
        listCar.removeAll(listCar);
        car.getSelectionModel().clearSelection();
        car.getItems().clear();
        File file = new File("cars.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                listCar.addAll(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        car.getItems().addAll(listCar);
    }

    public void loadDataRoute() {
        listRoute.removeAll(listRoute);
        route.getSelectionModel().clearSelection();
        route.getItems().clear();
        File file = new File("route.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                listRoute.addAll(line);
            }
        } catch (FileNotFoundException e) {
            //     e.printStackTrace();
        }
        route.getItems().addAll(listRoute);
    }

    public void krai(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("First.fxml"));
            Stage stage = new Stage();
            stage.setTitle("test");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            //   e.printStackTrace();
        }
    }

    public void trieneCar(ActionEvent event) throws Exception {
        String kola = car.getSelectionModel().getSelectedItem();
        removeLine(kola, "cars.txt");
        loadDataCar();
    }

    public void trieneRoute(ActionEvent event) throws Exception {
        String marshrut = route.getSelectionModel().getSelectedItem();
        removeLine(marshrut, "route.txt");
        loadDataRoute();
    }

    public void removeLine(String lineContent, String put) throws Exception {
        File file = new File(put);
        List<String> out = Files.lines(file.toPath())
                .filter(line -> !line.contains(lineContent))
                .collect(Collectors.toList());
        Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}