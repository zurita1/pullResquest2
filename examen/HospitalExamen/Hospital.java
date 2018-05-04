package HospitalExamen;

import java.util.ArrayList;

public class Hospital {

	private ArrayList<Paciente> arrayPacientes = new ArrayList<Paciente>();
	int ID = 0;

	public void alta(String nombre, Sexo sexo, int habitacion, Cama cama)
			throws camaOcupadaexception, CamaNoExisteExeption, SexoNoExisteExeption, FormatoNoValidoexception {
		Paciente paciente = new Paciente(nombre, sexo, habitacion, cama);
		if (arrayPacientes.contains(paciente)) {
			throw new camaOcupadaexception("La cama ya esta ocupada");
		}

		paciente.setID(ID++);
		arrayPacientes.add(paciente);
	}

	public Paciente baja(int ID) throws PacienteNoExisteException {
		Paciente paciente = getID(ID);
		return arrayPacientes.remove(arrayPacientes.indexOf(paciente));

	}

	private Paciente getID(int ID) throws PacienteNoExisteException {
		for (Paciente paciente : arrayPacientes) {
			if (paciente.getID() == ID)
				return paciente;
		}
		throw new PacienteNoExisteException("El paciente no existe");
	}

	public void cambiarCama(int ID, Cama cama, int habitacion)
			throws PacienteNoExisteException, CamaNoExisteExeption, camaOcupadaexception {
		Paciente paciente = getID(ID);
		if (arrayPacientes.contains(new Paciente(cama, habitacion))) {
			throw new camaOcupadaexception("La cama ya esta ocupada");
		}
		paciente.setCama(cama);
		paciente.setHabitacion(habitacion);
	}

	public String toString() {
		String mensaje = "";
		for (Paciente paciente : arrayPacientes) {
			mensaje += paciente + "\n";
		}
		return mensaje;
	}
}
