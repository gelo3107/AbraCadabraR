/*
 * This class changes GUI presets (color style, labels visibility) during app operation
 */

package com.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;

public class GUIPresets
{
    /* Method to change color style */
    public static void setColorStyle(String bGroundColor, String textColor, String buttonStyle, RadioButton blackRButton,
                                     RadioButton whiteRButton, Label putPassword, Label putMessage, AnchorPane mainPane,
                                     Button clear, Button code, Button decode, Button help) {
        blackRButton.setStyle(textColor);
        whiteRButton.setStyle(textColor);
        putPassword.setStyle(textColor);
        putMessage.setStyle(textColor);
        mainPane.setStyle(bGroundColor);
        clear.setStyle(buttonStyle);
        code.setStyle(buttonStyle);
        decode.setStyle(buttonStyle);
        help.setStyle(buttonStyle);
    }

    /* Method for changing labels visibility */
    public static void visibleLables (Label done, boolean visibleDone, Label incorrectPassword, boolean visibleIncorrectPassword){
        done.setVisible(visibleDone);
        incorrectPassword.setVisible(visibleIncorrectPassword);
    }
}
