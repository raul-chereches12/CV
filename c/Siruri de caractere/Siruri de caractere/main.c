#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define N 30
/*
void subsir(char *d,const char *s,int poz,int nr){//extragere subsir;

if(poz>=strlen(s))
    d[0]='\0';//sir vid
    else{
    strncpy(d,s+poz,nr);
    d[nr]='\0';
    }
}
int main()
{
    int poz,nr;
    char s[20],d[20];
    printf("Introduceti sirul sursa:");
    fgets(s,20,stdin);

    printf("introduceti pozitia de inceput a subsirului");
    scanf("%d",&poz);
     printf("introduceti nr de caractere a subsirului");
     scanf("%d",&nr);

     subsir(d,s,poz,nr);
     printf("%s",d);

}
*/
/*
void insereaza(char *d,const char *s,int poz){//inserare sir
    if(poz>strlen(d))
        return;
    char aux[N];
    strcpy(aux,d+poz);
    strcpy(d+poz,s);
    strcat(d,aux);
}
void eliminaLF(char *s){
    int  n=strlen(s);
    if(s[n-1]=='\n')
        s[n-1]='\0';

}
int main(){
     int poz;
    char s[N],d[N];
    printf("Introduceti sirul care va fi inserat:");
    fgets(s,20,stdin);
    eliminaLF(s);
    printf("Introduceti sirul sursa:");
    fgets(d,20,stdin);

    printf("introduceti pozitia de inceput a subsirului");
    scanf("%d",&poz);


     insereaza(d,s,poz);

     printf("%s",d);

return 0;
}
*/

/*
memmove(d+poz+strlen(s),d+poz,strlen(d+poz)+1)
strncpy(d+poz,s,strlen(s))
*/

/*
void sterge(char *d,int poz,int nr){//stergere subsir
    if(poz>=strlen(d))
        return;
   if(poz+nr>=strlen(d))
    d[poz]='\0';
   else
    memmove(d+poz,d+poz+nr,strlen(d+poz+nr)+1);
}

int main(){
     int poz,nr;
    char s[N],d[N];
    printf("Introduceti sirul sursa");
    fgets(s,20,stdin);

    printf("introduceti pozitia de inceput pt stergere");
    scanf("%d",&poz);
    printf("introduceti nr de caractere a subsirului sters");
    scanf("%d",&nr);
printf("introduceti pozitia de inceput pt stergere");
    scanf("%d",&poz);
     sterge(s,poz,nr);
     printf("%s",s);

return 0;
}
*/

//5

int indexOf(const char *sir,const char *subsir){

char*p=strstr(sir,subsir);
if(p==NULL)
return -1;
else
    return p-sir; SE RETURNEAZA POZIIA I DIN SIR UNDE SE AFLA SUBSIRUL

}
