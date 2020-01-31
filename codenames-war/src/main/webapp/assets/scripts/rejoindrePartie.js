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
	.then(resp => joueur = resp.json())
	.catch(err => console.log(err));
	
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
