#include <iostream>
#include <fstream>
#include <windows.h>
#include <conio.h>
#include <stdio.h>
using namespace std;
ifstream f("date.txt");
char hartaMica[30][30];
char hartaMare[200][200];
int inaltimeHartaMica=6,lungimeHartaMica=21,mort=0;

struct pozitie{
int pozX,pozY;

}Om;



void citireHartaMica(){
    int i,j;

string linie;

for(i=1;i<=inaltimeHartaMica;i++){
        getline(f,linie);
        for(j=1;j<=lungimeHartaMica;j++)
           hartaMica[i][j]=linie[j-1];
}


}
int construire_bloc(int x,int y,char material){
int x1,y1,j,i;



x1=3*x-2;
y1=3*y-2;

if(material!=' ')
    material=219;

    for(i=1;i<=3;i++)
    for(j=1;j<=3;j++)
        hartaMare[x1+i-1][y1+j-1]=material;



}
void creareHartaMare(){
int i,j;

for(i=1;i<=inaltimeHartaMica;i++)
    for(j=1;j<=lungimeHartaMica;j++)
        construire_bloc(i,j,hartaMica[i][j]);

}

void colorare(int i,int j){
    char material;
    int i1,j1;
    i1=i;
    j1=j;

    i--;
    j--;
    i=i/3;
    j=j/3;
    i++;
    j++;
    material=hartaMica[i][j];

switch(material){

    case 'P':
    if(i1%3==1){
        SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),2);
    printf("%c",219);
    }
    else {
        SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),6);
    printf("%c",219);
    }
    break;

    case '0':
         printf("%c",' ');
    break;

    case 'W':
         SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),6);
    printf("%c",219);
        break;
        case 'L':
         SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),10);
    printf("%c",219);
        break;
        case 'C':
            if((i1%3==1)&&((j1%3==0)||(j1%3==1))||((i1%3==0)&&((j1%3==0)||(j1%3==1)))){

    printf("%c",' ');
    }
    else{
         SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),1);
    printf("%c",219);
    }
        break;
}
}
void afisareHartaMare(){
    int i,j;

for(i=1;i<=inaltimeHartaMica*3;i++){
    for(j=1;j<=lungimeHartaMica*3;j++)
    colorare(i,j);
    cout<<endl;
}
SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),15);




}
void afisareHartaMica(){
int i,j;
cout<<"harta mica"<<endl;
for(i=1;i<=inaltimeHartaMica;i++){
        for(j=1;j<=lungimeHartaMica;j++){
           printf("%c ",hartaMica[i][j]);
        }
           cout<<endl;
}

}
void cadere(){

hartaMica[Om.pozX][Om.pozY]='0';
Om.pozX++;
hartaMica[Om.pozX][Om.pozY]='C';
system("cls");
afisareHartaMare();

}
void deplasare(){

                int ox=Om.pozX;
                int oy=Om.pozY;
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

            }

            if(hartaMica[ox][oy]=='0'){
                 hartaMica[Om.pozX][Om.pozY]='0';
                    Om.pozX=ox;
                    Om.pozY=oy;
                hartaMica[Om.pozX][Om.pozY]='C';

            }

system("CLS");
afisareHartaMare();
cout<<endl;
afisareHartaMica();




}

int main()
{


int i,j;
citireHartaMica();
//PUNERE OM PE HARTA
Om.pozX=3;
Om.pozY=11;
hartaMica[Om.pozX][Om.pozY]='C';
    //
afisareHartaMare();
cout<<endl;
afisareHartaMica();



//FACEM COPIE LA VARIABILELE DE MISCARE INTRUCAT LA ALEGEREA UNEI DIRECTII TREBUIE FACUT O VERIFICARE DACA SE
//POATE MERGE IN LOCUL ALES SAU NU

while(mort!=1){

     if(_kbhit())
        deplasare();
if(_kbhit())
        deplasare();


    if(hartaMica[Om.pozX+1][Om.pozY]=='0')
cadere();
Sleep(100);




}

}
