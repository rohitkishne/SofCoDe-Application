/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import project_components.compressor;
import project_components.decompressor;

/**
 *
 * @author dell
 */
public class AppFrame extends JFrame implements ActionListener {
        JButton compressButton;
        JButton decompressButton;
        JLabel heading;
        
        
        AppFrame(){
            
            
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(null);
            
            setTitle("CompressorDecompress App");
            
            heading = new JLabel("Compressor And Decompressor");
            heading.setBounds(150,50, 300, 50);
            
            Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Java project\\compressor_depressor\\compress.png");    
            this.setIconImage(icon);    
            
            compressButton = new JButton("Select file to Compress");
            compressButton.addActionListener(this);
            compressButton.setBounds(20, 150, 200, 30);
            
            decompressButton = new JButton("Select file to Decompress");
            decompressButton.addActionListener(this);
            decompressButton.setBounds(250, 150, 200, 30);
            
            this.add(compressButton);
            this.add(decompressButton);
            this.add(heading);
            this.setSize(500, 150);
            this.getContentPane().setBackground(Color.gray);
            this.setLayout(null); 
            this.setVisible(true);
        }
        
        @Override
        
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == compressButton)
            {
                JFileChooser filechooser = new JFileChooser();
                int response = filechooser.showSaveDialog(null);
                
                if(response == JFileChooser.APPROVE_OPTION)
                {
                    
                    File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                    try{
                        compressor.method(file);
                        JOptionPane.showMessageDialog(null, "File has been Successfully Compressed");
                    }
                    catch(Exception exce)
                    {
                        JOptionPane.showMessageDialog(null, exce.toString());
                    }
                }
            }
            if(e.getSource()==decompressButton)
            {
                JFileChooser filechooser = new JFileChooser();
                int response = filechooser.showSaveDialog(null);
                
                if(response == JFileChooser.APPROVE_OPTION)
                {
                    File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                    
                    try{
                        decompressor.method(file);
                        JOptionPane.showMessageDialog(null, "File has been Successfully Decompressed");
                    }
                    catch(Exception exce)
                    {
                        JOptionPane.showMessageDialog(null, exce.toString());
                    }
                }
            }
        }
    }
