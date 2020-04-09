/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_entry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.Collation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Abood Sh
 */


    /**
     * @param args the command line arguments
     */
 public class Student_Entry extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("login page .. ");
        Label label = new Label("welcome");
        label.setId("welcome");
        GridPane GP = new GridPane(); 
        GP.add(label, 0, 0);
        Label name = new Label("username");
        GP.add(name, 0, 1);
        TextField inname = new TextField();
        GP.add(inname, 1, 1);
        Label password = new Label("password");
        GP.add(password, 0, 2);
        TextField inpassword = new TextField();
        GP.add(inpassword, 1, 2);
        Button Sign_up = new Button("Sign up");
        Sign_up.setOnAction(E -> {
            File F;
            Scanner input;
            try {
                F = new File("names.txt");
                if (!F.exists()) {
                    F.createNewFile();
                }
                input = new Scanner(F);
                boolean isFound = false;
                while (input.hasNextLine()) {
                    String[] data = input.nextLine().split(" ");
                    if (inname.getText().equals(data[0]) && inpassword.getText().equals(data[1])) {
                        isFound = true;
                        Button adds = new Button("Add Student");
                        adds.setOnAction(event -> {
                            GridPane grid_pane = new GridPane();
                            Label student_data = new Label("student_data");
                            student_data.setStyle("-fx-font-weight: bold ;");
                            grid_pane.add(student_data, 0, 0);
                            Label id_s = new Label("id : ");
                            grid_pane.add(id_s, 0, 1);
                            TextField id_input = new TextField("");
                            grid_pane.add(id_input, 1, 1);
                            Label name_s = new Label("name : ");
                            grid_pane.add(name_s, 0, 2);
                            TextField name_input = new TextField("");
                            grid_pane.add(name_input, 1, 2);
                            Label major_s = new Label("major : ");
                            grid_pane.add(major_s, 0, 3);
                            TextField major_input = new TextField("");
                            grid_pane.add(major_input, 1, 3);
                            Label geade_s = new Label("geade : ");
                            grid_pane.add(geade_s, 0, 4);
                            TextField geade_input = new TextField("");
                            grid_pane.add(geade_input, 1, 4);
                            Label ave_gread = new Label("");
                            grid_pane.add(ave_gread,1,5);
                            grid_pane.setHgap(8);
                            grid_pane.setVgap(8);
                            Button Add, Reset, Exit;
                            Add = new Button("add");
                            Reset = new Button("Reset");
                            Exit = new Button("Exit");
                            Button sortname , name_and_grade, range_greade80_90 , total_average , group_Students ;
                            sortname = new Button("sortname");
                            name_and_grade = new Button("name_and_grade");
                            range_greade80_90 = new Button("range_greade80_90");
                            total_average = new Button("total_average");
                            group_Students = new Button("group_Students");
                            ListView listView = new ListView();
                            ArrayList<Student>s = new ArrayList<>();
                            Add.setOnAction(e -> {
                                int id = Integer.parseInt(id_input.getText());
                                String username = name_input.getText().toString(); 
                                String major = major_input.getText().toString();
                                double greade = Double.parseDouble(geade_input.getText());
                                Student st = new Student(id,username,major,greade);
                                s.add(st);
                                listView.getItems().addAll(st);
                                Collections.sort(listView.getItems(), new Comparator<Student>() {
                                    @Override
                                    public int compare(Student o1, Student o2) {
                                        if (o1.getGrade()== o2.getGrade()) {
                                            return 0;
                                        } else if (o1.getGrade()> o2.getGrade()) {
                                            return -1;
                                        } else if (o1.getGrade()< o2.getGrade()) {
                                            return 1;
                                        }
                                          return 0;
                                    }});
                            id_input.clear();
                            name_input.clear();
                            major_input.clear();
                            geade_input.clear();
                            });
                                sortname.setOnAction(e ->{
                                listView.getItems().setAll(s.stream().sorted((Student o1 , Student o2 )-> {
                                return o1.getName().compareTo(o2.getName());  
                                }).collect(Collectors.toList())
                                );    
                                });
                                name_and_grade.setOnAction(e ->{
                                listView.getItems().setAll(s.stream().sorted((Student o1, Student o2) -> o1.getGrade()> o2.getGrade()? -1 : 1).collect(Collectors.toList()));   
                                });
                                range_greade80_90.setOnAction(e ->{
                                listView.getItems().setAll(s.stream().filter((Student t) ->t.getGrade()<= 90 && t.getGrade()>= 80).sorted((Student o1, Student o2) -> o1.getGrade()> o2.getGrade()? -1 : 1).collect(Collectors.toList()));
                                });
                                Label avg = new Label("");
                                total_average.setOnAction(e ->{
                                double average = s.stream().mapToDouble((Student t) -> t.getGrade()).average().getAsDouble();
                                avg.setText("average : "+average);    
                                });
                                group_Students.setOnAction(e ->{
                                 s.stream().collect(Collectors.groupingBy(Student::getMajor )).forEach((stud , m ) -> m.forEach(h -> listView.getItems().add(h)));   
                                });
                            avg.setStyle("-fx-background-color: #999 ;");
                            VBox buttons_sort = new VBox(8 , sortname , name_and_grade, range_greade80_90 , total_average , group_Students );
                            buttons_sort.setAlignment(Pos.BASELINE_LEFT);
                            VBox Grid_And_button = new VBox(8 ,grid_pane,buttons_sort);
                            HBox buttons_HB = new HBox(5, Add, Reset, Exit);
                            grid_pane.add(buttons_HB, 1, 5);
                            VBox ListAndLabel = new VBox(listView , avg );
                            HBox HB = new HBox(30, Grid_And_button ,ListAndLabel);
                            HB.setPadding(new Insets(20));
                            Scene scene = new Scene(HB, 550, 400);
                            primaryStage.setTitle("Student Entry page ");
                            scene.getStylesheets().add("Stylet.css");
                            primaryStage.setScene(scene);
                            primaryStage.show();
                        });
                        Button views = new Button("view Student");
                        VBox vb = new VBox(10, adds, views);
                        vb.setAlignment(Pos.CENTER);
                        Scene scene = new Scene(vb, 300, 250);
                        primaryStage.setTitle("options page");
                        primaryStage.setScene(scene);
                        scene.getStylesheets().add("Stylet.css");
                        primaryStage.show();
                    }
                }
                if (!isFound) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "not found !!! ", ButtonType.OK);
                    alert.showAndWait();
                }
            } catch (IOException ex) {

            }
        });
        Button buttone = new Button("Exit");
        HBox hbox = new HBox(10, Sign_up, buttone);
        hbox.setAlignment(Pos.CENTER);
        GP.add(hbox, 0, 2);
        GP.setAlignment(Pos.CENTER);
        GP.setVgap(15);
        GP.setHgap(5);
        VBox VB = new VBox(30, GP, hbox);
        VB.setPadding(new Insets(30 , 0, 0, 0));
        Scene scene = new Scene(VB, 300, 250);
        

        primaryStage.setScene(scene);
        scene.getStylesheets().add("Stylet.css");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
   

}
