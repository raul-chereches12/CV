#include <stdio.h>
#include <stdlib.h>
int *citeste(int *numar);
void afiseaza(int n,int *a);

int main()
{
    int *a;
int n;
    a=citeste(&n);
afiseaza(n,a);




    return 0;
}
int *citeste(int *numar){
    printf("introduceti nr de elem");
    scanf("%d",numar);

    int *a;
    a=(int*) calloc (*numar,sizeof(int));


int i;
for(i=0;i<*numar;i++){
    printf("%d=",i);
    scanf("%d",&a[i]);
    printf("\n");

}
printf("%p ",numar);
free(numar);
printf("%p ",numar);
return a;



}
void afiseaza(int n,int *a){


int i;

for(i=0;i<n;i++){
    printf("%d ",*(a+i));

}


}

