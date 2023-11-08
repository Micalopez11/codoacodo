document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("contactForm");
    const respuesta = document.getElementById("respuesta");
  
    form.addEventListener("submit", function (event) {
        event.preventDefault();
  
        // Obtén los valores de los campos del formulario
        const nombre = document.getElementById("nombre").value;
        const email = document.getElementById("email").value;
        const mensaje = document.getElementById("mensaje").value;
  
        // Simula el envío de los datos (puedes reemplazar esto con tu lógica de envío real)
        setTimeout(function () {
            respuesta.innerHTML = `¡Gracias por tu mensaje, ${nombre}! Hemos recibido tu mensaje.`;
            form.reset();
        }, 1000);
    });
  });
  