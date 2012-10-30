package funs;

/**
 *
 * @author acabrera
 */
public class Incrementar {

    public static int incUno(String p1){
        int a = 0;

        if(p1.length() == 0)
            a = 1;

        try {
            a = Integer.parseInt(p1) + 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return a;
    }
}
