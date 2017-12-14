package br.tatuapu.model;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Janela extends JFrame {

	public static final String APLICACAONOME = "Salario de Carreira";
	public static final String APLICACAOVERSAO = "v 0.1";
	public static final Integer APLICACAOWIDTH = 800;
	public static final Integer APLICACAOHEIGHT = 250;

	private static final long serialVersionUID = 1L;

	private JComboBox<String> boxCarreiras;
	private JComboBox<String> boxTitulacao;
	private JComboBox<String> boxHoras;
	private ArrayList<Carreira> dadosEncontrados;
	DecimalFormat formato;
	private JLabel l2017;
	private JTextField t2017;
	private JLabel l2019;
	private JTextField t2019;
	private JLabel l2020;
	private JTextField t2020;
	private JLabel lconclusao;
	private JTextPane tconclusao;
	private JLabel lAutores;
	private double teto2017 = 5531.31;
	private double teto2019 = 5531.31 * 1.032 * 1.043;
	private double teto2020 = 5531.31 * 1.032 * 1.043 * 1.042;
	private double salario2017;
	private double salario2019;
	private double salario2020;
	private List<Carreira> lista;
	private JCheckBox check;

	public Janela() throws Exception {
		super(APLICACAONOME + " - " + APLICACAOVERSAO);
		setSize(APLICACAOWIDTH, APLICACAOHEIGHT);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// Formulario
		JPanel painel = new JPanel(new BorderLayout());
		JPanel painelSuperior = new JPanel(new GridLayout(1, 1, 0, 0));
		JPanel painelInferior = new JPanel(new GridLayout(5, 1, 0, 0));

		// Criando estrutura da Tela
		JLabel lCarreiras = new JLabel("Classe/Nível:");
		painelSuperior.add(lCarreiras);

		boxCarreiras = new JComboBox<>();
		preencheComboBoxCarreiras();
		painelSuperior.add(boxCarreiras);

		JLabel lHoras = new JLabel("Horas de Trabalho:");
		painelSuperior.add(lHoras);

		boxHoras = new JComboBox<>();
		preencheComboBoxHoras();
		painelSuperior.add(boxHoras);

		JLabel lTitulacao = new JLabel("Titulação:");
		painelSuperior.add(lTitulacao);

		boxTitulacao = new JComboBox<>();
		preencheComboBoxTitulacao();
		painelSuperior.add(boxTitulacao);
		// Botoes

		JPanel p = new JPanel(new BorderLayout());

		JButton bConsultar = new JButton("CONSULTAR");
		p.add("North", bConsultar);

		painelSuperior.add(p);

		l2017 = new JLabel("2018");
		painelInferior.add(l2017);

		t2017 = new JTextField();
		t2017.setEditable(false);
		painelInferior.add(t2017);

		l2019 = new JLabel("2019");
		painelInferior.add(l2019);

		t2019 = new JTextField();
		t2019.setEditable(false);
		painelInferior.add(t2019);

		l2020 = new JLabel("2020");
		painelInferior.add(l2020);

		t2020 = new JTextField();
		t2020.setEditable(false);
		painelInferior.add(t2020);

		lconclusao = new JLabel("Conclusão");
		painelInferior.add(lconclusao);

		tconclusao = new JTextPane();
		tconclusao.setEditable(false);
		painelInferior.add(tconclusao);

		check = new JCheckBox("Ingresso após 03/2013");
		painelInferior.add(check);

		painel.add("North", painelSuperior);
		painel.add("Center", painelInferior);

		lAutores = new JLabel("Leonardo Caixeta Braga e Kaíque Matheus R. Cunha");
		painel.add("South", lAutores);

		setContentPane(painel);

		// Ações dos botões
		bConsultar.addActionListener(new ActionListener() {

			private String classe;
			private String tipo;
			private String titulacao;
			private Carreira carreira;

			public void actionPerformed(ActionEvent evt) {

				dadosEncontrados = new ArrayList<Carreira>();

				classe = boxCarreiras.getSelectedItem().toString();

				tipo = boxHoras.getSelectedItem().toString();

				titulacao = boxTitulacao.getSelectedItem().toString();

				dadosEncontrados = encontraCarreira(classe, tipo, titulacao);

				// System.out.println(dadosEncontrados.get(2).getSalario());
				formato = new DecimalFormat("R$ 0.00");

				t2017.setText((formato.format(calculo2018(salario2017 = dadosEncontrados.get(0).getSalario()))));
				t2019.setText((formato.format(calculo2019(salario2019 = dadosEncontrados.get(1).getSalario()))));
				t2020.setText((formato.format(calculo2020(salario2020 = dadosEncontrados.get(2).getSalario()))));
				tconclusao.setText(resultado(calculo2018(salario2017 = dadosEncontrados.get(0).getSalario()),
						calculo2020(salario2020 = dadosEncontrados.get(2).getSalario())));
			}

		});
	}

	public void preencheComboBoxCarreiras() {

		boxCarreiras.addItem("D I - 1");
		boxCarreiras.addItem("D I - 2");
		boxCarreiras.addItem("D II - 1");
		boxCarreiras.addItem("D II - 2");
		boxCarreiras.addItem("D III - 1");
		boxCarreiras.addItem("D III - 2");
		boxCarreiras.addItem("D III - 3");
		boxCarreiras.addItem("D III - 4");
		boxCarreiras.addItem("D IV - 1");
		boxCarreiras.addItem("D IV - 2");
		boxCarreiras.addItem("D IV - 3");
		boxCarreiras.addItem("D IV - 4");
		boxCarreiras.addItem("TITULAR  - 1");

	}

	public void preencheComboBoxHoras() {

		boxHoras.addItem("20H");
		boxHoras.addItem("40H");
		boxHoras.addItem("DE");

	}

	public void preencheComboBoxTitulacao() {

		boxTitulacao.addItem("Graduação");
		boxTitulacao.addItem("Aperfeiçoamento");
		boxTitulacao.addItem("Especialização ou Graduação + RSC I");
		boxTitulacao.addItem("Mestrado ou Especialização + RSC II");
		boxTitulacao.addItem("Doutorado ou Mestrado + RSC III");

	}

	public void setData(List<Carreira> lista) {
		this.lista = lista;
	}

	public ArrayList<Carreira> encontraCarreira(String nome, String tipo, String titulacao) {
		ArrayList<Carreira> dadosCarreira = new ArrayList<Carreira>();
		for (Carreira c : this.lista) {
			String no = c.getClasse() + " - " + c.getNivel();
			if (no.equals(nome) && c.getTipo().equals(tipo) && c.getTitulacao().equals(titulacao)) {
				dadosCarreira.add(c);
			}
		}
		return dadosCarreira;
	}

	public double calculo2018(double salario2017) {

		if (salario2017 <= teto2017) {
			return salario2017 = 0.11 * salario2017;
		} else {
			if (check.isSelected()) {
				return salario2017 = 0.11 * teto2017;
			} else {
				return salario2017 = 0.11 * 5531.31 + 0.14 * (salario2017 - teto2017);
			}
		}
	}

	public double calculo2019(double salario2019) {

		if (salario2019 <= teto2019) {
			return salario2019 = 0.11 * salario2019;
		} else {
			if(check.isSelected()) {
				return  0.11 * teto2019;
			}else {
				return salario2019 = 0.11 * 5531.31 * 1.032 * 1.043 + 0.11 * (salario2019 - teto2019);
			}
			
		}
	}

	public double calculo2020(double salario2020) {

		if (salario2020 <= teto2020) {
			return salario2020 = 0.11 * salario2020;
		} else {
			if(check.isSelected()) {
				return  0.11 * teto2020;
			}else {
			return salario2020 = 0.11 * 5531.31 * 1.032 * 1.043 * 1.042 + 0.14 * (salario2020 - teto2020);
			}
		}
	}

	public String resultado(double result2017, double result2020) {
		double result = result2020 - result2017;
		double porc = ((result2020 - result2017) / result2017) * 100;
		DecimalFormat formato = new DecimalFormat("R$ 0.000");
		DecimalFormat formatoPorcentagem = new DecimalFormat(" 0.000");
		// String con= "No ano de 2017 para 2020 obetve-se um aumento na contribuição
		// de: R$ " + result +" e " + porc +"%";
		String con = "No ano de 2017 para 2020 obetve-se um aumento na contribuição de: R$ " + formato.format(result)
				+ " e " + formatoPorcentagem.format(porc) + "%";

		return con;
	}

}
