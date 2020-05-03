# Hangman
 Hangman App - School Project
 
Jag började med att tänka ut vad jag ville att appen skulle göra och se ut.
Skrev en TODO för att följa varje del jag behövde göra för att slutföra och gjorde sedan research för att hitta sätt att lösa problemet.
Fick prova mig fram med flertalet metoder och lösa ytterligare problem som uppstod när jag provade annat.
Koden är inte ordentligt strukturerad, då det blev för mycket redigeringar i slutändan. :/

Min app tar fram ett random ord från en lista på 58000 ord och döljer bakom XXXXX, där dessa är baserat på antal tecken i ordet.
Man kan välja att testa på en bokstav eller ett helt ord. Den skiljer sedan på detta och lagras i olika preferences.
Man har 8 gissningar på sig, och den räknar inte av när man gissar rätt. En timer startar med 3 minuter, men den ger bara en Toast när tiden är ute. Klickar man reset, så startar timer, ett nytt ord sätts in och countern nollställs. Trycker man show stats knappen, får man resultatfönster där man ser alla bokstäver man provat, samt alla ord man provat.

För varje fel gissning, förändras hangman och man går från galje till hängd och en text som säger game over.

Väljer man Quit Game, men sedan klickar på start igen, lägger den upp ett nytt spel och rensar tidigare historik.



