let verificationInput = document.querySelector('form.inscription a.inscription').addEventListener('click', function(event){
	if(document.querySelector('input[name="speudo"]').value === ""){
		event.preventDefault();//Empêche l'execution par default de s'executer
		document.querySelector('input[name="speudo"]').style.borderColor = 'red';
		document.querySelector('input[type=text]').style.setProperty("--c", "red");
	}
	if(document.querySelector('input[name="speudo"]').value === ""){
		event.preventDefault();//Empêche l'execution par default de s'executer
		document.querySelector('input[name="speudo"]').style.borderColor = 'red';
		document.querySelector('input[name="speudo"]').style.setProperty("--c", "red");
	}
	if(document.querySelector('input[name="password"]').value === ""){
		event.preventDefault();//Empêche l'execution par default de s'executer
		document.querySelector('input[name="password"]').style.borderColor = 'red';
		document.querySelector('input[name="password"]').style.setProperty("--c", "red");
	}
	if(document.querySelector('input[name="vpassword"]').value === ""){
		event.preventDefault();//Empêche l'execution par default de s'executer
		document.querySelector('input[name="vpassword"]').style.borderColor = 'red';
		document.querySelector('input[name="vpassword"]').style.setProperty("--c", "red");
	}
	if(document.querySelector('input[name="vpassword"]').value === document.querySelector('input[name="password"]').value){
		event.preventDefault();//Empêche l'execution par default de s'executer
		document.querySelector('input[name="password"]').style.borderColor = 'red';
		document.querySelector('input[name="password"]').style.setProperty("--c", "red");
		document.querySelector('input[name="vpassword"]').style.borderColor = 'red';
		document.querySelector('input[name="vpassword"]').style.setProperty("--c", "red");
	}
});

const verification = (verificationInput) =>{
	return new Promise((resolve) => {
		if(verificationInput == null){
			resolve("ERREUR");
		}
	});
}
