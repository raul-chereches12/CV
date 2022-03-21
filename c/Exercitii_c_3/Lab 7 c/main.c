#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define EPS 1e-5

/*
//VARIANTA CU ALOCARE DINAMICA
int main()
{
    int n,ok,i;
    char *a,*b;

   n=50;
   a=(char*)malloc(n);
   b=(char*)malloc(n);
   scanf("%s",a);
   scanf("%s",b);
   ok=2;i=0;
   while(a+i!=NULL&&b+i!=NULL&&ok!=2){

    if(*(a+i)>*(b+i))
       ok=1;
       else if(*(a+i)<*(b+i))
    ok=-1;
        else
        ok=0;
   }
printf("%d",ok);
}
*/
/*
char** citSiruri(int *pn){

scanf("%d%*c",pn);
char** ts=(char**)calloc(*pn,sizeof(char*));
if(ts==NULL)
    exit(1);
//
char s[200];
int i;
printf("Sirurile de caractere;\n");
for(i=0;i<*pn;i++){
    fgets(s,200,stdin);
    ts[i]=(char*)malloc(strlen(s)+1);
if(ts[i]==NULL)
    exit(1);
strcpy(ts[i],s);
}
return ts;
}
void bubbleSort(char**ts,int n){
int sortat=0,i;
while(sortat==0){
    sortat=1;
    for(i=1;i<n;i++)
    if(strcmp(ts[i-1],ts[i])>0){
        schimba(&ts[i-1],&ts[i]);
    sortat=0;}
    n--;
    }


}

void schimba(char**p,char**q){

char* aux;
aux=*p;
*p=*q;
*q=aux;
}

void elib(char**ts,int n){
int i;

for(i=0;i<n;i++)
    free(ts[i]);
    free(ts);

}
void afisSiruri(char** ts,int n){
int i;

for(i=0;i<n;i++)
    printf("%s\n",ts[i]);


}
int main(){

char **ts;
int n;
ts=citSiruri(&n);
bubbleSort(ts,n);
printf("Sirurile in ordine cresc \n");
afisSiruri(ts,n);
elib(ts,n);

}
*/
//VARIANTA FARA ALOCARE DINAMICA
void citire(char v[30][30],int n){
int i;
for(i=0;i<n;i++)
        fgets(v[i],20,stdin);

}
void afisare(char v[30][30],int n){
    int i;
for(i=0;i<n;i++)
    printf("%s\n",v[i]);

}
bubbleSort(char v[30][30],int n){
int sortat=0,i;
char aux[30];
while(sortat==0){
    sortat=1;
    for(i=1;i<n;i++)
    if(strcmp(v[i-1],v[i])>0){
        strcpy(aux,v[i-1]);
    strcpy(v[i-1],v[i]);
    strcpy(v[i],aux);
    sortat=0;
    }
    n--;
}
}
int main(){
char v[30][30];
int n;

scanf("%d%*c",&n);
citire(v,n);
bubbleSort(v,n);
afisare(v,n);


}
