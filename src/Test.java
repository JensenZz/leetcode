import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {

    public static void main(String[] args) {
        exeCmd("");

    }
    private static String exeCmd(String commandStr) {
        try {
            Process process = Runtime.getRuntime().exec("sh "+System.getProperty("user.dir")+"/checkPath.sh"+ " 11"+ " 11");
            BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stderrReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            System.out.println("OUTPUT");
            while ((line = stdoutReader.readLine()) != null) {
                System.out.println(line);
            }
//            System.out.println("ERROR");
//            while ((line = stderrReader.readLine()) != null) {
//                System.out.println(line);
//            }
            int exitVal = process.waitFor();
            System.out.println("process exit value is " + exitVal);
        } catch (Exception e) {

        }
        return "";
    }

}
