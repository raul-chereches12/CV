package exceptions;

public class CardsLimitExcededException extends Exception{

    private static final String msg="Max number of cards exceded ! (max number=5)";

    public CardsLimitExcededException() {

          super(msg);

        }


    }


