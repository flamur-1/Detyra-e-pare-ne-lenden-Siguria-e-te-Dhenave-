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
//function to encrypt the plain text
string encrypt(string x,int n)
    {
    string cipher="";

    for(int i=0;i<x.length();i++)
        {
        if(isupper(x[i]))
            cipher += (x[i] + n - 65)%26 + 65;
        else if(islower(x[i]))
            cipher += (x[i] + n - 97)%26 + 97;
        else
            cipher += x[i];
        }
    return cipher;
    }

//function to decrypt the cipher text using brute force attack
void decrypt(string x)
    {
    string text;
    for(int n=0;n<26;n++)
        {
        text = "";
        for(int i=0;i<x.length();i++)
            {
            if(isupper(x[i]))
                {
                if((x[i] - n - 65)<0)
                    text += 91 + (x[i] - n - 65);
                else
                    text += (x[i] - n - 65)%26 + 65;
                }
            else if(islower(x[i]))
                {
                if((x[i] - n - 97) < 0)
                    text += 123 + (x[i] - n - 97);
                else
                    text += (x[i] - n - 97)%26 + 97;
                }
            else
                text += x[i];
            }
        cout << "plain text for key " << n << " :- " << text << endl;
        }
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

    } else if(argv[2][0] == 'b'){
        
        int key = atoi(argv[3]);

string text = argv[4];



 encrypt(text,key);
cout << "cipher text : " << encrypt(text, key) << endl << endl;

decrypt(encrypt(text, key));

    

        
    }
       else{
       
           cout << "Zgjedhje e gabuar!";
       
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
else if(argv[1][0] == 't') {

    string arqin, arqout;
    int ntaps, convert;

       if(argc==6){
        arqin = argv[2];
        arqout = argv[3];
        ntaps = atoi(argv[4]);
        convert = atoi(argv[5]);
       }

    switch(argc)
    {
    case 6:
        if(ntaps < 1) ntaps = 1;
        if(convert == 2)
        {
            cout << "Decoding... Sheno tekstin: ";
            char str;
            int linha = 0;
            int coluna = 0;
            bool alt = false;
            int prox = 0;
            FILE *arqentrada = fopen(arqin.c_str(), "r");
            FILE *arqexit = fopen(arqout.c_str(), "w");
            if(arqentrada)
            {
                while(scanf("%c", &str) != EOF)
                {
                    if(str == '.'){
                        if(alt == false)
                            linha++;
                        else
                            coluna++;
                    }
                    else
                    {
                        if(alt == true) alt = false;
                        else alt = true;
                        prox++;
                    }

                    if(prox == 2)
                    {
                        linha /= ntaps;
                        coluna /= ntaps;
                        printf( "%c", tapcode[linha-1][coluna-1]);
                        linha = coluna = prox = 0;
                    }
                }
                printf("\n");
            }
            fclose(arqentrada);
            fclose(arqexit);
            cout << "OK!" << endl;
        }
        else
        {
            cout << "Coding... Sheno tekstin: ";
            char caracter;
            FILE *arqentrada = fopen(arqin.c_str(), "r");
            FILE *arqexit = fopen(arqout.c_str(), "w");
            if(arqentrada)
            {
                while(scanf( "%c", &caracter) != EOF)
                {
                    if(caracter != 'k')
                        printf( "%s", convertfortap(caracter, ntaps).c_str());
                    else
                        printf("%s", convertfortap('c', ntaps).c_str());
                }
                printf( "\n");
            }
            fclose(arqentrada);
            fclose(arqexit);
            cout << "OK!" << endl;
        }
    break;
    case 2:
        cout << "HELP!" << endl;

    break;

    default:
        cout << "Gabim!" << endl;
    break;
    }
}
    else {
    
    cout << "Zgjedhje e gabuar e argumentit te pare!";
    }

return 0;
}
