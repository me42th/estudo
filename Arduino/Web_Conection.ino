/*
  Web client

 This sketch connects to a website (http://www.google.com)
 using an Arduino Wiznet Ethernet shield.

 Circuit:
 * Ethernet shield attached to pins 10, 11, 12, 13

 created 18 Dec 2009
 by David A. Mellis
 modified 9 Apr 2012
 by Tom Igoe, based on work by Adrian McEwen

 */

#include <SPI.h>
#include <Ethernet.h>

#define ID 42618 
#define BIT_1 7
#define BIT_2 6
#define BIT_3 5
#define BIT_4 2
#define BOTAO_1 8
#define BOTAO_2 9
#define LED_1 18
#define LED_2 19

// Enter a MAC address for your controller below.
// Newer Ethernet shields have a MAC address printed on a sticker on the shield
byte mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };
// if you don't want to use DNS (and reduce your sketch size)
// use the numeric IP instead of the name for the server:
// http://localhost:8080/arduino/insert?v1=3&v2=2
//IPAddress server(192,168,15,3);  // numeric IP for Google (no DNS)
char server[] = "192.168.15.3";    // name address for Google (using DNS)
//Ative todos os bits para ativar debug e acompanhar exec do cód via serial
int debug = 0;
int v1 = -1,v2 = -1,cod = 0;
String resultado = "";
// Set the static IP address to use if the DHCP fails to assign
IPAddress ip(192, 168, 15, 42);

// Initialize the Ethernet client library
// with the IP address and port of the server
// that you want to connect to (port 80 is default for HTTP):
EthernetClient client;

void setup() 
{
  //Portas digitais e serial
  pinMode(LED_1,OUTPUT);
  pinMode(LED_2,OUTPUT);
  pinMode(BOTAO_1,INPUT_PULLUP);
  pinMode(BOTAO_2,INPUT_PULLUP);
  pinMode(BIT_1,INPUT_PULLUP);
  pinMode(BIT_2,INPUT_PULLUP);
  pinMode(BIT_3,INPUT_PULLUP);
  pinMode(BIT_4,INPUT_PULLUP);
  if(leitura() == 15){Serial.println("//DEBUG_ON\\");Serial.println("<<DEBUG_ON>>");Serial.println("<<<<DEBUG_ON>>>>");Serial.println("<<<<<DEBUG_ON>>>>>");Serial.println("<<<<<<<DEBUG_ON>>>>>>>");debug =1;}
  if(debug){
  Serial.begin(9600);  Serial.println("-!");  while (!Serial) {/* wait for serial port to connect. Needed for native USB port only  */}  
  }
  
  // Ethernet:
  Ethernet.begin(mac, ip);
  // give the Ethernet shield a second to initialize:
  if(debug){  Serial.print("Shield(10s): ");  for(int cont = 1; cont <= 10; cont++){  Serial.print(cont,DEC);  if(cont != 10) Serial.print(",");  else Serial.println("!");  delay(1000);  } Serial.println("-b1,insert"); Serial.println("-b2,select"); }
}
/*  Serial.println("connecting...");

  // if you get a connection, report back via serial:
  
  if (client.connect(server, 80)) {
    Serial.println("connected");
    // Make a HTTP request:
    client.println("GET /arquivo.php?v1=funciona&v2=porra HTTP/1.1");
    client.println("Host: 192.168.15.3");
    client.println("Connection: close");
    client.println();
  } else {
    // if you didn't get a connection to the server:
    Serial.println("connection failed");
  }
   client.stop();
*/


/*
void saida(int total){
  for(int cont = 0; cont < total; cont++){
    digitalWrite(LED_SUPERIOR,HIGH);
    digitalWrite(LED_INFERIOR,HIGH);
    delay(700);
    digitalWrite(LED_SUPERIOR,LOW);
    digitalWrite(LED_INFERIOR,LOW);
    delay(500);   
   }
 }
*/



void loop() {
  // if there are incoming bytes available
  // from the server, read them and print them:
 digitalWrite(LED_1,HIGH);
 digitalWrite(LED_2,HIGH);
  if(cod)
  {
  if(debug){ Serial.print("-cod ");Serial.println(String(cod));}
  if (client.available()) {
    char c = client.read();
    if(debug){ Serial.println("client.available()");Serial.print("-c ");Serial.println(String(c));}
    resultado.concat(String(c));
    if(debug){ Serial.print("-resultado ");Serial.println(resultado);}
  }
  // if the server's disconnected, stop the client:
  if (!client.connected())
  {
    if(debug){ Serial.println("!client.connected()");}
    Serial.println();
    Serial.println("disconnecting.");
    client.stop();
    contador(resultado.toInt(),2000);
    resultado = "";
    cod = 0;
  }

    
    return;
 } else {
  if(digitalRead(BOTAO_1)!= HIGH)
 {  
    if(debug){ Serial.println("INSERT");}
    delay(1000);
    insert();
    if(debug){Serial.println("disconnecting.");}
    client.stop();
 } else if(digitalRead(BOTAO_2)!= HIGH)
 {  
    if(debug){ Serial.println("SELECT");}
    delay(1000);
    sinal(250,2);
    select();
//    if(debug){Serial.println("disconnecting.");}
//    client.stop();
 }
 }
 }
 /* if (client.available()) {
    char c = client.read();
   // Serial.print(c);
  }

  // if the server's disconnected, stop the client:
  if (!client.connected()) {
    Serial.println("--------------");
    Serial.println("disconnecting.");
    client.stop();

    // do nothing forevermore:
    
  }
  */

void select(){
int flag =1;  
while(true){
if(flag){sinal(250,2);}   
   if(digitalRead(BOTAO_1)!= HIGH)
   {
    flag = 0;  
    if(debug){ Serial.println("sendToServer(\"select\",\"v1\",String(leitura()))");}
    delay(200); 
    digitalWrite(LED_2,LOW);
    digitalWrite(LED_1,HIGH);
    delay(1000);
    sendToServer("select","v1",String(leitura()));
    cod = 1;
    return;    
 } else if(digitalRead(BOTAO_2)!= HIGH)
 {  
    flag = 0;
    if(debug){ Serial.println("sendToServer(\"select\",\"v2\",String(leitura()))");}
    delay(200);
    digitalWrite(LED_1,LOW);
    digitalWrite(LED_2,HIGH);
    delay(1000);
    sendToServer("select","v2",String(leitura()));
    cod = 1;
    return;
 }
 }
}
void insert(){
  while(v1 == -1 || v2 == -1)
    { 
      if(v1 == -1 && v2 == -1){sinal(250,1);}
      if(digitalRead(BOTAO_1)!= HIGH)
      {
        v1 = leitura();
        if(debug){ Serial.print("-B1 "); Serial.println(v1,DEC); }
        delay(200);
        digitalWrite(LED_2,LOW);
        digitalWrite(LED_1,HIGH);
        delay(1000);
      }
       else if(digitalRead(BOTAO_2)!= HIGH)
      {
        v2 = leitura();
        if(debug){ Serial.print("-B2 "); Serial.println(v2,DEC);}
        delay(200);
        digitalWrite(LED_1,LOW);
        digitalWrite(LED_2,HIGH);
        delay(1000);
      }
      if(v1 != -1 && v2 != -1)
      {     
        if(sendToServer("insert",String(v1),String(v2))){
          sinal(50,1);
          sinal(100,1);
          sinal(200,1);  
          sinal(300,1);
          }
        else
          {
          sinal(50,2);
          sinal(100,2);  
          sinal(200,2);
          sinal(300,2); 
          }
      }       
 }
  digitalWrite(LED_1,LOW);
  digitalWrite(LED_2,LOW);
  v1 =-1;
  v2 =-1;
 if(debug){ Serial.print("-if,v1 "); Serial.println(v1,DEC); Serial.print("-if,v2 "); Serial.println(v2,DEC);}        
}
//int receiveFromServer()
//{
  

//}

int sendToServer(String action,String valor1,String valor2)
{
    if (client.connect(server, 80)) {
    if(debug){Serial.println("connected");}
    // Make a HTTP request:
    String URL = "GET /arquivo.php?action=";URL.concat(action);URL.concat("&v1=");URL.concat(valor1);URL.concat("&v2=");URL.concat(valor2);URL.concat("&ID=");URL.concat(String(ID));
    if(debug){Serial.println(URL);}
    client.println(URL);
    client.println("Host: 192.168.15.3");
    client.println("Connection: close");
    client.println();
    return 1;
  } else {
    // if you didn't get a connection to the server:
    if(debug){Serial.println("connection failed");}
    return 0;
  }
}

//Alternado tipo->2, Simétrico tipo->1  
void sinal(int pausa,int tipo)
{
   int estado_1 = (10%tipo)==0?1:0;
   int estado_2 = (5%tipo)==0?1:0;
   pausa = ((5%tipo == 0)&&(10%tipo == 0))?(int)(pausa/2):pausa;    
   digitalWrite(LED_1,estado_1);
   digitalWrite(LED_2,estado_2);
   delay(pausa);
   if((5%tipo == 0)&&(10%tipo == 0))
    {
      digitalWrite(LED_1,LOW);
      digitalWrite(LED_2,LOW);
      delay(pausa);
     }
   digitalWrite(LED_1,estado_2);
   digitalWrite(LED_2,estado_1);
   delay(pausa);
   if((5%tipo == 0)&&(10%tipo == 0))
    {
      digitalWrite(LED_1,LOW);
      digitalWrite(LED_2,LOW);
      delay(pausa);
     }
   digitalWrite(LED_1,estado_1);
   digitalWrite(LED_2,estado_2);
   delay(pausa);
   if((5%tipo == 0)&&(10%tipo == 0))
    {
      digitalWrite(LED_1,LOW);
      digitalWrite(LED_2,LOW);
      delay(pausa);
     }
   digitalWrite(LED_1,estado_2);
   digitalWrite(LED_2,estado_1);
 }
void contador(int resp,int pausa){
  if(debug){  Serial.print("-resp "); Serial.println(resp,DEC);}

  for(int cont = 0;cont < resp;cont++)
    {
      digitalWrite(LED_1,HIGH);
      digitalWrite(LED_2,HIGH);
      delay(pausa);
      digitalWrite(LED_1,LOW);
      digitalWrite(LED_2,LOW);
      delay(pausa);
    }
  } 
 int leitura(){
  String temp = "";
  int bit1 = digitalRead(BIT_1) == 1?0:1;
  temp.concat(String(bit1));
  if(debug){ Serial.print("-bit1 ");  Serial.println(bit1,DEC);}
  int bit2 = digitalRead(BIT_2) == 1?0:1;
  temp.concat(String(bit2));
  if(debug){Serial.print("-bit2 ");  Serial.println(bit2,DEC);}
  int bit3 = digitalRead(BIT_3) == 1?0:1;
  temp.concat(String(bit3));
  if(debug){ Serial.print("-bit3 ");  Serial.println(bit3,DEC);}
  int bit4 = digitalRead(BIT_4) == 1?0:1;
  temp.concat(String(bit4));
  if(debug){ Serial.print("-bit4 ");Serial.println(bit4,DEC);Serial.print("-temp ");Serial.println(temp);Serial.print("-read ");Serial.println(binDec(temp.toInt()),DEC);}            
  
  return binDec(temp.toInt());;
}
  
int binDec(int bin)
{
    int total  = 0;
    int potenc = 1;
    while(bin > 0) {
        total += bin % 10 * potenc;
        bin    = bin / 10;
        potenc = potenc * 2;
       }
    return total;
}   
