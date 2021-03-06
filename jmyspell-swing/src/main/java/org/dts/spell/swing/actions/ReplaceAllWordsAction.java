/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dts.spell.swing.actions;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.text.JTextComponent;
import org.dts.spell.ErrorInfo;
import org.dts.spell.swing.JTextComponentSpellChecker;
import org.dts.spell.swing.utils.Messages;

/**
 *
 * @author personal
 */
public class ReplaceAllWordsAction extends ErrorInfoAction {

    private String suggestion;

    protected ReplaceAllWordsAction(JTextComponentSpellChecker txtCmpSpellChecker) {
        super(txtCmpSpellChecker);
    }

    @Override
    public void setErrorInfo(ErrorInfo errorInfo) {
        super.setErrorInfo(errorInfo);
    }

    public void setSuggestion(String suggestion) {

        if (null != suggestion) {
            putValue(NAME, Messages.getString("REPLACE_ALL_WORDS", suggestion));
        } else {
            putValue(NAME, Messages.getString("REPLACE_ALL_WORDS", ""));
        }

        setEnabled(null != suggestion);

        this.suggestion = suggestion;
    }

    public void doAction(Object object) {
        actionPerformed(new ActionEvent(object, MouseEvent.MOUSE_PRESSED, DEFAULT));
    }

    public void actionPerformed(ActionEvent e) {
        JTextComponent txtCmp = getTextComponent(e);
        getTxtCmpSpellChecker().replaceAllBadWords(txtCmp, getErrorInfo().getBadWord().toString(), suggestion);
        txtCmp.requestFocusInWindow();
    }
}
