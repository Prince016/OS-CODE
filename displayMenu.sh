#!/bin/bash
echo "Menu of Operations "
echo "1: lis of files"
echo "2: process status"
echo "3: Date"
echo "4: users in program"
echo "5: Quit"

while :
do
echo "enter your choice : "
read ch
case $ch in
	1) ls;;
	2) pgrep chrome;;
	3) date;;
	4) uname -user;;
        5) exit;;
	*) echo "invalid Choice";;
	esac
done
	



