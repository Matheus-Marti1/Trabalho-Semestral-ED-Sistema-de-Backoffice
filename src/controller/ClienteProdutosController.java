package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;

public class ClienteProdutosController implements ActionListener {

    private JComboBox<Object> cbCategoriaProdutosCliente;
    private JList<Object> listaProdutosCliente;

    public ClienteProdutosController(JComboBox<Object> cbCategoriaProdutosCliente, JList<Object> listaProdutosCliente) {
        this.cbCategoriaProdutosCliente = cbCategoriaProdutosCliente;
        this.listaProdutosCliente = listaProdutosCliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Carregar produtos")) {
            try {
                montarTabelaProdutos();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
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
			cbCategoriaProdutosCliente.removeAllItems();
			while (line != null) {
				String[] vetLine = line.split(";");
				cbCategoriaProdutosCliente.addItem(vetLine[1]);
				line = buffer.readLine();
			}
			buffer.close();
		}
	}
    
    private String buscaIdCategoria(String cbCategoria) throws IOException {
        String currentDirectory = new File(".").getCanonicalPath();
        String path = currentDirectory + File.separator + "SistemaBackoffice";
        File file = new File(path, "tipoProduto.csv");
        if (file.exists() && file.isFile()) {
            try (FileInputStream fis = new FileInputStream(file);
                 InputStreamReader isr = new InputStreamReader(fis);
                 BufferedReader buffer = new BufferedReader(isr)) {
	                String line = buffer.readLine();
	                while (line != null) {
	                    String[] vetLine = line.split(";");
	                    if (vetLine[1].equals(cbCategoria)) {
	                        return vetLine[0];
	                    }
	                    line = buffer.readLine();
	                }
            }
        }
        return null;
    }

    private void montarTabelaProdutos() throws IOException {
        String currentDirectory = new File(".").getCanonicalPath();
        String path = currentDirectory + File.separator + "SistemaBackoffice";
        File file = new File(path, "produto.csv");
        Object selectedItem = cbCategoriaProdutosCliente.getSelectedItem();
        String codCategoria = buscaIdCategoria(selectedItem.toString());
        if (codCategoria == null) {
            System.out.println("Tipo de produto não encontrado.");
            return;
        }
        if (file.exists() && file.isFile()) {
            try (FileInputStream fis = new FileInputStream(file);
                 InputStreamReader isr = new InputStreamReader(fis);
                 BufferedReader buffer = new BufferedReader(isr)) {
	                String line = buffer.readLine();
	                DefaultListModel<Object> prodsConsultadosListModel = new DefaultListModel<>();
	                while (line != null) {
	                    String[] vetLine = line.split(";");
	                    if (vetLine[5].equals(codCategoria)) {
	                        prodsConsultadosListModel.addElement("Id: " + vetLine[0] + "; Produto: " + vetLine[1] + "; Valor: R$"
	                                + vetLine[2] + "; Descrição: " + vetLine[3] + "; Quantidade em estoque: " + vetLine[4]);
	                    }
	                    line = buffer.readLine();
	                }
	                listaProdutosCliente.setModel(prodsConsultadosListModel);
            }
        }
    }
}
