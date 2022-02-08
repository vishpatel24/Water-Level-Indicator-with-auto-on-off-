# Water(Fluid)-Level-Indicator-with-auto-on-off-
It's Water level indicator which uses ultrasonic sensor and shows status on android app over the internet. It also can turn water motor on-off automatically and manually. 

Components 
Ultrasonic sensor
NodeMCU
Relay switch
Cables 


Step 1: Connect ultrasonic sensor and Relay switch with nodeMCU.
Step 2: check the connection via simple data read from ultrasonic and simple on off oprations on Relay switch.
Step 3: deploy main_node_code_final.ino file into NodeMCU using Arduno IDE, make changes according to your wifi network, so nodeMCU can connect to your wifi network.
Step 4: install Android app on any android phone and give asked permission.

System should be ready to work.


Functionalities:

1) Ultrasonic sensor reads the depth of fluid in tank.
      1.1) If system is in auto mode --> checks the condition and check the switch status, and changes if required 
      1.2) Sends the data to thingspeak server.
      
2) Android app fatches the data from thingspeak server and displays the fluid level inside the tank, and updates Switch on/off status repetadly. 
3) Android app can also change the mode of the switch(Auto/Manual) via toggal button. 

Auto Mode:
  If fluid level goes below 10%, switch turns on automatically, and when reaches 90% it turns off switch automatically, even if android app is not connected.
  
Manual mode:
  Dosnt's relay on sensor's data, user can turn it ON or OFF whenever he wants using the android app.
  
 Modes can be changed via Android app, and both the android phone and NodeMCU does not need to be in one network to run functions, both devices must have to have internet for changing the mode, once mode is changed, NodMCU can run offline completely. 
