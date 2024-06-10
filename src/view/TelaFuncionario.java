package view;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DropMode;
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
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import controller.ClienteFisicoController;
import controller.ClienteJuridicoController;
import controller.ProdutoController;
import controller.TipoProdutoController;
import controller.CheckOutController;

public class TelaFuncionario extends JFrame {

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
	private JTextField tfProdutosCadastroNome;
	private JTextField tfProdutosCadastroValor;
	private JTextField tfProdutosCadastroCodigo;
	private JTextField tfTiposCadastroNome;
	private JTextField tfTiposCadastroCodigo;
	private JTextField textFieldIdCompra;

	public TelaFuncionario(JFrame parentFrame) {
		setTitle("Sistema Backoffice");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 916, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				parentFrame.setVisible(true);
				dispose();
			}
		});

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 880, 531);
		contentPane.add(tabbedPane);

		JPanel tabCliente = new JPanel();
		tabbedPane.addTab("Clientes", null, tabCliente, "Cadastrar e consultar clientes");
		tabCliente.setLayout(null);

		JTabbedPane tabClienteSeletor = new JTabbedPane(JTabbedPane.LEFT);
		tabClienteSeletor.setBounds(12, 12, 851, 479);
		tabClienteSeletor.setBorder(new CompoundBorder());
		tabCliente.add(tabClienteSeletor);

		JPanel tabClienteFisico = new JPanel();
		tabClienteSeletor.addTab("Físico", null, tabClienteFisico, "Cadastrar cliente do tipo físico");
		tabClienteFisico.setLayout(null);

		JLabel lblClienteFisicoNome = new JLabel("Nome");
		lblClienteFisicoNome.setBounds(10, 14, 67, 25);
		lblClienteFisicoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabClienteFisico.add(lblClienteFisicoNome);

		JLabel lblClienteFisicoCpf = new JLabel("CPF");
		lblClienteFisicoCpf.setBounds(10, 56, 67, 25);
		lblClienteFisicoCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabClienteFisico.add(lblClienteFisicoCpf);

		JLabel lblClienteFisicoEndereco = new JLabel("Endereço");
		lblClienteFisicoEndereco.setBounds(10, 98, 67, 25);
		lblClienteFisicoEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabClienteFisico.add(lblClienteFisicoEndereco);

		JLabel lblClienteFisicoNumero = new JLabel("Número");
		lblClienteFisicoNumero.setBounds(10, 140, 67, 25);
		lblClienteFisicoNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabClienteFisico.add(lblClienteFisicoNumero);

		JLabel lblClienteFisicoComplemento = new JLabel("Complemento");
		lblClienteFisicoComplemento.setBounds(10, 182, 112, 25);
		lblClienteFisicoComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabClienteFisico.add(lblClienteFisicoComplemento);

		JLabel lblClienteFisicoCep = new JLabel("CEP");
		lblClienteFisicoCep.setBounds(10, 221, 67, 25);
		lblClienteFisicoCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabClienteFisico.add(lblClienteFisicoCep);

		JLabel lblClienteFisicoCelular = new JLabel("Celular");
		lblClienteFisicoCelular.setBounds(10, 260, 67, 25);
		lblClienteFisicoCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabClienteFisico.add(lblClienteFisicoCelular);

		tfClienteFisicoNome = new JTextField();
		tfClienteFisicoNome.setBounds(121, 11, 367, 31);
		tfClienteFisicoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabClienteFisico.add(tfClienteFisicoNome);
		tfClienteFisicoNome.setColumns(10);

		tfClienteFisicoCpf = new JTextField();
		tfClienteFisicoCpf.setBounds(121, 53, 367, 31);
		tfClienteFisicoCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteFisicoCpf.setColumns(10);
		tabClienteFisico.add(tfClienteFisicoCpf);

		tfClienteFisicoEndereco = new JTextField();
		tfClienteFisicoEndereco.setBounds(121, 95, 367, 31);
		tfClienteFisicoEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteFisicoEndereco.setColumns(10);
		tabClienteFisico.add(tfClienteFisicoEndereco);

		tfClienteFisicoNumero = new JTextField();
		tfClienteFisicoNumero.setBounds(121, 137, 367, 31);
		tfClienteFisicoNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteFisicoNumero.setColumns(10);
		tabClienteFisico.add(tfClienteFisicoNumero);

		tfClienteFisicoComplemento = new JTextField();
		tfClienteFisicoComplemento.setBounds(121, 179, 367, 31);
		tfClienteFisicoComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteFisicoComplemento.setColumns(10);
		tabClienteFisico.add(tfClienteFisicoComplemento);

		tfClienteFisicoCep = new JTextField();
		tfClienteFisicoCep.setBounds(121, 218, 367, 31);
		tfClienteFisicoCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteFisicoCep.setColumns(10);
		tabClienteFisico.add(tfClienteFisicoCep);

		tfClienteFisicoCelular = new JTextField();
		tfClienteFisicoCelular.setBounds(121, 257, 367, 31);
		tfClienteFisicoCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfClienteFisicoCelular.setColumns(10);
		tabClienteFisico.add(tfClienteFisicoCelular);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 317, 759, 148);
		tabClienteFisico.add(scrollPane_1);

		JTextArea taClienteFisico = new JTextArea();
		scrollPane_1.setViewportView(taClienteFisico);
		taClienteFisico.setEditable(false);

		JButton btnClienteFisicoCadastrar = new JButton("Cadastrar");
		btnClienteFisicoCadastrar.setBounds(590, 14, 127, 42);
		btnClienteFisicoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabClienteFisico.add(btnClienteFisicoCadastrar);

		JButton btnClienteFisicoConsultar = new JButton("Consultar");
		btnClienteFisicoConsultar.setBounds(590, 98, 127, 42);
		btnClienteFisicoConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabClienteFisico.add(btnClienteFisicoConsultar);

		JButton btnClienteFisicoExcluir = new JButton("Excluir");
		btnClienteFisicoExcluir.setBounds(590, 185, 127, 42);
		btnClienteFisicoExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
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

		btnClienteFisicoCadastrar.addActionListener(cfCont);
		btnClienteFisicoConsultar.addActionListener(cfCont);
		btnClienteFisicoExcluir.addActionListener(cfCont);
		btnClienteJuridicoCadastrar.addActionListener(cjCont);
		btnClienteJuridicoConsultar.addActionListener(cjCont);
		btnClienteJuridicoExcluir.addActionListener(cjCont);
		
		JPanel tabVendas = new JPanel();
		tabbedPane.addTab("Vendas", null, tabVendas, "Consultar histórico de compras dos clientes");
		tabVendas.setLayout(null);
		
		JPanel tabVendasClientes = new JPanel();
		tabVendasClientes.setLayout(null);
		tabVendasClientes.setBounds(51, 18, 794, 474);
		tabVendas.add(tabVendasClientes);
		
		JLabel lblIdCompra = new JLabel("ID da Compra");
		lblIdCompra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdCompra.setBounds(79, 56, 88, 25);
		tabVendasClientes.add(lblIdCompra);
		
		textFieldIdCompra = new JTextField();
		textFieldIdCompra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldIdCompra.setColumns(10);
		textFieldIdCompra.setBounds(177, 53, 367, 31);
		tabVendasClientes.add(textFieldIdCompra);
		
		JButton btnVendaConsultar = new JButton("Consultar");
		btnVendaConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVendaConsultar.setBounds(569, 47, 127, 42);
		tabVendasClientes.add(btnVendaConsultar);
		JScrollPane scrollPaneVendasCliente = new JScrollPane();
			
		scrollPaneVendasCliente.setBounds(10, 121, 774, 342);
		tabVendasClientes.add(scrollPaneVendasCliente);
		
		JList<Object> listaVendasCliente = new JList<Object>();
		scrollPaneVendasCliente.setViewportView(listaVendasCliente);
		listaVendasCliente.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		
		CheckOutController checkOutCont = new CheckOutController(null, null, null, null, textFieldIdCompra, listaVendasCliente);
		btnVendaConsultar.addActionListener(checkOutCont);

				JPanel tabProdutos = new JPanel();
		tabbedPane.addTab("Produtos", null, tabProdutos, "Cadastrar e consultar produtos");
		tabProdutos.setLayout(null);

		JTabbedPane tabProdutosSeletor = new JTabbedPane(JTabbedPane.LEFT);
		tabProdutosSeletor.setBounds(10, 11, 855, 481);
		tabProdutos.add(tabProdutosSeletor);

		JPanel tabProdutosCadastro = new JPanel();
		tabProdutosSeletor.addTab("Cadastro", null, tabProdutosCadastro, "Cadastro de produtos");
		tabProdutosCadastro.setLayout(null);

		JLabel lblProdutosCadastroNome = new JLabel("Nome");
		lblProdutosCadastroNome.setBounds(10, 11, 67, 25);
		lblProdutosCadastroNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabProdutosCadastro.add(lblProdutosCadastroNome);

		JLabel lblProdutosCadastroValor = new JLabel("Valor");
		lblProdutosCadastroValor.setBounds(10, 85, 67, 25);
		lblProdutosCadastroValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabProdutosCadastro.add(lblProdutosCadastroValor);

		JLabel lblProdutosCadastroDescricao = new JLabel("Descrição");
		lblProdutosCadastroDescricao.setBounds(10, 122, 93, 25);
		lblProdutosCadastroDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabProdutosCadastro.add(lblProdutosCadastroDescricao);

		tfProdutosCadastroNome = new JTextField();
		tfProdutosCadastroNome.setDropMode(DropMode.INSERT);
		tfProdutosCadastroNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfProdutosCadastroNome.setBounds(121, 8, 367, 31);
		tabProdutosCadastro.add(tfProdutosCadastroNome);
		tfProdutosCadastroNome.setColumns(10);

		tfProdutosCadastroValor = new JTextField();
		tfProdutosCadastroValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfProdutosCadastroValor.setDropMode(DropMode.INSERT);
		tfProdutosCadastroValor.setBounds(121, 82, 367, 31);
		tabProdutosCadastro.add(tfProdutosCadastroValor);
		tfProdutosCadastroValor.setColumns(10);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(121, 123, 367, 180);
		tabProdutosCadastro.add(scrollPane_2);

		JTextArea taProdutosCadastroDescricao = new JTextArea();
		taProdutosCadastroDescricao.setDropMode(DropMode.INSERT);
		scrollPane_2.setViewportView(taProdutosCadastroDescricao);
		taProdutosCadastroDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		taProdutosCadastroDescricao.setWrapStyleWord(true);
		taProdutosCadastroDescricao.setLineWrap(true);

		JLabel lblProdutosCadastroTipo = new JLabel("Tipo");
		lblProdutosCadastroTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProdutosCadastroTipo.setBounds(10, 315, 67, 25);
		tabProdutosCadastro.add(lblProdutosCadastroTipo);

		JComboBox<Object> cbProdutosCadastroTipo = new JComboBox<Object>();
		
		JButton btnProdutosCadastroCarregarCB = new JButton("Recarregar");
		btnProdutosCadastroCarregarCB.setBounds(327, 315, 93, 25);
		tabProdutosCadastro.add(btnProdutosCadastroCarregarCB);

		cbProdutosCadastroTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbProdutosCadastroTipo.setToolTipText("Selecione o tipo do produto");
		cbProdutosCadastroTipo.setBounds(121, 315, 194, 25);
		tabProdutosCadastro.add(cbProdutosCadastroTipo);

		JLabel lblProdutosCadastroQtd = new JLabel("Quantidade em estoque");
		lblProdutosCadastroQtd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProdutosCadastroQtd.setBounds(10, 352, 185, 25);
		tabProdutosCadastro.add(lblProdutosCadastroQtd);

		JSpinner spProdutosCadastroQtd = new JSpinner();
		spProdutosCadastroQtd
				.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spProdutosCadastroQtd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spProdutosCadastroQtd.setBounds(198, 353, 117, 24);
		tabProdutosCadastro.add(spProdutosCadastroQtd);

		JButton btnProdutosCadastroCadastrar = new JButton("Cadastrar produto");
		btnProdutosCadastroCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProdutosCadastroCadastrar.setBounds(12, 400, 163, 64);
		tabProdutosCadastro.add(btnProdutosCadastroCadastrar);

		JLabel lblProdutosCadastroCodigo = new JLabel("Código");
		lblProdutosCadastroCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProdutosCadastroCodigo.setBounds(10, 48, 67, 25);
		tabProdutosCadastro.add(lblProdutosCadastroCodigo);

		tfProdutosCadastroCodigo = new JTextField();
		tfProdutosCadastroCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfProdutosCadastroCodigo.setBounds(121, 45, 367, 31);
		tabProdutosCadastro.add(tfProdutosCadastroCodigo);
		tfProdutosCadastroCodigo.setColumns(10);

		JPanel tabProdutosConsulta = new JPanel();
		tabProdutosSeletor.addTab("Consulta", null, tabProdutosConsulta, null);
		tabProdutosConsulta.setLayout(null);

		JLabel lblProdutosConsultaTipo = new JLabel("Tipo de produtos");
		lblProdutosConsultaTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProdutosConsultaTipo.setBounds(10, 11, 123, 25);
		tabProdutosConsulta.add(lblProdutosConsultaTipo);

		JComboBox<Object> cbProdutosConsultaTipo = new JComboBox<Object>();
		cbProdutosConsultaTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbProdutosConsultaTipo.setBounds(143, 13, 123, 25);
		tabProdutosConsulta.add(cbProdutosConsultaTipo);

		JButton btnProdutosConsultaConsultar = new JButton("Consultar produtos");
		btnProdutosConsultaConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProdutosConsultaConsultar.setBounds(276, 12, 223, 27);
		tabProdutosConsulta.add(btnProdutosConsultaConsultar);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 50, 757, 415);
		tabProdutosConsulta.add(scrollPane_3);

		JList<Object> listaProdutosConsulta = new JList<Object>();
		listaProdutosConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_3.setViewportView(listaProdutosConsulta);
		listaProdutosConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnConsultaProdutosExcluir = new JButton("Excluir produto selecionado");
		btnConsultaProdutosExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultaProdutosExcluir.setBounds(544, 12, 223, 27);
		tabProdutosConsulta.add(btnConsultaProdutosExcluir);

		ProdutoController prodCont = new ProdutoController(tfProdutosCadastroNome, tfProdutosCadastroValor,
				taProdutosCadastroDescricao, cbProdutosCadastroTipo, spProdutosCadastroQtd, tfProdutosCadastroCodigo, cbProdutosConsultaTipo, listaProdutosConsulta);
		btnProdutosCadastroCadastrar.addActionListener(prodCont);
		btnProdutosConsultaConsultar.addActionListener(prodCont);
		btnConsultaProdutosExcluir.addActionListener(prodCont);
		btnProdutosCadastroCarregarCB.addActionListener(prodCont);

		JPanel tabTipos = new JPanel();
		tabbedPane.addTab("Tipos", null, tabTipos, null);
		tabTipos.setLayout(null);

		JTabbedPane tabTiposSeletor = new JTabbedPane(JTabbedPane.LEFT);
		tabTiposSeletor.setBounds(6, 6, 868, 486);
		tabTipos.add(tabTiposSeletor);

		JPanel tabTiposCadastro = new JPanel();
		tabTiposSeletor.addTab("Cadastro", null, tabTiposCadastro, null);
		tabTiposCadastro.setLayout(null);

		JLabel lblTiposCadastroNome = new JLabel("Nome");
		lblTiposCadastroNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTiposCadastroNome.setBounds(10, 11, 67, 25);
		tabTiposCadastro.add(lblTiposCadastroNome);

		JLabel lblTiposCadastroCodigo = new JLabel("Código");
		lblTiposCadastroCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTiposCadastroCodigo.setToolTipText("Insira o código do tipo de produto");
		lblTiposCadastroCodigo.setBounds(10, 48, 67, 25);
		tabTiposCadastro.add(lblTiposCadastroCodigo);

		tfTiposCadastroNome = new JTextField();
		tfTiposCadastroNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTiposCadastroNome.setBounds(89, 11, 352, 25);
		tabTiposCadastro.add(tfTiposCadastroNome);
		tfTiposCadastroNome.setColumns(10);

		tfTiposCadastroCodigo = new JTextField();
		tfTiposCadastroCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTiposCadastroCodigo.setBounds(89, 50, 352, 25);
		tabTiposCadastro.add(tfTiposCadastroCodigo);
		tfTiposCadastroCodigo.setColumns(10);

		JLabel lblTiposCadastroDescricao = new JLabel("Descrição");
		lblTiposCadastroDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTiposCadastroDescricao.setBounds(10, 85, 116, 25);
		tabTiposCadastro.add(lblTiposCadastroDescricao);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(89, 87, 352, 180);
		tabTiposCadastro.add(scrollPane_4);

		JTextArea taTiposCadastroDescricao = new JTextArea();
		scrollPane_4.setViewportView(taTiposCadastroDescricao);
		taTiposCadastroDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		taTiposCadastroDescricao.setWrapStyleWord(true);
		taTiposCadastroDescricao.setLineWrap(true);

		JButton btnTiposCadastroCadastrarTipo = new JButton("Cadastrar Tipo");
		btnTiposCadastroCadastrarTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTiposCadastroCadastrarTipo.setBounds(89, 279, 131, 43);
		tabTiposCadastro.add(btnTiposCadastroCadastrarTipo);

		JPanel tabTiposConsulta = new JPanel();
		tabTiposSeletor.addTab("Consulta", null, tabTiposConsulta, null);
		tabTiposConsulta.setLayout(null);

		JLabel lblTiposConsultaTipos = new JLabel("Tipos");
		lblTiposConsultaTipos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTiposConsultaTipos.setBounds(16, 6, 76, 27);
		tabTiposConsulta.add(lblTiposConsultaTipos);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(16, 45, 359, 421);
		tabTiposConsulta.add(scrollPane_5);

		JList<Object> listaTiposConsultaTipos = new JList<Object>();
		listaTiposConsultaTipos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_5.setViewportView(listaTiposConsultaTipos);
		listaTiposConsultaTipos.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(414, 47, 359, 421);
		tabTiposConsulta.add(scrollPane_6);

		JList<Object> listaTiposConsultaProdutos = new JList<Object>();
		listaTiposConsultaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_6.setViewportView(listaTiposConsultaProdutos);
		listaTiposConsultaProdutos.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblTiposConsultaProdutos = new JLabel("Produtos");
		lblTiposConsultaProdutos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTiposConsultaProdutos.setBounds(414, 6, 76, 27);
		tabTiposConsulta.add(lblTiposConsultaProdutos);

		JButton btnTiposConsultaExcluirTipo = new JButton("Excluir tipo selecionado");
		btnTiposConsultaExcluirTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTiposConsultaExcluirTipo.setBounds(194, 6, 181, 27);
		tabTiposConsulta.add(btnTiposConsultaExcluirTipo);

		
		TipoProdutoController tPCont = new TipoProdutoController(tfTiposCadastroCodigo, tfTiposCadastroNome,
				taTiposCadastroDescricao, listaTiposConsultaTipos, listaTiposConsultaProdutos);
		
		JButton btnTiposConsultaRecarregar = new JButton("Recarregar lista");
		btnTiposConsultaRecarregar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTiposConsultaRecarregar.setBounds(59, 6, 123, 27);
		tabTiposConsulta.add(btnTiposConsultaRecarregar);
		btnTiposCadastroCadastrarTipo.addActionListener(tPCont);
		btnTiposConsultaExcluirTipo.addActionListener(tPCont);
		btnTiposConsultaRecarregar.addActionListener(tPCont);
	}
}