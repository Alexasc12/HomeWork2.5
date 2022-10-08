import exception.WrongLoginException;
import exception.WrongPasswordException;

public class HomeWork25 {
    public static void main(String[] args) {
        String login = "sffds6563=-=df23";
        String pass = null;
        String confirmPass = "123";
        System.out.println(acceptThreeParameters(login,pass,confirmPass));
    }

    public static boolean acceptThreeParameters(String login, String password,String confirmPassword){
        boolean checkLogin;
        boolean checkPassword;
        boolean checkLengthPass;
             try {
            checkLogin = checkValidationCharacter(login);
            checkPassword = checkValidationCharacter(password);
            checkLengthLogin(login);
            checkLengthPass = checkLengthPassword(password);
            checkPasswordMatching(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException exception) {
            System.out.println(exception.getMessage());
            return false;
        } return checkLogin && checkPassword && checkLengthPass;

    }
    public static boolean checkValidationCharacter(String checkWord) {
        if (checkWord == null) {
            throw  new NullPointerException("Поле пустое");
                    }

        if (checkWord.matches("\\w+")) {
            return true;
        }
        System.out.println("Недопустимые символы в слове " + checkWord);
        return false;
    }

    public  static  boolean checkLengthLogin(String login) throws WrongLoginException{
        if (login.length() > 20) {
            throw new WrongLoginException("Слишком длинный логин");
        }
        return true;
    }
    public static boolean checkLengthPassword(String pass) {
        if (pass.length() > 19) {
            System.out.println("Слишком длинный пароль");
            return false;
        }
        return true;
    }
    public static boolean checkPasswordMatching(String password,String confirmPassword) throws WrongPasswordException {
        if (password.equals(confirmPassword)) return true;
        throw new WrongPasswordException("Пароли не совпадают");
    }


}