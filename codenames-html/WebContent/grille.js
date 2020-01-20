function creerGrille(){
	//créer 25 div allant se mettre dans la grille, le compteur remplace le libelle du mot pour l'instant
	let listeCartes = creerListeCartes();
	for(let i = 0; i < 25; i++){
		let donneesCarte = listeCartes[i];
		let texte = document.createElement('span');
		let mot = document.createElement('div');
		let carte = document.createElement('div');
		texte.classList.add("texte");
		mot.classList.add("mot");
		carte.classList.add("carte");
		carte.setAttribute('data-couleur', donneesCarte.couleurCarte);
		mot.append(texte);
		carte.append(mot);
		document.querySelector(".grille").append(carte);
		texte.innerHTML = donneesCarte.libelle;
	}
}

function click(){
	let monClick = document.querySelectorAll("[data-couleur]");
	
	//lorsque l'on clique sur une carte, la couleur est révélée et cache l'entièreté de la case
	monClick.forEach((lien) =>{
		lien.addEventListener('click', function(event) {
			if(event.target.classList == "carte"){
				let texte = event.target.querySelector(".texte");
				texte.classList.remove("texte");
				texte.classList.add("gone");
				let mot = event.target.querySelector(".mot");
				mot.classList.remove("mot");
				mot.classList.add("gone");
				event.target.classList.remove("carte");
				if(event.target.getAttribute("data-couleur") == "blanche"){
					finDuTour();
					alert("Vous êtes tombés sur un témoin, c'est au tour de l'équipe adverse");
					event.target.classList.add("blanche");
				}
				if(event.target.getAttribute("data-couleur") == "rouge"){
					if(rouge == false){
						finDuTour();
						alert("Vous êtes tombés sur une tuile de l'équipe adverse, fin du tour");
					}
					event.target.classList.add("rouge");
				}
				if(event.target.getAttribute("data-couleur") == "bleue"){
					if(rouge == true){
						finDuTour();
						alert("Vous êtes tombés sur une tuile de l'équipe adverse, fin du tour");
					}
					event.target.classList.add("bleue");
				}
				if(event.target.getAttribute("data-couleur") == "noire"){
					finDuTour();
					alert("Salut mon pote, c'est Game Over");
					event.target.classList.add("noire");
				}
			}
		});
	});
}
//la fonction qui simule une liste de 25 cartes avec leurs libelle et couleur
function creerListeCartes(){
	let listeCartes = [];
	for(let i = 1; i < 26; i++){
		compteur = Math.floor(Math.random()*4);
		if(compteur == 0){
			couleur = "blanche";
		}
		if(compteur == 1){
			couleur = "rouge";
		}
		if(compteur == 2){
			couleur = "bleue";
		}
		if(compteur == 3){
			couleur = "noire";
		}
		let carte = {
				libelle : i,
				couleurCarte: couleur
		}
		listeCartes.push(carte);
	}
	return listeCartes;
}

function lancementPartie(){
	let equipeRouge = document.querySelector(".goneEquipeRouge")
	let boutonTemporaire = document.querySelector(".gone");
	let boutonPret = document.querySelector(".boutonPret");
	let msgDebut = document.querySelector(".debut");
	msgDebut.classList.remove("debut");
	msgDebut.classList.add("gone");
	boutonPret.classList.remove("boutonPret");
	boutonPret.classList.add("gone");
	boutonTemporaire.classList.remove("gone");
	boutonTemporaire.classList.add("boutonTemporaire");
	equipeRouge.classList.remove("goneEquipeRouge");
	equipeRouge.classList.add("equipeRouge");
}

let rouge = true;
function finDuTour(){
	if (rouge == true){
		let equipeRouge = document.querySelector(".equipeRouge");
		let equipeBleue = document.querySelector(".goneEquipeBleue");
		equipeRouge.classList.remove("equipeRouge");
		equipeRouge.classList.add("goneEquipeRouge");
		equipeBleue.classList.remove("goneEquipeBleue");
		equipeBleue.classList.add("equipeBleue");
	}
	else{
		let equipeRouge = document.querySelector(".goneEquipeRouge");
		let equipeBleue = document.querySelector(".equipeBleue");
		equipeRouge.classList.remove("goneEquipeRouge");
		equipeRouge.classList.add("equipeRouge");
		equipeBleue.classList.remove("equipeBleue");
		equipeBleue.classList.add("goneEquipeBleue");
	}
	rouge = !rouge;
}

function deroulementTour(){
	
}


creerGrille();
click();