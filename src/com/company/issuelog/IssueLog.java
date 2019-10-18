package com.company.issuelog;

import com.company.issuelog.model.Issue;
import com.company.issuelog.model.Project;
import com.company.issuelog.view.RootLayoutController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class IssueLog extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;

    /**
     * The data as an observable list of issues.
     */
    private ObservableList<Issue> issueData = FXCollections.observableArrayList();
    private ObservableList<Project> projectData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public IssueLog() {
        // Add some sample data
        projectData.add(new Project("ProjectA"));
        projectData.add(new Project("ProjectB"));
        projectData.add(new Project("ProjectC"));
        projectData.add(new Project("ProjectD"));
        projectData.add(new Project("ProjectE"));

        issueData.add(new Issue("project_1", "open","big fat bug"));
        issueData.add(new Issue("project_2", "open","error"));
        issueData.add(new Issue("project_3", "proceed","exception"));
        issueData.add(new Issue("project_4", "resolved","runtime error"));
    }


    /**
     * Returns the data as an observable list of issues and projects.
     * @return
     */
    public ObservableList<Issue> getIssueData() {
        return issueData;
    }

    public ObservableList<Project> getProjectData() {
        return projectData;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage= primaryStage;
        this.primaryStage.setTitle("IssueLog - We track bugs");

        // Set the application icon.
        this.primaryStage.getIcons().add(new Image("file:resources.images/bugsearch.png"));

        initRootLayout();
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(IssueLog.class.getResource("view/RootLayout.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
