/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myorg.pluginnetbeans;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "org.myorg.pluginnetbeans.GitHubActionListener"
)
@ActionRegistration(
        iconBase = "org/myorg/pluginnetbeans/github16.png",
        displayName = "#CTL_GitHubActionListener"
)
@ActionReference(path = "Menu/Tools", position = 0)
@Messages("CTL_GitHubActionListener=GitHub")
public final class GitHubActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String repo = JOptionPane.showInputDialog("Indique el nombre para el repositorio");
            
            GitHub github = GitHub.connect();
            GHCreateRepositoryBuilder builder;
            builder = github.createRepository(repo);
            builder.create();
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
