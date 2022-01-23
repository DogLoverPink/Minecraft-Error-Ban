# Minecraft-Error-Ban
A whole new spin on banning! Ban players by giving them an error when they try to connect! Minecraft plugin version 1.18.1
# What is it?
Error-Ban plugin is a plugin to ban players from your server, but making it seems like its their fault! when an error-banned palyers tries to connect to your server, they will be met with a fake error message, making it look like they have bad wifi, or the wrong ip addresss or something else. And no matter what they try, they won't ever be able to actually connect!
# Usage:
The only command for this plugin is /errorban. The permission "errorban.use" is required to use this command, and it won't be visible without it.
When you type in the command, there will be 4 sub options to choose from, these should be pretty self explanatory, but I will explain them anyway.
![image](https://user-images.githubusercontent.com/64995932/150690213-df8312f0-cc2b-44dd-acc2-d36adda4605a.png)

**/errorban ban <player/offlineplayer>**:
This is the main command to "Error-Ban" somebody, to use it, just do "/errorban ban username". If the specified player is online, it will kick them with a message saying "Timed Out". If they are offline, it will just prevent any further connections. 

**/errorban unban <error-banned-player>**:
  This is the command to unban a player who had previously been error-banned, the tab complete for this command will be all of the error-banned players, allowing for easy unbanning of players.
  
**/errorban list**:
  This command simply just lists all of the error-banned players, it will print a message in chat will a list of players. 
  
  **/errorban setmessage <newmessage>**:
  This is the command to set the error message when an errorbanned player attempts to join, by default it is set to "Connection refused: no further information", but it can be set to anything you like. The tab complete will suggest some common error messages used by minecraft, but they are not required to use these recomendations.
  ![image](https://user-images.githubusercontent.com/64995932/150690711-6d01f5d5-a933-40f5-85ac-88feb0d5d225.png)
Default (fake) Error Message:
  
![image](https://user-images.githubusercontent.com/64995932/150690733-419e123d-b2ce-4230-98c3-d381b812225a.png)

