
#include <ESP8266WiFi.h>

#include <ESP8266HTTPClient.h>
#include <ThingSpeak.h>;
WiFiClient client;


long ultrason_2() {
   long duration, distance;
   digitalWrite(2,LOW);
   delayMicroseconds(2);
   digitalWrite(2, HIGH);   delayMicroseconds(10);
   digitalWrite(2, LOW);
   duration = pulseIn(0, HIGH);
   distance = (duration/2) / 29.1;
   return distance;
}

String thingSpeakAddress= "http://api.thingspeak.com/update?";
String writeAPIKey;
String tsfield1Name;
String request_string;
String str1;
HTTPClient http;
const char * myWriteAPIKey = "DEGGNHXTH6YL7FD8";
const char * myReadAPIKey = "6RNLHYT3JQMDTTHS";
const char * ch2 = "GDWXF4C1BAZE2XE1";
void setup()
{
   
  pinMode(2, OUTPUT);
pinMode(0, INPUT);
  WiFi.disconnect();
   WiFi.begin("Jay Maharaj","Apexap2018");
  while ((!(WiFi.status() == WL_CONNECTED))){
    delay(300);
Serial.begin(9600);
 pinMode(LED_BUILTIN, OUTPUT); 

  }
 
ThingSpeak.begin(client);

}

 



void loop()
{
  long data =  ultrason_2();
  
    ThingSpeak.writeField(741025, 1,data, myWriteAPIKey);
    delay(3000);

String n = ThingSpeak.readStringField(759216,1,ch2);
String n1 = ThingSpeak.readStringField(759216,2,ch2);
Serial.print(n);
   delay(200);
   Serial.print(n + "  ");
   Serial.print(n1 + "  ");
   
    if(n=="1" && data<10){
      digitalWrite(LED_BUILTIN, LOW);
              
      }else if(n=="1" && data>90){
      digitalWrite(LED_BUILTIN, HIGH);
      }else if(n == "0" && n1 == "0"){
      digitalWrite(LED_BUILTIN, HIGH);
      }else if(n == "0" && n1 == "1"){
        digitalWrite(LED_BUILTIN, LOW);
        
      }
      }

      

   

    
