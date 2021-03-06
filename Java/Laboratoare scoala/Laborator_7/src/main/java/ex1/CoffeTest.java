package ex1;

public class CoffeTest {
    public static void main(String[] args) {
        CofeeMaker mk = new CofeeMaker();
        CofeeDrinker d = new CofeeDrinker();

        for(int i = 0;i<15;i++){


            try {
                Cofee c = mk.makeCofee();
                d.drinkCofee(c);
            }
            catch (TemperatureException e) {
                System.out.println("Exception:"+e.getMessage()+" temp="+e.getTemp());
            } catch (ConcentrationException e) {
                System.out.println("Exception:"+e.getMessage()+" conc="+e.getConc());
            }
            catch (MaxCoffeException e){
                System.out.println("Exception: "+e.getMessage()+" (maximum number of instances reached)");
            }
            finally{
                System.out.println("Throw the cofee cup.\n");
            }
        }
    }
}//.class
