package br.com.eniac.eniac.modulos;

import br.com.eniac.eniac.modulos.tratamentos.DiabetesObservacoes;

public class TesteAcompanhamento {
	public static void main(String[] args) {
		//Cadastra um usuario
		Usuario anna = new Usuario("Anna Mikaelly","1234");
		// Aqui cadastramos uma enfermidade
		Enfermidade diabetes = new Enfermidade(new DiabetesObservacoes(false, 201));
		//Aqui abrimos um acompanhamento da engermidade, para isso passamos um usuario e uma enfermidade
		Acompanhamento acompanhamento = new Acompanhamento(anna, diabetes);
		System.out.print(
				"Paciente: "+ acompanhamento.getPaciente().getNome()+ "\n"+
				"Enfermidade: "+ acompanhamento.getEnfermidade().getNome()+ "\n"+
				"Status: "+ acompanhamento.getStatus()+ "\n"
				);
	}

}
