------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Random Cipher
PURPOSE OF PROJECT: This program encrypts a user inputted sentence and writes it to a file and decrypts 
the message by reading from that file.
VERSION or DATE: 4/15/2022
HOW TO START THIS PROJECT: Compile and run
AUTHORS: Sreeya Gambhirrao
USER INSTRUCTIONS: Compile and run and enter input as per instructions

**************************** P M R********************************************************************
 
<+s>: At the beginning of the project, I knew that this was somewhat similar to the previous prject 
with some changes. So the first thing I did as take a look at that code and try to figure out what and 
where the changes would be. Later I made a pseudocode on how I would make those changes. I think it helped 
with writing my code because I had a plan set out. Most of the time, my code ran smoothly but there were 
a couple complications here and there.

<-s>: After I made sure that my code was correct, I tested it out and there were a couple problems. 
One was that some of the questions that I ask the user to enter input all came at once and when I tried 
decryption it wouldn't read from the file. It would ask the user what sentence it should decrypt. So 
the first thing I did was fix the reading from file error. It turns out I had multiple scanner objects 
and I had to close some of them so the others could work. This actually read from the file so that was 
out of the way. But the program was still asking the questions all at once. After some trial and error, 
it worked after putting an extra nextLine.
*******************************************************************************************************
In the future: Writing down the code on paper and planning out worked well. In the future I will continue 
doing the same thing.


