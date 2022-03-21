#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#define N 10
#define M_PI 3.14
typedef struct{
float re,im;
double mod,arg;
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

//3 modificat fisiere binare
/*
creeazaFis(const char *nume){
FILE *pf=deschide(nume,"w");
Complex c;

int n,i;
printf("nr de nr complexe:");
scanf("%d",&n);
for(i=0;i<n;i++){
    printf("[%d]",i);
    scanf("%f %f",&c.re,&c.im);
    c.mod=sqrt(c.re*c.re+c.im*c.im);
    c.arg=atan2(c.im,c.re);
    fwrite(&c,sizeof(Complex),1,pf);
}
fclose(pf);


}
//3
void afiseazaFis(const char *nume){
FILE *pf=deschide(nume,"r");
Complex c;

while(fread(&c,sizeof(Complex),1,pf)==1){
    printf("%.2f+i*%2f ",c.re,c.im);
    printf("Modul:%.8f, arg:%.8f grade\n",c.mod,c.arg/M_PI*180);


}

fclose(pf);
}
//modificare
void modif(const char*nume){
FILE *pf=deschide(nume,"rb+");
int i;
printf("Al cateleaza nr il modificam");
scanf("%d",&i);
if(fseek(pf,i*sizeof(Complex),SEEK_SET)==0){
    Complex c;
printf("Noul nr complex:");
    scanf("%f %f",&c.re,&c.im);
    c.mod=sqrt(c.re*c.re+c.im*c.im);
    c.arg=atan2(c.im,c.re);
    fwrite(&c,sizeof(Complex),1,pf);


}
fclose(pf);
}
int main()
{
    char nume[]="fis.dat";
creeazaFis(nume);
afiseazaFis(nume);
modif(nume);
afiseazaFis(nume);

    return 0;
}
*/

//4Concatenare a doua fisiere
void afiseazaFis(FILE *pr){
float nr;
while(fscanf(pr,"%f",&nr)==1)
    printf("%.2f ",nr);

}
void concat(FILE *pr,const char *nume){
FILE *pf=deschide(nume,"r");
float nr;
while(fscanf(pf,"%f",&nr)==1)
    fprintf(pr,"%f ",nr);
fprintf(pr,"\n");
fclose(pf);

}

int main(){
FILE *pr=deschide("rez.txt","w+");//PUTEM ACTUALIZA
char nume[20];
int n,i;
printf("NR DE FISIERE DE CONCATENAT");
scanf("%d",&n);
for(i=1;i<=n;i++){
sprintf(nume,"fis%d.txt",i);
concat(pr,nume);
}
fflush(pr);
rewind(pr);
afiseazaFis(pr);
fclose(pr);

}

