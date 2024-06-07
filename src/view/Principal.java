package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfLoginClienteNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Sistema Backoffice");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 357, 134);
		contentPane.add(tabbedPane);

		JPanel tabFuncionario = new JPanel();
		tabbedPane.addTab("Funcionário", null, tabFuncionario, "Entrar no sistema se você é funcionário");
		tabFuncionario.setLayout(null);

		JButton btnFuncionarioEntrar = new JButton("Abrir");
		btnFuncionarioEntrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnFuncionarioEntrar.setBounds(111, 23, 135, 55);
		tabFuncionario.add(btnFuncionarioEntrar);

		JPanel tabCliente = new JPanel();
		tabbedPane.addTab("Cliente", null, tabCliente, null);
		tabCliente.setLayout(null);

		JLabel lblLoginNomeCliente = new JLabel("Nome");
		lblLoginNomeCliente.setBounds(7, 10, 37, 20);
		lblLoginNomeCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tabCliente.add(lblLoginNomeCliente);

		tfLoginClienteNome = new JTextField();
		tfLoginClienteNome.setBounds(51, 7, 300, 26);
		tfLoginClienteNome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tabCliente.add(tfLoginClienteNome);
		tfLoginClienteNome.setColumns(10);

		JButton btnLoginCliente = new JButton("Entrar");
		btnLoginCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeCliente = tfLoginClienteNome.getText();
				TelaCliente telaCliente = new TelaCliente(Principal.this, nomeCliente);
				telaCliente.setVisible(true);
				setVisible(false);
			}
		});
		btnLoginCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLoginCliente.setBounds(113, 45, 131, 50);
		tabCliente.add(btnLoginCliente);
		btnFuncionarioEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFuncionario telaFun = new TelaFuncionario(Principal.this);
				telaFun.setVisible(true);
				setVisible(false);
			}
		});
	}
}
