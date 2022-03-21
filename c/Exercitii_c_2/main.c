#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main(){

int maximTOT=0,v[30],maximSIR,poz,i,nr;


scanf("%d",&nr);
printf("%d",nr);

for(i=1;i<=nr;i++)
scanf("%d",&v[i]);

i=1;
maximSIR=0;

while(i<nr){

    if(v[i]==v[i+1])
    maximSIR++;
    else
    {
        if(maximSIR>maximTOT){
            maximTOT=maximSIR;
            poz=i;
        }
        maximSIR=0;
    }

i++;
}
poz=poz-maximTOT;
printf("pozitia pe care se afla subsirul maxim %d de elemente:%d",poz,maximTOT);



}
