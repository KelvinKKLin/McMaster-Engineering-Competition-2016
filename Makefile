all: classes run manifest

run: $(classes)
	echo "#!/bin/bash" > run.sh
	echo "java -cp competition/Run" >> run.sh
	chmod 754 run.sh 

classes:
	javac competition/*.java

manifest: $(classes)
	echo "Manifest-Version: 1.0" > Manifest.txt
	echo "Class-Path: ." >> Manifest.txt l
	echo "Main-Class: competition.Run" >> Manifest.txt 
	jar cfm Main.jar Manifest.txt competition/*.class

clean:
	rm competition/*.class
	rm *.jar
	rm run.sh
	rm Manifest.txt
