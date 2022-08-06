/*
 * This class describes GUI form behaviour after some events (push buttons, select radio buttons)
 */

package com.controller;

import com.gui.GUIPresets;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import com.logic.Coder;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Controller
{
    /* Declaration of fields based on fxml */
    @FXML
    private AnchorPane mainPane;
    @FXML
    private TextField passwordBox;
    @FXML
    private TextArea messageBox;
    @FXML
    private Button code, decode, clear, help;
    @FXML
    private Label incorrectPassword, done, putPassword, putMessage;
    @FXML
    private RadioButton blackRButton, whiteRButton;

    /* White style constants declaration */
    private static final String WHITE_BUTTON_STYLE = "-fx-background-color: white; -fx-text-fill: black;";
    private static final String WHITE_TEXT_COLOR = "-fx-text-fill: white";
    private static final String BLACK_BG_COLOR = "-fx-background-color: black";

    /* Black style constants declaration */
    private static final String BLACK_BUTTON_STYLE = "-fx-background-color: black; -fx-text-fill: white;";
    private static final String BLACK_TEXT_COLOR = "-fx-text-fill: black";
    private static final String WHITE_BG_COLOR = "-fx-background-color: white";

    /* Calling method when button "Code" is pushed */
    @FXML
    public void code() {
        /* Checking if message less than 5 symbols */
        if (!Coder.checkMessage(messageBox.getText())) {
            done.setText("Text 5 symbols or more");
            GUIPresets.visibleLables(done,true, incorrectPassword,false);
        } else {
            /* Code message if password checking is Ok */
            if (Coder.checkPasswordCode(passwordBox.getText())) {
                String codedText = Coder.getCoded(messageBox.getText(), passwordBox.getText());
                messageBox.clear();
                passwordBox.clear();
                messageBox.setText(codedText);
                done.setText("Done!");
                GUIPresets.visibleLables(done,true, incorrectPassword,false);
            } else {
                //* Return warning if password is not Ok */
                incorrectPassword.setText("Invalid password (5 symbols)");
                GUIPresets.visibleLables(done,false, incorrectPassword,true);
            }
        }
    }

    /* Calling method when button "Decode" is pushed */
    @FXML
    public void decode() {
        /* If massage is less than 5 symbols return warning */
            if (!Coder.checkMessage(messageBox.getText())) {
            done.setText("Put 5 symbols or more");
            GUIPresets.visibleLables(done,true, incorrectPassword,false);
        /* Decode message */
        } else {
            String decoded = Coder.getTranspondedString(messageBox.getText());
            String passwordToChek = passwordBox.getText();
            String checkedPassword = Coder.returnPasswordDecode(decoded);

            /* If inserted password more or less than 5 symbols return warning */
            if (!Coder.checkPasswordCode(passwordBox.getText())) {
                incorrectPassword.setText("Put 5 symbols");
                GUIPresets.visibleLables(done,false, incorrectPassword,true);
            /* If inserted password equals to message password show decoded message */
            } else if (passwordToChek.equals(checkedPassword)) {
                messageBox.clear();
                passwordBox.clear();
                messageBox.setText(decoded.substring(5));
                done.setText("Done!");
                GUIPresets.visibleLables(done,true, incorrectPassword,false);
            /* If inserted password does not equal to message password return warning */
            } else {
                incorrectPassword.setText("Invalid password");
                GUIPresets.visibleLables(done,false, incorrectPassword,true);
            }
        }
    }

    /* Calling method when button "Clear" is pushed */
    @FXML
    public void clear() {
        passwordBox.clear();
        messageBox.clear();
        GUIPresets.visibleLables(done,false, incorrectPassword,false);
    }

    /* Calling method when button "Help" is pushed */
    public void openHelp() throws IOException {
        String [] command = {"notepad.exe",(new File("").getAbsolutePath()+"/help.txt")};
        new ProcessBuilder(command).start();
    }

    /* Calling method for black / white style changing by radio buttons */
    @FXML
    public void changeColorTheme() {
        if(blackRButton.isSelected()) {
            GUIPresets.setColorStyle(BLACK_BG_COLOR, WHITE_TEXT_COLOR, WHITE_BUTTON_STYLE,
                                        blackRButton, whiteRButton, putPassword, putMessage, mainPane, clear, code, decode, help);
        } else if (whiteRButton.isSelected()) {
            GUIPresets.setColorStyle(WHITE_BG_COLOR, BLACK_TEXT_COLOR, BLACK_BUTTON_STYLE,
                                        blackRButton, whiteRButton, putPassword, putMessage, mainPane, clear, code, decode, help);
        }
    }
}