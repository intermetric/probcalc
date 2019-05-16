import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Peaklass extends Application {

    @Override
    public void start(Stage pealava) {

        //////////////////////////////////////////////////////////////////////////////////////

        StackPane juur = new StackPane();
        Scene stseen = new Scene(juur, 1000, 580);

        //////////////////////////////////////////////////////////////////////////////////////

        //CSS + fondid
        File f = new File("styles.css");
        stseen.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        stseen.getStylesheets().add("http://fonts.googleapis.com/css?family=Overpass:400,700");
        stseen.getStylesheets().add("http://fonts.googleapis.com/css?family=Karla:400,700");

        //////////////////////////////////////////////////////////////////////////////////////

        // #1 - Tekstiväli

        Text tekst = new Text("Tõenäosusteooria valemite kalkulaator");

        StackPane.setAlignment(tekst, Pos.TOP_CENTER);
        StackPane.setMargin(tekst, new Insets(30, 0, 0, 0));
        tekst.setId("tiitel");

        //Animatsioon (fade in) tiitlile
        FadeTransition ft = new FadeTransition(Duration.millis(3000), tekst);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.setCycleCount(1);
        ft.setAutoReverse(true);
        ft.play();

        juur.getChildren().add(tekst);

        //////////////////////////////////////////////////////////////////////////////////////

        // #2 Sissejuhatav lause

        Text valik = new Text("Valige valem:");

        StackPane.setAlignment(valik, Pos.TOP_LEFT);
        StackPane.setMargin(valik, new Insets(130, 0, 0, 64));
        valik.setId("valik");

        juur.getChildren().add(valik);

        //////////////////////////////////////////////////////////////////////////////////////

        // #3 Nupud valemite nimedega

        GridPane grid = new GridPane();

        grid.setAlignment(Pos.TOP_CENTER);
        grid.setMinSize(400, 200);
        grid.setPadding(new Insets(180, 50, 10, 50));
        grid.setVgap(5);
        grid.setHgap(20);

        Button bernoulli = new Button("Bernoulli valem");
        bernoulli.setPrefWidth(170);
        grid.add(bernoulli, 0, 0);

        Button bernoulliJaotus = new Button("Bernoulli jaotus");
        bernoulliJaotus.setPrefWidth(170);
        grid.add(bernoulliJaotus, 1, 0);

        Button binoom = new Button("Binoomjaotus");
        binoom.setPrefWidth(170);
        grid.add(binoom, 2, 0);

        Button geo = new Button("Geomeetriline jaotus");
        geo.setPrefWidth(170);
        grid.add(geo, 3, 0);

        Button poisson = new Button("Poissoni jaotus");
        poisson.setPrefWidth(170);
        grid.add(poisson, 4, 0);

        juur.getChildren().add(grid);

        //////////////////////////////////////////////////////////////////////////////////////

        // #4 Väljad kasutajaga suhtlemiseks

        ///////////////////////////////////
        // Bernoulli valem //

        //p (vaadeldava sündmuse toimumise tõenäosus, mis on igal katsel sama)
        final TextField pBernValem = new TextField();
        pBernValem.setPromptText("Sisestage p");
        pBernValem.setPrefWidth(10);
        GridPane.setConstraints(pBernValem, 0, 1);

        //n (kõikide katsete koguarv)
        final TextField nBernValem = new TextField();
        nBernValem.setPromptText("Sisestage n");
        nBernValem.setPrefWidth(10);
        GridPane.setConstraints(nBernValem, 0, 1);

        //k (mitmel korral sündmus toimub)
        final TextField kBernValem = new TextField();
        kBernValem.setPromptText("Sisestage k");
        kBernValem.setPrefWidth(10);
        GridPane.setConstraints(kBernValem, 0, 1);

        ///////////////////////////////////
        // Bernoulli jaotus //

        //p (vaadeldava sündmuse toimumise tõenäosus, mis on igal katsel sama)
        final TextField pBernJ = new TextField();
        pBernJ.setPromptText("Sisestage p");
        pBernJ.setPrefWidth(10);
        GridPane.setConstraints(pBernJ, 1, 1);

        ///////////////////////////////////
        // Binoomjaotus //

        //p (vaadeldava sündmuse toimumise tõenäosus, mis on igal katsel sama)
        final TextField pBin = new TextField();
        pBin.setPromptText("Sisestage p");
        pBin.setPrefWidth(10);
        GridPane.setConstraints(pBin, 2, 1);

        //n (kõikide katsete koguarv)
        final TextField nBin = new TextField();
        nBin.setPromptText("Sisestage n");
        nBin.setPrefWidth(10);
        GridPane.setConstraints(nBin, 2, 1);

        ///////////////////////////////////
        // Geomeetriline jaotus //

        //p (vaadeldava sündmuse toimumise tõenäosus, mis on igal katsel sama)
        final TextField pGeo = new TextField();
        pGeo.setPromptText("Sisestage p");
        pGeo.setPrefWidth(10);
        GridPane.setConstraints(pGeo, 3, 1);

        ///////////////////////////////////
        // Poissoni jaotus //

        //lambda (Poissoni jaotuse parameeter)
        final TextField L = new TextField();
        L.setPromptText("Sisestage lambda");
        L.setPrefWidth(10);
        GridPane.setConstraints(L, 4, 1);

        //Nupud
        String next = "Edasi";
        String compute = "Arvuta!";

        Button edasi = new Button(next);
        edasi.setId("edasi");
        GridPane.setConstraints(edasi, 0, 2);

        Button edasi0 = new Button(next);
        edasi0.setId("edasi");
        GridPane.setConstraints(edasi0, 0, 2);

        Button edasi4 = new Button(next);
        edasi4.setId("edasi");
        GridPane.setConstraints(edasi4, 2, 2);

        Button arvuta = new Button(compute);
        arvuta.setId("arvuta");
        GridPane.setConstraints(arvuta, 0, 2);

        Button arvuta4 = new Button(compute);
        arvuta4.setId("arvuta");
        GridPane.setConstraints(arvuta4, 1, 2);

        Button arvuta5 = new Button(compute);
        arvuta5.setId("arvuta");
        GridPane.setConstraints(arvuta5, 2, 2);

        Button arvuta6 = new Button(compute);
        arvuta6.setId("arvuta");
        GridPane.setConstraints(arvuta6, 3, 2);

        Button arvuta7 = new Button(compute);
        arvuta7.setId("arvuta");
        GridPane.setConstraints(arvuta7, 4, 2);

        //////////////////////////////////////////////////////////////////////////////////////

        // #5 Veatöötlus

        //////////////////////////////////////////////////////////////////////////////////////

        // luuakse teine lava
        Stage viga = new Stage();
        // tekstivälja ja ok-nupu loomine
        Text sõnum = new Text("Sisend ei olnud korrektne!");
        Button okButton = new Button("OK");

        // sündmuse lisamine nupule OK
        okButton.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                viga.hide();
                pBernValem.clear();
                kBernValem.clear();
                nBernValem.clear();
                pBernJ.clear();
                nBin.clear();
                pBin.clear();
                pGeo.clear();
                L.clear();
                grid.getChildren().remove(kBernValem);
                grid.getChildren().remove(arvuta);
                grid.getChildren().remove(nBernValem);
                grid.getChildren().remove(edasi0);
                grid.getChildren().remove(pBernValem);
                grid.getChildren().remove(edasi);
                grid.getChildren().remove(pBernJ);
                grid.getChildren().remove(arvuta4);
                grid.getChildren().remove(nBin);
                grid.getChildren().remove(arvuta5);
                grid.getChildren().remove(pBin);
                grid.getChildren().remove(edasi4);
                grid.getChildren().remove(pGeo);
                grid.getChildren().remove(arvuta6);
                grid.getChildren().remove(L);
                grid.getChildren().remove(arvuta7);
                List<Node> eemaldatavad = new ArrayList<>();
                for (Node child : juur.getChildren()) {
                    if (child.getClass() == Text.class && !child.getId().equals("tiitel") && !child.getId().equals("valik"))
                        eemaldatavad.add(child);
                }
                for (Node child : eemaldatavad) {
                    juur.getChildren().remove(child);
                }
            }
        });

        // teksti ja nupu grupeerimine
        FlowPane pane = new FlowPane(10, 10);
        pane.setOrientation(Orientation.VERTICAL);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(sõnum, okButton);

        //stseeni loomine
        Scene stseen2 = new Scene(pane, 300, 150);
        viga.setTitle("Viga");
        viga.setScene(stseen2);

        //////////////////////////////////////////////////////////////////////////////////////

        // #6 Dünaamilised nupud ja väljad hakkavad sisestatud infot töötlema

        //////////////////////////////////////////////////////////////////////////////////////

        //Nupp väljastatud vastuse ja väljade tühjendamiseks
        Button tühjenda = new Button("Tühjenda");
        StackPane.setAlignment(tühjenda, Pos.BOTTOM_CENTER);
        StackPane.setMargin(tühjenda, new Insets(0, 0, 40, 0));
        tühjenda.setId("tühjenda");

        //Nupp programmist väljumiseks
        Button välju = new Button("Välju");
        StackPane.setAlignment(välju, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(välju, new Insets(0, 62, 40, 0));
        tühjenda.setId("välju");

        välju.setOnAction(event -> {
            pealava.close();
        });

        juur.getChildren().add(välju);

        tühjenda.setOnAction(event2 -> {
            pBernValem.clear();
            kBernValem.clear();
            nBernValem.clear();
            pBernJ.clear();
            nBin.clear();
            pBin.clear();
            pGeo.clear();
            L.clear();
            grid.getChildren().remove(kBernValem);
            grid.getChildren().remove(arvuta);
            grid.getChildren().remove(nBernValem);
            grid.getChildren().remove(edasi0);
            grid.getChildren().remove(pBernValem);
            grid.getChildren().remove(edasi);
            grid.getChildren().remove(pBernJ);
            grid.getChildren().remove(arvuta4);
            grid.getChildren().remove(nBin);
            grid.getChildren().remove(arvuta5);
            grid.getChildren().remove(pBin);
            grid.getChildren().remove(edasi4);
            grid.getChildren().remove(pGeo);
            grid.getChildren().remove(arvuta6);
            grid.getChildren().remove(L);
            grid.getChildren().remove(arvuta7);
            List<Node> eemaldatavad = new ArrayList<>();
            for (Node child : juur.getChildren()) {
                if (child.getClass() == Text.class && !child.getId().equals("tiitel") && !child.getId().equals("valik"))
                    eemaldatavad.add(child);
            }
            for (Node child : eemaldatavad) {
                juur.getChildren().remove(child);
            }
            juur.getChildren().remove(tühjenda);
        });

        //Bernoulli valem
        EventHandler<javafx.scene.input.MouseEvent> bernoulliValHandler1 =
                (MouseEvent e) -> {
                    grid.getChildren().remove(edasi4);
                    grid.getChildren().remove(pBernJ);
                    grid.getChildren().remove(pBin);
                    grid.getChildren().remove(nBin);
                    grid.getChildren().remove(pGeo);
                    grid.getChildren().remove(L);
                    grid.getChildren().remove(arvuta4);
                    grid.getChildren().remove(arvuta5);
                    grid.getChildren().remove(arvuta6);
                    grid.getChildren().remove(arvuta7);

                    grid.getChildren().add(pBernValem);
                    grid.getChildren().add(edasi);
                };
        EventHandler<javafx.scene.input.MouseEvent> bernoulliValHandler2 =
                (MouseEvent e) -> {
                    grid.getChildren().add(nBernValem);
                    grid.getChildren().add(edasi0);
                };
        EventHandler<javafx.scene.input.MouseEvent> bernoulliValHandler3 =
                (MouseEvent e) -> {
                    grid.getChildren().add(kBernValem);
                    grid.getChildren().add(arvuta);
                };

        bernoulli.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, bernoulliValHandler1);
        edasi.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, bernoulliValHandler2);
        edasi0.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, bernoulliValHandler3);

        arvuta.setOnAction(event -> {

            try {
                double p = Double.parseDouble(pBernValem.getText());
                int n = Integer.parseInt(nBernValem.getText());
                int k = Integer.parseInt(kBernValem.getText());

                if (!BernoulliValem.kontrolli(p, n, k))
                    throw new NumberFormatException();

                Text berniVastus = new Text(BernoulliValem.arvuta(p, n, k));
                StackPane.setAlignment(berniVastus, Pos.BOTTOM_CENTER);
                StackPane.setMargin(berniVastus, new Insets(0, 0, 140, 0));
                berniVastus.setId("vastus");
                juur.getChildren().add(berniVastus);
                juur.getChildren().add(tühjenda);
            } catch (NumberFormatException e) {
                viga.show();
            }

        });

        //////////////////////////////////////////////////////////////////////////////////////

        //Bernoulli jaotus
        EventHandler<javafx.scene.input.MouseEvent> bernoulliHandler =
                e -> {
                    grid.getChildren().remove(pBernValem);
                    grid.getChildren().remove(edasi);
                    grid.getChildren().remove(nBernValem);
                    grid.getChildren().remove(edasi0);
                    grid.getChildren().remove(kBernValem);
                    grid.getChildren().remove(arvuta);
                    grid.getChildren().remove(edasi4);
                    grid.getChildren().remove(pBin);
                    grid.getChildren().remove(nBin);
                    grid.getChildren().remove(pGeo);
                    grid.getChildren().remove(L);
                    grid.getChildren().remove(arvuta5);
                    grid.getChildren().remove(arvuta6);
                    grid.getChildren().remove(arvuta7);

                    grid.getChildren().add(pBernJ);
                    grid.getChildren().add(arvuta4);
                };

        bernoulliJaotus.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, bernoulliHandler);

        arvuta4.setOnAction(event -> {

            try {
                double p = Double.parseDouble(pBernJ.getText());

                if (!BernoulliJaotus.kontrolli(p))
                    throw new NumberFormatException();

                Text bernJVastus = new Text(BernoulliJaotus.arvuta(p));

                StackPane.setAlignment(bernJVastus, Pos.BOTTOM_CENTER);
                StackPane.setMargin(bernJVastus, new Insets(0, 0, 140, 0));
                bernJVastus.setId("vastus");
                juur.getChildren().add(bernJVastus);
                juur.getChildren().add(tühjenda);
            }
            catch (NumberFormatException e) {
                viga.show();
            }

        });

        //////////////////////////////////////////////////////////////////////////////////////

        //Binoomjaotus
        EventHandler<javafx.scene.input.MouseEvent> binoomHandler =
                e -> {
                    grid.getChildren().remove(pBernValem);
                    grid.getChildren().remove(edasi);
                    grid.getChildren().remove(nBernValem);
                    grid.getChildren().remove(edasi0);
                    grid.getChildren().remove(kBernValem);
                    grid.getChildren().remove(arvuta);
                    grid.getChildren().remove(pBernJ);
                    grid.getChildren().remove(pGeo);
                    grid.getChildren().remove(L);
                    grid.getChildren().remove(arvuta4);
                    grid.getChildren().remove(arvuta6);
                    grid.getChildren().remove(arvuta7);

                    grid.getChildren().add(pBin);
                    grid.getChildren().add(edasi4);
                };
        EventHandler<javafx.scene.input.MouseEvent> binoomHandler2 =
                (MouseEvent e) -> {
                    grid.getChildren().add(nBin);
                    grid.getChildren().add(arvuta5);
                };

        binoom.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, binoomHandler);
        edasi4.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, binoomHandler2);

        arvuta5.setOnAction(event -> {

            try {
                double p = Double.parseDouble(pBin.getText());
                int n = Integer.parseInt(nBin.getText());

                if (!BinoomJaotus.kontrolli(p))
                    throw new NumberFormatException();

                Text binVastus = new Text(BinoomJaotus.arvuta(p, n));

                StackPane.setAlignment(binVastus, Pos.BOTTOM_CENTER);
                StackPane.setMargin(binVastus, new Insets(0, 0, 140, 0));
                binVastus.setId("vastus");
                juur.getChildren().add(binVastus);
                juur.getChildren().add(tühjenda);
            }
            catch (NumberFormatException e) {
                viga.show();
            }

        });

        //////////////////////////////////////////////////////////////////////////////////////

        //Geomeetriline jaotus
        EventHandler<javafx.scene.input.MouseEvent> geoHandler =
                e -> {
                    grid.getChildren().remove(pBernValem);
                    grid.getChildren().remove(edasi);
                    grid.getChildren().remove(nBernValem);
                    grid.getChildren().remove(edasi0);
                    grid.getChildren().remove(kBernValem);
                    grid.getChildren().remove(arvuta);
                    grid.getChildren().remove(edasi4);
                    grid.getChildren().remove(pBernJ);
                    grid.getChildren().remove(pBin);
                    grid.getChildren().remove(nBin);
                    grid.getChildren().remove(L);
                    grid.getChildren().remove(arvuta4);
                    grid.getChildren().remove(arvuta5);
                    grid.getChildren().remove(arvuta6);
                    grid.getChildren().remove(arvuta7);

                    grid.getChildren().add(pGeo);
                    grid.getChildren().add(arvuta6);
                };

        geo.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, geoHandler);

        arvuta6.setOnAction(event -> {

            try {
                double p = Double.parseDouble(pGeo.getText());

                if (!GeomeetrilineJaotus.kontrolli(p))
                    throw new NumberFormatException();

                Text geoVastus = new Text(GeomeetrilineJaotus.arvuta(p));

                StackPane.setAlignment(geoVastus, Pos.BOTTOM_CENTER);
                StackPane.setMargin(geoVastus, new Insets(0, 0, 140, 0));
                geoVastus.setId("vastus");
                juur.getChildren().add(geoVastus);
                juur.getChildren().add(tühjenda);
            }
            catch (NumberFormatException e) {
                viga.show();
            }

        });

        //////////////////////////////////////////////////////////////////////////////////////

        //Poissoni jaotus
        EventHandler<javafx.scene.input.MouseEvent> poisHandler;
        poisHandler = e -> {
            grid.getChildren().remove(pBernValem);
            grid.getChildren().remove(edasi);
            grid.getChildren().remove(nBernValem);
            grid.getChildren().remove(edasi0);
            grid.getChildren().remove(kBernValem);
            grid.getChildren().remove(arvuta);
            grid.getChildren().remove(edasi4);
            grid.getChildren().remove(pBernJ);
            grid.getChildren().remove(pBin);
            grid.getChildren().remove(nBin);
            grid.getChildren().remove(pGeo);
            grid.getChildren().remove(arvuta4);
            grid.getChildren().remove(arvuta5);
            grid.getChildren().remove(arvuta6);

            grid.getChildren().add(L);
            grid.getChildren().add(arvuta7);
        };

        poisson.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, poisHandler);

        arvuta7.setOnAction(event -> {

            try {
                Text poissoniVastus = new Text(PoissoniJaotus.arvuta(Double.parseDouble(L.getText())));

                StackPane.setAlignment(poissoniVastus, Pos.BOTTOM_CENTER);
                StackPane.setMargin(poissoniVastus, new Insets(0, 0, 140, 0));
                poissoniVastus.setId("vastus");
                juur.getChildren().add(poissoniVastus);
                juur.getChildren().add(tühjenda);
            }
            catch (NumberFormatException e) {
                viga.show();
            }

        });

        //////////////////////////////////////////////////////////////////////////////////////

        pealava.setTitle("Tõenäosusteooria kalkulaator");
        pealava.setScene(stseen);
        pealava.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}