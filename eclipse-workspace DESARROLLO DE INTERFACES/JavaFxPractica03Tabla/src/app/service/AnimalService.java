package app.service;

import java.util.ArrayList;
import java.util.List;

import app.exception.AnimalesNotFoundException;
import app.modelo.Animal;

public class AnimalService {

private static List<Animal> animales;
	
	static {
		animales  = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			Animal a = new Animal("gato", "blas " + i, + 3+i);
			animales.add(a);
		}
		for (int i = 1; i <= 3; i++) {
			Animal a = new Animal("perro", "blas " + i, + 3+i);
			animales.add(a);
		}
		for (int i = 1; i <= 3; i++) {
			Animal a = new Animal("loro", "blas " + i, + 3+i);
			animales.add(a);
		}
	}
	
	public List<Animal> consultarAnimales(String tipo) throws AnimalesNotFoundException{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (tipo != null && tipo.isEmpty()) {
			return animales;
		}
		List<Animal> filtrados = new ArrayList<>();
		for (Animal animal : animales) {
			if (animal.getTipo().equalsIgnoreCase(tipo)) {
				filtrados.add(animal);
			}
		}
		if (filtrados.isEmpty()) {
			throw new AnimalesNotFoundException();
		}
		return filtrados;
	}
	public void addAnimal(Animal a) {
		animales.add(a);
	}
}
