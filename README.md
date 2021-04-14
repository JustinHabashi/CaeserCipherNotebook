# Simple Notebook

## Create and track notes in a simple console interface

This program allows users to create a notebook comprised of individual notebook entries.
Each entry has a random value between 1 and 10 assigned to it. This value determines the 
cipher value. A GUI is launched through main.

It simulates a simple way of encrypting a message. 

A bidirectional relationship has been implemented between NotebookEntry and CipherText.
The two classes both require the other to be active and present for its functionality
within the GUI, so a bidirectional relationship seemed appropriate. However the relationship is
not fully implemented in all calls at this time.  
