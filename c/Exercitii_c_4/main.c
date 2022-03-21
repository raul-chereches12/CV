#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#define N 20

/*
int a[20];
int citestePol(int a[]);
int valPolinom(int x,int grad,int a[]);

int citestePol(int a[]){
int grad,i;

printf("citeste gradul(<=%d)",GRAD_MAX);

scanf("%d",&grad);
printf("coeficineti:\n");
for(i=grad;i>=0;i--){

    printf("[%d]= ",i);
    scanf("%d",&a[i]);

}
return grad;
}

void afisRad(int grad,int a[]){
int nrRad=0,d;
int a0=abs(a[0]);
for(d=1;d<=a0;d++)
if(a0%d==0){
    if(valPolinom(d,grad,a)==0)
    nrRad++,printf("%d ",d);
    if(valPolinom(-d,grad,a)==0)
        nrRad++,printf("%d ",-d);
}
    if(nrRad==0)
        printf("Nu exista radacini");

}

int valPolinom(int x,int grad,int a[]){
int s=0,p=1,i;

for(i=0;i<=grad;i++){

 s=s+a[i]*p;
 p=p*x;

}
return s;

}

int main()
{

int grad,a[20+1];
printf("Polinomul:\n");return grad;
grad=citestePol(a);
printf("Radacinile intregi:");
afisRad(grad,a);
return 0;

    return 0;
}
*/

int citesteRel(int R[][2]);
int detMult(int R[][2],int n,int M[]);
void afiseaza(int n,int a[]);
int refl(int R[][2],int n,int M[],int m);
int sim(int R[][2],int n);
int tranz(int R[][2],int n);
int existaInR(int x,int y,int R[][2],int n);

int main()
{
    int R[N][2],n,M[N*2],m;
    n=citesteRel(R);
    m=detMult(R,n,M);
    printf("Multimea: ");
int r=refl(R,n,M,m);
int s=sim(R,n);
int t=tranz(R,n)
    afiseaza(m,M);
    if(r&&s&&t)
        printf("\nEchiv");
    else
        printf("\Nu e echiv");



}
int citesteRel(int R[][2])
{
    int n,i;
    printf("Nr de perechi(<=%d):",N);
    scanf("%d",&n);
    printf("perechi:\n");
    for(i=0; i<n; i++)
    {
        printf("[%d]",i);
        scanf("%d%d",&R[i][0],&R[i][1]);

    }
    return n;
}


void afiseaza(int n,int a[])
{
    int i;
    for(i=0; i<n; i++)
        printf("%d ",a[i]);
    printf("\n");

}
int detMult(int R[][2],int n,int M[])
{
     int exista(int val,int a[],int n)
    {
        int i;
        for(i=0;i<n;i++){
            if(a[i]==val)
                return 1;
        }
        return 0;
    }
    int m=0,i,j;
    for(i=0; i<n; i++)
        for(j=0; j<2; j++)
            if(!exista(R[i][j],M,m))
                M[m++]=R[i][j];//se pune prima data pe m=0 dupa se incrementeaza//
    return m;


}
int refl(int R[][2]int n,int M[],int m){
int i;
    for(i=0;i<m;i++)
if(!existaInR(M[i],M[i],R,n))
    return 0;
return 1;




}

int existaInR(int x,int y,int R[][2],int n){
int i;
for(i=0;i<n;i++)
    if(R[i][0]==x&&R[i][1]==y)
    return 1;
return 0;
}
int sim(int R[][2],int n){
int i;
for(i=0;i<n;i++)
    if(!existaInR(R[i][1],R[i][0],R,n))
    return 0;
return 1;

}
int tranz(int R[][2],int n){

int i,j;
for(i=0;i<n;i++)
for(j=0;j<n;j++)
        if(R[i][1]==r[i][0])
        if(!existaInR(R[i][0],R[j][1],R,n))
        return 0;
return 1;




}



