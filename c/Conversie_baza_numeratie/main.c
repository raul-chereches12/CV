#include <stdio.h>
#include <stdlib.h>
#define N 30
#define NMAX 10000
#define BAZA_MAX 36
#include <ctype.h>
/*
int main()
{
    float a[N],min,max;
    int n,imin,imax,i;
for(n=0;n<1||n>N;scanf("%d",&n)){
fflush(stdin);
    printf("nr elem (<=%d) ",N);
}


    if((n<1)||(n>N))
    {

        printf("Val gresita");
        return 0;
    }
    printf("elementele:\n") ;
    for(i=0; i<n; i++)
    {


        printf("a[%d]=",i);
        scanf("%f",&a[i]);
    }

    imin=imax=0;

    for(i=1; i<n; i++)
    {

        if(a[i]<a[imin])
        {
            imin=i;

        }

        if(a[i]>a[imax])
        {
            imax=i;

        }


    }

    printf("MINIM:%.2f, pe pozitia %d\n:",a[imin],imin);
    printf("maxim:%.2f, pe pozitia %d\n:",a[imax],imax);


    return 0;
}
*/
/*
int main(){
int n,i,j;
char a[NMAX+1]={0};
scanf("%d",&n);
for(i=2;i<=sqrt(n);i++){
        if(a[i]==0)
        for(j=2*i;j<=n;j=j+1)
        a[j]=1;

    for(i=2;i<=n;i++)
    if(a[i]==0)
    printf("%d ",a[i]);

}

*/
/*
int main()
{

    int baza,nrB10,cifra,i;

    char nr[32];
    printf("baza(intre 2 si %d",BAZA_MAX);
    scanf("%d",&baza);
    printf("numarul in baza %d",baza);
    scanf("%31s",nr);
    nrB10=0;
    for(i=0; nr[i]!='\0'; i++)
    {
        if((nr[i]>='0')&&(nr[i]<='9'))
            cifra=nr[i]-'0';
        else
        {
            nr[i]=toupper(nr[i]);
            if((nr[i]>='A')&&(nr[i]<='Z'))
                cifra=nr[i]-'A'+10;
            else
            {
                printf("caracter gresit: %c\n",nr[i]);
                return 0;
            }
        }
        if(cifra>=baza)
        {
            printf("cifra gresita: %c(%d)\n",cifra);
            return 0;


        }
        nrB10=nrB10*baza+cifra;

    }
printf("nr in b10: %d",nrB10);





}


*/



