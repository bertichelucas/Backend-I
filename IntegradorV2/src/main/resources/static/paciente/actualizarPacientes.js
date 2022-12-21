window.onload = function() {
    console.log("Entre")

    const form = document.querySelector("form")

    form.onsubmit = function(e){
        e.preventDefault()

        const formData = {
                id: document.querySelector('#idpaciente').value,
                nombre: document.querySelector('#nombre').value,
                apellido: document.querySelector('#apellido').value,
                dni: document.querySelector('#DNI').value,
                fechaIngreso: document.querySelector('#fechaIngreso').value,
                domicilio: {
                    calle: document.querySelector('#calle').value,
                    numero: document.querySelector('#numero').value,
                    localidad: document.querySelector('#localidad').value,
                    provincia: document.querySelector('#provincia').value,
                },
                email: document.querySelector('#email').value,
        }

        const url = '/pacientes'
        
        const settings = {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body:  JSON.stringify(formData)
        }

        fetch(url, settings, true)
        .then(response => response.json())
        .then(data => {
            console.log(data)
        })

        console.log(formData)
    } 
}