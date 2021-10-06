#! /bin/bash
echo " -- Press 8 To  Quit  --"
while :
    do
       read -p 'Enter a number: ' num
      case $num in
        1) echo " Monday";;
        2) echo " Tuesday";;
        3) echo " Wednesday";;
        4) echo " Thursday";;
        5) echo " Friday";;
        6) echo " Saturday";;
        7) echo " Sunday";;
	8) exit;;
        *) echo " Invalid choice ";;
      esac
done
