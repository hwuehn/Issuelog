package com.company.issuelog.view;

import com.company.issuelog.IssueLog;
import com.company.issuelog.model.Issue;
import com.company.issuelog.model.Project;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.security.auth.callback.Callback;


/**
* The controller for the root layout. The root layout provides the basic
* application layout containing space where other JavaFX
* elements can be placed.
*
* @author Henning Wuehn
*/
public class RootLayoutController {

    @FXML
    private ListView<Project> projectListView;

    @FXML
    private TableView<Issue> issueTable;

    @FXML
    private TableColumn<Issue, String> nameTableColumn;

    @FXML
    private TableColumn<Issue, String> statusTableColumn;

    @FXML
    private TableColumn<Issue, String> synopsisTableColumn;


    @FXML
    private TextField projectTextField;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField statusTextField;

    @FXML
    private Label synopsisLabel;

    @FXML
    private TextField synopsisTextField;

    @FXML
    private Label projectLabel;

    @FXML
    private TextArea inputTextArea;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Button newBtn;

    @FXML
    private Button saveBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Text welcomeText;

    private Issue issue;

    // Reference to the main application.
    private IssueLog mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public RootLayoutController() {
    }

    @FXML
    private void initialize() {
        // Initialize the issue table with the three columns.
        nameTableColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        statusTableColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        synopsisTableColumn.setCellValueFactory(cellData -> cellData.getValue().synopsisProperty());

        // Initialize the ListView
        // TODO
        //projectListView.setCellFactory(Callback<ListView<Project>, ListCell<Project>> );
        // Clear person details.
        showIssueDetails(null);

        // Listen for selection changes and show the person details when changed.
        issueTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showIssueDetails((newValue)));
    }

    /**
     *  Is called by the main application to give a referenz back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(IssueLog mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table.
        issueTable.setItems(mainApp.getIssueData());

    }

    /**
     * Fills text field to show details about the issue.
     * If the specified issue is null, text field are cleared.
     *
     * @param issue or null
     */
    private void showIssueDetails(Issue issue) {
        if (issue != null) {
            // Fill the textField with info from the issue object.
            inputTextArea.setText(issue.getDetail());
        } else {
            // Person is null, remove all the text.
            inputTextArea.setText("");
        }
    }

    /**
     * Called when the user clicks the new button. A new issue is invoked.
     */
    @FXML
    private void handleNewBtn() {
        Issue newIssue = new Issue();
        newIssue.setName(projectTextField.getText());
        newIssue.setStatus(statusTextField.getText());
        newIssue.setSynopsis(synopsisTextField.getText());
        newIssue.setDetail(inputTextArea.getText());
        mainApp.getIssueData().add(newIssue);
        }
    }


