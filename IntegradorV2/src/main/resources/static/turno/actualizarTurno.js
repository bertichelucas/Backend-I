window.onload = function() {
    console.log("Entre")

    const form = document.querySelector("form")

    form.onsubmit = function(e){
        e.preventDefault()

        const formData = {
                id: document.querySelector("#idturno").value,
                paciente: document.querySelector("#idpaciente").value,
                odontologo: document.querySelector("#idodontologo").value,
                fecha: document.querySelector("#fechaTurno").value
        }

        const url = '/turnos'
        
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