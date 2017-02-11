/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License"). You
 * may not use this file except in compliance with the License. You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package com.ums.driver;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.ums.buildings.AdminBlock;
import com.ums.buildings.Library;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LibrarianStageController implements Initializable, ControlledScreen {

    ScreensController controller;

    @FXML
    JFXButton exit;
    @FXML
    JFXButton logout;

    @FXML
    JFXButton but1;
    @FXML
    JFXButton but2;
    @FXML
    JFXButton but3;
    @FXML
    JFXButton but4;
    @FXML
    JFXButton but5;
    @FXML
    JFXButton but6;
    @FXML
    JFXButton but7;
    @FXML
    JFXButton but8;

    @FXML
    JFXTextArea area;

    @FXML
    Text text;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        area.setEditable(false);
        text.setText("Welcome to your dashboard, Chief Librarian " + Library.chiefLibrarian.getName()
                + "\nCurrent Opening Time Of Library: " + Library.time
                + "\tNumber of Books in the Library: " + Library.numOfBooks
                + "\tNumber Of Librarians: " + Library.numOfLibrarians);
    }

    public void setScreenParent(ScreensController screenParent) {
        controller = screenParent;
    }

    @FXML
    private void logout(ActionEvent event) {
        controller.setScreen(Driver.screen2ID);
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void viewInfo() {
        area.setText(Library.chiefLibrarian.toString());

    }

    @FXML
    private void setTime() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");
        Stage stage = new Stage();
        stage.setTitle("UMS - Change Time");
        VBox layout = new VBox(10);
        Label label = new Label();
        JFXTextField tField = new JFXTextField();
        tField.setPromptText("Enter new Time in the format HH:MM");
        tField.setFocusColor(green);
        Button butt = new Button("Confirm");
        butt.setStyle("-fx-background-color: #016F61");
        butt.setTextFill(white);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(tField, butt, label);
        layout.setStyle("-fx-background: #FFFFFF;");
        Scene scene = new Scene(layout, 400, 110);
        stage.setScene(scene);
        stage.show();
        butt.setOnAction(event -> lbChangeTimeOK(tField.getText()
                , stage, label));
    }

    private void lbChangeTimeOK(String time, Stage stage, Label label) {
        if (time.equals("Enter new Time in the format HH:MM") || time.equals("")) {
            label.setText("Please enter time in the correct format");
        } else if (time.contains(":")) {
            Library.chiefLibrarian.setTimeTo(time);
            stage.close();

            Driver.mainContainer.loadScreen(Driver.screen6ID, Driver.screen6File);
            Driver.mainContainer.setScreen(Driver.screen6ID);
        } else {
            label.setText("Enter time in the correct format");
        }
    }

    @FXML
    private void setTimeToDefault() {
        Driver.mainContainer.loadScreen(Driver.screen6ID, Driver.screen6File);
        Driver.mainContainer.setScreen(Driver.screen6ID);
        Stage stage = new Stage();
        stage.setTitle("UMS - Set Time to Default");
        VBox layout = new VBox(10);
        Library.chiefLibrarian.setTimeToDefault();
        Label label = new Label("The time has been set to default");
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(label);
        layout.setStyle("-fx-background: #FFFFFF;");
        Scene scene = new Scene(layout, 400, 80);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void hireLibrarians() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");
        Stage stage = new Stage();
        stage.setTitle("UMS - Hire Librarians");
        VBox layout = new VBox(10);
        Label label = new Label();
        JFXTextField tField = new JFXTextField();
        tField.setPromptText("Enter number of Librarians you wish to hire");
        tField.setFocusColor(green);
        JFXButton butt = new JFXButton("Confirm");
        butt.setStyle("-fx-background-color: #016F61");
        butt.setTextFill(white);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(tField, butt, label);
        layout.setStyle("-fx-background: #FFFFFF;");
        Scene scene = new Scene(layout, 400, 120);
        stage.setScene(scene);
        stage.show();

        butt.setOnAction(event -> hireLibrariansOK(tField.getText(),
                stage, label));
    }

    private void hireLibrariansOK(String n, Stage stage, Label label) {
        if (n.equals("Enter number of Librarians you wish to hire") || n.equals("")) {
            label.setText("Please fill the field");
        } else {
            Library.chiefLibrarian.hireNewLibrarians(Integer.parseInt(n));
            stage.close();
            Driver.mainContainer.loadScreen(Driver.screen6ID, Driver.screen6File);
            Driver.mainContainer.setScreen(Driver.screen6ID);
        }
    }

    @FXML
    private void fireLibrarians() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Stage stage = new Stage();
        stage.setTitle("UMS - Fire Librarians");
        VBox layout = new VBox(10);
        Label label = new Label();
        JFXTextField tField = new JFXTextField();
        tField.setPromptText("Enter number of Librarians you wish to fire");
        tField.setFocusColor(green);
        JFXButton butt = new JFXButton("Confirm");
        butt.setStyle("-fx-background-color: #016F61");
        butt.setTextFill(white);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(tField, butt, label);
        layout.setStyle("-fx-background: #FFFFFF;");
        Scene scene = new Scene(layout, 400, 120);
        stage.setScene(scene);
        stage.show();

        butt.setOnAction(event -> fireLibrariansOK(tField.getText(),
                stage, label));
    }

    private void fireLibrariansOK(String n, Stage stage, Label label) {
        if (n.equals("Enter number of Librarians you wish to fire") || n.equals("")) {
            label.setText("Please fill the field");
        } else {
            Library.chiefLibrarian.fireLibrarians(Integer.parseInt(n));
            stage.close();
            Driver.mainContainer.loadScreen(Driver.screen6ID, Driver.screen6File);
            Driver.mainContainer.setScreen(Driver.screen6ID);
        }
    }

    @FXML
    private void increaseBooks() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Stage stage = new Stage();
        stage.setTitle("UMS - Hire Librarians");
        VBox layout = new VBox(10);
        Label label = new Label();
        JFXTextField tField = new JFXTextField();
        tField.setPromptText("Enter number of Books you wish to increase");
        tField.setFocusColor(green);
        JFXButton butt = new JFXButton("Confirm");
        butt.setStyle("-fx-background-color: #016F61");
        butt.setTextFill(white);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(tField, butt, label);
        layout.setStyle("-fx-background: #FFFFFF;");
        Scene scene = new Scene(layout, 400, 120);
        stage.setScene(scene);
        stage.show();

        butt.setOnAction(event -> increaseBooksOK(tField.getText(),
                stage, label));
    }

    private void increaseBooksOK(String n, Stage stage, Label label) {
        if (n.equals("Enter number of Books you wish to increase") || n.equals("")) {
            label.setText("Please fill the field");
        } else {
            Library.chiefLibrarian.inreaseBooks(Integer.parseInt(n));
            stage.close();
            Driver.mainContainer.loadScreen(Driver.screen6ID, Driver.screen6File);
            Driver.mainContainer.setScreen(Driver.screen6ID);
        }
    }

    @FXML
    private void decreaseBooks() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Stage stage = new Stage();
        stage.setTitle("UMS - Fire Librarians");
        VBox layout = new VBox(10);
        Label label = new Label();
        JFXTextField tField = new JFXTextField();
        tField.setPromptText("Enter number of Books you wish to decrease");
        tField.setFocusColor(green);
        JFXButton butt = new JFXButton("Confirm");
        butt.setStyle("-fx-background-color: #016F61");
        butt.setTextFill(white);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(tField, butt, label);
        layout.setStyle("-fx-background: #FFFFFF;");
        Scene scene = new Scene(layout, 400, 120);
        stage.setScene(scene);
        stage.show();

        butt.setOnAction(event -> decreaseBooksOK(tField.getText(),
                stage, label));
    }

    private void decreaseBooksOK(String n, Stage stage, Label label) {
        if (n.equals("Enter number of Books you wish to decrease") || n.equals("")) {
            label.setText("Please fill the field");
        } else {
            Library.chiefLibrarian.decreaseBooks(Integer.parseInt(n));
            stage.close();
            Driver.mainContainer.loadScreen(Driver.screen6ID, Driver.screen6File);
            Driver.mainContainer.setScreen(Driver.screen6ID);
        }
    }

    @FXML
    private void resign() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        JFXButton butt1 = new JFXButton("NO");
        JFXButton butt2 = new JFXButton("YES");
        butt1.setStyle("-fx-background-color: #016F61");
        butt1.setTextFill(white);
        butt2.setStyle("-fx-background-color: #016F61");
        butt2.setTextFill(white);
        Label label = new Label("You are resigning from your position as Chief Librarian. Are you sure?");

        Stage stage = new Stage();
        stage.setTitle("UMS - Resign");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setStyle("-fx-background: #FFFFFF;");

        layout.getChildren().addAll(label, butt1, butt2);
        Scene scene = new Scene(layout, 400, 150);
        stage.setScene(scene);
        stage.show();
        butt1.setOnAction(event -> resignNo(stage));
        butt2.setOnAction(event -> resignYes());
    }

    private void resignYes() {
        try {
            Library.chiefLibrarian.resign();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    private void resignNo(Stage stage) {
        stage.close();
    }

    @FXML
    private void changePassword() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Stage stage = new Stage();
        stage.setTitle("UMS - Change Password");
        VBox layout = new VBox(10);
        JFXButton butt = new JFXButton("Confirm");
        butt.setStyle("-fx-background-color: #016F61");
        butt.setTextFill(white);

        Label lab = new Label();
        JFXTextField textField = new JFXTextField();
        textField.setPromptText("Enter new Password");
        textField.setFocusColor(green);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(textField, butt, lab);
        layout.setStyle("-fx-background: #FFFFFF;");
        Scene scene = new Scene(layout, 400, 120);
        stage.setScene(scene);
        stage.show();

        butt.setOnAction(event -> changePasswordOk(textField.getText(), stage, lab));
    }

    private void changePasswordOk(String pass, Stage stage, Label lab) {
        if (pass.equals("Enter new Password") || pass.equals(""))
            lab.setText("Please enter Password");
        else {
            try {
                Library.chiefLibrarian.changePassword(pass);
                stage.close();
                Driver.mainContainer.loadScreen(Driver.screen2ID, Driver.screen2File);
                Driver.mainContainer.loadScreen(Driver.screen6ID, Driver.screen6File);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void message() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Label lab1 = new Label("Initiate chat with");
        HBox hbox = new HBox();
        hbox.setStyle("-fx-background: #FFFFFF;");
        ToggleGroup group = new ToggleGroup();
        JFXRadioButton r1 = new JFXRadioButton("Vice Chancellor");
        r1.setToggleGroup(group);
        r1.setUserData("Vice Chancellor");
        group.selectToggle(r1);

        hbox.getChildren().addAll(r1);

        Stage stage = new Stage();
        stage.setTitle("UMS - Message");
        VBox layout = new VBox(10);
        JFXButton butt = new JFXButton("Confirm");
        butt.setStyle("-fx-background-color: #016F61");
        butt.setTextFill(white);

        Label lab2 = new Label();
        JFXTextField textField = new JFXTextField();
        textField.setPromptText("Enter ID of the User");
        textField.setFocusColor(green);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(lab1, hbox, textField, butt, lab2);
        layout.setStyle("-fx-background: #FFFFFF;");
        Scene scene = new Scene(layout, 400, 170);
        stage.setScene(scene);
        stage.show();

        butt.setOnAction(event -> messageOK(textField.getText(), group.getSelectedToggle().getUserData().toString(), stage, lab2));
    }

    private void messageOK(String id, String toggle, Stage stage, Label lab2) {

        if (id.equals("Enter ID of the User") || id.equals(""))
            lab2.setText("Please enter ID");

        else if (toggle.equals("Vice Chancellor")) {
            if (AdminBlock.viceChancellor.getID().equals(id)) {
                Library.chiefLibrarian.communicate(AdminBlock.viceChancellor.getPort());
                stage.close();
                startClientMessageGUI();
            } else {
                lab2.setText("User with this ID does not exist.");
            }
        }
    }

    public static JFXTextArea messageArea = new JFXTextArea();
    public static JFXTextField messageField = new JFXTextField();
    public static JFXButton messageButt = new JFXButton("Send");

    public static void startClientMessageGUI() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Stage stage = new Stage();
        stage.setTitle("UMS - Message");
        VBox layout = new VBox(10);

        messageArea.setFocusColor(green);
        messageArea.setEditable(false);
        messageArea.setPrefSize(430, 210);

        messageField.setPromptText("Enter message.");
        messageField.setFocusColor(green);
        messageField.setPrefWidth(450);

        messageButt.setStyle("-fx-background-color: #016F61");
        messageButt.setTextFill(white);
        messageButt.setPrefWidth(65);

        HBox hbox = new HBox();
        hbox.setSpacing(20);
        hbox.getChildren().addAll(messageField, messageButt);

        layout.setStyle("-fx-background: #FFFFFF;");
        layout.setPadding(new Insets(5, 5, 5, 5));

        layout.getChildren().addAll(messageArea, hbox);

        Scene scene = new Scene(layout, 550, 265);
        stage.setScene(scene);
        stage.show();

        messageButt.setOnAction(event -> sendClientMessage());
    }

    private static void sendClientMessage() {
        Library.chiefLibrarian.client.writer.println(messageField.getText());
        messageArea.appendText(AdminBlock.viceChancellor.getName() + ": " + messageField.getText() + "\n");
        messageField.clear();
    }

    public static void startServerMessageGUI() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Stage stage = new Stage();
        stage.setTitle("UMS - Message");
        VBox layout = new VBox(10);

        messageArea.setFocusColor(green);
        messageArea.setEditable(false);
        messageArea.setPrefSize(430, 210);

        messageField.setPromptText("Enter message.");
        messageField.setFocusColor(green);
        messageField.setPrefWidth(450);

        messageButt.setStyle("-fx-background-color: #016F61");
        messageButt.setTextFill(white);
        messageButt.setPrefWidth(65);

        HBox hbox = new HBox();
        hbox.setSpacing(20);
        hbox.getChildren().addAll(messageField, messageButt);

        layout.setStyle("-fx-background: #FFFFFF;");
        layout.setPadding(new Insets(5, 5, 5, 5));

        layout.getChildren().addAll(messageArea, hbox);

        Scene scene = new Scene(layout, 550, 265);
        stage.setScene(scene);
        stage.show();

        messageButt.setOnAction(event -> sendServerMessage());
    }

    private static void sendServerMessage() {
        Library.chiefLibrarian.server.writer.println(messageField.getText());
        messageArea.appendText(Library.chiefLibrarian.getName() + ": " + messageField.getText() + "\n");
        messageField.clear();
    }
}
