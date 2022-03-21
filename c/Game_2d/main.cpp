#include <iostream>
#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <windows.h>
#include <time.h>
#include <fstream>
using namespace std;
ifstream f("mapa.txt");
int n=30,m=90,x_om=3,y_om=5,mort=0,test=1;
char harta[100][100];

struct hitbox{
int x,y;
}blocks[20];

int construire_harta(int x,int y,char c){
int x1,y1,i,j;

x1=3*x-2;
y1=3*y-2;
for(i=x1;i<=3;i++)
    for(j=y1;j<=3;j++)
harta[i][j]=c;




}
int construire_bloc(int x,int y,int ok){
int x1,y1,i;



x1=3*x-2;
y1=3*y-2;
for(i=1;i<=3;i++){
    harta[x1][y1]=219;
    y1++;}
y1--;
for(i=1;i<=3;i++){
    harta[x1][y1]=219;
    x1++;}
x1--;

for(i=1;i<=3;i++){
    harta[x1][y1]=219;
    y1--;}
y1++;
harta[x1-1][y1]=219;
if(ok==1)
    harta[x1-1][y1+1]=219;
if(ok==2)
 harta[x1-1][y1+1]='G';
if(ok==3)
     harta[x1-1][y1+1]='C';

}
int stergere_bloc(int x,int y){
int x1,y1,i;



x1=3*x-2;
y1=3*y-2;
for(i=1;i<=3;i++){
    harta[x1][y1]=' ';
    y1++;}
y1--;
for(i=1;i<=3;i++){
    harta[x1][y1]=' ';
    x1++;}
x1--;

for(i=1;i<=3;i++){
    harta[x1][y1]=' ';
    y1--;}
y1++;
harta[x1-1][y1]=' ';
harta[x1-1][y1+1]=' ';

}




int afisare_harta(){
int i,j;
for(i=1;i<=n;i++){
    for(j=1;j<=m;j++)
    cout<<harta[i][j];
cout<<endl;}

}
int spawn_man(int x,int y){
    int x1,y1;
x1=3*x-1;
y1=3*y-1;
harta[x1-1][y1]=254;
harta[x1][y1]=219;
harta[x1+1][y1]=239;
x_om=x;
y_om=y;

}

int cadere(){
    char c;
    stergere_bloc(x_om,y_om);
    spawn_man(x_om+1,y_om);
    system("cls");
  afisare_harta();



}

int main(){
int i,j;
for(i=1;i<=n;i++)
    for(j=1;j<=m;j++)
harta[i][j]=' ';

for(i=1;i<=m/3;i++){
construire_bloc(4,i,1);
construire_bloc(9,i,1);}
stergere_bloc(4,2);

spawn_man(x_om,y_om);
afisare_harta();

while(mort!=1){
        int ox=x_om,oy=y_om;


Sleep(10);


         if(_kbhit())
        {
            char ch = getch();
            switch (ch)
            {
            case 'a':
            {
                oy--;

                break;
            }
            case 'd':
            {
                oy++;

                break;
            }
            case 'w':
            {
                ox--;

                break;
            }
            case 's':
            {
                ox++;
                break;
            }
            case 't':
            {
                int x,y;
                cout<<"unde doriti sa va teleportati?";
                cin>>x;
                cin>>y;
                ox=x;
                oy=y;
                break;
            }
            }
/*
if(harta[ox*3][oy*3]==' '){
    */
            stergere_bloc(x_om,y_om);
            spawn_man(ox,oy);
            system("CLS");
            afisare_harta();
            cout<<x_om<<"--"<<y_om;
/*
}
else{
    ox=x_om;
    oy=y_om;
}
*/
        }

if(harta[x_om*3+1][y_om*3]==' '){
cadere();
 cout<<">>"<<harta[x_om*3+1][y_om*3]<<"<<"<<endl;
}



}


}

