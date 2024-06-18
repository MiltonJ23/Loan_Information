/*
 * This file is part of the marquis valois distribution
 * Copyright (c) 2024 Acheron Systems.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.Hell.Driver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;


public  class Main extends Application{
  @Override
  public void start(Stage stage) throws Exception {
      // fxmloader is an object capable to load the layout in the window
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/res/fxml/Loan.fxml"));
    Pane root_pane = fxmlLoader.load();
    //tentons de créer les objets url et  ResourceBundle vides , donc nuls
    URL fm = null;
    ResourceBundle messages = null;
    //fin de création
    LoanController controller = fxmlLoader.getController();
    controller.SetPrimaryStage(stage);
    controller.initialize(fm,messages);
    stage.setTitle("Loan Analysis");
    stage.setScene(new Scene(root_pane, 1080, 647));
    stage.show();
    }


    public static void main(String[] args) {
        launch(args); // launching project
    }
}
