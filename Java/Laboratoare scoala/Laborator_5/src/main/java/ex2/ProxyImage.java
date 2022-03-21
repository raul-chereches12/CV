package ex2;

public class ProxyImage implements Image{
    private Image image;
    private String fileName;
    private boolean option;




    public ProxyImage(String fileName,boolean option){
        this.fileName = fileName;
        this.option=option;
    }



    @Override
    public void display() {
        if((image == null)&&(option)){
            image = new RealImage(fileName);
            image.display();
        }
        else if(image == null){
            image = new RotatedImage(fileName);
            image.display();
        }

    }
}
