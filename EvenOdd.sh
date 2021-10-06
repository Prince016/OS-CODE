#!/bin/sh
echo -n "Enter a number:- "
read n
echo -n "No is :-  "
if [ `expr $n % 2` == 0 ]
then
	echo "$n is even"
else
	echo "$n is Odd"
fi
