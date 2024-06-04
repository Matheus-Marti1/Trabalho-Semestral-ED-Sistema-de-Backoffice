package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import controller.ClienteFisicoController;
import controller.ClienteJuridicoController;

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
	private JTextField tfClienteJuridicoEmail;
	private JTextField tfClienteFisicoCelular;
	private JTextField tfCadastroProdutosNome;
	private JTextField tfCadastroProdutosValor;
	private JTextField tfCadastroProdutosCodigo;
	private JTextField textField;
	private JTextField textField_1;

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
		tabbedPane.addTab("Cliente", null, tabCliente, "Cadastrar e consultar clientes");
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

		tfClienteJuridicoEmail = new JTextField();
		tfClienteJuridicoEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteJuridicoEmail.setColumns(10);
		tfClienteJuridicoEmail.setBounds(121, 296, 367, 31);
		tabClienteJuridico.add(tfClienteJuridicoEmail);

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

		ClienteFisicoController cfCont = new ClienteFisicoController(tfClienteFisicoNome, tfClienteFisicoCpf,
				tfClienteFisicoEndereco, tfClienteFisicoNumero, tfClienteFisicoComplemento, tfClienteFisicoCep,
				tfClienteFisicoCelular, taClienteFisico);
		ClienteJuridicoController cjCont = new ClienteJuridicoController(tfClienteJuridicoNome, tfClienteJuridicoCnpj,
				tfClienteJuridicoEndereco, tfClienteJuridicoNumero, tfClienteJuridicoComplemento, tfClienteJuridicoCep,
				tfClienteJuridicoTelefone, tfClienteJuridicoEmail, taClienteJuridico);

		JPanel tabProdutos = new JPanel();
		tabbedPane.addTab("Produtos", null, tabProdutos, "Cadastrar e consultar produtos");
		tabProdutos.setLayout(null);

		JTabbedPane tabProdutosSeletor = new JTabbedPane(JTabbedPane.LEFT);
		tabProdutosSeletor.setBounds(10, 11, 855, 481);
		tabProdutos.add(tabProdutosSeletor);

		JPanel tabCadastroProdutos = new JPanel();
		tabProdutosSeletor.addTab("Cadastro", null, tabCadastroProdutos, null);
		tabCadastroProdutos.setLayout(null);

		JLabel lblCadastroProdutosNome = new JLabel("Nome");
		lblCadastroProdutosNome.setBounds(10, 14, 67, 25);
		lblCadastroProdutosNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabCadastroProdutos.add(lblCadastroProdutosNome);

		tfCadastroProdutosNome = new JTextField();
		tfCadastroProdutosNome.setBounds(121, 11, 367, 31);
		lblCadastroProdutosNome.setLabelFor(tfCadastroProdutosNome);
		tfCadastroProdutosNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCadastroProdutosNome.setColumns(10);
		tabCadastroProdutos.add(tfCadastroProdutosNome);

		JLabel lblCadastroProdutosValor = new JLabel("Valor");
		lblCadastroProdutosValor.setBounds(10, 92, 67, 25);
		lblCadastroProdutosValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabCadastroProdutos.add(lblCadastroProdutosValor);

		tfCadastroProdutosValor = new JTextField();
		tfCadastroProdutosValor.setBounds(121, 89, 367, 31);
		tfCadastroProdutosValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCadastroProdutosValor.setColumns(10);
		tabCadastroProdutos.add(tfCadastroProdutosValor);

		JLabel lblCadastroProdutosDescricao = new JLabel("Descrição");
		lblCadastroProdutosDescricao.setBounds(10, 130, 67, 25);
		lblCadastroProdutosDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabCadastroProdutos.add(lblCadastroProdutosDescricao);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(121, 131, 367, 180);
		tabCadastroProdutos.add(scrollPane_2);

		JTextArea taCadastroProdutosDescricao = new JTextArea();
		taCadastroProdutosDescricao.setLineWrap(true);
		taCadastroProdutosDescricao.setWrapStyleWord(true);
		taCadastroProdutosDescricao.setToolTipText("Insira a descrição do produto");
		taCadastroProdutosDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_2.setViewportView(taCadastroProdutosDescricao);

		JLabel lblQuantidadeEmEstoque = new JLabel("Quantidade em estoque");
		lblQuantidadeEmEstoque.setBounds(10, 358, 154, 43);
		lblQuantidadeEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabCadastroProdutos.add(lblQuantidadeEmEstoque);

		JButton btnCadastroProdutosCadastrar = new JButton("Cadastrar");
		btnCadastroProdutosCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastroProdutosCadastrar.setBounds(10, 412, 163, 53);
		tabCadastroProdutos.add(btnCadastroProdutosCadastrar);

		JLabel lblCadastroProdutosTipo = new JLabel("Tipo");
		lblCadastroProdutosTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastroProdutosTipo.setBounds(10, 322, 67, 25);
		tabCadastroProdutos.add(lblCadastroProdutosTipo);

		JSpinner spQuantidadeEmEstoque = new JSpinner();
		spQuantidadeEmEstoque.setToolTipText("Escolha a quantidade do produto que está em estoque");
		spQuantidadeEmEstoque
				.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spQuantidadeEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spQuantidadeEmEstoque.setBounds(174, 367, 101, 25);
		tabCadastroProdutos.add(spQuantidadeEmEstoque);

		JComboBox cbCadastroProdutosTipo = new JComboBox();
		cbCadastroProdutosTipo.setToolTipText("Selecione o tipo de produto");
		cbCadastroProdutosTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbCadastroProdutosTipo.setBounds(121, 322, 154, 25);
		tabCadastroProdutos.add(cbCadastroProdutosTipo);

		JLabel lblCadastroProdutosCodigo = new JLabel("Código");
		lblCadastroProdutosCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastroProdutosCodigo.setBounds(10, 53, 67, 25);
		tabCadastroProdutos.add(lblCadastroProdutosCodigo);

		tfCadastroProdutosCodigo = new JTextField();
		tfCadastroProdutosCodigo.setToolTipText("Insira o código do produto");
		tfCadastroProdutosCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCadastroProdutosCodigo.setColumns(10);
		tfCadastroProdutosCodigo.setBounds(121, 50, 367, 31);
		tabCadastroProdutos.add(tfCadastroProdutosCodigo);

		JPanel tabConsultaProdutos = new JPanel();
		tabProdutosSeletor.addTab("Consulta", null, tabConsultaProdutos, null);
		tabConsultaProdutos.setLayout(null);

		JLabel lblConsultaProdutosTipos = new JLabel("Tipo de produtos");
		lblConsultaProdutosTipos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsultaProdutosTipos.setBounds(10, 11, 121, 28);
		tabConsultaProdutos.add(lblConsultaProdutosTipos);

		JComboBox cbConsultaProdutosTipos = new JComboBox();
		cbConsultaProdutosTipos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbConsultaProdutosTipos.setBounds(141, 11, 197, 27);
		tabConsultaProdutos.add(cbConsultaProdutosTipos);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 50, 750, 415);
		tabConsultaProdutos.add(scrollPane_4);

		JList listaConsultaProdutos = new JList();
		scrollPane_4.setViewportView(listaConsultaProdutos);
		listaConsultaProdutos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listaConsultaProdutos.setModel(new AbstractListModel() {
			String[] values = new String[] {};

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		JButton btnConsultaProdutosConsultar = new JButton("Consultar");
		btnConsultaProdutosConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultaProdutosConsultar.setBounds(348, 11, 121, 28);
		tabConsultaProdutos.add(btnConsultaProdutosConsultar);

		JButton btnConsultaProdutosExcluir = new JButton("Excluir");
		btnConsultaProdutosExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultaProdutosExcluir.setBounds(639, 11, 121, 28);
		tabConsultaProdutos.add(btnConsultaProdutosExcluir);

		JPanel tabTipos = new JPanel();
		tabbedPane.addTab("Tipos", null, tabTipos, "Cadastrar e consultar tipos de produtos");
		tabTipos.setLayout(null);

		JTabbedPane tabTiposSeletor = new JTabbedPane(JTabbedPane.LEFT);
		tabTiposSeletor.setBounds(10, 11, 855, 481);
		tabTipos.add(tabTiposSeletor);

		JPanel tabCadastroTipos = new JPanel();
		tabTiposSeletor.addTab("Cadastro", null, tabCadastroTipos, null);
		tabCadastroTipos.setLayout(null);

		JLabel lblCadastroTiposNome = new JLabel("Nome");
		lblCadastroTiposNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastroTiposNome.setBounds(10, 14, 67, 25);
		tabCadastroTipos.add(lblCadastroTiposNome);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(121, 11, 367, 31);
		tabCadastroTipos.add(textField);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(122, 93, 365, 233);
		tabCadastroTipos.add(scrollPane_3);

		JTextArea taCadastroTiposDescricao = new JTextArea();
		scrollPane_3.setViewportView(taCadastroTiposDescricao);
		taCadastroTiposDescricao.setWrapStyleWord(true);
		taCadastroTiposDescricao.setToolTipText("Insira a descrição do tipo");
		taCadastroTiposDescricao.setLineWrap(true);
		taCadastroTiposDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblCadastroTiposDescricao = new JLabel("Descrição");
		lblCadastroTiposDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastroTiposDescricao.setBounds(10, 92, 67, 25);
		tabCadastroTipos.add(lblCadastroTiposDescricao);

		JButton btnCadastroTiposCadastrar = new JButton("Cadastrar");
		btnCadastroTiposCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastroTiposCadastrar.setBounds(121, 337, 163, 53);
		tabCadastroTipos.add(btnCadastroTiposCadastrar);

		JLabel lblCadastroProdutosCodigo_1 = new JLabel("Código");
		lblCadastroProdutosCodigo_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastroProdutosCodigo_1.setBounds(10, 53, 67, 25);
		tabCadastroTipos.add(lblCadastroProdutosCodigo_1);

		textField_1 = new JTextField();
		textField_1.setToolTipText("Insira o código do tipo");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(121, 50, 367, 31);
		tabCadastroTipos.add(textField_1);

		JPanel tabConsultaTipos = new JPanel();
		tabTiposSeletor.addTab("Consulta", null, tabConsultaTipos, null);
		tabConsultaTipos.setLayout(null);

		JLabel lblTipos = new JLabel("Tipos");
		lblTipos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipos.setBounds(10, 11, 67, 25);
		tabConsultaTipos.add(lblTipos);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 47, 372, 418);
		tabConsultaTipos.add(scrollPane_5);

		JList listaConsultaTipos = new JList();
		scrollPane_5.setViewportView(listaConsultaTipos);

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(392, 47, 372, 418);
		tabConsultaTipos.add(scrollPane_6);

		JList listaConsultaTiposProdutos = new JList();
		scrollPane_6.setViewportView(listaConsultaTiposProdutos);

		JLabel lblConsultaTiposProdutos = new JLabel("Produtos");
		lblConsultaTiposProdutos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsultaTiposProdutos.setBounds(392, 11, 67, 25);
		tabConsultaTipos.add(lblConsultaTiposProdutos);

		JButton btnConsultaTiposExcluir = new JButton("Excluir");
		btnConsultaTiposExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultaTiposExcluir.setBounds(282, 11, 100, 25);
		tabConsultaTipos.add(btnConsultaTiposExcluir);
		btnClienteFisicoCadastrar.addActionListener(cfCont);
		btnClienteFisicoConsultar.addActionListener(cfCont);
		btnClienteFisicoExcluir.addActionListener(cfCont);
		btnClienteJuridicoCadastrar.addActionListener(cjCont);
		btnClienteJuridicoConsultar.addActionListener(cjCont);
		btnClienteJuridicoExcluir.addActionListener(cjCont);

	}
}
