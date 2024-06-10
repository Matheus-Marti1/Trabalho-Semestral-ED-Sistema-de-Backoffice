package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.TelaCliente;

public class ClienteController implements ActionListener {

    private JFrame frame;
	private JTextField tfLoginClienteNome;
	
    public ClienteController(JFrame frame, JTextField tfLoginClienteNome) {
	   	 this.frame = frame;
	     this.tfLoginClienteNome = tfLoginClienteNome;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Entrar")) {
	        try {
	        	validarCliente(tfLoginClienteNome.getText());
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
        }
    }
    
    private void validarCliente(String nomeCliente) throws IOException {
        if (buscarNomeCliente(nomeCliente, "clienteFisico.csv") || buscarNomeCliente(nomeCliente, "clienteJuridico.csv")) { 
            TelaCliente telaCliente = new TelaCliente(frame, nomeCliente);
            telaCliente.setVisible(true);
            frame.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
        }
    }
    
    private boolean buscarNomeCliente(String nomeCliente, String arquivo) throws IOException {
        try {
            String currentDirectory = new File(".").getCanonicalPath();
            String path = currentDirectory + File.separator + "SistemaBackoffice";
            File file = new File(path, arquivo);
            if (file.exists() && file.isFile()) {
                BufferedReader buffer = new BufferedReader(new FileReader(file));
                String line;
                while ((line = buffer.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts.length > 1 && parts[1].equals(nomeCliente)) {
                        buffer.close();
                        return true;
                    }
                }
                buffer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}