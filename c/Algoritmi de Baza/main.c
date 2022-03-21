#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
/*
SUMA PRODUS
int main()
{
    int n,p=1,s=0;
    scanf("%d",&n);


    while(n!=0){

        s+=n%10;
        p*=n%10;
        n/=10;

    }
    printf("suma este %d\n",s);
    printf("produsul este %d",p);
    return 0;
}
*/
/*
PALINDROM
int main(){

int n,copie,p=0;
    scanf("%d",&n);
    copie=n;

    while(n!=0){
        p=p*10+n%10;
        n=n/10;
    }

if(copie==p)
    printf("palindrom");

    else
    printf("nu palindrom");

}
*/
/*
MAXIM MINIM
int* citVec(int *pn,char c);
int main(){
int n,i,maxim=0,minim=9999,min=0,max=0;
int *v;


v=citVec(&n,'v');




for(i=1;i<=n;i++){
if(v[i]>maxim)
    maxim=v[i];
    if(v[i]<minim)
    minim=v[i];
}

for(i=1;i<=n;i++){
if(v[i]==maxim)
   max++;
if(v[i]==minim)
    min++;

}
printf("maxim apare de %d ori",max);
printf("minim apare de %d ori",min);
}nm7e3c-----
int* citVec(int *pn,char c){
//cit elem;
int i;
printf("n=?");
scanf("%d",pn);
int *a;

a=(int*) calloc(*pn,sizeof(int));

for(i=1;i<=*pn;i++){
        printf("%c[%d]=",c,i);
    scanf("%d",a+i);

}
return a;


}
*/
/*
PRIM
int main(){

int n,ok,i;

scanf("%d",&n);

ok=0;
for(i=2;i<=sqrt(n);i++){

    if(n%i==0)
        ok=1;

}
if(ok==0)
    printf("prim");


}
*/
/*
//ORDINE CRESC DESC
void BubbleSort(int *v,int n);
int main(){

int i,n,v[20];
scanf("%d",&n);
for(i=1;i<=n;i++)
    scanf("%d",&v[i]);

    BubbleSort(v,n);

for(i=1;i<=n;i++)
    printf("%d ",v[i]);

}
void BubbleSort(int v[],int n){
int ok,i,aux;

    ok=1;

    while(ok==1){
        ok=0;

        for(i=1;i<n;i++){

            if(v[i]>v[i+1])  //> SAU < IN FUNCTIE DE PREFERINTA
            {
            aux=v[i+1];
            v[i+1]=v[i];
            v[i]=aux;
            ok=1;
        }

        }

    }

}
*/
/*
LITERA MARE LITERA MICA
int main(){
int i;
char s[30];

scanf("%s",s);

for(i=0;i<strlen(s);i++){

    //if((s[i]>='a')&&(s[i]<='z'))
       // s[i]=s[i]-('a'-'A');
       if((s[i]>='A')&&(s[i]<='Z'))
       s[i]=s[i]+('a'-'A');

}
printf("%s",s);


}
*/
/*
CAUTARE IN VECTOR
int main(){
    int i,n,nr,v[20];
scanf("%d",&nr);
scanf("%d",&n);
for(i=1;i<=n;i++)
    scanf("%d",&v[i]);

    for(i=1;i<=n;i++){
        if(v[i]==nr)
        printf("pozitia pe care se afla elementul este:%d\n",i);
    }
}
*/
/*
//CAUTARE BINARA
int binarySearch(int v[],int a,int b,int nr);
int main(){

 int i,n,nr,v[20];
 printf("introduceti valoare cautata");
scanf("%d",&nr);
printf("introduceti numarul de elemente din vector apoi cititi vectorul(sa fie ordonat)");
scanf("%d",&n);

for(i=1;i<=n;i++)
    scanf("%d",&v[i]);

    printf("%d",binarySearch(v,1,n,nr));

}
int binarySearch(int v[],int a,int b,int nr){

int mij=(a+b)/2;
if(v[mij]==nr)
    return mij;
else
    if(nr<v[mij])
    binarySearch(v,a,mij-1,nr);
else
    binarySearch(v,mij+1,b,nr);

}
/*
/*
//INSERARE

int main(){

int a[20],b[40],n1,n2,poz,i,j;
scanf("%d",&n1);
scanf("%d",&n2);

for(i=1;i<=n1;i++)
    scanf("%d",&a[i]);

    for(i=1;i<=n2;i++)
    scanf("%d",&b[i]);

    printf("INTRODUCETI POZITIA UNDE SA FIE INSERAT");
    scanf("%d",&poz);


 for(i=1;i<=n1;i++){
    n2++;
 for(j=n2;j>poz;j--)
    b[j]=b[j-1];

 }

 for(i=1;i<=n1;i++){
    b[poz+i-1]=a[i];

}


for(i=1;i<=n2;i++)
printf("%d ",b[i]);


}

*/
/*
//INTERCLASARE
int main(){
int a[20],b[20],c[40],i,j,n1,n2,k;
scanf("%d",&n1);
scanf("%d",&n2);

for(i=1;i<=n1;i++)
    scanf("%d",&a[i]);

    for(i=1;i<=n2;i++)
    scanf("%d",&b[i]);
i=k=j=1;

    while((i<=n1)&&(j<=n2)){
    if(a[i]>b[j])
        {
        c[k]=b[j];
        j++;
    }
    else
        {
    c[k]=a[i];
    i++;
    }
    k++;
    }
   while(i<=n1){
        c[k]=a[i];
        i++;
        k++;
   }
     while(j<=n2){
        c[k]=b[j];
        j++;
        k++;
   }

    for(i=1;i<=n2+n1;i++)
printf("%d ",c[i]);

}
*/
/*
//STERGE N NUMERE
int main(){
int a[20],i,j,n,poz,nr;
scanf("%d",&n);
for(i=1;i<=n;i++)
    scanf("%d",&a[i]);

scanf("%d",&nr);
scanf("%d",&poz);

for(i=1;i<=nr;i++){
    for(j=poz;j<n;j++)
        a[j]=a[j+1];
    n--;
}

    for(i=1;i<=n;i++)
printf("%d ",a[i]);
}
*/

/*
//CONVERSIE BAZA N IN BAZA 10
int main(){

int i=0,nr,p,conversia=0,baza,v[20],j;
char n[20];

gets(n);
nr=strlen(n);

for(i=0;i<nr;i++){
        if((n[i]>='0')&&(n[i]<='9'))
            v[i+1]=(int)n[i]-(int)'0';
        else
         v[i+1]=(int)n[i]-(int)'a'+10;


}

for(i=1;i<=strlen(n);i++)
    printf("%d ",v[i]);



printf("introduceti baza din care se face conversia");
scanf("%d",&baza);

p=1;

for(j=nr;j>=1;j--){
    conversia=conversia+(v[j]*p);
    p=p*baza;
}

printf("%d",conversia);
}
*/
/*
//CONVERSIE BAZA 10 IN BAZA N
int main(){
    int n,baza,i,rest;
    char v[10];

    scanf("%d",&n);
    scanf("%d",&baza);
    i=0;

    while(n!=0){
              if(n%baza<10)
         v[i]=n%baza+'0';
         else
            v[i]=n%baza+'a'-10;


         i++;
    n/=baza;
    }
    char aux;
    for(n=0;n<i/2;n++){
        aux=v[n];
        v[n]=v[i-n-1];
        v[i-n-1]=aux;
        }
v[i]='\0';


puts(v);
}
*/

/*
int main(){
int v[32],i,ia;
char s[20];
for(i=1;i<=30;i++)
    v[i]=0;

    scanf("%s",s);

    for(i=0;i<strlen(s);i++){
        v[(int)s[i]-(int)'a'+1]++;


    }

        for(i=1;i<=30;i++)
    printf("%d ",v[i]);


}
*/

/*
int main ()
{
  char s[40],cuvmaxim[10];
  char * pch;
  int maxim=0;
gets(s);

  pch = strtok (s," ,.-");
  while (pch != NULL)
  {
    if(strlen(pch)>maxim){
        maxim=strlen(pch);
        strcpy(cuvmaxim,pch);
    }
    pch = strtok (NULL, " ,.-");
  }
  printf("%s de lungime %d",cuvmaxim,maxim);
  return 0;
}
*/
/*
int main(){

int v[31],i,n;
char s[30];

for(i=0;i<=25;i++){
    v[i]=0;
}
gets(s);

for(i=0;i<strlen(s);i++){
   if(s[i]!=' ') v[(int)s[i]-'a']++;
}

for(i=0;i<=25;i++){
    printf("%c=%d \n",'a'+i,v[i]);
}


}
*/
int valoarePolinom(int v[],int x,int n){

int i,s;
s=0;

printf("pentru x=%d valoarea este:",x);

for(i=n;i>=0;i--)
    s=x*s+v[i];

    printf("val lui s este=%d\n",s);
    printf("\n");

return s;
}
int main(){

    int grad,i,v[20];

scanf("%d",&grad);

for(i=0;i<=grad;i++){
        printf("v[%d]=",i);
    scanf("%d",&v[i]);
}
if(v[0]==0){
        printf("0 este solutie");
    for(i=0;i<grad;i++)
        v[i]=v[i+1];

    grad--;
}
    printf("v[0]=%d",v[0]);

    for(i=0;i<=abs(v[0]);i++)
    if(valoarePolinom(v,i,grad)==0)
    printf("%d este solutie /n",i);
    else if(valoarePolinom(v,-i,grad)==0)
    printf("%d este solutie /n",-i);




}
