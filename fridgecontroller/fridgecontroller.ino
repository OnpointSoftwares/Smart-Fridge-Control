/* DHT11 temperature and humidity sensor
 */
#include <Servo.h> 
#define dht_dpin 4
Servo servo;
int state = 0;
int angle = 10;
byte bGlobalErr;
byte dht_dat[5];

void setup(){
InitDHT();
servo.attach(9);
servo.write(angle);
Serial.begin(9600);
delay(300);
Serial.println("Humidity and temperature\n\n");
delay(700);
}

void loop(){
  ReadDHT();
 Serial.print("Current humdity = ");
 Serial.print(dht_dat[0], DEC);
 Serial.print(".");
 Serial.print(dht_dat[1], DEC);
 Serial.print("%  ");
 Serial.print("temperature = ");
 Serial.print(dht_dat[2], DEC);
 Serial.print(".");
 Serial.print(dht_dat[3], DEC);
 Serial.println("C  ");
       digitalWrite(5,HIGH);
       servoControl();
if(Serial.available() > 0)
{ // Checks whether data is comming from the serial port
    state = Serial.read(); 
    
}
Serial.print(state);
  delay(800);
}

void InitDHT(){
   pinMode(dht_dpin,OUTPUT);
        digitalWrite(dht_dpin,HIGH);
}
void servoControl()
{
   
 // scan from 0 to 180 degrees
  for(angle = 10; angle < 180; angle++)  
  {                                  
    servo.write(angle);               
    delay(15);                   
  } 
  // now scan back from 180 to 0 degrees
  for(angle = 180; angle > 10; angle--)    
  {                                
    servo.write(angle);           
    delay(15);       
  } 
}
void ReadDHT(){
bGlobalErr=0;
byte dht_in;
byte i;
digitalWrite(dht_dpin,LOW);
delay(20);

digitalWrite(dht_dpin,HIGH);
delayMicroseconds(40);
pinMode(dht_dpin,INPUT);
//delayMicroseconds(40);
dht_in=digitalRead(dht_dpin);

if(dht_in){
   bGlobalErr=1;
   return;
   }
delayMicroseconds(80);
dht_in=digitalRead(dht_dpin);

if(!dht_in){
   bGlobalErr=2;
   return;
   }
delayMicroseconds(80);
for (i=0; i<5; i++)
   dht_dat[i] = read_dht_dat();
pinMode(dht_dpin,OUTPUT);
digitalWrite(dht_dpin,HIGH);
byte dht_check_sum =
       dht_dat[0]+dht_dat[1]+dht_dat[2]+dht_dat[3];
if(dht_dat[4]!= dht_check_sum)
   {bGlobalErr=3;}
};

byte read_dht_dat(){
  byte i = 0;
  byte result=0;
  for(i=0; i< 8; i++){
      while(digitalRead(dht_dpin)==LOW);
      delayMicroseconds(30);
      if (digitalRead(dht_dpin)==HIGH)
     result |=(1<<(7-i));
    while (digitalRead(dht_dpin)==HIGH);
    }
  return result;
 if (state == '0') {
  digitalWrite(5, LOW); // Turn LED OFF
  Serial.println("LED: OFF"); // Send back, to the phone, the String "LED: ON"
  state = 0;
 }
 else if (state == '1') {
  digitalWrite(5, HIGH);
  Serial.println("LED: ON");;
  state = 0;
 } 
}