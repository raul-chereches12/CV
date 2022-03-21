#include <stdio.h>
#include <stdlib.h>

void schimba(float *p,float *q);
void bubbleSort(float a[],int n);
int *citeste(int *pn);
void afiseaza(float *a,int n);
/*
int main()
{

 float *a;
 int n;

 a=citeste(&n);
 bubbleSort(a,n);
 printf("Tabel sortat: ");
 afiseaza(a,n);
 free(a);
 return 0;
}
*/
int *citeste(int *pn)
{
    printf("Introduceti nr de elemente:");
    scanf("%d",pn);

    int *a=(int*)calloc(*pn,size_t(int));

    if(a==NULL)
    {

        printf("Mem insuf");
        exit(1);
    }
    int i;
    for(i=0; i<*pn; i++)
    {

        printf("[%d]:",i);
        scanf("%f",&a[i]);


    }
    return a;
}
void bubbleSort(float a[],int n)
{
//float *a=a[]
    int sortat=0,i;

    while(sortat==0)
    {
        sortat=1;

        for(i=1; i<n; i++)
        {
            if(a[i-1]>a[i])
            {
                schimba(&a[i-1],&a[i]);
                sortat=0;
            }

        }
        n--;


    }

}
void schimba(float *p,float *q)
{
    float aux;
    aux=*p;
    *p=*q;
    *q=aux;

}
void afiseaza(float *a,int n)
{
    int i;
    for(i=0; i<n; i++)
        printf("%f ",a[i]);

}

float *interclaseaza(float a[],int na,float b[],int nb,int *pnc)
{
    *pnc=na+nb;
    float *c=(float*)calloc(*pnc,sizeof(float));
    if(c==NULL)
    {

        printf("Mem insuf");
        exit(1);
    }
    int i,j,k;

    i=j=k=0;
    while(i<na&&j<nb)
        if(a[i]<=b[j])
            c[k++]=a[i++];
        else
            c[k++]=b[j++];

    while(i<na)c[k++]=a[i++];
    while(j<nb)c[k++]=b[j++];
    return c;
}
/*
int main(){
    float *a,*b,*c;
    int na,nb,nc;
    printf("primul vector ord cresc\n");
    a=citeste(&na);
    printf("al doilea vector ord cresc\n");
    b=citeste(&nb);
    c=interclaseaza(a,na,b,nb,&nc);
    printf("Vectorul rezultat: ");
    afiseaza(c,nc);
    free(a);
    free(b);
    free(c);
}
*/

int cauta(int *a,int na,int *b,int nb)
{

    int i=0,j;
    while(i<=na-nb)
    {
        for(j=0; j<nb; j++)
            if(a[i+j]!=b[j])
                break;
        if(j==nb)
            return i;
        else
            i++;
    }
    return -1;


}


int main()
{

    int *a,*b,m,n;
    printf("tabl in care cauta (a):\n");
    a=citeste(&m);
    printf("tabloul cautat\n");
    b=citeste(&n);
    printf("b apare in a pe poz: ");
    int nrAparitii=0,poz,ind=0;
    while(ind<m&&(poz=cauta(a+ind,m-ind,b,n))>=0)
    {
        nrAparitii++;
        ind+=poz;
        printf("%d ",ind);
        ind++;
    }
    if(nrAparitii==0)
        printf(" nu apare");
    free(a);
    free(b);




}




