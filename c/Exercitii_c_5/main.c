#include <stdio.h>
#include <stdlib.h>
#include <math.h>
/*
int main()
{
    double x,y,z;

    printf("x= ");
    scanf("%lf",&x);
    printf("y= ");
    scanf("%lf",&y);

    z=pow(x,y);

    printf("x la puterea y este egal cu %.4f\n",z);





}
*/
/*
int main(){

int a,b;
printf("dati 2 valori intregi:");
scanf("%d%d",&a,&b);

if(b!=0){

    printf("catul impartirii: %d\n",a/b);
    printf("restul impartirii %d\n",a%b);
    float c=(float)a/b;
    printf("impartirea reala %f\n",c);


}

/*
int main(){

int a;
double r;

printf("introuceti unghiul alfa: ");
scanf("%d",&a);

r=M_PI*(a/180.0);

printf("sin de %d egal cu %.10f\n",a,sin(r));




return 0;
}

*/
/*
int main(){

int a;
printf("dati un an in [1600,4900]");
scanf("%d",&a);
if((a<1600)||(a>4900))
printf("nu se aplica");
else
    if(((a%4==0)&&(a%100!=0))||(a%400==0))
    printf("%d este an bisect",a);





}

*/
/*
int main(){
float x,fx;

printf("x= ");
scanf("%f",&x);

fx=x<-2?x*x+4*x+4:x==-2?0:x*x+5*x;
printf("fx= %f",fx);






}

*/
/*
int main(){


double r,g,m,s,a;


printf("introduceti numarul de radiani");
scanf("%f",&r);


a=r/M_PI*180.0;

m=60*(a-(int)a);
s=60*(m-(int)m);

printf("%d gr,min %d,sec %f",(int)a,(int)m,s);



*/
/*
int main(){
int a;
printf("int ocupa %d octeti",sizeof(a));



}
*/
int main(){

int x,y;

printf("dati 2 valori:");
scanf("%d%d",&x,&y);

printf("in hexa:x=%x,y=%x",x,y);


}










