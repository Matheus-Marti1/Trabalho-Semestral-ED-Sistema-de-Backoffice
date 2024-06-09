package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JComboBox;


public class ClienteProdutosController implements ActionListener {
	private JComboBox<Object> cbTiposProdutosCompra;

	public ClienteProdutosController(JComboBox<Object> cbTiposProdutosCompra) {
		this.cbTiposProdutosCompra = cbTiposProdutosCompra;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	String cmd = e.getActionCommand();
		if (cmd.equals("Carregar categorias")) {
			try {
				carregarComboBoxCategorias();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	private void carregarComboBoxCategorias() throws IOException {
		String currentDirectory = new File(".").getCanonicalPath();
		String path = currentDirectory + File.separator + "SistemaBackoffice";
		File file = new File(path, "tipoProduto.csv");
		if (file.exists() && file.isFile()) {
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String line = buffer.readLine();
			cbTiposProdutosCompra.removeAllItems();
			while (line != null) {
				String[] vetLine = line.split(";");
				cbTiposProdutosCompra.addItem(vetLine[1]);
				line = buffer.readLine();
			}
			buffer.close();
		}
	}
	
	}

