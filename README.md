# Simple Notebook

## Create and track notes in a simple console interface

This program allows users to create a notebook comprised of individual inputs.
The usage could be for a meal tracker, daily journal, or notepad. The functionality
will hopefully be extended in order to encrypt the notepad entries, but for the time being
it works as an interface to track notes. Inside of NotebookEntry it has been given a cipher value
which will later contribute to encrypting the individual entries.

This project is of interest to me because it serves as an elementary look
into storing and securing information. **Security** and **Networking** are two
side interests of mine that both incorporate many forms of encryption and 
protecting packets of information. This information is stored using as few dependencies as possible.
The NotebookApp communicates only with the Notebook, which communicates with the individual NotebookEntry class. 

**As a User**
I want to:
<ol>
    <li> add a notebook entry</li>
    <li> retrieve all entries</li>
    <li> clear the notebook</li>
    <li> view how many entries are in the notebook</li>
    <li> save my notebook contents</li>
    <li> retrieve my previously saved notebooks from file</li>
</ol>

**Phase 4: Task 2**
A bidirectional relationship has been implemented between NotebookEntry and CipherText.
The two classes both require the other to be active and present for its functionality
within the GUI, so a bidirectional relationship seemed appropriate. 

If I had more time to work on the project, I would reorganize. The class structure
is far too flat for comfort. Many of the classes have functionality that could better
be divided among classes. In order to allow for functionality extensions I would make 
the UI and model packages more modular.  
