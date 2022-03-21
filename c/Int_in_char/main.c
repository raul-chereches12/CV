#include <stdio.h>
#include <stdlib.h>

/*
int main()
{
    int n,a=5,b=8,v[30],i;

        scanf("%d",&n);

        citireVector(v,n);

        for(i=1;i<=n;i++)
            printf("%d ",*(v+i));
}
void citireVector(int *v,int n){
int i;
for(i=1;i<=n;i++)
    scanf("%d",v+i);


}
*/
/*
int main(){

char a,b;
a=56;
b=65;

printf("%c ",a);



}
*/
void citireVector(int v[],int n){
int i;

for(i=1;i<=n;i++){
    scanf("%d",&v[i]);

}


}
int main(){

int a[20],b[20],i;

citireVector(a,5);

for(i=1;i<=5;i++)
    printf("%d ",a[i]);



}
