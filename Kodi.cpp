#include <iostream>
#include <string>
#include <cstring>
#include <cstdio>
#include <stdlib.h>
#include <windows.h>

using namespace std;

char tapcode[5][5] = {{'a','b','c','d','e'},{'f','g','h','i','j'},{'l','m','n','o','p'},{'q','r','s','t','u'},{'v','w','x','y','z'}};

string returntaps(int n, int tap)
{
    string subtap = "";
    for(int i=1; i <= (n*tap); i++){
        subtap = subtap + ".";
    }
    return subtap;
}

string convertfortap(char c, int ntap)
{
    char letra = tolower(c);
    string tap = "";
    for(int i=0; i < 5; i++){
        for(int j=0; j < 5; j++){
            if(tapcode[i][j] == letra)
            {
                tap = returntaps(i+1, ntap) + " " + returntaps(j+1, ntap) + " ";
            }
        }
    }
    return tap;
}

int main(int argc, char*argv[]){

   SetConsoleTitle("ds");
   
   if(argv[1][0] == 'c'){

    if (argv[2][0] == 'e'){
        // encryption
        string msg = argv[3];


        int key = atoi(argv[4]);


        string encryptedText = msg;

        for (int i = 0; i < msg.size(); i ++){

            if(msg[i]==32){
                continue; 
            } else {

                if((msg[i]+key) > 122) {
                   
                    int temp = (msg[i] + key) - 122;
                    encryptedText[i] = 96 + temp;
                } else if (msg[i] + key > 90 && msg[i] <= 96){
                    
                    int temp = (msg[i] + key) - 90;
                    encryptedText[i] = 64 + temp;
                } else {
                    
                    encryptedText[i] += key;
                }

            } 
        }
        cout << endl;
        cout << "Mesazhi i enkriptuar: " << encryptedText;

    } else if (argv[2][0] == 'd'){
        

        string encpMsg = argv[3];


        int dcyptKey = atoi(argv[4]);


        string decryptedText = encpMsg;

        for (int i = 0; i < encpMsg.size(); i++){
            if(encpMsg[i]==32){
                continue;
            } else {
                if((encpMsg[i] - dcyptKey) < 97 && (encpMsg[i] - dcyptKey) > 90){
                    int temp = (encpMsg[i] - dcyptKey) + 26;
                    decryptedText[i] = temp;
                } else if((encpMsg[i] - dcyptKey) < 65){
                    int temp = (encpMsg[i] - dcyptKey) + 26;
                    decryptedText[i] = temp;
                } else {
                    decryptedText[i] = encpMsg[i] - dcyptKey;
                }
            }
        }
        cout << endl;
        cout << "Mesazhi i dekriptuar: " << decryptedText << endl;

    } else {
        cout << "Zgjedhje e gabuar";
    }

    }
  
else if(argv[1][0] == 'k'){


if(argv[2][0] == 'U'){
string teksti = argv[3];


string result = "";
cout << endl;

for(int i=0 ; i<teksti.size() ; i++){

    if(teksti[i] >= 'a' && teksti[i] <='z'){

        result +=(char)(teksti[i] - 32);

    }
    else{

        result +=teksti[i];

    }

}

cout << "Uppercase: " << result;
}
else if(argv[2][0] == 'L'){


string teksti1 = argv[3];



string result1 = "";
for(int i=0 ; i<teksti1.size(); i++){
    if(teksti1[i]>='A' && teksti1[i]<='Z'){
        result1 +=(char)(teksti1[i] + 32);

    }
    else{

        result1+=teksti1[i];

    }

}
cout << endl;

cout << "Lowercase: " << result1 << endl;

}
else if(argv[2][0] =='I'){

string teksti2 = argv[3];

string result2 = "";
for(int i=0; i<teksti2.size(); i++){

    if(teksti2[i]>='a' && teksti2[i]<='z'){

        result2 += (char)(teksti2[i] - 32);
    }
    else if(teksti2[i]>='A' && teksti2[i]<='Z'){

        result2+=(char)(teksti2[i] + 32);

    }
    else {

        result2 += teksti2[i];

    }

}

cout << "Inverse: " << result2 << endl;

}
else if(argv[2][0]=='C'){

string teksti3 = argv[3];


teksti3[0] = toupper(teksti3[0]);

   for (int i = 1; i < teksti3.size(); i++)
   {
        if ( teksti3[i - 1] == ' ' ){
            teksti3[i] = toupper( teksti3[i] );
        }
        else{
            teksti3[i] = tolower(teksti3[i]);
        }
   }
   cout << "Capitalize: " << teksti3 << endl;
   cout << endl << endl;
}
else {

    cout << "Duhet te zgjedhni numra 1, 2, 3 ose 4 e jo tjere!";

}
}

