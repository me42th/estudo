/*
  Blink
  Turns on an LED on for one second, then off for one second, repeatedly.

  Most Arduinos have an on-board LED you can control. On the Uno and
  Leonardo, it is attached to digital pin 13. If you're unsure what
  pin the on-board LED is connected to on your Arduino model, check
  the documentation at http://www.arduino.cc

  This example code is in the public domain.

  modified 8 May 2014
  by Scott Fitzgerald
 */


// the setup function runs once when you press reset or power the board




#define LED_VERDE 9
#define LED_VERMELHO 11 
#define BOTAO 13

int estadoVermelho = 0,contVermelho = 0;
int estadoVerde = 0,contVerde = 0;
int contador = 0;

void setup() 
{
    pinMode(LED_VERDE,OUTPUT);
    pinMode(LED_VERMELHO,OUTPUT);
    pinMode(BOTAO,INPUT_PULLUP);
    randomSeed(analogRead(0));
    int aleatorio = random(10)%2;
    estadoVermelho = aleatorio == 0?1:0;
    estadoVerde = aleatorio != 0?1:0;
    Serial.begin(9600);
      // Open serial communications and wait for port to open:
  Serial.begin(9600);

}

// the loop function runs over and over again forever

void loop()
  {
        int contTempo = 0;   
    Serial.println("--------------Wait--------------");
    while(contTempo < 30)
      {
       Serial.print("[]");
       contTempo++;
       delay(100);
       if(digitalRead(BOTAO) != HIGH)
          { 
            Serial.println(" "); 
            placar();
            break;
          } 
       }
    Serial.println(" ");   
    Serial.print("--------------Exec");
    Serial.print(contador++,DEC);
    Serial.println("--------------");

    digitalWrite(LED_VERDE,estadoVerde);
    digitalWrite(LED_VERMELHO,estadoVermelho);
    Serial.print("Verde ");
    Serial.println(estadoVerde,DEC);
    Serial.print("Vermelho ");
    Serial.println(estadoVermelho,DEC);
    inverteLampada();
    delay(500);
    
    
  }
void placar(){
    Serial.println("-------------Score--------------");
    digitalWrite(LED_VERMELHO,LOW);
    digitalWrite(LED_VERDE,LOW);
    if(contVermelho > contVerde) Serial.println("Vermelho Vencendo");
    else if (contVermelho < contVerde) Serial.println("Verde Vencendo");
    else Serial.println("Empate");
    Serial.print("Vermelho :");
    Serial.println(contVermelho,DEC);
    Serial.print("Verde :");
    Serial.println(contVerde,DEC);
    Serial.println("--------------Wait--------------");
    while(digitalRead(BOTAO) == HIGH){
      delay(100);
    }    
  }
void inverteLampada()
{
    int aleatorio = random(10) % 2;
    estadoVerde = (aleatorio == 0?1:0);
    contVerde += estadoVerde;
    estadoVermelho = (aleatorio != 0?1:0);
    contVermelho += estadoVermelho;
}
