# LaTent - *A Mathematician's Guide to the Universe*

## Purpose
Everyone remembers their first introduction to LaTeX and it was never pleasant.
From University math courses to making resumes or anything PDF related, LaTeX is 
infamous for its sharp learning curve. This project seeks to remedy the challenges of
memorizing and familiarizing the nature of LaTex commands and is not only geered towards students
but all new users to LaTex. 
<p>
The project will serve both as a simple collection of navigable LaTeX commands and 
as a personal collection of favourite commands/tricks (Much like in Half-Blood Prince).
</p>

## User Stories
Features and specific tasks I would like to accomplish as a **user** with this application.

- As a **user**, I want to be able to add/remove/edit my own commands with descriptions to my collection.
- As a **user**, I want to be able to see all the commands I have saved so far in my journal.
- As a **user**, I want to be able to render saved LaTex notation when I am looking through my collection.
- As a **user**, I want to be able to search for specific commands through keywords to see their details.
- As a **user**, I want to be able to choose to save my current collection and its commands.
- As a **user**, I want to be able to choose to load a pre-existing collection of commands. 

## Instruction for Grader
- You can generate the first required action related to the user story "adding multiple Xs to a Y" by 
selecting the `New Entry` button to log a new entry through the editor interface.

- You can generate the second required action related to the user story "adding multiple Xs to a Y" by
using the search bar to reorder and find the desired entry in the catalogue.
- You can locate my visual component on start up and when selecting entries in the view panel.
- You can save the state of my application by pressing the save button on the view panel.
- You can reload the state of my application by pressing the load button on the view panel.

## Logs Samples
Actions such as adding entries, removing entries, and editing entries.
```
Tue Apr 02 19:06:53 PDT 2024
Added entry to catalogue named Integral
Tue Apr 02 19:07:02 PDT 2024
Removed entry from catalogue named Equation K
Wed Apr 03 10:21:15 PDT 2024
\omega description went from Greek omega symbol (w) to Greek omega symbol (d)
Wed Apr 03 10:21:15 PDT 2024
\omega title went from Omega to Delta
Wed Apr 03 10:21:15 PDT 2024
\omega command went from \omega to \delta
```

## Phase 4: Task 3 - Design Improvements
While the design of LaTenT already makes use of several design patterns there are many aspects that can be 
refactored to allow for easier future additions. Particularly, while there does not appear to be significant coupling
in the UML, this is due to the use of static getters being used across the hierarchy to modify children 
on the same level of the hierarchy. This should be refactored with a singleton pattern, with prime examples
of this application being seen in the `EntryEditorWindow`, `EntryViewerWindow`, and `HomeWindow` of the Swing GUI package. For these
classes, along with the entire instance of the app itself, only one instance should exist, hence singleton 
should be used here instead. This would allow for the removal of nested static getters for modifying GUI elements
in separate windows and overall lead to a cleaner design. 

Additionally, there is a case specifically in the Swing `EntryViewerPanel` where this class should
have its panels be abstracted into separate classes to better adhere to the single responsibility rule. As
of now, this class demonstrates low cohesion for its highly nested nature, which should thus be refactored. 
Similar steps 

Overall, refactoring this project with the singleton pattern is the most pertinent next step in terms of 
improving the code quality of this project. 


## Resources
Thanks to JLaTeXMath, FuzzyWuzzy, Stable Diffusion for assets and libraries used in this application.


