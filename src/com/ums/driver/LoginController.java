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
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.ums.buildings.AdminBlock;
import com.ums.buildings.Library;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable, ControlledScreen {

    ScreensController controller;

    @FXML
    JFXButton login;
    @FXML
    JFXButton goBack;
    @FXML
    JFXButton exit;

    @FXML
    JFXTextField tField;
    @FXML
    JFXPasswordField pField;

    @FXML
    Label label;

    @FXML
    JFXComboBox choices;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choices.getItems().addAll("Select one", "Student", "Teacher", "Dean", "Chief Librarian", "Vice Chancellor");
        choices.setValue("Select one");
    }

    public void setScreenParent(ScreensController screenParent) {
        controller = screenParent;
    }

    @FXML
    private void login(ActionEvent event) {
        if (choices.getValue().equals("Select one"))
            label.setText("Please select one");

        else {
            if (choices.getValue().equals("Student")) {
                if (Driver.university.st.login(tField.getText(), pField.getText())) {
                    for (int i = 0; i < AdminBlock.studentList.students.size(); i++) {
                        if (AdminBlock.studentList.students.get(i).getID().equalsIgnoreCase(tField.getText())) {
                            Driver.university.st.setID(AdminBlock.studentList.students.get(i).getID());
                            Driver.university.st.setName(AdminBlock.studentList.students.get(i).getName());
                            Driver.university.st.setPassword(AdminBlock.studentList.students.get(i).getPassword());
                            Driver.university.st.setPosition(AdminBlock.studentList.students.get(i).getPosition());
                            Driver.university.st.setDepartment(AdminBlock.studentList.students.get(i).getDepartment());
                            Driver.university.st.setField(AdminBlock.studentList.students.get(i).getField());
                            Driver.university.st.setSemester(AdminBlock.studentList.students.get(i).getSemester());
                            Driver.university.st.setFee(AdminBlock.studentList.students.get(i).getFee());
                            Driver.university.st.setAttendance(AdminBlock.studentList.students.get(i).getAttendance());
                            Driver.university.st.setCGPA(AdminBlock.studentList.students.get(i).getCGPA());
                            Driver.university.st.setMarks(AdminBlock.studentList.students.get(i).getMarks());
                            Driver.university.st.setCourseList(AdminBlock.studentList.students.get(i).getCourseList());
                            Driver.university.st.setPort(AdminBlock.studentList.students.get(i).getPort());
                            Driver.university.st.server = AdminBlock.studentList.students.get(i).server;
                        }
                    }
                    label.setText("");
                    Driver.university.st.startServer(Driver.university.st.getPort());
                    Driver.mainContainer.loadScreen(Driver.screen3ID, Driver.screen3File);
                    controller.setScreen(Driver.screen3ID);
                } else
                    label.setText("ID or Password incorrect");
            } else if (choices.getValue().equals("Teacher")) {
                if (Driver.university.tr.login(tField.getText(), pField.getText())) {
                    for (int i = 0; i < AdminBlock.teacherList.size(); i++) {
                        if (AdminBlock.teacherList.get(i).getID().equalsIgnoreCase(tField.getText())) {
                            Driver.university.tr.setID(AdminBlock.teacherList.get(i).getID());
                            Driver.university.tr.setName(AdminBlock.teacherList.get(i).getName());
                            Driver.university.tr.setPassword(AdminBlock.teacherList.get(i).getPassword());
                            Driver.university.tr.setPosition(AdminBlock.teacherList.get(i).getPosition());
                            Driver.university.tr.setQualification(AdminBlock.teacherList.get(i).getQualification());
                            Driver.university.tr.setDepartment(AdminBlock.teacherList.get(i).getDepartment());
                            Driver.university.tr.setSalary(AdminBlock.teacherList.get(i).getSalary());
                            Driver.university.tr.setAttendance(AdminBlock.teacherList.get(i).getAttendance());
                            Driver.university.tr.setPort(AdminBlock.teacherList.get(i).getPort());
                            Driver.university.tr.server = AdminBlock.teacherList.get(i).server;
                        }
                    }
                    label.setText("");
                    Driver.university.tr.startServer(Driver.university.tr.getPort());
                    Driver.mainContainer.loadScreen(Driver.screen4ID, Driver.screen4File);
                    controller.setScreen(Driver.screen4ID);
                } else
                    label.setText("ID or Password incorrect");
            } else if (choices.getValue().equals("Dean")) {
                if (Driver.university.dn.login(tField.getText(), pField.getText())) {
                    for (int i = 0; i < AdminBlock.deanList.size(); i++) {
                        if (AdminBlock.deanList.get(i).getID().equalsIgnoreCase(tField.getText())) {
                            Driver.university.dn.setID(AdminBlock.deanList.get(i).getID());
                            Driver.university.dn.setName(AdminBlock.deanList.get(i).getName());
                            Driver.university.dn.setPassword(AdminBlock.deanList.get(i).getPassword());
                            Driver.university.dn.setPosition(AdminBlock.deanList.get(i).getPosition());
                            Driver.university.dn.setQualification(AdminBlock.deanList.get(i).getQualification());
                            Driver.university.dn.setDepartment(AdminBlock.deanList.get(i).getDepartment());
                            Driver.university.dn.setSalary(AdminBlock.deanList.get(i).getSalary());
                            Driver.university.dn.setAttendance(AdminBlock.deanList.get(i).getAttendance());
                            Driver.university.dn.setPort(AdminBlock.deanList.get(i).getPort());
                            Driver.university.dn.server = AdminBlock.deanList.get(i).server;
                        }
                    }
                    label.setText("");
                    Driver.university.dn.startServer(Driver.university.dn.getPort());
                    Driver.mainContainer.loadScreen(Driver.screen5ID, Driver.screen5File);
                    controller.setScreen(Driver.screen5ID);
                } else
                    label.setText("ID or Password incorrect");
            } else if (choices.getValue().equals("Chief Librarian")) {
                if (Library.chiefLibrarian.login(tField.getText(), pField.getText())) {
                    label.setText("");
                    Library.chiefLibrarian.startServer(Library.chiefLibrarian.getPort());
                    Driver.mainContainer.loadScreen(Driver.screen6ID, Driver.screen6File);
                    controller.setScreen(Driver.screen6ID);
                } else
                    label.setText("ID or Password incorrect");
            } else if (choices.getValue().equals("Vice Chancellor")) {
                if (AdminBlock.viceChancellor.login(tField.getText(), pField.getText())) {
                    label.setText("");
                    AdminBlock.viceChancellor.startServer(AdminBlock.viceChancellor.getPort());
                    Driver.mainContainer.loadScreen(Driver.screen7ID, Driver.screen7File);
                    controller.setScreen(Driver.screen7ID);
                } else
                    label.setText("ID or Password incorrect");
            }
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        controller.setScreen(Driver.screen1ID);
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
}