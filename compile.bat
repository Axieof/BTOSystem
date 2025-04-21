@echo off

:: Change to the directory where the batch file is located (BTOSystem)
cd /d "%~dp0"

:: Compile all Java files in the BTO directory
javac src\com\BTO\*.java

:: Run the Main class from the BTO package (with correct classpath)
java src.com.BTO.Main

:: Pause to keep the terminal open
pause
