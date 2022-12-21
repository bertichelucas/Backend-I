window.onload = function() {
    console.log("Entre")

    const form = document.querySelector("form")

    form.onsubmit = function(e){
        e.preventDefault()

        const formData = {
            numeroMatricula: document.querySelector('#matricula').value,
            nombre: document.querySelector('#nombre').value,
            apellido:  document.querySelector('#apellido').value
        }

        const url = '/odontologo'
        
        const settings = {
            method: 'POST',
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