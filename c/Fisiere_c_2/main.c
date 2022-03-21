#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#define N 10
#define M_PI 3.14
typedef struct{
float re,im;
}Complex;

FILE *deschide(const char *nume,const char *mod){
FILE *pf=fopen(nume,mod);
if(pf==NULL){
    perror(nume);
    exit(1);
}
return pf;
}
//2
/*
void creeazaFis(const char *nume){
FILE *pf=deschide(nume,"w");
char s[N];
printf("dati linii de text si la sfarsit ctrl-z si Enter;\n");
while(fgets(s,N,stdin)!=NULL)
    fputs(s,pf);
fclose(pf);
*/
/*
}
void afiseazaFis(const char *nume){
    FILE *pf=deschide(nume,"r");
    char s[N];int nrLinie=1;
    printf("1. ");
    while(fgets(s,N,pf)!=NULL){
        printf("%s",s);
if(s[strlen(s)-1]=='\n')
        printf("%d. ",++nrLinie);
    }
fclose(pf);

}
*/

/*
//3
creeazaFis(const char *nume){
FILE *pf=deschide(nume,"w");
Complex c;
double mod,arg;
int n,i;
printf("nr de nr complexe:");
scanf("%d",&n);
for(i=0;i<n;i++){
    printf("[%d]",i);
    scanf("%f %f",&c.re,&c.im);
    mod=sqrt(c.re*c.re+c.im*c.im);
    arg=atan2(c.im,c.re);
    fprintf(pf,"%f %f %.8f %.8f\n",c.re,c.im,mod,arg);
}
fclose(pf);


}
//3
void afiseazaFis(const char *nume){
FILE *pf=deschide(nume,"r");
Complex c;
double mod,arg;
while(fscanf(pf,"%f%f%lf%lf",&c.re,&c.im,&mod,&arg)==4){
    printf("%.2f+i*%2f ",c.re,c.im);
    printf("Modul:%.8f, arg:%.8f grade\n",mod,arg/M_PI*180);


}

fclose(pf);
}
*/
int main()
{
    char nume[]="fis.txt";
creeazaFis(nume);
afiseazaFis(nume);

    return 0;
}


