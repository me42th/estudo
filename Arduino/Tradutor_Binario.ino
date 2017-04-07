#define BIT_1 2
#define BIT_2 3
#define BIT_3 4
#define BIT_4 5
#define BOTAO 7
#define LED_SUPERIOR 12
#define LED_INFERIOR 10

void setup() {
pinMode(LED_SUPERIOR,OUTPUT);
pinMode(BOTAO,INPUT_PULLUP);
pinMode(BIT_1,INPUT_PULLUP);
pinMode(BIT_2,INPUT_PULLUP);
pinMode(BIT_3,INPUT_PULLUP);
pinMode(BIT_4,INPUT_PULLUP);
pinMode(LED_INFERIOR,OUTPUT);
Serial.begin(9600);
}


void loop() {
if(digitalRead(BOTAO)!= HIGH){
saida(leitura());
  delay(1000);
}
delay(100);
}

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

int leitura(){
  int retorno = 0;
  String temp = "";
  int bit1 = digitalRead(BIT_1) == 1?0:1;
  temp.concat(String(bit1));
  int bit2 = digitalRead(BIT_2) == 1?0:1;
  temp.concat(String(bit2));
  int bit3 = digitalRead(BIT_3) == 1?0:1;
  temp.concat(String(bit3));
  int bit4 = digitalRead(BIT_4) == 1?0:1;
  temp.concat(String(bit4));
  return binDec(temp.toInt());
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
