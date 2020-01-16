function creerGrille(){
	//créer 25 div allant se mettre dans la grille, le compteur remplace le libelle du mot pour l'instant
	for(let i = 1; i < 26; i++){
		let texte = document.createElement('span');
		let mot = document.createElement('div');
		let carte = document.createElement('div');
		texte.classList.add("texte");
		mot.classList.add("mot");
		carte.classList.add("carte");
		carte.setAttribute('data-couleur', 'rouge');
		mot.append(texte);
		carte.append(mot);
		document.querySelector(".grille").append(carte);
		texte.innerHTML = i;
	}
}

creerGrille();

let monClick = document.querySelectorAll("[data-couleur]");


monClick.forEach((lien) =>{
	lien.addEventListener('click', function(event) {
		let texte = event.target.querySelector(".texte");
		texte.classList.remove("texte");
		texte.classList.add("gone");
		let mot = event.target.querySelector(".mot");
		mot.classList.remove("mot");
		mot.classList.add("gone");
		event.target.classList.remove("carte");
		event.target.classList.add("blanche");
	});
});
