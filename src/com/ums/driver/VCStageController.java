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
import com.ums.entities.AccountHolder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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

public class VCStageController implements Initializable, ControlledScreen {

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
    JFXButton but9;
    @FXML
    JFXButton but10;
    @FXML
    JFXButton but11;
    @FXML
    JFXButton but12;
    @FXML
    JFXButton but13;
    @FXML
    JFXButton but14;

    @FXML
    JFXButton sort1;
    @FXML
    JFXButton sort2;
    @FXML
    JFXButton sort3;

    @FXML
    JFXTextArea area;

    @FXML
    Text text;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        area.setEditable(false);
        text.setText("Welcome to your dashboard, " + AdminBlock.viceChancellor.getName()
                + ", Vice Chancellor of Karachi University");
        sort1.setDisable(true);
        sort2.setDisable(true);
        sort3.setDisable(true);
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
    private void viewPersonalInfo() {
        area.setText(AdminBlock.viceChancellor.toString());
        sort1.setDisable(true);
        sort2.setDisable(true);
        sort3.setDisable(true);
    }

    @FXML
    private void generateAttandanceReport() {
        area.setText(AdminBlock.viceChancellor.generateAttendanceReport());
        sort1.setDisable(true);
        sort2.setDisable(true);
        sort3.setDisable(true);
    }

    @FXML
    private void generateSalaryReport() {
        area.setText(AdminBlock.viceChancellor.generateSalaryReport());
        sort1.setDisable(true);
        sort2.setDisable(true);
        sort3.setDisable(true);
    }

    @FXML
    private void viewDeans() {
        area.setText(AdminBlock.viceChancellor.viewDeans());
        sort1.setDisable(true);
        sort2.setDisable(true);
        sort3.setDisable(true);
    }

    @FXML
    private void viewTeachers() {
        area.setText(AdminBlock.viceChancellor.viewTeachers());
        sort1.setDisable(false);
        sort2.setDisable(true);
        sort3.setDisable(true);
    }

    @FXML
    private void viewStudents() {
        area.setText(AdminBlock.viceChancellor.viewStudents());
        sort2.setDisable(false);
        sort1.setDisable(true);
        sort3.setDisable(true);
    }

    @FXML
    private void viewCourses() {
        area.setText(AdminBlock.viceChancellor.viewCourses());
        sort3.setDisable(false);
        sort1.setDisable(true);
        sort2.setDisable(true);
    }

    @FXML
    private void sortTeachers() {
        AdminBlock.teacherSort();
        viewTeachers();
    }

    @FXML
    private void sortStudents() {
        AdminBlock.studentList.sort();
        viewStudents();
    }

    @FXML
    private void sortCourses() {
        AdminBlock.courseList.sort();
        viewCourses();
    }

    @FXML
    private void viewDepartments() {
        area.setText(Driver.university.ubit + "\n\n" + Driver.university.kubs + "\n\n"
                + Driver.university.pharmacy);
        sort3.setDisable(true);
        sort1.setDisable(true);
        sort2.setDisable(true);
    }

    @FXML
    private void registerDean() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Stage stage = new Stage();
        stage.setTitle("UMS - Register Dean");
        VBox layout = new VBox(10);
        JFXButton butt1 = new JFXButton("Confirm");
        butt1.setStyle("-fx-background-color: #016F61");
        butt1.setTextFill(white);
        Label label = new Label();
        JFXTextField textField1 = new JFXTextField();
        JFXTextField textField2 = new JFXTextField();
        JFXTextField textField3 = new JFXTextField();
        JFXTextField textField4 = new JFXTextField();

        textField1.setPromptText("Enter Name");
        textField2.setPromptText("Enter Qualification");
        textField3.setPromptText("Enter Department");
        textField4.setPromptText("Enter Salary");

        textField1.setFocusColor(green);
        textField2.setFocusColor(green);
        textField3.setFocusColor(green);
        textField4.setFocusColor(green);

        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(textField1, textField2, textField3, textField4, butt1, label);
        layout.setStyle("-fx-background: #FFFFFF;");
        Scene scene = new Scene(layout, 400, 230);
        stage.setScene(scene);
        stage.show();
        butt1.setOnAction(event -> registerDeanOK(textField1.getText(), textField2.getText()
                , textField3.getText(), textField4.getText(), stage, label));
    }

    private void registerDeanOK(String name, String qualification, String department, String salary, Stage stage, Label label) {
        if (AdminBlock.deanList.size() >= 3) {
            label.setText("No need to hire a new Dean");
        } else if (name.equals("Enter Name") || name.equals("") || qualification.equals("Enter Qualification") || qualification.equals("")
                || department.equals("Enter Department") || department.equals("") || salary.equals("Enter Salary") || salary.equals("")) {
            label.setText("Please fill all the fields");
        } else {
            try {
                AdminBlock.viceChancellor.hireNewEmployee(name, qualification, department, Integer.parseInt(salary), AccountHolder.Position.DEAN);
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.close();
        }
    }

    @FXML
    private void fireDean() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Stage stage = new Stage();
        stage.setTitle("UMS - Fire Dean");
        VBox layout = new VBox(10);
        JFXButton butt1 = new JFXButton("Confirm");
        butt1.setStyle("-fx-background-color: #016F61");
        butt1.setTextFill(white);
        JFXTextField textField = new JFXTextField();
        textField.setPromptText("Enter ID to Fire");
        textField.setFocusColor(green);
        Label label = new Label();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(textField, butt1, label);
        layout.setStyle("-fx-background: #FFFFFF;");
        Scene scene = new Scene(layout, 400, 120);
        stage.setScene(scene);
        stage.show();


        butt1.setOnAction(event -> fireDeanOk(textField.getText(), label));
    }

    private void fireDeanOk(String id, Label label) {
        if (id.equals("Enter ID to Fire") || id.equals("")) {
            label.setText("Please fill the field");
        } else {
            try {
                AdminBlock.viceChancellor.fireEmployee(id);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void registerTeacher() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Stage stage = new Stage();
        stage.setTitle("UMS - Register Teacher");
        VBox layout = new VBox(10);
        JFXButton butt1 = new JFXButton("Confirm");

        butt1.setStyle("-fx-background-color: #016F61");
        butt1.setTextFill(white);

        Label label = new Label();

        JFXTextField textField1 = new JFXTextField();
        JFXTextField textField2 = new JFXTextField();
        JFXTextField textField3 = new JFXTextField();
        JFXTextField textField4 = new JFXTextField();

        textField1.setPromptText("Enter Name");
        textField2.setPromptText("Enter Qualification");
        textField3.setPromptText("Enter Department");
        textField4.setPromptText("Enter Salary");

        textField1.setFocusColor(green);
        textField2.setFocusColor(green);
        textField3.setFocusColor(green);
        textField4.setFocusColor(green);

        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(textField1, textField2, textField3, textField4, butt1, label);
        layout.setStyle("-fx-background: #FFFFFF;");
        Scene scene = new Scene(layout, 400, 230);
        stage.setScene(scene);
        stage.show();
        butt1.setOnAction(event -> registerTeacherOK(textField1.getText(), textField2.getText()
                , textField3.getText(), textField4.getText(), stage, label));
    }

    private void registerTeacherOK(String name, String qualification, String department, String salary, Stage stage, Label label) {
        if ((name.equals("Enter Name") || department.equals("Enter Department") || qualification.equals("Enter Qualification")
                || salary.equals("Enter Salary") || name.equals("") || department.equals("")
                || qualification.equals("")) || salary.equals(""))
            label.setText("Please fill all the fields");

        else {
            try {
                AdminBlock.viceChancellor.hireNewEmployee(name, qualification, department, Integer.valueOf(salary), AccountHolder.Position.TEACHER);
                stage.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void fireTeacher() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Stage stage = new Stage();
        stage.setTitle("UMS- Fire Teacher");
        VBox layout = new VBox(10);
        JFXButton butt1 = new JFXButton("Confirm");
        butt1.setStyle("-fx-background-color: #016F61");
        butt1.setTextFill(white);
        Label label = new Label();
        JFXTextField textField = new JFXTextField();
        textField.setPromptText("Enter ID to Fire");
        textField.setFocusColor(green);
        ;
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(textField, butt1, label);
        layout.setStyle("-fx-background: #FFFFFF;");
        Scene scene = new Scene(layout, 400, 120);
        stage.setScene(scene);
        stage.show();


        butt1.setOnAction(event -> fireTeacherOk(textField.getText(), label, stage));
    }

    private void fireTeacherOk(String id, Label label, Stage stage) {
        if (id.equals("Enter ID to Fire") || id.equals("")) {
            label.setText("Please fill the field");
        } else {
            try {
                AdminBlock.viceChancellor.fireEmployee(id);
                stage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void updateSalary() {
        Paint green = Paint.valueOf("#016F61");
        Paint white = Paint.valueOf("#ffffff");

        Stage stage = new Stage();
        stage.setTitle("UMS - Increase Salary");
        VBox layout = new VBox(10);
        Label lab = new Label();
        layout.setPadding(new Insets(10, 10, 10, 10));
        JFXTextField tField1 = new JFXTextField();
        JFXTextField tField2 = new JFXTextField();

        tField1.setPromptText("Enter Employee ID");
        tField2.setPromptText("Enter Updated Salary");

        tField1.setFocusColor(green);
        tField2.setFocusColor(green);

        JFXButton butt = new JFXButton("Confirm");

        butt.setStyle("-fx-background-color: #016F61");
        butt.setTextFill(white);

        butt.setOnAction(event -> updateSalaryOK(tField1.getText(), tField2.getText(), stage, lab));

        layout.getChildren().addAll(tField1, tField2, butt, lab);
        layout.setStyle("-fx-background: #FFFFFF;");
        Scene scene = new Scene(layout, 400, 150);
        stage.setScene(scene);
        stage.show();
    }

    private void updateSalaryOK(String id, String sal, Stage stage, Label lab) {
        if (id.equals("Enter Employee ID") || id.equals("") || sal.equals("Enter updated salary") || sal.equals("")) {
            lab.setText("Please fill all the fields");
        } else {
            try {
                AdminBlock.viceChancellor.increaseSalary(id, Integer.parseInt(sal));
                stage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
                AdminBlock.viceChancellor.changePassword(pass);
                stage.close();
                Driver.mainContainer.loadScreen(Driver.screen7ID, Driver.screen7File);
                Driver.mainContainer.loadScreen(Driver.screen2ID, Driver.screen2File);
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
        JFXRadioButton r1 = new JFXRadioButton("Dean");
        JFXRadioButton r2 = new JFXRadioButton("Chief Librarian");
        r1.setToggleGroup(group);
        r1.setUserData("Dean");
        r2.setToggleGroup(group);
        r2.setUserData("Chief Librarian");
        group.selectToggle(r1);

        hbox.getChildren().addAll(r1, r2);

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

        else if (toggle.equals("Dean")) {
            for (int i=0; i<AdminBlock.deanList.size(); i++) {
                if (AdminBlock.deanList.get(i).getID().equals(id)) {
                    AdminBlock.viceChancellor.communicate(AdminBlock.deanList.get(i).getPort());
                    stage.close();
                    startClientMessageGUI();
                }
                else {
                    lab2.setText("User with this ID does not exist.");
                }
            }
        }

        else {
            if (Library.chiefLibrarian.getID().equals(id)) {
                AdminBlock.viceChancellor.communicate(Library.chiefLibrarian.getPort());
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
        AdminBlock.viceChancellor.client.writer.println(messageField.getText());
        messageArea.appendText(AdminBlock.viceChancellor.getName() + ": " + messageField.getText() + "\n");
        messageField.clear();
    }

    public static void startServertMessageGUI() {
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
        AdminBlock.viceChancellor.server.writer.println(messageField.getText());
        messageArea.appendText(AdminBlock.viceChancellor.getName() + ": " + messageField.getText() + "\n");
        messageField.clear();
    }
}
