package HospitalExamen;

public enum Cama {
	A, B, C, D;

	public static String[] toArray() {
		String[] arrayCama = new String[Cama.values().length];
		int i = 0;
		for (Cama cama : Cama.values()) {

			arrayCama[i++] = cama.toString();
		}

		return arrayCama;

	}
}