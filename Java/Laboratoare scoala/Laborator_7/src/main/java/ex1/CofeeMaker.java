package ex1;

class CofeeMaker {
    private int maxNumberOfCoffs=5;
    Cofee makeCofee() throws MaxCoffeException {

        System.out.println("Make a coffe");
        int t = (int)(Math.random()*100);
        int c = (int)(Math.random()*100);
        if(maxNumberOfCoffs==Cofee.getNumberOfInstances())
            throw new MaxCoffeException("--Too many coffes--");
        Cofee cofee = new Cofee(t,c);

        return cofee;
    }

}//.class
