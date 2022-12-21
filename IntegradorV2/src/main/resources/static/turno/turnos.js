window.onload = () => {

    const tableBody = document.querySelector("tbody")
    console.log(tableBody)
    
    const url = '/turnos'
        
   

    getLista(url, tableBody)

    const delButton = document.querySelector("#dltButton")
    const delInput = document.querySelector("#dltInput")

    const srchButton = document.querySelector("#SearchButton")
    const srchInput = document.querySelector("#SearchInput")

    delButton.addEventListener("click", () =>{
        console.log("entre")
        const settings = {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }
        fetch(url + `/${delInput.value}`,settings)
        .then(response => {
            console.log(response.status)
        })
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
                    <td>${data.paciente}</td>
                    <td>${data.odontologo}</td>
                    <td>${data.fecha}</td>
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
            console.log(data)
            data.map(item => {
                tableBody.innerHTML += `
                <tr>
                    <th scope="row">${item.id}</th>
                    <td>${item.paciente}</td>
                    <td>${item.odontologo}</td>
                    <td>${item.fecha}</td>
                </tr>    
            `
            })
        })
}