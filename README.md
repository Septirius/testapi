# testapi
Application testée avec Postman pour l'envoie de requetes Application run sur server d'application tomcat v9.0 Application dont les dependances sont gérées par Maven

Il faut d'abord créer des livres en utilisant une requete GET à l'URL suivant: http://localhost:8080/example/api/books/save exemple de JSON : { "title" : "yellow", "quantity": 3 // stock de livres disponibles }

Les livres doivent etre créés les uns après les autres et sont persistés en base de données

Pour simuler une commande, requete POST sur l'URL : http://localhost:8080/example/api/orders/save exemple de JSON:

{ "orderNumber": "4k7aa7a", "orderedBooks" : [ //liste de livres commandés { "title" : "green", "price" : 45.60, "quantity" : 1 //nombre voulu d'un livre de la liste }, { "title" : "blue", "price" : 45.60, "quantity" : 4 }, { "title" : "red", "price" : 45.60, "quantity" : 1 } ], "customer": //le client passant commande { "name": "bob" } }

Pour lister tous les livres presents dans le stock avec leur nombre restant, requete GET sur l'URL : http://localhost:8080/example/api/books

Pour lister toutes les commandes, requete sur l'URL : http://localhost:8080/example/api/orders
