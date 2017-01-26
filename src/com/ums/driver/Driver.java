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

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Driver extends Application {

    public static final String screen1ID = "main";
    public static final String screen1File = "main.fxml";
    public static final String screen2ID = "login";
    public static final String screen2File = "login.fxml";
    public static final String screen3ID = "studentStage";
    public static final String screen3File = "stStage.fxml";
    public static final String screen4ID = "teacherStage";
    public static final String screen4File = "trStage.fxml";
    public static final String screen5ID = "deanStage";
    public static final String screen5File = "deanStage.fxml";
    public static final String screen6ID = "librarianStage";
    public static final String screen6File = "librarianStage.fxml";
    public static final String screen7ID = "vcStage";
    public static final String screen7File = "vcStage.fxml";
    public static ScreensController mainContainer;
    public static University university;

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        university = new University();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        mainContainer = new ScreensController();
        mainContainer.loadScreen(Driver.screen1ID, Driver.screen1File);
        mainContainer.loadScreen(Driver.screen2ID, Driver.screen2File);
        mainContainer.loadScreen(Driver.screen3ID, Driver.screen3File);
        mainContainer.loadScreen(Driver.screen4ID, Driver.screen4File);
        mainContainer.loadScreen(Driver.screen5ID, Driver.screen5File);
        mainContainer.loadScreen(Driver.screen6ID, Driver.screen6File);
        mainContainer.loadScreen(Driver.screen7ID, Driver.screen7File);

        mainContainer.setScreen(Driver.screen1ID);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root, 750, 460);
        primaryStage.setScene(scene);
        primaryStage.setTitle("UMS - University Management System");
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}