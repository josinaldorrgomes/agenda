package br.com.agenda.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Agenda {

	private class NomeComparator implements Comparator<Contato> {

		@Override
		public int compare(Contato c1, Contato c2) {
			return c1.getNome().compareTo(c2.getNome());
		}

	}

	private static Agenda instance;
	private Map<Integer, Contato> contatos = new HashMap<Integer, Contato>();
	private NomeComparator nomeComparator = new NomeComparator();
	private int proximoId = 1;

	private Agenda() {

		Contato contato = null;
		contato = new Contato(null, "José", "1111-1111");
		salvar(contato);
		contato = new Contato(null, "Maria", "2222-2222");
		salvar(contato);
		contato = new Contato(null, "João", "3333-3333");
		salvar(contato);
		contato = new Contato(null, "Luciana", "4444-4444");
		salvar(contato);
		contato = new Contato(null, "Alberto", "5555-5555");
		salvar(contato);

	}

	public static Agenda getInstance() {
		if (instance == null) {
			instance = new Agenda();
		}
		return instance;
	}

	public Set<Contato> getContatos() {
		Set<Contato> set = new TreeSet<Contato>(nomeComparator);
		set.addAll(contatos.values());
		return set;
	}

	public void salvar(Contato contato) {
		if (contato.getId() == null) {
			contato.setId(gerarId());
		}
		contatos.put(contato.getId(), contato);
	}

	public Contato carregar(int id) {
		return contatos.get(id);
	}

	public void excluir(int id) {
		contatos.remove(id);
	}

	public int gerarId() {
		return proximoId++;
	}

}
