public class CalcTest {

    //input.lenght() == 3->input.toUpperCase()
    //input.lenght() == 4->input.toLowerCase()
    //input
    public static String checkString(String input) throws IncorrectException {
        if (input != null) {
            if (input.length() == 3) {
                return input.toUpperCase();
            }
            if (input.length() == 4) {
                return input.toLowerCase();
            }
            return input;
        }
        else{
            throw new IncorrectException("input is null!");
        }
    }


}
