package HospitalExamen;

public enum Sexo {
	HOMBRE, MUJER;

	public static String[] toArray() {
		String[] arraySexo = new String[Sexo.values().length];
		int i = 0;
		for (Sexo sexo : Sexo.values()) {

			arraySexo[i++] = sexo.toString();
		}

		return arraySexo;

	}
}
