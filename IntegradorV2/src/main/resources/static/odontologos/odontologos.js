window.onload = () => {

    const tableBody = document.querySelector("tbody")
    
    const url = '/odontologo'
        
   

    getLista(url, tableBody)

    const delButton = document.querySelector("#dltButton")
    const delInput = document.querySelector("#dltInput")

    const srchButton = document.querySelector("#SearchButton")
    const srchInput = document.querySelector("#SearchInput")

    delButton.addEventListener("click", () =>{
        const settings = {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }
        fetch(url + `/${delInput.value}`,settings)
        .then(response => response.json())
        .then(location.reload(true))
    })

    srchButton.addEventListener("click", () =>{
        console.log("atroden")
        const settings = {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }
        fetch(url + `/${srchInput.value}`,settings)
        .then(response => response.json())
        .then(data => {
            tableBody.innerHTML = ''
            tableBody.innerHTML += `
            <tr>
                    <th scope="row">${data.id}</th>
                    <td>${data.nombre}</td>
                    <td>${data.apellido}</td>
                    <td>${data.numeroMatricula}</td>
                </tr>    
            `
            
        })
    })
    
   
}

const getLista = (url, tableBody) => {
    tableBody.innerHTML = ''
    const settings = {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    }
    fetch(url, settings, true)
        .then(response => response.json())
        .then(data => {
            data.map(item => {
                tableBody.innerHTML += `
                <tr>
                    <th scope="row">${item.id}</th>
                    <td>${item.nombre}</td>
                    <td>${item.apellido}</td>
                    <td>${item.numeroMatricula}</td>
                </tr>    
            `
            })
        })
}