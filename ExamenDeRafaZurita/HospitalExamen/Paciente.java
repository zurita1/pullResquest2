package HospitalExamen;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Paciente {

	private String nombre;
	private Sexo sexo;
	private Cama cama;
	private int habitacion;
	private static Pattern patron = Pattern.compile("[\\s\\w]*");
	private int ID;

	Paciente(String nombre, Sexo sexo, int habitacion, Cama cama)
			throws CamaNoExisteExeption, SexoNoExisteExeption, FormatoNoValidoexception {
		setNombre(nombre);
		setSexo(sexo);
		setHabitacion(habitacion);
		setCama(cama);

	}

	Paciente(Cama cama, int habitacion) throws CamaNoExisteExeption {
		setHabitacion(habitacion);
		setCama(cama);
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getID() {
		return ID;
	}

	void setHabitacion(int habitacion) {
		this.habitacion = habitacion;

	}

	void setCama(Cama cama) throws CamaNoExisteExeption {
		if (cama == null)
			throw new CamaNoExisteExeption();
		this.cama = cama;
	}

	private void setSexo(Sexo sexo) throws SexoNoExisteExeption {
		if (sexo == null)
			throw new SexoNoExisteExeption("El sexo que has introducido es erroneo");
		this.sexo = sexo;
	}

	private void setNombre(String nombre) throws FormatoNoValidoexception {
		Matcher matcher = patron.matcher(nombre);
		if (!matcher.matches())
			throw new FormatoNoValidoexception("El formato del nombre es incorrecto");
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cama == null) ? 0 : cama.hashCode());
		result = prime * result + habitacion;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (cama != other.cama)
			return false;
		if (habitacion != other.habitacion)
			return false;
		return true;
	}

	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + ((cama == null) ? 0 : cama.hashCode());
	// return result;
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// Paciente other = (Paciente) obj;
	// if (cama != other.cama)
	// return false;
	// return true;
	// }
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Sexo: " +sexo+ ", Habitacion/cama: " +habitacion+"-"+cama;
	}
}
