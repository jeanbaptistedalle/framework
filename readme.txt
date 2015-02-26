Dans ce repository se trouve un projet fonctionnel codé en Java J2EE couplé aux frameworks Spring, Hibernate et Struts. 

Afin de le récuperer, vous devez disposer de git et executer la commande suivante : git clone https://github.com/jeanbaptistedalle/turbo-tomcat-octo-framework.git

En ce qui concerne les versions, j'ai utilisé Java 1.7 ainsi que Tomcat 7. Pour les différents framework, une fois le projet importé dans eclipse, clic droit sur le projet > maven > update project afin d'importer tous les jar nécessaires au bon fonctionnement du projet (dans le cas où le projet ne serait pas configuré pour maven, clic droit > configure > add maven nature)

Puis, il est necessaire de créer la base de donnée. Pour cela, il faut créer une base nommée 'spring', puis d'executer le fichier customer.sql

Dans le cadre de ce projet, on utilisera l'utilisateur 'root' avec le mot de passe 'root' pour faire le lien entre la base de donnée et l'application. Dans le cas où ces informations ne seraient pas exactes, il faudrat les modifier dans le fichier database.properties

Des commentaires sont placés à différents endroits dans le code afin d'expliquer différents concepts utilisés, mais en cas de problème, n'hésitez pas à me contacter : jean-baptiste.dalle@laposte.net

Si vous avez déjà jeté un oeil au code, vous pourrez remarquer qu'il est relativement touffu, on ne sais pas vraiment où donner de la tête. Donc, de manière à bien comprendre comment spring, struts et hibernate interviennent et cohabitent, nous allons suivre pas à pas le chargement d'une page. Vous pouvez de plus vous appuyer sur le schema Architecture 3-tier.jpg. Prenons donc un exemple assez simple : la page d'index, qui liste les clients existants. 

Commençons par nous demander pourquoi cette page est chargée. Jetons un oeil au fichier web.xml. A l'interieur de celui-ci, on peut trouver une balise <welcome-file> qui contient pages/index.jsp. On comprend donc aisément que notre page index.jsp est la page d'accueil. index.jsp ne contient cependant qu'une seule ligne pertinente : response.sendRedirect("listCustomerAction"); Cette ligne indique à Struts qu'il faut rediriger le client sur l'action nommée "listCustomerAction". Comme il n'est pas possible de donner une action comme welcome-file, cette ligne permet de contourner la difficulté.

Arrivé ici, nous devons donc effectuer l'action listCustomerAction. Cherchons donc à savoir à quoi cela correspond. Les actions sont définies par struts dans le fichier struts.xml. on y retrouve donc notre fameuse action, qui semble être définie dans la classe ListCustomerAction et plus précisemment dans la méthode listCustomerAction, allons donc y jeter un oeil !

Cette méthode plutôt simple doit récuperer la liste des clients qui sera ensuite affichée sur la page customer.jsp. Actuellement, on se trouve dans la couche Présentation de l'architecture 3-tier dans laquelle on doit simplement préparer les données à l'affichage. Cette couche est gérée par Struts et on y trouve toutes les actions. Cette couche doit être légère et contenir le moins de traitement possible. La méthode contient donc une seule ligne, qui fait appel à CustomerService pour récuperer la liste des clients.

Nous descendons donc d'une couche pour arriver dans la couche Métier. Dans cette couche, on trouve les différents Services. Les services s'occupent de faire transiter les données entre la couche Persistance et la couche Présentation tout en effectuant les traitement les plus lourds sur les données. Ici, on ne fait que récupérer les clients et les convertir. Le but de cette conversion est de ne pas faire remonter jusqu'à la couche Présentation les objets entité lié à hibernate.

Nous continuons donc vers la couche Persistance, gérée par Hibernate et contenant les DAO. Hibernate permet de récupérer directement sous forme d'objet les données contenues dans la BDD. En l'occurence, la méthode findAll() utilisée ici fait partie des méthodes fournies par GenericDAO dont hérite CustomerDAO. 
