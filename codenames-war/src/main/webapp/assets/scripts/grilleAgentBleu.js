//Compteurs de tuiles. Ceux-ci diminueront à chaque tuile découverte correspondant à une couleur de compteur
let compteurRouge = 0;
let compteurBleu = 0;
let compteurBlanc = 0;
let compteurNoir = 0;
//Compteur de joueurs qui ne sont pas encore prêt, à chaque fois qu'un joueur appuiera sur "Pret!", ce compteur diminuera
//jusqu'à atteindre zéro pour permettre de lancer la partie
let compteurJoueursPasPret = 2;
//Booléen permettant de vérifier si la partie est commencée. Si non, les joueurs ne pourront pas
//intéragir avec la grille
let partieCommencee = false;
//Booléen permettant de différencier les tours rouges des tours bleus. Il changera de valeur à chaque fin de tour
let rouge = false;

document.querySelector(".compteurJoueursPasPret").innerHTML = compteurJoueursPasPret;
creerGrille();

function creerGrille(){
	
	if (partieCommencee == true){
		document.querySelectorAll(".carte")
		.forEach((tuile) => {
			tuile.remove();
		});
		compteurRouge = 0;
		compteurBleu = 0;
		compteurBlanc = 0;
		compteurNoir = 0;
	}
	
	fetch('http://localhost:8080/codenames-war/api/carte/1')
		.then(resp => resp.json())
		.then(cartes => {
			for(let c of cartes){
				let texte = document.createElement('span');
				let mot = document.createElement('div');
				let carte = document.createElement('div');
				texte.classList.add("texte");
				mot.classList.add("mot");
				carte.setAttribute('decouvert', c.decouvert);
				if(c.decouvert == false){
					carte.classList.add("carte");
					carte.setAttribute('data-couleur', c.couleur);
					mot.append(texte);
					carte.append(mot);
					if (c.couleur == "Rouge"){
						compteurRouge ++;
					}
					if (c.couleur == "Bleu"){
						compteurBleu ++;
					}
					if (c.couleur == "Blanc"){
						compteurBlanc ++;
					}
					if (c.couleur == "Noir"){
						compteurNoir ++;
					}
				}
				else{
					carte.classList.add(c.couleur);
				}
				document.querySelector("#grille").append(carte);
				if(partieCommencee == false){
					document.querySelector("#grille").classList.add("grilleGrise");
				}
				texte.innerHTML = c.monMot.mot;
			}
			document.querySelector(".compteurRouge").innerHTML = compteurRouge;
			document.querySelector(".compteurBleu").innerHTML = compteurBleu;
			document.querySelector(".compteurBlanc").innerHTML = compteurBlanc;
			document.querySelector(".compteurNoir").innerHTML = compteurNoir;
			click();
		})
}

function click(){
	
	let monClick = document.querySelectorAll("[data-couleur]");
	
	//lorsque l'on clique sur une carte, la couleur est révélée et cache l'entièreté de la case
	monClick.forEach((lien) =>{
		lien.addEventListener('click', function(event) {
			if(partieCommencee == true){
				if(rouge == false){
					if(event.target.classList == "carte"){
						let texte = event.target.querySelector(".texte");
						texte.classList.remove("texte");
						texte.classList.add("gone");
						let mot = event.target.querySelector(".mot");
						mot.classList.remove("mot");
						mot.classList.add("gone");
						event.target.classList.remove("carte");
						if(event.target.getAttribute("data-couleur") == "Blanc"){
							finDuTour();
							alert("Vous êtes tombés sur un témoin, c'est au tour de l'équipe adverse");
							event.target.classList.add("Blanc");
							
						}
						if(event.target.getAttribute("data-couleur") == "Rouge"){
							//Cette boucle if permet de vérifier si l'équipe tombée sur la case est bleue,
							//si c'est le cas, le tour est fini
							//On retrouve la même boucle pour le cas de la case bleue sélectionnée par l'équipe rouge
							if(rouge == false){
								finDuTour();
								alert("Vous êtes tombés sur une tuile de l'équipe adverse, fin du tour");
							}
							event.target.classList.add("Rouge");
						}
						if(event.target.getAttribute("data-couleur") == "Bleu"){
							if(rouge == true){
								finDuTour();
								alert("Vous êtes tombés sur une tuile de l'équipe adverse, fin du tour");
							}
							event.target.classList.add("Bleu");
						}
						if(event.target.getAttribute("data-couleur") == "Noir"){
							finDuTour();
							alert("Salut mon pote, c'est Game Over");
							event.target.classList.add("Noir");
						}
					}
				}
			}
		});
	});
}
//la fonction qui simule une liste de 25 cartes avec leurs libelle et couleur
//function creerListeCartes(){
//	let listeCartes = [];
//	for(let i = 1; i < 26; i++){
//		compteur = Math.floor(Math.random()*4);
//		if(compteur == 0){
//			couleur = "blanche";
//			compteurBlanc ++;
//		}
//		if(compteur == 1){
//			couleur = "rouge";
//			compteurRouge ++
//		}
//		if(compteur == 2){
//			couleur = "bleue";
//			compteurBleu ++
//		}
//		if(compteur == 3){
//			couleur = "noire";
//			compteurNoir ++
//		}
//		let carte = {
//				libelle : i,
//				couleurCarte: couleur
//		}
//		listeCartes.push(carte);
//	}
//	return listeCartes;
//}

function lancementPartie(){
	let equipeRouge = document.querySelector(".goneEquipeRouge")
	let boutonTemporaire = document.querySelector(".gone");
	let boutonPret = document.querySelector(".boutonPret");
	boutonPret.classList.remove("boutonPret");
	boutonPret.classList.add("gone");
	equipeRouge.classList.remove("goneEquipeRouge");
	equipeRouge.classList.add("equipeRouge");
	document.querySelector("#grille").classList.add("grilleRouge");
	rouge = true;
	click();
}

//function deroulementTour(){
//	while (true){
//		if(rouge == true){
//			click();
//		}
//		if(compteurRouge == 0 || compteurBleu == 0 || compteurNoir == 0){
//			break;
//		}
//	}
//	alert("la partie est finie")
//}

function finDuTour(){
	if (rouge == true){
		let equipeRouge = document.querySelector(".equipeRouge");
		let equipeBleue = document.querySelector(".goneEquipeBleue");
		equipeRouge.classList.remove("equipeRouge");
		equipeRouge.classList.add("goneEquipeRouge");
		equipeBleue.classList.remove("goneEquipeBleue");
		equipeBleue.classList.add("equipeBleue");
		document.querySelector("#grille").classList.remove("grilleRouge")
		document.querySelector("#grille").classList.add("grilleBleue");
	}
	else{
		let equipeRouge = document.querySelector(".goneEquipeRouge");
		let equipeBleue = document.querySelector(".equipeBleue");
		equipeRouge.classList.remove("goneEquipeRouge");
		equipeRouge.classList.add("equipeRouge");
		equipeBleue.classList.remove("equipeBleue");
		equipeBleue.classList.add("goneEquipeBleue");
		document.querySelector("#grille").classList.remove("grilleBleue")
		document.querySelector("#grille").classList.add("grilleRouge");
	}
	rouge = !rouge;
}
function allumerLeFeu(){
	let souris = document.querySelector(".boutonPret");
	souris.addEventListener('mouseenter', e =>{
		document.querySelector("#audioPlayer").play();
	})
}

const pret = async (event) => {
	event.preventDefault();
	let msgDebut = document.querySelector(".debut");
	let msgJoueurPret = document.querySelector(".joueurPretGone");
	msgDebut.classList.remove("debut");
	msgDebut.classList.add("gone");
	msgJoueurPret.classList.add("joueurPret");
	msgJoueurPret.classList.remove("joueurPretGone");
	let joueurPret = {
			ready: 1
	}
	let ping = await fetch('http://localhost:8080/codenames-war/api/plateauDeJeu', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(joueurPret)
	}).then(resp => resp.json());	
}

document.querySelector('.boutonPret')
	.addEventListener('click', pret);

let eventSource = new EventSource('http://localhost:8080/codenames-war/api/plateauDeJeu/sse');
eventSource.addEventListener('message', (event) => {

	compteurJoueursPasPret --;
	document.querySelector(".compteurJoueursPasPret").innerHTML = compteurJoueursPasPret;
	if(compteurJoueursPasPret == 0){
		partieCommencee = true;
		let msgJoueurPret = document.querySelector(".joueurPret");
		msgJoueurPret.classList.add("joueurPretGone");
		msgJoueurPret.classList.remove("joueurPret");
		creerGrille();
		lancementPartie();
	}
});


//allumerLeFeu();