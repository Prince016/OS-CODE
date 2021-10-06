#!/bin/sh
grossSalary=0
da=0
ta=0
echo "enter your basic salary"
read basic

da=$(((10/100)*$basic))






ta=$(((15*$basic)/100))

grossSalary=$(($basic+$da+$ta))

echo "grossSalary of person =$grossSalary"

