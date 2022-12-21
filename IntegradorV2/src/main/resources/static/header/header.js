const header = document.querySelector(".header")

header.innerHTML = `
    <header class="d-flex">
    <nav class="navbar navbar-expand-lg navbar-light bg-light border border-primary w-100 p-3 d-flex justify-content-between">
      <a class="navbar-brand" href="#">Clinica Perez</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/index.html">Home</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Odontologos
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="/odontologos/registro-odontologo.html">Registrar Odontologo</a>
              <a class="dropdown-item" href="/odontologos/actualizar-odontologo.html">Actualizar Odontologo</a>
              <a class="dropdown-item" href="/odontologos/tabla-odontologos.html">Lista Odontologos</a>
              <div class="dropdown-divider"></div>
            </div>
          </li>

          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Pacientes
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="/paciente/registro-pacientes.html">Registrar Paciente</a>
              <a class="dropdown-item" href="/paciente/actualizar-pacientes.html">Actualizar Paciente</a>
              <a class="dropdown-item" href="/paciente/tabla-pacientes.html">Lista Pacientes</a>
              <div class="dropdown-divider"></div>
            </div>
          </li>

          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Turnos
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="/turno/registro-turnos.html">Sacar Turno</a>
              <a class="dropdown-item" href="/turno/actualizar-turnos.html">Actualizar Turno</a>
              <a class="dropdown-item" href="/turno/tabla-turnos.html">Lista Turnos</a>
              <div class="dropdown-divider"></div>
            </div>
          </li>
        </ul>
        </ul>

      </div>
      
        
      
    </nav>
</header>
`
