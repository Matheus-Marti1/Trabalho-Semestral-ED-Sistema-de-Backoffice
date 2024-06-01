package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import controller.ClienteFisicoController;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfClienteFisicoNome;
	private JTextField tfClienteFisicoCpf;
	private JTextField tfClienteFisicoEndereco;
	private JTextField tfClienteFisicoNumero;
	private JTextField tfClienteFisicoComplemento;
	private JTextField tfClienteFisicoCep;
	private JTextField tfClienteJuridicoNome;
	private JTextField tfClienteJuridicoCnpj;
	private JTextField tfClienteJuridicoEndereco;
	private JTextField tfClienteJuridicoNumero;
	private JTextField tfClienteJuridicoComplemento;
	private JTextField tfClienteJuridicoCep;
	private JTextField tfClienteJuridicoTelefone;
	private JTextField textField;
	private JTextField tfClienteFisicoCelular;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tela() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 916, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 880, 531);
		contentPane.add(tabbedPane);

		JPanel tabCliente = new JPanel();
		tabbedPane.addTab("Cliente", null, tabCliente, "Cadastrar Cliente");
		tabCliente.setLayout(null);

		JTabbedPane tabClienteSeletor = new JTabbedPane(JTabbedPane.LEFT);
		tabClienteSeletor.setBorder(new CompoundBorder());
		tabClienteSeletor.setBounds(10, 11, 855, 481);
		tabCliente.add(tabClienteSeletor);

		JPanel tabClienteFisico = new JPanel();
		tabClienteSeletor.addTab("Físico", null, tabClienteFisico, "Cadastrar cliente do tipo físico");
		tabClienteFisico.setLayout(null);

		JLabel lblClienteFisicoNome = new JLabel("Nome");
		lblClienteFisicoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClienteFisicoNome.setBounds(10, 14, 67, 25);
		tabClienteFisico.add(lblClienteFisicoNome);

		JLabel lblClienteFisicoCpf = new JLabel("CPF");
		lblClienteFisicoCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClienteFisicoCpf.setBounds(10, 56, 67, 25);
		tabClienteFisico.add(lblClienteFisicoCpf);

		JLabel lblClienteFisicoEndereco = new JLabel("Endereço");
		lblClienteFisicoEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClienteFisicoEndereco.setBounds(10, 98, 67, 25);
		tabClienteFisico.add(lblClienteFisicoEndereco);

		JLabel lblClienteFisicoNumero = new JLabel("Número");
		lblClienteFisicoNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClienteFisicoNumero.setBounds(10, 140, 67, 25);
		tabClienteFisico.add(lblClienteFisicoNumero);

		JLabel lblClienteFisicoComplemento = new JLabel("Complemento");
		lblClienteFisicoComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClienteFisicoComplemento.setBounds(10, 182, 112, 25);
		tabClienteFisico.add(lblClienteFisicoComplemento);

		JLabel lblClienteFisicoCep = new JLabel("CEP");
		lblClienteFisicoCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClienteFisicoCep.setBounds(10, 221, 67, 25);
		tabClienteFisico.add(lblClienteFisicoCep);
		
		JLabel lblClienteFisicoCelular = new JLabel("Celular");
		lblClienteFisicoCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClienteFisicoCelular.setBounds(10, 260, 67, 25);
		tabClienteFisico.add(lblClienteFisicoCelular);

		tfClienteFisicoNome = new JTextField();
		tfClienteFisicoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteFisicoNome.setBounds(121, 11, 367, 31);
		tabClienteFisico.add(tfClienteFisicoNome);
		tfClienteFisicoNome.setColumns(10);

		tfClienteFisicoCpf = new JTextField();
		tfClienteFisicoCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteFisicoCpf.setColumns(10);
		tfClienteFisicoCpf.setBounds(121, 53, 367, 31);
		tabClienteFisico.add(tfClienteFisicoCpf);

		tfClienteFisicoEndereco = new JTextField();
		tfClienteFisicoEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteFisicoEndereco.setColumns(10);
		tfClienteFisicoEndereco.setBounds(121, 95, 367, 31);
		tabClienteFisico.add(tfClienteFisicoEndereco);

		tfClienteFisicoNumero = new JTextField();
		tfClienteFisicoNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteFisicoNumero.setColumns(10);
		tfClienteFisicoNumero.setBounds(121, 137, 367, 31);
		tabClienteFisico.add(tfClienteFisicoNumero);

		tfClienteFisicoComplemento = new JTextField();
		tfClienteFisicoComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteFisicoComplemento.setColumns(10);
		tfClienteFisicoComplemento.setBounds(121, 179, 367, 31);
		tabClienteFisico.add(tfClienteFisicoComplemento);

		tfClienteFisicoCep = new JTextField();
		tfClienteFisicoCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteFisicoCep.setColumns(10);
		tfClienteFisicoCep.setBounds(121, 218, 367, 31);
		tabClienteFisico.add(tfClienteFisicoCep);
		
		tfClienteFisicoCelular = new JTextField();
		tfClienteFisicoCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteFisicoCelular.setColumns(10);
		tfClienteFisicoCelular.setBounds(121, 257, 367, 31);
		tabClienteFisico.add(tfClienteFisicoCelular);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 317, 759, 148);
		tabClienteFisico.add(scrollPane_1);
		
		JTextArea taClienteFisico = new JTextArea();
		scrollPane_1.setViewportView(taClienteFisico);
		taClienteFisico.setEditable(false);
		
		JButton btnClienteFisicoCadastrar = new JButton("Cadastrar");
		btnClienteFisicoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClienteFisicoCadastrar.setBounds(590, 14, 127, 42);
		tabClienteFisico.add(btnClienteFisicoCadastrar);
		
		JButton btnClienteFisicoConsultar = new JButton("Consultar");
		btnClienteFisicoConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClienteFisicoConsultar.setBounds(590, 98, 127, 42);
		tabClienteFisico.add(btnClienteFisicoConsultar);
		
		JButton btnClienteFisicoExcluir = new JButton("Excluir");
		btnClienteFisicoExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClienteFisicoExcluir.setBounds(590, 185, 127, 42);
		tabClienteFisico.add(btnClienteFisicoExcluir);

		JPanel tabClienteJuridico = new JPanel();
		tabClienteSeletor.addTab("Jurídico", null, tabClienteJuridico, "Cadastrar cliente do tipo jurídico");
		tabClienteJuridico.setLayout(null);

		JLabel lblClienteJuridicoNome = new JLabel("Nome Fantasia");
		lblClienteJuridicoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClienteJuridicoNome.setBounds(10, 14, 112, 25);
		tabClienteJuridico.add(lblClienteJuridicoNome);

		JLabel lblClienteJuridicoCnpj = new JLabel("CNPJ");
		lblClienteJuridicoCnpj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClienteJuridicoCnpj.setBounds(10, 56, 67, 25);
		tabClienteJuridico.add(lblClienteJuridicoCnpj);

		JLabel lblClienteJuridicoEndereco = new JLabel("Endereço");
		lblClienteJuridicoEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClienteJuridicoEndereco.setBounds(10, 98, 67, 25);
		tabClienteJuridico.add(lblClienteJuridicoEndereco);

		JLabel lblClienteClienteJuridicoNumero = new JLabel("Número");
		lblClienteClienteJuridicoNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClienteClienteJuridicoNumero.setBounds(10, 140, 67, 25);
		tabClienteJuridico.add(lblClienteClienteJuridicoNumero);

		JLabel lblClienteClienteJuridicoComplemento = new JLabel("Complemento");
		lblClienteClienteJuridicoComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClienteClienteJuridicoComplemento.setBounds(10, 182, 112, 25);
		tabClienteJuridico.add(lblClienteClienteJuridicoComplemento);

		JLabel lblClienteJuridicoCep = new JLabel("CEP");
		lblClienteJuridicoCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClienteJuridicoCep.setBounds(10, 221, 67, 25);
		tabClienteJuridico.add(lblClienteJuridicoCep);

		tfClienteJuridicoNome = new JTextField();
		tfClienteJuridicoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteJuridicoNome.setColumns(10);
		tfClienteJuridicoNome.setBounds(121, 11, 367, 31);
		tabClienteJuridico.add(tfClienteJuridicoNome);

		tfClienteJuridicoCnpj = new JTextField();
		tfClienteJuridicoCnpj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteJuridicoCnpj.setColumns(10);
		tfClienteJuridicoCnpj.setBounds(121, 53, 367, 31);
		tabClienteJuridico.add(tfClienteJuridicoCnpj);

		tfClienteJuridicoEndereco = new JTextField();
		tfClienteJuridicoEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteJuridicoEndereco.setColumns(10);
		tfClienteJuridicoEndereco.setBounds(121, 95, 367, 31);
		tabClienteJuridico.add(tfClienteJuridicoEndereco);

		tfClienteJuridicoNumero = new JTextField();
		tfClienteJuridicoNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteJuridicoNumero.setColumns(10);
		tfClienteJuridicoNumero.setBounds(121, 137, 367, 31);
		tabClienteJuridico.add(tfClienteJuridicoNumero);

		tfClienteJuridicoComplemento = new JTextField();
		tfClienteJuridicoComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteJuridicoComplemento.setColumns(10);
		tfClienteJuridicoComplemento.setBounds(121, 179, 367, 31);
		tabClienteJuridico.add(tfClienteJuridicoComplemento);

		tfClienteJuridicoCep = new JTextField();
		tfClienteJuridicoCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteJuridicoCep.setColumns(10);
		tfClienteJuridicoCep.setBounds(121, 218, 367, 31);
		tabClienteJuridico.add(tfClienteJuridicoCep);

		JLabel lblClienteJuridicoTelefone = new JLabel("Telefone");
		lblClienteJuridicoTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClienteJuridicoTelefone.setBounds(10, 260, 67, 25);
		tabClienteJuridico.add(lblClienteJuridicoTelefone);

		tfClienteJuridicoTelefone = new JTextField();
		tfClienteJuridicoTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteJuridicoTelefone.setColumns(10);
		tfClienteJuridicoTelefone.setBounds(121, 257, 367, 31);
		tabClienteJuridico.add(tfClienteJuridicoTelefone);

		JLabel lblClienteJuridicoEmail = new JLabel("E-mail");
		lblClienteJuridicoEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClienteJuridicoEmail.setBounds(10, 299, 67, 25);
		tabClienteJuridico.add(lblClienteJuridicoEmail);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(121, 296, 367, 31);
		tabClienteJuridico.add(textField);
		
		JButton btnClienteJuridicoCadastrar = new JButton("Cadastrar");
		btnClienteJuridicoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClienteJuridicoCadastrar.setBounds(590, 56, 127, 42);
		tabClienteJuridico.add(btnClienteJuridicoCadastrar);
		
		JButton btnClienteJuridicoConsultar = new JButton("Consultar");
		btnClienteJuridicoConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClienteJuridicoConsultar.setBounds(590, 140, 127, 42);
		tabClienteJuridico.add(btnClienteJuridicoConsultar);
		
		JButton btnClienteJuridicoExcluir = new JButton("Excluir");
		btnClienteJuridicoExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClienteJuridicoExcluir.setBounds(590, 227, 127, 42);
		tabClienteJuridico.add(btnClienteJuridicoExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 335, 759, 130);
		tabClienteJuridico.add(scrollPane);
		
		JTextArea taClienteJuridico = new JTextArea();
		scrollPane.setViewportView(taClienteJuridico);
		taClienteJuridico.setEditable(false);
		
		ClienteFisicoController cfCont = new ClienteFisicoController(tfClienteFisicoNome, tfClienteFisicoCpf, tfClienteFisicoEndereco, tfClienteFisicoNumero, tfClienteFisicoComplemento, tfClienteFisicoCep, tfClienteFisicoCelular, taClienteFisico);
		btnClienteFisicoCadastrar.addActionListener(cfCont);
		btnClienteFisicoConsultar.addActionListener(cfCont);
		btnClienteFisicoExcluir.addActionListener(cfCont);
		
		
		
	}
}
