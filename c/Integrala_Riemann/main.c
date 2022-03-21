#include <stdio.h>
#include <stdlib.h>
float suprafata (float x0,float x1);
float functie(int x){

return x*x+2*x;

}
int main()
{

    float a,b,val=0,i,c;
    printf("introduceti capetele de integrare:a,b\n");
    scanf("%f",&a);
    scanf("%f",&b);

    for(i=a;c<=b;i=i+0.1){
        c=i+0.1;
      val=val+suprafata(i,c);

    }
    printf("%f",val);
    return 0;
}
float suprafata (float x0,float x1){
float arie;
float y0=functie(x0);
float y1=functie(y0);

arie=(x1-x0)*(y1-y0);
return arie;


}
