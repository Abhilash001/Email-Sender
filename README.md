# Email Sender
Email sender is specifically a Gmail email sender written in java that can send emails through Command prompt of your computer. Since it 
is a .java file, you will need a java compiler to run the program as well as the additional 2 .jar files included in this repository for 
extra import packages.

The Email Sender is Copyright under the GNU General Public License 2007 of the Free Software Foundation, thus, making it completely free 
to use, distribute and/or modify.

## Setting up java compiler in Command prompt(ignore if already set up):
For initial setup, download and install JDK 7(or higher version) in your computer [from here](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html) 
after accepting the license agreement. If you have it, then start by setting path for the compiler. Click on the link below to see how(not my video).

[![Tutorial on how to set path for java compilers](https://img.youtube.com/vi/vhBNV8no4CI/0.jpg)](https://www.youtube.com/watch?v=vhBNV8no4CI)

## Setting the 2 jar files provided(Important!):
For this, you only need to copy the two jar files to Java\jre7\lib directory and then add their file names in the classpath system 
variable value. For example, from the above video, 

```
C:\Program Files\Java\jre7\lib
```

will be replaced by 

```
C:\Program Files\Java\jre7\lib\mail.jar;C:\Program Files\Java\jre7\lib\activation.jar
```

in the classpath system variable. Since 2 files are being added, we need to provide 2 paths individually.

## Running SendGmailSSL file:
Just compile the file in command prompt by writing 

```
javac SendGmailSSL.java
```

in the directory containing the program. Then run it by writing 

```
java SendGmailSSL
```

The program will guide you furthur.
