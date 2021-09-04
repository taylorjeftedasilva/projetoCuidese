package br.com.eniac.eniac.userCase;

import java.util.List;
import java.util.stream.Collectors;


public class Enfermidade {

	public static DiabetesObservacoes getStatus(Lancamentos lancamento) {
		if(lancamento == null){ return null;}
		return new DiabetesObservacoes(lancamento.getJejum(), lancamento.getDado());
	}

	public static List<DiabetesObservacoes> getStatus(List<Lancamentos> lancamentos){
		if(lancamentos.isEmpty()){ return null; }
		lancamentos.sort((obj, obj1) -> {
			if (obj.getData().after(obj1.getData())){
				return 1;
			}
			if(obj.getData().before(obj1.getData())){
				return -1;
			}
			return 0;
		});
		return lancamentos.stream().map(lan -> new DiabetesObservacoes(lan.getJejum(), lan.getDado()))
				.collect(Collectors.toList());
	}
}
