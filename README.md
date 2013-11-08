gram
====

Compress and restored genetic sequences using patchfiles.

This idea was inspired by Git and other version control systems. The idea is that institutes like universities are almost certain to have the complete genomes of model organisms on hand. In a very rough sense, the general workflow would be somthing like

\<Researcher 1>: Oh look I have some important genetic information that needs to be shared, but the data file is huge!  
\<Gram>: Let me see it. What organism is this most closely related to?  
\<Researcher 1>: \<Some model organism genome|transcriptome|rna reads>  
\<Gram>: Okay, here's a significantly smaller file that describes the differences between your data and \<model organism>  
\<Researcher 1>: Awesome! I can now send this easily and quickly!  

\<Researcher 2>: I got a patchfile from \<Researcher 1> who says its a comparison against \<model organism>    
\<Gram>: Oh, neat. Let me analyze it and reconstruct \<Researcher 1>'s original data for you.    
\<Researcher 2>: Sweet! Now I can use this data to help me in my own studies.    
