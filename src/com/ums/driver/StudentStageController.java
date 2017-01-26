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
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.ums.buildings.IBA;
import com.ums.buildings.Pharmacy;
import com.ums.buildings.UBIT;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentStageController implements Initializable, ControlledScreen {

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
    JFXButton sort;

    @FXML
    JFXTextArea area;

    @FXML
    Text text;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        area.setEditable(false);
        text.setText("Welcome to your dashboard, " + Driver.university.st.getName()
                + " of " + Driver.university.st.getDepartment());
        sort.setDisable(true);
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
        area.setText(Driver.university.st.toString());

    }

    @FXML
    private void viewMarksheet() {
        area.setText(Driver.university.st.generateMarksSheet());
    }

    @FXML
    private void viewCourses() {
        area.setText(Driver.university.st.viewCourseList());
        sort.setDisable(false);
    }

    @FXML
    private void sortCourses() {
        if (Driver.university.st.getDepartment().equals("UBIT")) {
            UBIT.courseList.sort();
            viewCourses();
        } else if (Driver.university.st.getDepartment().equals("IBA")) {
            IBA.courseList.sort();
            viewCourses();
        } else {
            Pharmacy.courseList.sort();
            viewCourses();
        }
    }

    @FXML
    private void selectCourses() {
        if (Driver.university.st.getCourseList().courses.size() > 0) {
            Stage stage = new Stage();
            stage.setTitle("UMS - Select Courses");
            VBox layout = new VBox(10);

            Label label = new Label("\n\n  You have already selected courses for next semester");
            layout.getChildren().add(label);
            Scene scene = new Scene(layout, 300, 100);
            stage.setScene(scene);
            stage.show();
        } else {
            Label label1 = new Label("Select any six");
            label1.setMaxSize(500, 50);
            Label label2 = new Label("");
            JFXTextField tField1 = new JFXTextField();
            JFXTextField tField2 = new JFXTextField();
            JFXTextField tField3 = new JFXTextField();
            JFXTextField tField4 = new JFXTextField();
            JFXTextField tField5 = new JFXTextField();
            JFXTextField tField6 = new JFXTextField();

            Paint green = Paint.valueOf("#016F61");
            Paint white = Paint.valueOf("#ffffff");

            tField1.setPromptText("Enter ID");
            tField2.setPromptText("Enter ID");
            tField3.setPromptText("Enter ID");
            tField4.setPromptText("Enter ID");
            tField5.setPromptText("Enter ID");
            tField6.setPromptText("Enter ID");

            tField1.setFocusColor(green);
            tField2.setFocusColor(green);
            tField3.setFocusColor(green);
            tField4.setFocusColor(green);
            tField5.setFocusColor(green);
            tField6.setFocusColor(green);

            tField1.setMaxSize(150, 10);
            tField2.setMaxSize(150, 10);
            tField3.setMaxSize(150, 10);
            tField4.setMaxSize(150, 10);
            tField5.setMaxSize(150, 10);
            tField6.setMaxSize(150, 10);

            JFXTextArea textArea = new JFXTextArea();
            textArea.setEditable(false);
            textArea.setFocusColor(green);

            textArea.setText(Driver.university.st.viewCourseList());
            JFXButton butt = new JFXButton("Confirm");
            butt.setMaxSize(150, 20);

            butt.setStyle("-fx-background-color: #016F61");
            butt.setTextFill(white);

            Stage stage = new Stage();
            stage.setTitle("UMS - Select Courses");
            stage.setResizable(false);
            VBox layout = new VBox(10);

            tField1.setFocusColor(green);

            layout.setStyle("-fx-background: #FFFFFF;");

            layout.setPadding(new Insets(10, 10, 10, 10));

            textArea.setMaxSize(800, 350);
            textArea.setMinSize(800, 350);

            layout.getChildren().addAll(textArea, label1, tField1, tField2, tField3, tField4, tField5, tField6, butt, label2);
            Scene scene = new Scene(layout, 820, 690);
            stage.setScene(scene);
            stage.show();

            butt.setOnAction(event -> getCourses(tField1.getText(), tField2.getText(), tField3.getText(),
                    tField4.getText(), tField5.getText(), tField6.getText(), stage, label2));
        }
    }

    private void getCourses(String tField1, String tField2, String tField3,
                            String tField4, String tField5, String tField6, Stage stage, Label label) {
        if (tField1.equals("Enter ID") || tField1.equals("") || tField2.equals("Enter ID") || tField2.equals("")
                || tField3.equals("Enter ID") || tField3.equals("") || tField4.equals("Enter ID") || tField4.equals("")
                || tField5.equals("Enter ID") || tField5.equals("") || tField6.equals("Enter ID") || tField6.equals(""))
            label.setText("Please fill all the fields");

        else {

            try {
                Driver.university.st.selectCourses(tField1, tField2, tField3, tField4, tField5, tField6);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            stage.close();
        }
    }

    @FXML
    private void viewSelectedCourses() {
        area.setText(Driver.university.st.viewSelectedCourses());
    }

    @FXML
    private void dropOut() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        JFXButton butt1 = new JFXButton("NO");
        JFXButton butt2 = new JFXButton("YES");

        butt1.setStyle("-fx-background-color: #016F61");
        butt1.setTextFill(white);

        butt2.setStyle("-fx-background-color: #016F61");
        butt2.setTextFill(white);

        Label label = new Label("You are dropping out from University. Are you sure?");

        Stage stage = new Stage();
        stage.setTitle("UMS - Dropping Out");
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        layout.getChildren().addAll(label, butt1, butt2);
        layout.setStyle("-fx-background: #FFFFFF;");

        Scene scene = new Scene(layout, 400, 150);
        stage.setScene(scene);
        stage.show();
        butt1.setOnAction(event -> dropNo(stage));
        butt2.setOnAction(event -> dropYes());
    }

    private void dropYes() {
        try {
            Driver.university.st.dropOut();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    private void dropNo(Stage stage) {
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
                Driver.university.st.changePassword(pass);
                stage.close();
                Driver.mainContainer.loadScreen(Driver.screen2ID, Driver.screen2File);
                Driver.mainContainer.loadScreen(Driver.screen3ID, Driver.screen3File);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
