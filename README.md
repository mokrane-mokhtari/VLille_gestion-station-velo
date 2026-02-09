# Projet de Gestion des Stations de Vélo en Libre-Service


## Introduction :
Le projet consiste en la gestion d'un système de vélos en libre-service, où l'on peut gérer des véhicules stockés dans des stations. Le système prend en charge les opérations de dépôt et de retrait des vélos, la gestion de l'état des stations (pleines, vides, normales), ainsi que la redistribution des vélos entre les stations en fonction de la demande. Il met en œuvre plusieurs patterns de conception tels que l'interface, le pattern Décorateur, le pattern Observateur, le pattern fabrique et le pattern Stratégie pour assurer une structure flexible et extensible.

## MAIN
- Nous avons essayé de concevoir un main le plus random possible afin d'avoir une experience unique à chaque lancement, confession : nous nous sommes aidés d'ia, car nous ne maitrisons pas la bibliothéque random.
- Nous avons quand même fait en sorte que chaque éxcecution contienne au moins une fois les fonctionnalités demandés au projet, afin que vous n'ayez pas à relancer le main en boucle. A chaque lancement vous devriez trouver : des vols, des notifications, des mises hors service, des réparations, des redistributions. Le tout coloré afin que vous puissiez facilement les distinguer du reste du texte.
- Vous remarqurez que j'ai en premier lieu moi meme crée des velos et les ai déposé dans des stations, et ensuite la création se fait au fur et a mesure de façon aléatoire. C'est pour montrer avant le début de la temporalité(les tours) que les velos avec accésoires peuvent etre crées + déposé + catch la notification. Afin de vous faciliter votre travail de correction
- Nous avons choisi d'y mettre 10 tours, une condition d'une seule utilisation pour le passage vers l'état Hors service afin que ce soit visible, vu le nombre de vélos il aurait fallu encore plus de tours pour qu'un vélo tombe en panne avec une condition fixée à 2 ou 3, ce qui ne vous facilitera pas le travail. 
- Vous remarquerez qu'il n'existe pas de classe voleur, car il n'a pas été demandé dans notre sujet d'en faire mais juste de gérer des vols. Nous avons donc décider de faire cela dans le Main, quand un velo atteint un certain nombre de tour sans etre utilisé il devient alors possible de le voler, à partir de la il a 50% de chance de disparaitre et basculer vers l'état VOLE. Cela nous évite de nous embeter avec une nouvelle personne.

## TESTS 
- Nous avons fait attention à ne pas tester les méthodes get et set comme vous l'aviez demandé, en contrepartie cela fait que ça a baissé la couverture de test du projet.
- Absolument toutes les classes ont leur classe de test
- Nous avons bien utilisé des mocks lorsqu'un test demandé l'utilisation d'une classe "complexe"
- Pas de MockBike lors de TestStation car Bike est une classe nulle qui ne contient que des get et set donc pas besoin de la mocker
- Nous n'avons pas trouvé l'utilisation d'héritage de test pertinent dans ce projet

## Précision : ce sont des commandes windows 
2. Générer la Documentation :
- javadoc -sourcepath src -d docs src/*.java

3. Compiler nos classes source et de test :
- javac -d classes/src src\*.java
- javac -d classes/test -cp "junit-console.jar;classes/src" test/*.java

4. Lancement des tests :
- java -jar junit-console.jar -classpath "classes/src;classes/test" -scan-classpath


5. Excecution du Main : 
- java -cp "classes/src" Main 


6. JAR 
- Je suis désolé mais je n'ai pas réussi à générer le JAR manuellement malgrés mes heures de tentatives, j'ai donc fini par le faire avec mon ide directement...
- java -jar projet-coo.jar

# Présentation des Éléments de Code Saillants
## 1. Conception et Architecture
Le système repose sur plusieurs patterns de conception pour garantir une structure flexible et évolutive :

### Pattern Décorateur:
  Ce pattern permet d'ajouter dynamiquement des accessoires aux véhicules (panier, porte-bagages, etc.). Par exemple, un vélo peut être décoré avec un panier en fonction des besoins du client, et une station peut accueillir des vélos avec des accessoires personnalisés. Ici au début de notre projet un des membres du groupe dont je tairai le nom a choisi de mettre les décorateurs sur les véhicules, ce qui n'est pas trés dramatique dans le cadre de notre petit projet de L3 mais il aurait quand même été préférable de les mettre sur les velos.

### Pattern Observateur:
 Le pattern Observateur est utilisé dans notre projet pour gérer la communication entre les stations et le centre de contrôle. Chaque station agit comme un sujet qui surveille les événements internes, tels que le dépôt ou le retrait de véhicules. Lorsqu'un événement se produit, la station notifie tous ses observateurs (ici, le centre de contrôle). Cela permet au centre de contrôle de réagir immédiatement aux changements, comme la gestion de la redistribution des vélos lorsque les stations deviennent trop pleines ou trop vides. En appliquant ce pattern, nous avons pu garantir un découplage efficace entre les différentes parties du système, rendant l'extension et la maintenance du projet plus faciles. Ce mécanisme de notification permet également d’ajouter de nouveaux observateurs sans modifier le code existant, assurant ainsi une extensibilité et une flexibilité du système.

### Pattern Stratégie :
 Ce pattern est utilisé pour gérer la redistribution des vélos entre les stations. Si une station devient vide ou pleine, le système choisit une stratégie de redistribution pour rééquilibrer les stations. Grace a l'utilisation de ce pattern, nous pourrons ajouter d'autres façons de redistribuer les véhicules entre les stations. Remarque : étant donné que nous l'avons vu assez tardivement en TD il n'a été ajouté que vers la fin du Projet.

### Pattern Factory :
 Le Pattern Factory est utilisé pour créer des techniciens réparateurs à partir de la classe Humain. Plutôt que de créer manuellement chaque technicien, une TechnicienFactory centralise la création de ces objets, ce qui permet de créer des instances de techniciens réparateurs en fonction de certains paramètres ou rôles. Par exemple, selon le type de réparations qu'un technicien est censé effectuer, la TechnicienFactory pourrait instancier différentes classes de techniciens. Cela permet d'ajouter de nouveaux types de techniciens sans modifier le code existant, tout en facilitant l'extensibilité du système. Nous l'avons à peine utiliser dans notre projet mais c'est toujours bon à avoir

### Pattern state : 
 Nous ne l'avons pas ajouter mais il reste interessant de le mentionner car nous y avons penser un court moment, finalement il n'a pas sa place dans notre projet étant donné qu'il n'apporte rien a notre classe bike qui est "faible" ne contenant quasiment que des getters et setters.

## 2. Principes de Conception Mis en Œuvre
Les principes SOLID ont bien été respecté au cours de ce projet, notre code contient des classes ouvertes aux extension mais fermés aux modifications, responsables de leurs propres affaire ! Simples, non répétitives et avec une dépendance bien ordonnée. Monsieur solid aurait été fiers de nous...


### Modularité :
 Chaque fonctionnalité du système est encapsulée dans des classes et des interfaces séparées. Par exemple, les vélos sont gérés indépendamment des stations et des accessoires. Cela permet d'ajouter de nouveaux types de véhicules ou de modifier le comportement des stations sans perturber le reste du système.

### Extensibilité (Open-closed Principle):
 Grâce à l'utilisation des patterns de conception comme le Décorateur et le Stratégie, il est facile d'ajouter de nouvelles fonctionnalités, comme de nouveaux types de véhicules, d'accessoires, de stratégies de redistribution, ou memes de personnes grace à la classe humain.

### Séparation des Responsabilités (Single-responsibility Principle) :
 Chaque classe a une responsabilité unique. Par exemple, les stations ne gèrent que le dépôt et le retrait des véhicules, tandis que le centre de contrôle gère la redistribution et les notifications.

## 3. Points Forts du Projet
### Flexibilité :
 Le projet est conçu pour être facilement extensible. L'ajout de nouveaux types de véhicules, de nouveaux accessoires ou de nouvelles stratégies de redistribution et memes de novelles personnes peut se faire sans toucher au code existant.

### Gestion de l'État des Stations :
 Le système peut gérer les stations pleines, vides, ou normales en temps réel. Le centre de contrôle reçoit des notifications et peut initier des actions telles que la redistribution des vélos entre les stations.

### Redistribution Dynamique :
 Le système peut redistribuer les vélos de manière intelligente en fonction de la charge des stations, optimisant ainsi l'utilisation des vélos.

### Réparations :
  Les vélos défectueux peuvent être réparés par des techniciens, ce qui garantit que les vélos en mauvais état ne sont pas utilisés par les clients.

