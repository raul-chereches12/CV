#include <iostream>
#include "header.h"
#include <stdlib.h>
#include <time.h>
using namespace std;
/*
//5
//bulls and cows;

int ok;

int checking(vector<int> v1,vector<int> v2)
{
int cows=0,bulls=0,okay;

for(int i=0;i<4;i++)
    for(int j=0;j<4;j++)
    if(v1[i]==v2[j]){
    if(i==j) bulls++;
    else cows++;
    }

    cout<<"we have "<<bulls<<" bulls and we have "<<cows<<" cows"<<endl;

if((bulls==4)&&(cows==0))
    ok=1;
}

int main(){
    int nr;
    vector<int> v1,v2;
    srand(time(NULL));

for(int i=1;i<=4;i++){
    nr=rand()%10;

if(i>1){
ok=0;
    while(ok==0){
            ok=1;
    for(int j=0;j<i-1;j++)
        if(nr==v1[j])
        ok=0;

    if(ok==0)
   nr=rand()%10;
    }

}

v1.push_back(nr);

}



ok=0;
while(ok==0){

for(int i=0;i<=3;i++)
cout<<v1[i]<<" ";

cout<<endl;

    cout<<"Guess the 4-digits number";
v2.clear();
    for(int i=1;i<=4;i++){
        cout<<"["<<i<<"]=";
            cin>>nr;
            cout<<endl;
        v2.push_back(nr);
    }

    checking(v1,v2);




}
cout<<endl;
cout<<"you guessed the number!!!!";

}

*/
///6
//calculator

//
// This is example code from Chapter 6.6 "Trying the first version" of
// "Software - Principles and Practice using C++" by Bjarne Stroustrup
//



//------------------------------------------------------------------------------

class Token {
public:
    string kind;        // what kind of token
    double value;     // for numbers: a value
    Token(string ch)    // make a Token from a char
        :kind(ch), value(0) { }
    Token(char ch, double val)     // make a Token from a char and a double
        :kind(ch), value(val) { }
};

//------------------------------------------------------------------------------
/*
Token get_token()    // read a token from cin
{
    char ch;
    cin >> ch;    // note that >> skips whitespace (space, newline, tab, etc.)
    switch (ch) {
 //not yet   case ';':    // for "print"
 //not yet   case 'q':    // for "quit"
    case '(': case ')': case '+': case '-': case '*': case '/':
        return Token(ch);        // let each character represent itself
    case '.':
    case '0': case '1': case '2': case '3': case '4':
    case '5': case '6': case '7': case '8': case '9':
        {
            cin.putback(ch);         // put digit back into the input stream
            double val;
            cin >> val;              // read a floating-point number
            return Token('8',val);   // let '8' represent "a number"
        }
    default:
        error("Bad token");
    }
}
*/
//------------------------------------------------------------------------------
int fact(int nr){
    int prod=1;
if(nr==0)
    return 1;

for(int i=1;i<=nr;i++)
    prod=prod*i;
    return prod;

}
class Token_stream {
    public:
        Token get();            // get a Token
        void putback(Token t);  // put a Token back
    private:
        bool full {false};      // is there a Token in the buffer?
        Token buffer = {'0'};           // where we store a 'putback' Token
};

void Token_stream::putback(Token t)
{
    if (full) error("putback() into a full buffer");
    buffer = t;         // copy t to buffer
    full = true;        // buffer is now full
}

Token Token_stream::get()
{
    if (full) {
        full = false;
        return buffer;
    }
    string str;
    cin >> str;

    switch (str) {
        case "and":       // for "print"
        case "or":       // for "quit"
        case "but":
        case "birds":
        case "fish":
        case "c++":
        case "rules":
        case "fly":
        case "swim":
            return Token{ch};   // let each character represent itself
        case '.':
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
                cin.putback(ch);
                double val;
                cin >> val;
                return Token{'8', val};
            }
        default:
            error("Bad Token");
    }
}

//------------------------------------------------------------------------------

Token_stream ts;      // provides get() and putback()

//------------------------------------------------------------------------------

double expression();  // read and evaluate a Expression

//------------------------------------------------------------------------------

double term();        // read and evaluate a Term

//------------------------------------------------------------------------------
int factorial();
//------------------------------------------------------------------------------

string verb()     // read and evaluate a Primary
{
    Token t = ts.get();
    switch (t.kind) {
    case "rules":
    case "swim":
    case "fly":          // we use '8' to represent a number
        return t.kind;  // return the number's value
    default:
        error("verb expected");
    }
}
//------------------------------------------------------------------------------

int main()
try {
    while (cin)
        cout << expression() << '\n';
    keep_window_open("~0");
}
catch (exception& e) {
    cerr << e.what() << endl;
    keep_window_open ("~1");
    return 1;
}
catch (...) {
    cerr << "exception \n";
    keep_window_open ("~2");
    return 2;
}

//------------------------------------------------------------------------------

string sentence()
{
    string left = term();      // read and evaluate a Term
    Token t = ts.get();        // get the next token
    while(true) {
        switch(t.kind) {
        case '+':
            left += term();    // evaluate Term and add
            t = ts.get();
            break;
        case '-':
            left -= term();    // evaluate Term and subtract
            t = ts.get();
            break;
        default:
            ts.putback(t);
            return left;       // finally: no more + or -: return the answer
        }
    }
}

//------------------------------------------------------------------------------

string conjunction()
{
    string left = factorial();
    Token t = ts.get();     // get the next token

    while(true) {
        switch (t.kind) {
        case '*':
            left *= factorial();
            t = ts.get();
            break;
        case '/':
            {
                double d = factorial();
                if (d == 0) error("divide by zero");
                left /= d;
                t = ts.get();
                break;
            }
        default:
            ts.putback(t);
            return left;
        }
    }
}
string noun()
{
    double left = primary();
    Token t = ts.get();     // get the next token

    while(true) {
        switch (t.kind) {
        case '!':
          return fact(left);
            break;

        default:
            ts.putback(t);
            return left;
        }
    }
}

//------------------------------------------------------------------------------

