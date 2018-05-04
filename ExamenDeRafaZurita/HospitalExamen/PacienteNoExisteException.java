package HospitalExamen;

public class PacienteNoExisteException extends Exception {
	PacienteNoExisteException(String string) {
		super(string);
	}
}
