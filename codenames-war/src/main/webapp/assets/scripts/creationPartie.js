console.log("Hello world !");
let btnValider = document.querySelector('button[name="role_couleur"]');
btnValider.addEventListener('click', (event) => {
	let roleQuery;
	let couleurQuery;
	
	if(document.querySelector('input[id="role_agent"]').checked == true){
		roleQuery = document.querySelector('input[id="role_agent"]').getAttribute("value");
	}else if (document.querySelector('input[id="role_maitre"]').checked == true){
		roleQuery = document.querySelector('input[id="role_maitre"]').getAttribute("value");
	}else{
		event.preventDefault();
		alert("Selectionner un rôle")
	}
	
	if(document.querySelector('input[id="couleur_rouge"]').checked == true){
		couleurQuery = document.querySelector('input[id="role_agent"]').getAttribute("value");
	}else if (document.querySelector('input[id="couleur_bleu"]').checked == true){
		couleurQuery = document.querySelector('input[id="couleur_bleu"]').getAttribute("value");
	}else{
		event.preventDefault();
		alert("Selectionner une couleur")
	}
	
	let joueur = null;
	
	fetch(`http://localhost:8081/codenames-war/api/joueur/findJoueurBySession`)
	.then(resp => joueur = resp.json());
	console.log("Joueur : ");
	console.log(joueur);
	console.log("Couleur : ");
	console.log(couleurQuery);
	
	joueur.couleur = couleurQuery;
	joueur.role = roleQuery;
	
//	let joueur = {
//			couleur: couleurQuery,
//			role: roleQuery,
//			personne: peronneQuery
//	};
	
	fetch(`http://localhost:8081/codenames-war/api/joueur/save`,{
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(joueur)
	}).then(resp => resp.json(joueur));
});

//Si un autre joueur s'ajoute
let eventSource = new EventSource(`http://localhost:8081/codenames-war/api/joueur/save`);
evenSource.addEventListener('message', (event)=>{
	//alert(msg);
	//Si on a reçu un objet json
	let objetJoueur = JSON.parse(event.data);
	console.log(object);
	
	let row = document.createElement("tr");
	let colPseudo = document.createElement("td");
	let colCouleur = document.createElement("td");
	let colRole = document.createElement('td');
	let colDelete = document.createElement('td');
	let btnDelete = document.createElement('button');
	
	row.append(colPseudo);
	row.append(colCouleur);
	row.append(colRole);
	row.append(colDelete);
	
	document.querySelector('table tbody').append(row);
	
	colPseudo.innerHTML = objetJoueur.personne.pseudo;
	colCouleur.innerHTML = objetJoueur.couleur;
	colRole.innerHTML = objetJoueur.role;
	colDelete.append(btnDelete);
	
	btnDelete.innerHTML = "Supprimer";
	btnDelete.classList.add('btn', 'btn-danger');
	
	btnDelete.addEventListener('click', () => {
		fetch(`http://172.16.44.101:8081/emusic-web/api/produit/${ objetJoueur.id }`, {
			method: 'DELETE',
		}).then(resp => {
			row.remove();
		});
	});
});




