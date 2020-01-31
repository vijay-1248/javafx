#!/bin/bash

	state=$(acpi | awk '{print $3}' |tr -d ",") ;
	percentage=$(acpi| awk '{print $4}' | tr -d "%,")
	
	echo $state 
	echo $percentage


