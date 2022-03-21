#include <stdio.h>
#include <stdlib.h>

int main()
{
    char s[50],subsir[20];
    int a,b,ok,i,j;

    scanf("%s",s);
    scanf("%s",subsir);

    for(i=0;i<strlen(s);i++)
        if(s[i]==subsir[0]){
        a=i;ok=1;
    for(j=0;j<strlen(subsir)&&ok==1;j++,a++)
        if(subsir[j]!=s[a])
        ok=0;

        if(ok==1){
            b=a-1;
        a=i;
        printf("a=%d,b=%d",a,b);}

        }


    return 0;
}
