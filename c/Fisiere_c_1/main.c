#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
typedef struct {
float re,im;

}complex;

FILE *deschide(const char *nume,const char *mod){
FILE *pf=fopen(nume,mod);
if(pf==NULL){

    perror(nume);
    exit(1);

}
else
    return pf;

}
/*
void creareFisier(const char *nume,int *n,int *m){
FILE *pf=deschide(nume,"w");
int i,j,nr;
printf("introduceti n si m");
scanf("%d%d",n,m);

for(i=1;i<=*n;i++){
    for(j=1;j<=*m;j++)
        {
    scanf("%d",&nr);
fprintf(pf,"%d ",nr);
}
fprintf(pf,"\n");
}
fclose(pf);
}
void afisareFisier(const char *nume,int v[20][20],int n,int m){
FILE *pf=deschide(nume,"r");
int i,j;
for(i=1;i<=n;i++)
    for(j=1;j<=m;j++)
        fscanf(pf,"%d",&v[i][j]);

fclose(pf);

}

int main()
{
    char s[]="fis.txt";
    int n,m,v[20][20],i,j;
    creareFisier(s,&n,&m);

afisareFisier(s,v,n,m);
    for(i=1;i<=n;i++){
    for(j=1;j<=m;j++)
        printf("%d ",v[i][j]);
    printf("\n");
    }
}
*/
void creareFis(const char *nume){

FILE *pf=deschide(nume,"w");

char s[20];

while(gets(s)!=NULL){
    fprintf(pf,"%s\n",s);

}
fclose(pf);
}
void afisareFis(const char *nume){
FILE *pf=deschide(nume,"r");
char s[20];
while(fgets(s,20,pf)!=NULL){
        s[strlen(s)-1]='\0';
    printf("%s\n",s);

}

}


int main(){

const char nume[]="fisier.txt";

creareFis(nume);
afisareFis(nume);


}
