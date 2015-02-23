Dans ce repository se trouve un projet fonctionnel codé en Java J2EE couplé aux frameworks Spring, Hibernate et Struts. 

Afin de le récuperer, vous devez disposer de git et executer la commande suivante : git clone https://github.com/jeanbaptistedalle/turbo-tomcat-octo-framework.git

En ce qui concerne les versions, j'ai utilisé Java 1.7 ainsi que Tomcat 7. Pour les différents framework, une fois le projet importé dans eclipse, clic droit sur le projet > maven > update project afin d'importer tous les jar nécessaires au bon fonctionnement du projet (dans le cas où le projet ne serait pas configuré pour maven, clic droit > configure > add maven nature)

Puis, il est necessaire de créer la base de donnée. Pour cela, il faut créer une base nommée 'spring', puis d'executer le fichier customer.sql

Dans le cadre de ce projet, on utilisera l'utilisateur 'root' avec le mot de passe 'root' pour faire le lien entre la base de donnée et l'application. Dans le cas où ces informations ne seraient pas exactes, il faudrat les modifier dans le fichier database.properties

Des commentaires sont placés à différents endroits dans le code afin d'expliquer différents concepts utilisés, mais en cas de problème, n'hésitez pas à me contacter : jean-baptiste.dalle@laposte.net
