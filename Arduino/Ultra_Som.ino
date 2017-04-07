const int trigPin = 5;
const int echoPin = 7;
void setup() {
  Serial.begin(9600);
  pinMode(trigPin,OUTPUT);
  pinMode(echoPin, INPUT);

}

void loop() {
  
  digitalWrite(trigPin,LOW);
  delayMicroseconds(2);
  digitalWrite(trigPin,HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin,LOW);
  Serial.print("Distancia: ");
  //resultado
  Serial.print(pulseIn(echoPin,HIGH)/58);
  Serial.println(" cm");
 // delay(1000);
}
