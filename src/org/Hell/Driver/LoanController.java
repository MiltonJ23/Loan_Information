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

import java.util.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.Notifications;
import javafx.util.Duration;


public class LoanController implements Initializable{
  //Créeons les composants FXML
  @FXML
private Button ComputeButton;
  @FXML
private Button ComputeAnalysisButton;
  @FXML
private Button NewLoanButton;
  @FXML
private Button ExitButton;
  @FXML
private TextField NameField;
  @FXML
private TextField LoanBalanceField;
  @FXML
private TextField InterestField;
  @FXML
private TextField NumberPaymentField;
  @FXML
private TextField MonthlyPaymentField;
  @FXML
private TextArea Display1;
  @FXML
private AnchorPane Anchor;

private Stage primaryStage;
//Fin de création des composants fxml dans le controller

//création des méthodes d'actionnement des bouttons
  @FXML
  public void Compute(MouseEvent event){
    if((MonthlyPaymentField.getText().isEmpty() && LoanBalanceField.getText().isEmpty() && InterestField.getText().isEmpty())){
        Notifications builder = Notifications.create()
                                              .title("Saisies Invalides ")
                                              .text("Les valeurs de champs -Loan Balance,Interest et Monthly Payment- sont incorrectement remplis")
                                              .graphic(null)
                                              .hideAfter(Duration.seconds(7))
                                              .position(Pos.TOP_LEFT);

        builder.darkStyle();
        builder.showError();
    }else{
      //Gestion des erreurs dans les champs de saisie
      //gestion de l'erreur lors de la conversion de l'intérêt dans la variable "interest"
      float interest,monthypay,Loan;
      interest=0;monthypay=0;Loan=0;
      try {
      interest   = Float.parseFloat(InterestField.getText());
      } catch(Exception e) {

        Notifications buil = Notifications.create()
                                              .title("Valeur de l'intérêt invalide ")
                                              .text("Veuillez entrer une valeur numérique ")
                                              .graphic(null)
                                              .hideAfter(Duration.seconds(3))
                                              .position(Pos.TOP_LEFT);
        buil.darkStyle();
        buil.showError();
        System.out.println("Error = "+ e);
        InterestField.setText("");
      }
      //gestion de l'erreur lors de  la conversion du montant de prêt dans la variable "Loan"
      try {
         Loan = Float.parseFloat(LoanBalanceField.getText());
      } catch(Exception e) {
        Notifications builder2 = Notifications.create()
                                              .title("Valeur du prêt invalide ")
                                              .text("Veuillez entrer une valeur numérique ")
                                              .graphic(null)
                                              .hideAfter(Duration.seconds(3))
                                              .position(Pos.TOP_LEFT);
        builder2.darkStyle();
        builder2.showError();
        System.out.println("Error = "+ e);
        LoanBalanceField.setText("");
      }
      //gestion de l'erreur lors de  la conversion du montant du paiement mensuel dans la variable "monthypay"
      try {
         monthypay = Float.parseFloat(MonthlyPaymentField.getText());
      } catch(Exception e) {
        Notifications builder3 = Notifications.create()
                                              .title("Valeur du Paiement mensuel invalide ")
                                              .text("Veuillez entrer une valeur numérique ")
                                              .graphic(null)
                                              .hideAfter(Duration.seconds(3))
                                              .position(Pos.TOP_LEFT);
        builder3.darkStyle();
        builder3.showError();
        System.out.println("Error = "+ e);
        MonthlyPaymentField.setText("");
      }
      //fin de la gestion des erreurs  de conversion
      //Tentative de calcul de la valeur des tranches du versement et affichage
      try {
        float tranche = (Loan*((100+interest)/100))/monthypay;
        NumberPaymentField.setText(String.valueOf(tranche));
      } catch(Exception e) {
        System.out.println("Error : "+e);
      }
    }

  };

  @FXML
  public void NewLoan(MouseEvent event){
    Display1.setText("");
    MonthlyPaymentField.setText("");
    NumberPaymentField.setText("");
    InterestField.setText("");
    LoanBalanceField.setText("");
    NameField.setText("");
  }


  @FXML
  public void Analysis(MouseEvent event){
    if(!(MonthlyPaymentField.getText().isEmpty() && LoanBalanceField.getText().isEmpty() && InterestField.getText().isEmpty() && NumberPaymentField.getText().isEmpty())){


      Display1.setText("");
      Display1.setText("Contracting party Name :\t\t"+NameField.getText()+"\n\n"+"Loan Amount :\t\t"+ LoanBalanceField.getText()+"$"+"\n\n"+"Interest amount:\t\t"+InterestField.getText()
      +"\n\n"+" Monthly Payment:\t\t"+MonthlyPaymentField.getText()
      +"\n\n"+" Number of Payment :\t\t"+NumberPaymentField.getText());
}


}

  @FXML
  public void LogOut(MouseEvent event){
    this.primaryStage.close();
  }

  public void SetPrimaryStage(Stage stage){
    this.primaryStage=stage;
  }


// Après la création des fonctions qui seront liés à nos bouttons fxml , initialisons le lancement de l'interface dans controlleur
public void initialize(URL lim,ResourceBundle bundle){
  //figeons la taille de l'anchor pane
  Anchor.setMaxWidth(1080);
  Anchor.setMinWidth(1080);
  Anchor.setMaxHeight(647);
  Anchor.setMinHeight(647);
}


}
