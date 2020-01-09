/**
 * 
 */
package model;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Sladjana Savkovic
 *
 */
public class BazaPredmeta implements Serializable{
	
	private static final long serialVersionUID = 8628871629589964560L;
	
	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	//samo da ubacim neke podatke za pocetak
	private ArrayList<Predmet> predmeti;
	/*private ArrayList<String> studenti1;
	private ArrayList<String> studenti2;
	private ArrayList<String> studenti3;
	private ArrayList<String> studenti4;
	private ArrayList<String> studenti5;
	private ArrayList<String> studenti6;*/
	
	
	private BazaPredmeta() {  
		readPredmeti();
		//initPredmete();
		//writePredmeti();
	}
	/*public void initPredmete() {
		this.predmeti = new ArrayList<Predmet>();
		this.studenti1= new ArrayList<String>();
		this.studenti2= new ArrayList<String>();
		this.studenti3= new ArrayList<String>();
		this.studenti4= new ArrayList<String>();
		this.studenti5= new ArrayList<String>();
		this.studenti6= new ArrayList<String>();
		studenti1.add("RA1/2017");
		studenti1.add("RA78/2015");
		studenti1.add("RA25/2016");
		
		studenti2.add("RA1/2017");
		studenti2.add("RA78/2015");
		studenti2.add("RA25/2016");
		
		studenti3.add("RA1/2017");
		studenti3.add("RA78/2015");
		studenti3.add("RA25/2016");
		
		studenti4.add("PSI14/2017");
		studenti4.add("E3154/2015");
		studenti4.add("MEH215/2016");
		
		studenti5.add("PSI14/2017");
		studenti5.add("E3154/2015");
		studenti5.add("MEH215/2016");
		
		studenti6.add("RA44/2017");
		
		predmeti.add(new Predmet("E2123","Matematička analiza 1", "Nebojša Ralević", 1, 1, studenti1));
		predmeti.add(new Predmet("E2485", "Arhitektura računara", "Miroslav Hajduković", 2, 1, studenti2));
		predmeti.add(new Predmet("E2458", "Fizika", "Ljuba Budinski", 2, 1, studenti3));
		predmeti.add(new Predmet("E1042", "Mehanika", "Ljuba Budinski", 1, 1, studenti4));
		predmeti.add(new Predmet("MA750", "Algebra", "Nebojša Ralević", 1, 1, studenti5));
		predmeti.add(new Predmet("II802", "Operativni sistemi", "Miroslav Hajduković", 2, 2, studenti6));
		
	}*/
	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	public Predmet getPredmetIndex(int index) {
		return this.predmeti.get(index);
	}
	public int getIndexOfPredmet(String sifra) {
		for(int i=0;i<predmeti.size();i++) {
			Predmet p=predmeti.get(i);
			if (p.getSifra().equals(sifra))
				return i;
		}
		return -1;
	}
	public String getValueAt(int row, int column) {
		Predmet predmet=this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSifra();
		case 1:
			return predmet.getNaziv();
		case 2:
			return Integer.toString(predmet.getGodinaStudija());
		case 3:
			return Integer.toString(predmet.getSemestar());
		case 4:
			if(predmet.getPredmetniProfesor() != null)
				return "\""+predmet.getPredmetniProfesor().getBrLicneKarte()+"\", "
					+predmet.getPredmetniProfesor().getIme()+" "+predmet.getPredmetniProfesor().getPrezime(); //izmjena
			else
				return null;
		case 5:
			return Integer.toString(predmet.getBrojStudenata());
		default:
			return null;
		}
	}
	
	public void writePredmeti(){
		try {
			ObjectOutputStream out = new ObjectOutputStream((new FileOutputStream("data_files/predmeti.dat")));
			out.writeObject(predmeti);
		    out.close();
		} catch (IOException e) {
		      e.printStackTrace();
	    }
	}
	@SuppressWarnings("unchecked")
	public void readPredmeti(){
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("data_files/predmeti.dat"));
			predmeti = (ArrayList<Predmet>) in.readObject();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
	}
	public void obrisiPredmet(String sifPredmeta) {
		for (Predmet p : predmeti) {
			if (p.getSifra().equals(sifPredmeta)) {
				predmeti.remove(p);
				break;
			}
		}
	}
	public boolean dodajPredmet(Predmet p) {
		for(Predmet pr : predmeti) {
			if(!(pr.getSifra().equals(p.getSifra()))) {
				predmeti.add(p);
				return true;
			}
			break;
		}
		return false;
	}

	@Override
	public String toString() {
		return "BazaPredmeta [predmeti=" + predmeti + "]";
	}
	
	public Predmet getPredmet(String sifraPredmeta) {
		for(Predmet p : predmeti) {
			if(p.getSifra().equals(sifraPredmeta)) {
				return p;
			}
		}
		return null;
	}
	
	public void obrisiStudenta(String sifraPredmeta,int indeksStudentaListe) {
		Predmet p = getPredmet(sifraPredmeta);
		if(p != null) {
			p.getSpisakStudenata().remove(indeksStudentaListe);
		}else {
			return;
		}
	}
	public ArrayList<String> spisakStudenataNaPredmetu(int index){
		ArrayList<String> spisakStudenata = getPredmetIndex(index).getSpisakStudenata();
		return spisakStudenata;
	}
	public void izmjeniPredmet(Predmet predmet, Predmet t) {
		for(Predmet p : predmeti) {
			
			if(predmet.getSifra().equals(p.getSifra())) {
				if(!(t.getSifra().equals(p.getSifra()))) {
					p.setSifra(t.getSifra());
				}
				p.setNaziv(t.getNaziv());
				p.setPredmetniProfesor(t.getPredmetniProfesor());
				p.setSemestar(t.getSemestar());
				p.setGodinaStudija(t.getGodinaStudija());
			}
		}
	}
	public void profesorNaPredmet(String licnaKarta,int index) {
		Predmet predmet = getPredmetIndex(index);
		Profesor profesor = BazaProfesora.getInstance().getProfesor(licnaKarta);
		
		//Pronalazim broj licne karte profesora koji je nekad predavao predmet, ako takav postoji
		String stariProfesor="";
		/*for(int i=0;i<BazaProfesora.getInstance().getProfesori().size();i++)
			if(predmet.getPredmetniProfesor().contains(BazaProfesora.getInstance().getProfesori().get(i).getIme()) && 
			   predmet.getPredmetniProfesor().contains(BazaProfesora.getInstance().getProfesori().get(i).getPrezime()))
			   		stariProfesor =  BazaProfesora.getInstance().getProfesori().get(i).getBrLicneKarte();*/ //NIJE DOBRO
		
		for(int i=0;i<BazaProfesora.getInstance().getProfesori().size();i++)
			for(int j=0; j<BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().size(); j++) {
				if(BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().get(j).equals(predmet.getSifra())) {
					stariProfesor = BazaProfesora.getInstance().getProfesori().get(i).getBrLicneKarte();
					break;
				}
			}
						
		//Ako smo nasli profesora, brisem iz njegove liste predmeta, onaj predmet koji je nekad predavao
		if(!stariProfesor.equals("")) {
			for(int i=0;i<BazaProfesora.getInstance().getProfesor(stariProfesor).getSpisakPredmeta().size();i++)
				if(BazaProfesora.getInstance().getProfesor(stariProfesor).getSpisakPredmeta().get(i).equals(predmet.getSifra())) {
					BazaProfesora.getInstance().getProfesor(stariProfesor).getSpisakPredmeta().remove(i);
					break;
				}
		}
		
		predmet.setPredmetniProfesor(profesor);
		
		//Novom profesoru dodajem predmet u listu njegovih predmeta
		BazaProfesora.getInstance().getProfesor(licnaKarta).getSpisakPredmeta().add(predmet.getSifra());
	}
}
