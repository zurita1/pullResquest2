package consola;

import HospitalExamen.Cama;
import HospitalExamen.CamaNoExisteExeption;
import HospitalExamen.FormatoNoValidoexception;
import HospitalExamen.Hospital;
import HospitalExamen.PacienteNoExisteException;
import HospitalExamen.Sexo;
import HospitalExamen.SexoNoExisteExeption;
import HospitalExamen.ValorNoValidoException;
import HospitalExamen.camaOcupadaexception;
import utiles.Menu;
import utiles.Teclado;

public class TestPacientes {

	static Hospital hospital = new Hospital();
	static Menu menuHospital = new Menu("Gestion de pacientes",
			new String[] { "Alta", "Baja", "Cambio cama,habitacion", "Mostrar camas ocupadas" });

	public static void main(String[] args) {

		do {
			try {
				System.out.println(hospital);
				switch (menuHospital.gestionar()) {

				case 1:
					alta();
					break;

				case 2:
					baja();
					break;

				case 3:
					cambioCama();
					break;

				case 4:
					break;

				default:
					return;
				}
			} catch (Exception e) {

				System.err.println(e.getMessage());

			}
		} while (true);
	}

	private static void cambioCama() throws PacienteNoExisteException, CamaNoExisteExeption, camaOcupadaexception {
		hospital.cambiarCama(pedirIndice(), pedirCama(), pedirHabitacion());
		System.out.println("El paciente se ha cambiado de cama correctamente");
	}

	private static void baja() throws PacienteNoExisteException {
		hospital.baja(pedirIndice());
	}

	private static int pedirIndice() {
		return Teclado.leerEntero("Introduce el indice del paciente");
	}

	private static void alta()
			throws camaOcupadaexception, CamaNoExisteExeption, SexoNoExisteExeption, FormatoNoValidoexception {

		hospital.alta(pedirnombre(), pedirSexo(), pedirHabitacion(), pedirCama());

	}

	private static int pedirHabitacion() {

		return Teclado.leerEntero("Introduzca el numero de la habitacion del paciente");
	}

	private static String pedirnombre() {
		return Teclado.leerCadena("Introduce el nombre y el apellido del paciente");
	}

	private static Cama pedirCama() {
		Menu menuHospital = new Menu("Cama del paciente", Cama.toArray());

		switch (menuHospital.gestionar()) {

		case 1:
			return Cama.A;

		case 2:
			return Cama.B;

		case 3:
			return Cama.C;

		default:
			return Cama.D;

		}

	}

	private static Sexo pedirSexo() {
		Menu menuHospital = new Menu("Sexo del paciente", Sexo.toArray());

		switch (menuHospital.gestionar()) {

		case 1:
			return Sexo.HOMBRE;

		default:
			return Sexo.MUJER;

		}
	}

}
