import java.util.*;

public class CURPRFC{
	public static void main(String args[]) {
		persona curp = new persona(			//primer objeto q se utiliza para generar solo la curp
            CapturaEntrada.capturaString("nombre(s)"),
            CapturaEntrada.capturaString("primer apellido"),
            CapturaEntrada.capturaString("segundo apellido"),
            CapturaEntrada.capturaString("fecha de nacimiento (AAAA/MM/DD)"),
            CapturaEntrada.capturaString("sexo (hombre o mujer)"),
            CapturaEntrada.capturaString("estado donde nacio")
        );

        curp.setcurp();
        System.out.println("1. La CURP es: "+ curp.getcurp());
		
		System.out.println("");
		persona rfc = new persona(			//segundo objeto que e utiliza solo para generar el RFC
            CapturaEntrada.capturaString("nombre(s)"),
            CapturaEntrada.capturaString("primer apellido"),
            CapturaEntrada.capturaString("segundo apellido"),
            CapturaEntrada.capturaString("fecha de nacimiento (AAAA/MM/DD)"),
            CapturaEntrada.capturaString("sexo (hombre o mujer)"),
            CapturaEntrada.capturaString("estado donde nacio")
        );

        rfc.setrfc();
        System.out.println("2. El RFC es: "+ rfc.getrfc());
		
		System.out.println("");
		persona cyr = new persona(			//tercer objeto que se utiliza para generar curp y rfc
            CapturaEntrada.capturaString("nombre(s)"),
            CapturaEntrada.capturaString("primer apellido"),
            CapturaEntrada.capturaString("segundo apellido"),
            CapturaEntrada.capturaString("fecha de nacimiento (AAAA/MM/DD)"),
            CapturaEntrada.capturaString("sexo (hombre o mujer)"),
            CapturaEntrada.capturaString("estado donde nacio")
        );

		cyr.setcurp();
        cyr.setrfc();
        System.out.println("3. CURP y RFC: "+ cyr.getcurp() +" "+cyr.getrfc());
	}
}

class persona{
    String curp,rfc,nombre,apellido1,apellido2,fecha,estado,sexo;
    char ch;
    Random r = new Random();

    public persona(String nom,String ap1,String ap2,String fecha,String sex,String esta){
        nombre = nom.toUpperCase();
        apellido1 = ap1.toUpperCase();
        apellido2 = ap2.toUpperCase();
        this.fecha = fecha;
        sexo = sex.toUpperCase();
        estado = esta.toUpperCase();
    }

    public void setcurp(){
        curp = Character.toString(apellido1.charAt(0));
        for (int i = apellido1.length()-1; i >= 0; i--) {
            if (apellido1.charAt(i) == 'A' || apellido1.charAt(i) == 'E' || apellido1.charAt(i) == 'I'
			|| apellido1.charAt(i) == 'O' || apellido1.charAt(i) == 'U') {
                ch = apellido1.charAt(i);
            }
        }
        curp += ch;
        curp += Character.toString(apellido2.charAt(0));
        curp += Character.toString(nombre.charAt(0));
        for (int i = 2; i < fecha.length(); i++) {
            if (fecha.charAt(i) != '/') {
                curp += Character.toString(fecha.charAt(i));
            }
        }
        curp += Character.toString(sexo.charAt(0));
        curp += Character.toString(estado.charAt(0));
        for (int i = 0; i < estado.length(); i++) {
            if (estado.charAt(i) == ' ') {
                curp += Character.toString(estado.charAt(i+1));
            }
        }
        for (int i = apellido1.length()-1; i >= 1; i--) {
            if (apellido1.charAt(i) != 'A' && apellido1.charAt(i) != 'E' && apellido1.charAt(i) != 'I'
			&& apellido1.charAt(i) != 'O' && apellido1.charAt(i) != 'U') {
                ch = apellido1.charAt(i);
            }
        }
        curp += ch;
        for (int i = apellido2.length()-1; i >= 1; i--) {
            if (apellido2.charAt(i) != 'A' && apellido2.charAt(i) != 'E' && apellido2.charAt(i) != 'I'
			&& apellido2.charAt(i) != 'O' && apellido2.charAt(i) != 'U') {
                ch = apellido2.charAt(i);
            }
        }
        curp += ch;
        for (int i = nombre.length()-1; i >= 1; i--) {
            if (nombre.charAt(i) != 'A' && nombre.charAt(i) != 'E' && nombre.charAt(i) != 'I'
			&& nombre.charAt(i) != 'O' && nombre.charAt(i) != 'U') {
                ch = nombre.charAt(i);
            }
        }
        curp += ch;
        curp += Character.toString((char)(r.nextInt(26) + 'a')).toUpperCase(); //genera una letra al azar
        curp += Character.toString((char)(r.nextInt(26) + 'a')).toUpperCase();
    }

    public void setrfc(){
        rfc = Character.toString(apellido1.charAt(0));
        rfc += Character.toString(apellido1.charAt(1));
        rfc += Character.toString(apellido2.charAt(0));
        rfc += Character.toString(nombre.charAt(0));
        for (int i = 2; i < fecha.length(); i++) {
            if (fecha.charAt(i) != '/') {
                rfc += Character.toString(fecha.charAt(i));
            }
        }
        rfc += Character.toString((char)(r.nextInt(26) + 'a')).toUpperCase(); //genera un letra al azar
        rfc += Character.toString((char)(r.nextInt(26) + 'a')).toUpperCase();
        rfc += Character.toString((char)(r.nextInt(26) + 'a')).toUpperCase();
    }

    public String getcurp(){ //este metodo regresa el String curp
        return curp;
    }
    
    public String getrfc(){ //este metodo regresa el String rfc
        return rfc;
    }
}

class CapturaEntrada{
    public static String capturaString(String msg){
        Scanner sc= new Scanner(System.in);
        System.out.print("Ingresar "+ msg + ": ");
        return (sc.nextLine());
    }
}