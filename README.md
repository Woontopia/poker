# ReadME

## Design pattern utilisé

### Factory Method
Pour la création du type de poker j'ai utilisé une fabrique méthode qui selon le type de poker supporté 
passer a la factory. Ceci permet l'ajout de nouveau type de poker assez facilement pour le futur.

### <hr> Template Méthode
Dans mon projet, j'ai utilisé plusieurs template methode, dont la plus importante étant PokerGame qui permet
a ceux aux différent type de poker (Royal, Hold'em, Omaha, FiveCard) de redéfinir quelque de ces comportement
comme une ronde complete (play), et une nouvelle ronde. De plus, la classe PokerGame utilise des fonctions qui
sont utiliser dans tous les type de poker comme demander le nombre de joueur, ajouter des joueurs et commencer
une nouvelle ronde.

### <hr> Chaine de responsabilité
Comme demander j'ai utiliser une chaine de responsabilité pour définir quelle type de main chaque joueur possède.
Il est important de noter que chaque maillon (Analyzer) utilise un ou plusieurs Checker pour éviter de répetter du code.
Donc, chaque maillon tente de vérifier si le joueur possède une main spécifique, si cela n'est pas le cas on passe au
prochain maillon.


## Réflexion sur chaine de responsabilité
Je pense que la chaine de responsabilité est l'une des meilleures facon de déterminer quelle type de main le joueur possède.
On aurait pu se retrouver avec plusieurs if pour determiner le type de main mais avec la chaine chaque maillon vérifie
une main spécifique. Cela facilite grandement la maintenance du code, de plus si on peut faire en sorte de briser la
chaine dès que l'on arrive a la main la plus forte (En fessant une chaine en descendant ex. Royal Flush avant Flush).


## Analyse type de poker
Cette section comporte certaine différence entre les type de poker, pour expliquer certain point dans le code.

### Nombre de cartes du joueur
Le nombre de cartes que le joueur possède dans sa main diffère entre les types de poker, c'est pour ceci que nous
devions specifier le nombre de cartes qu'il peut avoir en créant un nouveau joueur.
- Texas Hold'em : 2 carte
- Omaha : 4 carte
- Five Card Draw : 5 carte (avec possibilité de remplacer carte)
- Royal Hold'em : 2 carte


### Carte communautaire
Le nombre de carte disponible a tous les joueurs (Community Pool). Seule le poker Five Card Draw ne possede pas carte
communautaire pour cette raison la classe PokerGame ne possede pas de community pool.

### Deck Royal Hold'em
Un deck pour du poker de type Royal Hold'em ne possede que les carte 10, J, Q, K et A. Pour cette raison, le deck doit
avoir le type de poker dans son instanciation pour pouvoir créer le deck approprier pour le type de jeux.


